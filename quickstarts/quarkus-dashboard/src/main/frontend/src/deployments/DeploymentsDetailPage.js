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
import {connect} from 'react-redux';
import metadata from '../metadata';
import deploymentsModule from './';
import pods from '../pods';
import replicaSets from '../replicasets';
import Card from '../components/Card';
import ContainerList from '../components/ContainerList';
import DashboardPage from '../components/DashboardPage';
import Form from '../components/Form';

const DeploymentsDetailPage = ({deployment, replicaSetsUids}) => (
  <DashboardPage
    title={`Deployments - ${metadata.selectors.namespace(deployment)} - ${metadata.selectors.name(deployment)}`}
  >
    <Card >
      <Card.Title>
        {metadata.selectors.namespace(deployment)} - {metadata.selectors.name(deployment)}
      </Card.Title>
      <Card.Body>
        <Form>
          <metadata.Details resource={deployment} />
          <Form.Field label='Replicas'>{deploymentsModule.selectors.specReplicas(deployment)}</Form.Field>
          <Form.Field label='Strategy'>{deploymentsModule.selectors.specStrategyType(deployment)}</Form.Field>
        </Form>
      </Card.Body>
    </Card>
    <ContainerList
      title='Containers'
      className='mt-4'
      containers={deploymentsModule.selectors.containers(deployment)} />
    <replicaSets.List
      title='Replica Sets'
      className='mt-4'
      ownerId={metadata.selectors.uid(deployment)} />
    <pods.List
      title='Pods'
      className='mt-4'
      ownerUids={replicaSetsUids} />
  </DashboardPage>
);

const mapStateToProps = ({deployments, replicaSets}) => ({
  deployments,
  replicaSets
});

const mergeProps = (stateProps, dispatchProps, ownProps) => ({
  ...stateProps,
  ...dispatchProps,
  ...ownProps,
  deployment: stateProps.deployments[ownProps.match.params.uid],
  replicaSetsUids: Object.values(stateProps.replicaSets)
    .filter(replicaSet => metadata.selectors.ownerReferencesUids(replicaSet)
      .includes(metadata.selectors.uid(stateProps.deployments[ownProps.match.params.uid])))
    .map(replicaSet => metadata.selectors.uid(replicaSet))
});

export default connect(mapStateToProps, null, mergeProps)(DeploymentsDetailPage);