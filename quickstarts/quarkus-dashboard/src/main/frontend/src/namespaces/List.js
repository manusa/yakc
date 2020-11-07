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
import ns from './';
import redux from '../redux';
import Icon from '../components/Icon';
import Link from '../components/Link';
import ResourceList from '../components/ResourceList';
import Table from '../components/Table';

const headers = [
  '',
  <span><Icon icon='fa-id-card' /> Name</span>,
  'Phase',
  <span><Icon icon='fa-tags' /> Labels</span>,
  ''
];

const Rows = ({namespaces, addOrReplace}) => {
  const deleteNamespace = namespace => async () => {
    const deletedNamespace = await ns.api.delete(namespace);
    addOrReplace(deletedNamespace);
  };
  return namespaces
    .sort(metadata.selectors.sortByCreationTimeStamp)
    .map(namespace => (
        <Table.Row key={metadata.selectors.uid(namespace)}>
          <Table.Cell className='whitespace-no-wrap w-3 text-center'>
            <Icon
              className={ns.selectors.isReady(namespace) ? 'text-green-500' : 'text-red-500'}
              icon={ns.selectors.isReady(namespace) ? 'fa-check' : 'fa-exclamation-circle'}
            />
          </Table.Cell>
          <Table.Cell className='text-nowrap'>
            <Link.Namespace to={`/namespaces/${metadata.selectors.uid(namespace)}`}>
              {metadata.selectors.name(namespace)}
            </Link.Namespace>
          </Table.Cell>
          <Table.Cell className='text-nowrap'>
            {ns.selectors.statusPhase(namespace)}
          </Table.Cell>
          <Table.Cell>
            <metadata.KeyValueList
              keyValues={metadata.selectors.labels(namespace)}
              maxEntries={2}
            />
          </Table.Cell>
          <Table.Cell className='whitespace-no-wrap text-center'>
            <Table.DeleteButton onClick={deleteNamespace(namespace)} />
          </Table.Cell>
        </Table.Row>
    ));
};

const List = ({namespaces, addOrReplace, loadedResources, deleteIngressAction, ...properties}) => (
  <ResourceList headers={headers} resources={namespaces} loading={!loadedResources['Namespace']} {...properties}>
    <Rows namespaces={namespaces} loadedResources={loadedResources} addOrReplace={addOrReplace} />
  </ResourceList>
);

const mapStateToProps = ({namespaces, ui: {loadedResources}}) => ({
  namespaces: Object.values(namespaces),
  loadedResources
});

const mapDispatchToProps = dispatch =>  bindActionCreators({
  addOrReplace: redux.actions.crudAddOrReplace
}, dispatch);

export default connect(mapStateToProps, mapDispatchToProps)(List);

