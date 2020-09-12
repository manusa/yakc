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
import {Button, Card, Icon, Table} from 'tabler-react';
import TableNoResults from '../components/TableNoResults';
import metadata from '../metadata';
import deploymentsModule from './'


const headers = [
  'Ready',
  'Name',
  'Namespace',
  'Images',
  ''
]

const sort = (p1, p2) =>
  metadata.selectors.creationTimestamp(p2) - metadata.selectors.creationTimestamp(p1);

const Rows = ({deployments}) => {
  const allDeployments = Object.values(deployments);
  if (allDeployments.length === 0) {
    return <TableNoResults colSpan={headers.length} />;
  }
  const deleteDeployment = deployment => async () => await deploymentsModule.api.requestDelete(deployment);
  return allDeployments
    .sort(sort)
    .map(deployment => (
        <Table.Row key={metadata.selectors.uid(deployment)}>
          <Table.Col>
            <Icon
              className={deploymentsModule.selectors.isReady(deployment) ? 'text-success' : 'text-danger'}
              name={deploymentsModule.selectors.isReady(deployment) ? 'check' : 'alert-circle'}
            />
          </Table.Col>
          <Table.Col className='text-nowrap'>
            <Link to={`/deployments/${metadata.selectors.uid(deployment)}`}>{metadata.selectors.name(deployment)}</Link>
          </Table.Col>
          <Table.Col className='text-nowrap'>
            {metadata.selectors.namespace(deployment)}
          </Table.Col>
          <Table.Col >
            {deploymentsModule.selectors.images(deployment).map((image, idx) =>
              <div key={idx}>{image}</div>
            )}
          </Table.Col>
          <Table.Col>
            <Button
              icon='trash'
              color='danger'
              outline
              size='sm'
              onClick={deleteDeployment(deployment)}
            />
          </Table.Col>
        </Table.Row>
    ));
}

const List = ({deployments}) => (
  <Card title='Deployments' className='table-responsive-sm'>
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
        <Rows deployments={deployments} />
      </Table.Body>
    </Table>
  </Card>
);

const mapStateToProps = ({deployments}) => ({
  deployments
});

export default connect(mapStateToProps, null, null)(List);

