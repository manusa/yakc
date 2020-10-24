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
import PropTypes from 'prop-types';
import {connect} from 'react-redux'
import metadata from '../metadata';
import redux from '../redux';
import rs from './';
import Icon from '../components/Icon';
import ResourceList from '../components/ResourceList';
import Table from '../components/Table';

const headers = [
  '',
  <span><Icon icon='fa-id-card' /> Name</span>,
  'Namespace',
  'Replicas',
  ''
]

const sort = (p1, p2) =>
  metadata.selectors.creationTimestamp(p2) - metadata.selectors.creationTimestamp(p1);

const Rows = ({replicaSets}) => {
  const allRS = Object.values(replicaSets);
  if (allRS.length === 0) {
    return <Table.NoResultsRow colSpan={headers.length} />;
  }
  const deleteReplicaSet = replicaSet => async () => await rs.api.requestDelete(replicaSet);
  return allRS
    .sort(sort)
    .map(replicaSet => (
      <Table.Row key={metadata.selectors.uid(replicaSet)}>
        <Table.Cell className='whitespace-no-wrap w-3 text-center'>
          <Icon
            className={rs.selectors.isReady(replicaSet) ? 'text-green-500' : 'text-red-500'}
            icon={rs.selectors.isReady(replicaSet) ? 'fa-check' : 'fa-exclamation-circle'}
          />
        </Table.Cell>
        <Table.Cell className='whitespace-no-wrap'>
          {metadata.selectors.name(replicaSet)}
        </Table.Cell>
        <Table.Cell className='whitespace-no-wrap'>
          {metadata.selectors.namespace(replicaSet)}
        </Table.Cell>
        <Table.Cell className='whitespace-no-wrap'>
          {rs.selectors.specReplicas(replicaSet)}
        </Table.Cell>
        <Table.Cell className='whitespace-no-wrap text-center'>
          <Table.DeleteButton onClick={deleteReplicaSet(replicaSet)} />
        </Table.Cell>
      </Table.Row>
    ));
}

const List = ({replicaSets, ownerId, ...properties}) => (
  <ResourceList headers={headers} {...properties}>
    <Rows replicaSets={replicaSets} />
  </ResourceList>
);

const mapStateToProps = ({replicaSets}) => ({
  replicaSets
});

const mergeProps = (stateProps, dispatchProps, ownProps) => ({
  ...stateProps,
  ...dispatchProps,
  ...ownProps,
  replicaSets: redux.selectors.resourcesBy(stateProps.replicaSets, ownProps)
});

List.propTypes = {
  ownerId: PropTypes.string
};

export default connect(mapStateToProps, null, mergeProps)(List);

