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
import {bindActionCreators} from 'redux';
import metadata from '../metadata';
import redux from '../redux';
import pv from './';
import Icon from '../components/Icon';
import Link from '../components/Link';
import ResourceList from '../components/ResourceList';
import Table from '../components/Table';

const headers = [
  <span><Icon className='fa-id-card' /> Name</span>,
  'Storage Class',
  'Capacity',
  'Status',
  ''
];

const Rows = ({persistentVolumes, loadedResources, deletePersistentVolumeAction}) => {
  if (!loadedResources['PersistentVolume']) {
    return <Table.Loading colSpan={headers.length} />;
  }
  const allPV = Object.values(persistentVolumes);
  if (allPV.length === 0) {
    return <Table.NoResultsRow colSpan={headers.length} />;
  }
  const deletePersistentVolume = persistentVolume => async () => {
    await pv.api.delete(persistentVolume);
    deletePersistentVolumeAction(persistentVolume);
  };
  return allPV
    .sort(metadata.selectors.sortByCreationTimeStamp)
    .map(persistentVolume => (
        <Table.Row key={metadata.selectors.uid(persistentVolume)}>
          <Table.Cell>
            <Link.PersistentVolume to={`/persistentvolumes/${metadata.selectors.uid(persistentVolume)}`}>
              {metadata.selectors.name(persistentVolume)}
            </Link.PersistentVolume>
          </Table.Cell>
          <Table.Cell>
            {pv.selectors.specStorageClassName(persistentVolume)}
          </Table.Cell>
          <Table.Cell>
            {pv.selectors.specCapacityStorage(persistentVolume)}
          </Table.Cell>
          <Table.Cell>
            {pv.selectors.statusPhase(persistentVolume)}
          </Table.Cell>
          <Table.Cell>
            <Table.DeleteButton onClick={deletePersistentVolume(persistentVolume)} />
          </Table.Cell>
        </Table.Row>
    ));
};

const List = ({persistentVolumes, loadedResources, deletePersistentVolumeAction, ...properties}) => (
  <ResourceList headers={headers} {...properties}>
    <Rows persistentVolumes={persistentVolumes} loadedResources={loadedResources} deletePersistentVolumeAction={deletePersistentVolumeAction} />
  </ResourceList>
);

const mapStateToProps = ({persistentVolumes, ui: {loadedResources}}) => ({
  persistentVolumes,
  loadedResources
});

const mapDispatchToProps = dispatch =>  bindActionCreators({
  deletePersistentVolumeAction: redux.actions.crudDelete
}, dispatch);

const mergeProps = (stateProps, dispatchProps, ownProps) => ({
  ...stateProps,
  ...dispatchProps,
  ...ownProps,
  persistentVolumes: redux.selectors.resourcesBy(stateProps.persistentVolumes, ownProps)
});

export default connect(mapStateToProps, mapDispatchToProps, mergeProps)(List);

