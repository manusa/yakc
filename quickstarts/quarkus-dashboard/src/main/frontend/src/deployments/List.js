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
  const restartDeployment = deployment => async () => await deploymentsModule.api.restart(deployment);
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
          <Link.Deployment to={`/deployments/${metadata.selectors.uid(deployment)}`}>
            {metadata.selectors.name(deployment)}
          </Link.Deployment>
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
        <Table.Cell className='whitespace-no-wrap text-center'>
          <Link
            variant={Link.variants.outline}
            onClick={restartDeployment(deployment)}
            title='Restart'
          ><Icon stylePrefix='fas' icon='fa-redo-alt' /></Link>
          <Table.DeleteButton
            className='ml-1'onClick={deleteDeployment(deployment)} />
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

const filterDeployments = (deployments = [], {
  namespace
} = undefined) => Object.entries(deployments)
.filter(([, deployment]) => {
  if (namespace) {
    return metadata.selectors.namespace(deployment) === namespace;
  }
  return true;
})
.reduce((acc, [key, deployment]) => {
  acc[key] = deployment;
  return acc;
}, {});

const mapStateToProps = ({deployments}) => ({
  deployments
});

const mergeProps = (stateProps, dispatchProps, ownProps) => ({
  ...stateProps,
  ...dispatchProps,
  ...ownProps,
  deployments: filterDeployments(stateProps.deployments, ownProps)
});

export default connect(mapStateToProps, null, mergeProps)(List);

