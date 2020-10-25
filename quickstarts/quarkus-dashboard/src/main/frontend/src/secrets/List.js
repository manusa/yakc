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
import s from './';
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

const Rows = ({secrets, loadedResources, crudDelete}) => {
  if (!loadedResources['Secret']) {
    return <Table.Loading colSpan={headers.length} />;
  }
  const allSecrets = Object.values(secrets);
  if (allSecrets.length === 0) {
    return <Table.NoResultsRow colSpan={headers.length} />;
  }
  const deleteSecret = secret => async () => {
    await s.api.requestDelete(secret);
    crudDelete(secret);
  };
  return allSecrets
    .sort(metadata.selectors.sortByCreationTimeStamp)
    .map(secret => (
        <Table.Row key={metadata.selectors.uid(secret)}>
          <Table.Cell>
            <Link.Secret to={`/secrets/${metadata.selectors.uid(secret)}`}>
              {metadata.selectors.name(secret)}
            </Link.Secret>
          </Table.Cell>
          <Table.Cell className='whitespace-no-wrap'>
            <Link.Namespace to={`/namespaces/${metadata.selectors.namespace(secret)}`}>
              {metadata.selectors.namespace(secret)}
            </Link.Namespace>
          </Table.Cell>
          <Table.Cell>
            <Table.DeleteButton onClick={deleteSecret(secret)} />
          </Table.Cell>
        </Table.Row>
    ));
};

const List = ({secrets, loadedResources, crudDelete, ...properties}) => (
  <ResourceList headers={headers} {...properties}>
    <Rows secrets={secrets} loadedResources={loadedResources} crudDelete={crudDelete} />
  </ResourceList>
);

const mapStateToProps = ({secrets, ui: {loadedResources}}) => ({
  secrets,
  loadedResources
});

const mapDispatchToProps = dispatch =>  bindActionCreators({
  crudDelete: redux.actions.crudDelete
}, dispatch);

const mergeProps = (stateProps, dispatchProps, ownProps) => ({
  ...stateProps,
  ...dispatchProps,
  ...ownProps,
  secrets: redux.selectors.resourcesBy(stateProps.secrets, ownProps)
});

export default connect(mapStateToProps, mapDispatchToProps, mergeProps)(List);

