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
import {Link} from 'react-router-dom';
import {Card, Table} from 'tabler-react';
import TableNoResults from '../components/TableNoResults';
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
    return <TableNoResults colSpan={headers.length} />;
  }
  return allServices
    .sort(sort)
    .map(service => (
        <Table.Row key={metadata.selectors.uid(service)}>
          <Table.Col className='text-nowrap'>
            <Link to={`/services/${metadata.selectors.uid(service)}`}>{metadata.selectors.name(service)}</Link>
          </Table.Col>
          <Table.Col className='text-nowrap'>
            {metadata.selectors.namespace(service)}
          </Table.Col>
          <Table.Col>
            {svc.selectors.specClusterIP(service)}
          </Table.Col>
          <Table.Col>
          </Table.Col>
        </Table.Row>
    ));
}

const List = ({services}) => (
  <Card title='Services' className='table-responsive-sm'>
    <Table
      responsive
      className='card-table table-vcenter table-striped'
    >
      <Table.Header>
        <Table.Row>
          {headers.map((header, idx) => (
            <Table.ColHeader key={idx}>{header}</Table.ColHeader>
          ))}
        </Table.Row>
      </Table.Header>
      <Table.Body>
        <Rows services={services} />
      </Table.Body>
    </Table>
  </Card>
);

const mapStateToProps = ({services}) => ({
  services
});

export default connect(mapStateToProps)(List);

