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
import Table from '../components/Table';

const containerHeaders = ['Name', 'Image', 'Ports'];

const ContainerList = ({containers, ...properties}) => (
  <Table {...properties}>
    <Table.Head
      columns={containerHeaders}
    />
    <Table.Body>
      {containers.map(c => (
        <Table.Row key={c.name}>
          <Table.Cell>{c.name}</Table.Cell>
          <Table.Cell>{c.image}</Table.Cell>
          <Table.Cell>
            {(c.ports ?? []).map((p, idx) => (
              <div key={idx}>{p.name} {p.containerPort} {p.protocol}</div>
            ))}
          </Table.Cell>
        </Table.Row>
      ))}
    </Table.Body>
  </Table>
);

export default ContainerList;
