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
import svc from './';

const headers = [
  'Name',
  'Namespace',
  'Cluster IP',
  ''
]

const sort = (p1, p2) =>
  metadata.selectors.creationTimestamp(p2) - metadata.selectors.creationTimestamp(p1);

const Rows = ({services}) => {
  const allServices = Object.values(services);
  if (allServices.length === 0) {
    return <Table.NoResultsRow colSpan={headers.length} />;
  }
  return allServices
    .sort(sort)
    .map(service => (
        <Table.Row key={metadata.selectors.uid(service)}>
          <Table.Cell className='text-nowrap'>
            <Link.RouterLink to={`/services/${metadata.selectors.uid(service)}`}>
              {metadata.selectors.name(service)}
            </Link.RouterLink>
          </Table.Cell>
          <Table.Cell className='text-nowrap'>
            {metadata.selectors.namespace(service)}
          </Table.Cell>
          <Table.Cell>
            {svc.selectors.specClusterIP(service)}
          </Table.Cell>
          <Table.Cell>
          </Table.Cell>
        </Table.Row>
    ));
}

const List = ({services, ...properties}) => (
  <Table {...properties}>
    <Table.Head
      columns={headers}
    />
    <Table.Body>
      <Rows services={services} />
    </Table.Body>
  </Table>
);

const mapStateToProps = ({services}) => ({
  services
});

export default connect(mapStateToProps)(List);

