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
import {Link} from "react-router-dom";
import {Button, Card, Icon, Table} from 'tabler-react';
import metadata from '../metadata';
import podsModule from './'


const headers = [
  'Ready',
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
  if (allPods.length === 0){
    return (
      <Table.Row>
        <Table.Col colSpan={headers.length}>
          No results found
        </Table.Col>
      </Table.Row>
    );
  }
  const deletePod = pod => async () => await podsModule.api.requestDelete(pod);
  return allPods
    .sort(sort)
    .map(pod => (
        <Table.Row key={metadata.selectors.uid(pod)}>
          <Table.Col>
            <Icon
              className={podsModule.selectors.containersReady(pod) ? 'text-success' : 'text-danger'}
              name={podsModule.selectors.containersReady(pod) ? 'check' : 'alert-circle'}
            />
          </Table.Col>
          <Table.Col className='text-nowrap'>
            <Link to={`/pods/${metadata.selectors.uid(pod)}`}>{metadata.selectors.name(pod)}</Link>
          </Table.Col>
          <Table.Col className='text-nowrap'>
            {metadata.selectors.namespace(pod)}
          </Table.Col>
          <Table.Col className='text-nowrap'>
            {podsModule.selectors.statusPhase(pod)}
          </Table.Col>
          <Table.Col >
            {podsModule.selectors.restartCount(pod)}
          </Table.Col>
          <Table.Col>
            <Button
              icon='trash'
              color='danger'
              outline
              size='sm'
              onClick={deletePod(pod)}
            />
          </Table.Col>
        </Table.Row>
    ));
}

const List = ({pods}) => (
  <Card title='Pods' className='table-responsive-sm'>
    <Table
      responsive
      className='card-table table-vcenter table-striped'
    >
      <Table.Header>
        <Table.Row>
          {headers.map((header, idx) => (
            <Table.ColHeader key={idx}>{header}</Table.ColHeader>
          ))}
        </Table.Row>
      </Table.Header>
      <Table.Body>
        <Rows pods={pods} />
      </Table.Body>
    </Table>
  </Card>
);

const mapStateToProps = ({pods}) => ({
  pods
});

const filterPods = (pods = [], {nodeName}) => Object.entries(pods)
  .filter(([, pod]) => {
    if (nodeName) {
      return podsModule.selectors.nodeName(pod) === nodeName;
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
  pods: filterPods(stateProps.pods, ownProps)
});

export default connect(mapStateToProps, null, mergeProps)(List);

