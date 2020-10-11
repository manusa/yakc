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
import metadata from '../metadata';
import deploymentsModule from './';
import Icon from '../components/Icon';
import Link from '../components/Link';
import Table from '../components/Table';

const headers = [
  '',
  <span><Icon icon='fa-id-card' /> Name</span>,
  'Namespace',
  <span><Icon icon='fa-layer-group'/> Images</span>,
  ''
]

const sort = (p1, p2) =>
  metadata.selectors.creationTimestamp(p2) - metadata.selectors.creationTimestamp(p1);

const Rows = ({deployments}) => {
  const allDeployments = Object.values(deployments);
  if (allDeployments.length === 0) {
    return <Table.NoResultsRow colSpan={headers.length} />;
  }
  const deleteDeployment = deployment => async () => await deploymentsModule.api.requestDelete(deployment);
  return allDeployments
    .sort(sort)
    .map(deployment => (
      <Table.Row key={metadata.selectors.uid(deployment)}>
        <Table.Cell className='whitespace-no-wrap w-3 text-center'>
          <Icon
            className={deploymentsModule.selectors.isReady(deployment) ? 'text-green-500' : 'text-red-500'}
            icon={deploymentsModule.selectors.isReady(deployment) ? 'fa-check' : 'fa-exclamation-circle'}
          />
        </Table.Cell>
        <Table.Cell className='whitespace-no-wrap'>
          <Link.RouterLink to={`/deployments/${metadata.selectors.uid(deployment)}`}>
            {metadata.selectors.name(deployment)}
          </Link.RouterLink>
        </Table.Cell>
        <Table.Cell className='whitespace-no-wrap'>
          <Link.Namespace to={`/namespaces/${metadata.selectors.namespace(deployment)}`}>
            {metadata.selectors.namespace(deployment)}
          </Link.Namespace>
        </Table.Cell>
        <Table.Cell>
          {deploymentsModule.selectors.images(deployment).map((image, idx) =>
            <div key={idx}>{image}</div>
          )}
        </Table.Cell>
        <Table.Cell>
          <Link
            variant={Link.variants.outlineDanger}
            onClick={deleteDeployment(deployment)}
            title='Delete'
          ><Icon stylePrefix='far' icon='fa-trash-alt' /></Link>
        </Table.Cell>
      </Table.Row>
    ));
}

const List = ({deployments, ...properties}) => (
  <Table {...properties}>
    <Table.Head
      columns={headers}
    />
    <Table.Body>
      <Rows deployments={deployments} />
    </Table.Body>
  </Table>
);

const mapStateToProps = ({deployments}) => ({
  deployments
});

export default connect(mapStateToProps, null, null)(List);

