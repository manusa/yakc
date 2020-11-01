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
import cm from './';
import redux from '../redux';
import Icon from '../components/Icon';
import Link from '../components/Link';
import ResourceList from '../components/ResourceList';
import Table from '../components/Table';

const headers = [
  <span><Icon className='fa-id-card' /> Name</span>,
  'Namespace',
  ''
];

const Rows = ({configMaps, crudDelete}) => {
  const allConfigMaps = Object.values(configMaps);
  if (allConfigMaps.length === 0) {
    return <Table.NoResultsRow colSpan={headers.length} />;
  }
  const deleteConfigMap = configMap => async () => await cm.api.requestDelete(configMap);
  return allConfigMaps
    .sort(metadata.selectors.sortByCreationTimeStamp)
    .map(configMap => (
        <Table.Row key={metadata.selectors.uid(configMap)}>
          <Table.Cell>
            <Link.ConfigMap to={`/configmaps/${metadata.selectors.uid(configMap)}`}>
              {metadata.selectors.name(configMap)}
            </Link.ConfigMap>
          </Table.Cell>
          <Table.Cell className='whitespace-no-wrap'>
            <Link.Namespace to={`/namespaces/${metadata.selectors.namespace(configMap)}`}>
              {metadata.selectors.namespace(configMap)}
            </Link.Namespace>
          </Table.Cell>
          <Table.Cell>
            <Table.DeleteButton onClick={deleteConfigMap(configMap)} />
          </Table.Cell>
        </Table.Row>
    ));
};

const List = ({configMaps,  crudDelete, ...properties}) => (
  <ResourceList headers={headers} {...properties}>
    <Rows configMaps={configMaps} crudDelete={crudDelete} />
  </ResourceList>
);

const mapStateToProps = ({configMaps}) => ({
  configMaps
});

const mapDispatchToProps = dispatch =>  bindActionCreators({
  crudDelete: redux.actions.crudDelete
}, dispatch);

const mergeProps = (stateProps, dispatchProps, ownProps) => ({
  ...stateProps,
  ...dispatchProps,
  ...ownProps,
  configMaps: redux.selectors.resourcesBy(stateProps.configMaps, ownProps)
});

export default connect(mapStateToProps, mapDispatchToProps, mergeProps)(List);

