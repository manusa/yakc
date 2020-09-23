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
import {Card, Grid} from 'tabler-react';
import ContainerList from '../components/ContainerList';
import DashboardPage from '../components/DashboardPage';
import Field from '../components/Field';
import metadata from '../metadata';
import deploymentsModule from './';
import pods from '../pods';
import replicaSets from '../replicasets';

const DeploymentsDetailPage = ({deployment, replicaSetsUids}) => (
  <DashboardPage>
    <Card title={`Deployment - ${metadata.selectors.namespace(deployment)} - ${metadata.selectors.name(deployment)}`}>
      <Card.Body>
        <metadata.Details resource={deployment} />
        <Grid.Row>
          <Field label='Replicas'>{deploymentsModule.selectors.specReplicas(deployment)}</Field>
          <Field label='Strategy'>{deploymentsModule.selectors.specStrategyType(deployment)}</Field>
        </Grid.Row>
      </Card.Body>
    </Card>
    <ContainerList containers={deploymentsModule.selectors.containers(deployment)} />
    <replicaSets.List ownerId={metadata.selectors.uid(deployment)} />
    <pods.List ownerUids={replicaSetsUids} />
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