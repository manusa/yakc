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
import {Card, Icon, Table} from 'tabler-react';
import TableNoResults from '../components/TableNoResults';
import metadata from '../metadata';
import rs from './'


const headers = [
  'Ready',
  'Name',
  'Namespace',
  'Replicas'
]

const sort = (p1, p2) =>
  metadata.selectors.creationTimestamp(p2) - metadata.selectors.creationTimestamp(p1);

const Rows = ({replicaSets}) => {
  const allRS = Object.values(replicaSets);
  if (allRS.length === 0) {
    return <TableNoResults colSpan={headers.length} />;
  }
  return allRS
    .sort(sort)
    .map(replicaSet => (
        <Table.Row key={metadata.selectors.uid(replicaSet)}>
          <Table.Col>
            <Icon
              className={rs.selectors.isReady(replicaSet) ? 'text-success' : 'text-danger'}
              name={rs.selectors.isReady(replicaSet) ? 'check' : 'alert-circle'}
            />
          </Table.Col>
          <Table.Col className='text-nowrap'>
            {metadata.selectors.name(replicaSet)}
          </Table.Col>
          <Table.Col className='text-nowrap'>
            {metadata.selectors.namespace(replicaSet)}
          </Table.Col>
          <Table.Col className='text-nowrap'>
            {rs.selectors.specReplicas(replicaSet)}
          </Table.Col>
        </Table.Row>
    ));
}

const List = ({replicaSets}) => (
  <Card title='Replica Sets' className='table-responsive-sm'>
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
        <Rows replicaSets={replicaSets} />
      </Table.Body>
    </Table>
  </Card>
);

const mapStateToProps = ({replicaSets}) => ({
  replicaSets
});

const filterReplicaSet = (replicaSets = [], {ownerId} = undefined) => Object.entries(replicaSets)
  .filter(([, replicaSet]) => {
    if (ownerId) {
      return metadata.selectors.ownerReferencesUids(replicaSet).includes(ownerId);
    }
    return true;
  })
  .reduce((acc, [key, replicaSet]) => {
    acc[key] = replicaSet;
    return acc;
  }, {});

const mergeProps = (stateProps, dispatchProps, ownProps) => ({
  ...stateProps,
  ...dispatchProps,
  ...ownProps,
  replicaSets: filterReplicaSet(stateProps.replicaSets, ownProps)
});

export default connect(mapStateToProps, null, mergeProps)(List);

