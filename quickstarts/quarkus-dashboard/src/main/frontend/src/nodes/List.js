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
import React, {useState} from 'react';
import {connect} from 'react-redux'
import {Card, Table, Tag} from 'tabler-react';
import metadata from '../metadata';
import nodesModule from './'

const maxLabels = 2;

const headers = [
  'Name',
  'Ready',
  'Labels'
]

const sort = (n1, n2) =>
  new Date(n1.metadata.creationTimestamp) - new Date(n2.metadata.creationTimestamp);

const Labels = ({labels}) => {
  const [collapsed, setCollapsed] = useState(true);
  const toggle = () => setCollapsed(!collapsed);
  const truncate = labels.length > maxLabels;
  const displayedLabels = truncate && collapsed ? labels.slice(0, maxLabels) : labels;
  return (
    <div className='d-flex flex-wrap align-items-center'>
      {displayedLabels.map((label, idx) =>
        <Tag key={idx} rounded color='blue' className='mr-1 mb-1'>{label}</Tag>
      )}
      {truncate && <a href='#' onClick={toggle}>{collapsed ? '...' : 'Show less'}</a>}
    </div>
  );
};

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
          <Table.Col className='text-nowrap'>
            {node.metadata.name}
          </Table.Col>
          <Table.Col>
            {nodesModule.selectors.isReady(node)}
          </Table.Col>
          <Table.Col >
            <Labels labels={Object.entries(metadata.selectors.labels(node.metadata))
              .map(([key, value]) => `${key}: ${value}`)} />
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

