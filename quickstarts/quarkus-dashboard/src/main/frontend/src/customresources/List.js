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
import redux from '../redux';
import {bindActionCreators} from 'redux';
import {connect} from 'react-redux';
import metadata from '../metadata';
import cr from './';
import Icon from '../components/Icon';
import Link from '../components/Link';
import ResourceList from '../components/ResourceList';
import Table from '../components/Table';

const headers = [
  <span><Icon className='fa-id-card' /> Name</span>,
  'Namespace',
  ''
];

const Rows = ({customResources, customResourceDefinition, deleteResourceCallback}) => {
  const deleteCustomResource = customResource => {
    const deleteFunc = cr.api.delete(customResourceDefinition);
    return async () => {
      await deleteFunc(customResource);
      deleteResourceCallback(customResource);
    }
  };
  return customResources
    .sort(metadata.selectors.sortByCreationTimeStamp)
    .map(customResource => (
        <Table.Row key={metadata.selectors.uid(customResource)}>
          <Table.Cell>
            {/*<Link to={`/customresources/${metadata.selectors.uid(customResource)}/edit`}>*/}
              {metadata.selectors.name(customResource)}
            {/*</Link>*/}
          </Table.Cell>
          <Table.Cell className='whitespace-no-wrap'>
            <Link.Namespace to={`/namespaces/${metadata.selectors.namespace(customResource)}`}>
              {metadata.selectors.namespace(customResource)}
            </Link.Namespace>
          </Table.Cell>
          <Table.Cell>
            <Table.DeleteButton onClick={deleteCustomResource(customResource)} />
          </Table.Cell>
        </Table.Row>
    ));
};

const List = ({customResources, customResourceDefinition, deleteResourceCallback, crudDelete, ...properties}) => (
  <ResourceList headers={headers} resources={customResources} {...properties}>
    <Rows
      customResources={customResources}
      customResourceDefinition={customResourceDefinition}
      deleteResourceCallback={deleteResourceCallback}
    />
  </ResourceList>
);

const mapDispatchToProps = dispatch =>  bindActionCreators({
  crudDelete: redux.actions.crudDelete
}, dispatch);

export default connect(null, mapDispatchToProps)(List);

