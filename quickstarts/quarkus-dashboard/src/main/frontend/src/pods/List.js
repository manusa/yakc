/*
 * Copyright 2020 Marc Nuri
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
import React from 'react';
import {connect} from 'react-redux'
import Icon from '../components/Icon';
import Link from '../components/Link';
import Table from '../components/Table';
import metadata from '../metadata';
import podsModule from './'

const headers = [
  '',
  'Name',
  'Namespace',
  'Status',
  'Restarts',
  ''
]

const sort = (p1, p2) =>
  metadata.selectors.creationTimestamp(p2) - metadata.selectors.creationTimestamp(p1);

const Rows = ({pods}) => {
  const allPods = Object.values(pods);
  if (allPods.length === 0) {
    return <Table.NoResultsRow colSpan={headers.length} />;
  }
  const deletePod = pod => async () => await podsModule.api.requestDelete(pod);
  return allPods
    .sort(sort)
    .map(pod => (
      <Table.Row key={metadata.selectors.uid(pod)}>
        <Table.Cell className='whitespace-no-wrap w-3 text-center'>
          <Icon
            className={podsModule.selectors.containersReady(pod) ? 'text-green-500' : 'text-red-500'}
            icon={podsModule.selectors.containersReady(pod) ? 'fa-check' : 'fa-exclamation-circle'}
          />
        </Table.Cell>
        <Table.Cell className='whitespace-no-wrap'>
          <Link.RouterLink to={`/pods/${metadata.selectors.uid(pod)}`}>
            {metadata.selectors.name(pod)}
          </Link.RouterLink>
        </Table.Cell>
        <Table.Cell className='whitespace-no-wrap'>
          {metadata.selectors.namespace(pod)}
        </Table.Cell>
        <Table.Cell className='whitespace-no-wrap'>
          {podsModule.selectors.statusPhase(pod)}
        </Table.Cell>
        <Table.Cell >
          {podsModule.selectors.restartCount(pod)}
        </Table.Cell>
        <Table.Cell className='text-center'>
          <Link.RouterLink
            variant={Link.variants.outline}
            to={`/pods/${metadata.selectors.uid(pod)}/logs`}
            title='Logs'
          ><Icon stylePrefix='far' icon='fa-file-alt' /></Link.RouterLink>
          <Link
            variant={Link.variants.outlineDanger}
            className='ml-1'
            onClick={deletePod(pod)}
            title='Delete'
          ><Icon stylePrefix='far' icon='fa-trash-alt' /></Link>
        </Table.Cell>
      </Table.Row>
    ));
}

const List = ({pods, nodeName, ...properties}) => (
  <Table {...properties}>
    <Table.Head
      columns={headers}
    />
    <Table.Body>
      <Rows pods={pods} />
    </Table.Body>
  </Table>
);

const mapStateToProps = ({pods}) => ({
  pods
});

const filterPods = (pods = [], replicaSets = [], {
  nodeName,
  ownerUids
} = undefined) => Object.entries(pods)
  .filter(([, pod]) => {
    if (nodeName) {
      return podsModule.selectors.nodeName(pod) === nodeName;
    }
    if (ownerUids) {
      return metadata.selectors.ownerReferencesUids(pod)
        .some(ownerUid => ownerUids.includes(ownerUid));
    }
    return true;
  })
  .reduce((acc, [key, pod]) => {
    acc[key] = pod;
    return acc;
  }, {});

const mergeProps = (stateProps, dispatchProps, ownProps) => ({
  ...stateProps,
  ...dispatchProps,
  ...ownProps,
  pods: filterPods(stateProps.pods, stateProps.replicaSets, ownProps)
});

export default connect(mapStateToProps, null, mergeProps)(List);

