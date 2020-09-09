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
import {Card, Icon, Table} from 'tabler-react';
import metadata from '../metadata';
import nodesModule from './'

const headers = [
  'Ready',
  'Name',
  'Labels'
]

const sort = (n1, n2) =>
  metadata.selectors.creationTimestamp(n1) - metadata.selectors.creationTimestamp(n2);

const Rows = ({nodes}) => {
  const allNodes = Object.values(nodes);
  if (allNodes.length === 0){
    return (
      <Table.Row>
        <Table.Col colSpan={headers.length}>
          No results found
        </Table.Col>
      </Table.Row>
    );
  }
  return allNodes
    .sort(sort)
    .map(node => (
        <Table.Row key={node.metadata.uid}>
          <Table.Col>
            <Icon
              name={nodesModule.selectors.isReady(node) ? 'check' : 'alert-circle'}
            />
          </Table.Col>
          <Table.Col className='text-nowrap'>
            {metadata.selectors.name(node)}
          </Table.Col>
          <Table.Col >
            <metadata.Labels
              labels={metadata.selectors.labels(node)}
              maxLabels={2}
            />
          </Table.Col>
        </Table.Row>
    ));
}

const List = ({nodes}) => (
  <Card title='Nodes' className='table-responsive-sm'>
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
        <Rows nodes={nodes} />
      </Table.Body>
    </Table>
  </Card>
);

const mapStateToProps = ({nodes}) => ({
  nodes
});

export default connect(mapStateToProps)(List);

