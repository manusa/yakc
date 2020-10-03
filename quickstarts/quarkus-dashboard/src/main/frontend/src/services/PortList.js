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
import Icon from '../components/Icon';
import Table from '../components/Table';

const headers = [
  <span><Icon className='fa-id-card' /> Name</span>,
  'App Protocol',
  'Node Port',
  'Port',
  'Protocol',
  'Target Port'
];

const Rows = ({ports}) => ports.map(port => (
  <Table.Row key={port.name}>
    <Table.Cell>{port.name}</Table.Cell>
    <Table.Cell>{port.appProtocol}</Table.Cell>
    <Table.Cell>{port.nodePort}</Table.Cell>
    <Table.Cell>{port.port}</Table.Cell>
    <Table.Cell>{port.protocol}</Table.Cell>
    <Table.Cell>{port.targetPort}</Table.Cell>
  </Table.Row>
));

const PortList = ({ports, deleteServiceAction, ...properties}) => (
  <Table {...properties}>
    <Table.Head
      columns={headers}
    />
    <Table.Body>
      <Rows ports={ports} deleteServiceAction={deleteServiceAction} />
    </Table.Body>
  </Table>
);

export default PortList;
