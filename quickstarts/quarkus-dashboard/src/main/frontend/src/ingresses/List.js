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
import ing from './';
import redux from '../redux';
import Icon from '../components/Icon';
import Link from '../components/Link';
import ResourceList from '../components/ResourceList';
import Table from '../components/Table';

const headers = [
  <span><Icon icon='fa-id-card' /> Name</span>,
  'Namespace',
  'Hosts',
  'Paths',
  ''
];

const Rows = ({ingresses, loadedResources, deleteIngressAction}) => {
  if (!loadedResources['Ingress']) {
    return <Table.Loading colSpan={headers.length} />;
  }
  const allIngresses = Object.values(ingresses);
  if (allIngresses.length === 0) {
    return <Table.NoResultsRow colSpan={headers.length} />;
  }
  const deleteIngress = ingress => async () => {
    await ing.api.requestDelete(ingress);
    deleteIngressAction(ingress);
  };
  return allIngresses
    .sort(metadata.selectors.sortByCreationTimeStamp)
    .map(ingress => (
        <Table.Row key={metadata.selectors.uid(ingress)}>
          <Table.Cell>
            <Link.Ingress to={`/ingresses/${metadata.selectors.uid(ingress)}`}>
              {metadata.selectors.name(ingress)}
            </Link.Ingress>
          </Table.Cell>
          <Table.Cell className='whitespace-no-wrap'>
            <Link.Namespace to={`/namespaces/${metadata.selectors.namespace(ingress)}`}>
              {metadata.selectors.namespace(ingress)}
            </Link.Namespace>
          </Table.Cell>
          <Table.Cell>
            {ing.selectors.allHosts(ingress).map((host, idx) =>
              <div key={idx}><a href={`http://${host}`}>{host}</a></div>
            )}
          </Table.Cell>
          <Table.Cell>
            {ing.selectors.allPaths(ingress).map((path, idx) =>
              <div key={idx}>{path}</div>
            )}
          </Table.Cell>
          <Table.Cell>
            <Table.DeleteButton onClick={deleteIngress(ingress)} />
          </Table.Cell>
        </Table.Row>
    ));
};

const List = ({ingresses, loadedResources, deleteIngressAction, ...properties}) => (
  <ResourceList headers={headers} {...properties}>
    <Rows ingresses={ingresses} loadedResources={loadedResources} deleteIngressAction={deleteIngressAction} />
  </ResourceList>
);

const mapStateToProps = ({ingresses, ui: {loadedResources}}) => ({
  ingresses,
  loadedResources
});

const mapDispatchToProps = dispatch =>  bindActionCreators({
  deleteIngressAction: redux.actions.crudDelete
}, dispatch);

const mergeProps = (stateProps, dispatchProps, ownProps) => ({
  ...stateProps,
  ...dispatchProps,
  ...ownProps,
  ingresses: redux.selectors.resourcesBy(stateProps.ingresses, ownProps)
});

export default connect(mapStateToProps, mapDispatchToProps, mergeProps)(List);

