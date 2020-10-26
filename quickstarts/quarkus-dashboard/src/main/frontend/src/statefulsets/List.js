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
import metadata from '../metadata';
import sts from './';
import redux from '../redux';
import Icon from '../components/Icon';
import Link from '../components/Link';
import ResourceList from '../components/ResourceList';
import Table from '../components/Table';

const headers = [
  '',
  <span><Icon icon='fa-id-card' /> Name</span>,
  'Namespace',
  <span><Icon icon='fa-layer-group'/> Images</span>,
  ''
];

const Rows = ({statefulSets}) => {
  const allStatefulSets = Object.values(statefulSets);
  if (allStatefulSets.length === 0) {
    return <Table.NoResultsRow colSpan={headers.length} />;
  }
  const deleteStatefulSet = statefulSet => async () => await sts.api.requestDelete(statefulSet);
  const restartStatefulSet = statefulSet => async () => await sts.api.restart(statefulSet);
  return allStatefulSets
    .sort(metadata.selectors.sortByCreationTimeStamp)
    .map(statefulSet => (
      <Table.Row key={metadata.selectors.uid(statefulSet)}>
        <Table.Cell className='whitespace-no-wrap w-3 text-center'>
          <Icon
            className={sts.selectors.isReady(statefulSet) ? 'text-green-500' : 'text-red-500'}
            icon={sts.selectors.isReady(statefulSet) ? 'fa-check' : 'fa-exclamation-circle'}
          />
        </Table.Cell>
        <Table.Cell className='whitespace-no-wrap'>
          <Link.StatefulSet to={`/statefulsets/${metadata.selectors.uid(statefulSet)}`}>
            {metadata.selectors.name(statefulSet)}
          </Link.StatefulSet>
        </Table.Cell>
        <Table.Cell className='whitespace-no-wrap'>
          <Link.Namespace to={`/namespaces/${metadata.selectors.namespace(statefulSet)}`}>
            {metadata.selectors.namespace(statefulSet)}
          </Link.Namespace>
        </Table.Cell>
        <Table.Cell>
          {sts.selectors.images(statefulSet).map((image, idx) =>
            <div key={idx}>{image}</div>
          )}
        </Table.Cell>
        <Table.Cell className='whitespace-no-wrap text-center'>
          <Link
            variant={Link.variants.outline}
            onClick={restartStatefulSet(statefulSet)}
            title='Restart'
          ><Icon stylePrefix='fas' icon='fa-redo-alt' /></Link>
          <Table.DeleteButton
            className='ml-1' onClick={deleteStatefulSet(statefulSet)} />
        </Table.Cell>
      </Table.Row>
    ));
}

const List = ({statefulSets, ...properties}) => (
  <ResourceList headers={headers} {...properties}>
    <Rows statefulSets={statefulSets} />
  </ResourceList>
);

const mapStateToProps = ({statefulSets}) => ({
  statefulSets
});

const mergeProps = (stateProps, dispatchProps, ownProps) => ({
  ...stateProps,
  ...dispatchProps,
  ...ownProps,
  statefulSets: redux.selectors.resourcesBy(stateProps.statefulSets, ownProps)
});

export default connect(mapStateToProps, null, mergeProps)(List);

