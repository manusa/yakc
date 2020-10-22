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
import Link from '../components/Link';
import Table from '../components/Table';
import metadata from '../metadata';
import cm from './';
import Icon from '../components/Icon';
import {bindActionCreators} from 'redux';
import redux from '../redux';

const headers = [
  <span><Icon className='fa-id-card' /> Name</span>,
  'Namespace',
  ''
];

const sort = (p1, p2) =>
  metadata.selectors.creationTimestamp(p2) - metadata.selectors.creationTimestamp(p1);

const Rows = ({configMaps, loadedResources, crudDelete}) => {
  if (!loadedResources['ConfigMap']) {
    return <Table.Loading colSpan={headers.length} />;
  }
  const allConfigMaps = Object.values(configMaps);
  if (allConfigMaps.length === 0) {
    return <Table.NoResultsRow colSpan={headers.length} />;
  }
  const deleteConfigMap = configMap => async () => {
    await cm.api.requestDelete(configMap);
    crudDelete(configMap);
  };
  return allConfigMaps
    .sort(sort)
    .map(configMap => (
        <Table.Row key={metadata.selectors.uid(configMap)}>
          <Table.Cell>
            <Link.Service to={`/configmaps/${metadata.selectors.uid(configMap)}`}>
              {metadata.selectors.name(configMap)}
            </Link.Service>
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

const List = ({configMaps, loadedResources, crudDelete, ...properties}) => (
  <Table {...properties}>
    <Table.Head
      columns={headers}
    />
    <Table.Body>
      <Rows configMaps={configMaps} loadedResources={loadedResources} crudDelete={crudDelete} />
    </Table.Body>
  </Table>
);

const mapStateToProps = ({configMaps, ui: {loadedResources}}) => ({
  configMaps,
  loadedResources
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

