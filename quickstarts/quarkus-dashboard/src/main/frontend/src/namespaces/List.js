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
import ns from './';
import Icon from '../components/Icon';
import {bindActionCreators} from 'redux';
import redux from '../redux';

const headers = [
  '',
  <span><Icon icon='fa-id-card' /> Name</span>,
  'Phase',
  <span><Icon icon='fa-tags' /> Labels</span>,
  ''
];

const sort = (p1, p2) =>
  metadata.selectors.creationTimestamp(p2) - metadata.selectors.creationTimestamp(p1);

const Rows = ({namespaces, addOrReplace, loadedResources}) => {
  if (!loadedResources['Namespace']) {
    return <Table.Loading colSpan={headers.length} />;
  }
  const allNamespaces = Object.values(namespaces);
  if (namespaces.length === 0) {
    return <Table.NoResultsRow colSpan={headers.length} />;
  }
  const deleteNamespace = namespace => async () => {
    const deletedNamespace = await ns.api.delete(namespace);
    addOrReplace(deletedNamespace);
  };
  return allNamespaces
    .sort(sort)
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
  <Table {...properties}>
    <Table.Head
      columns={headers}
    />
    <Table.Body>
      <Rows namespaces={namespaces} addOrReplace={addOrReplace} loadedResources={loadedResources} />
    </Table.Body>
  </Table>
);

const mapStateToProps = ({namespaces, ui: {loadedResources}}) => ({
  namespaces,
  loadedResources
});

const mapDispatchToProps = dispatch =>  bindActionCreators({
  addOrReplace: redux.actions.crudAddOrReplace
}, dispatch);

export default connect(mapStateToProps, mapDispatchToProps)(List);

