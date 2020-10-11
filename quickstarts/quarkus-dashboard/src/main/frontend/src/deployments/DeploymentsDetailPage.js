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
import d from './';
import pods from '../pods';
import rs from '../replicasets';
import Card from '../components/Card';
import ContainerList from '../components/ContainerList';
import DashboardPage from '../components/DashboardPage';
import Form from '../components/Form';
import Icon from '../components/Icon';
import Link from '../components/Link';

const ReplicasField = ({deployment}) => {
  const replicas = d.selectors.specReplicas(deployment);
  return (
    <Form.Field label='Replicas'>
      <div className='flex items-center'>
        <Icon stylePrefix='far' icon='fa-copy' className='text-gray-600 mr-2' />
        {replicas}
        <div className='flex flex-col ml-2 text-blue-600'>
          <Icon
            icon='fa-caret-up'
            className='leading-3 hover:text-blue-800 cursor-pointer'
            onClick={() => d.api.updateReplicas(deployment, replicas + 1)}
          />
          <Icon
            icon='fa-caret-down'
            className={`leading-3 ${replicas > 0 ? 'hover:text-blue-800 cursor-pointer' : 'text-gray-600'}`}
            onClick={() => d.api.updateReplicas(deployment, replicas - 1)}
          />
        </div>
      </div>
    </Form.Field>
  );
}

const DeploymentsDetailPage = ({deployment, replicaSetsUids}) => (
  <DashboardPage
    title={`Deployments - ${metadata.selectors.namespace(deployment)} - ${metadata.selectors.name(deployment)}`}
  >
    <Card>
      <Card.Title className='flex items-center'>
        <div className='flex-1'>
          {metadata.selectors.namespace(deployment)} - {metadata.selectors.name(deployment)}
        </div>
        <Link
          variant={Link.variants.outline}
          className='justify-self-end text-sm font-normal'
          onClick={() => d.api.restart(deployment)}
          title='Restart'
        >
          <Icon stylePrefix='fas' icon='fa-redo-alt' className='mr-2' />
          Restart
        </Link>
      </Card.Title>
      <Card.Body>
        <Form>
          <metadata.Details resource={deployment} />
          <ReplicasField deployment={deployment} />
          <Form.Field label='Strategy'>{d.selectors.specStrategyType(deployment)}</Form.Field>
        </Form>
      </Card.Body>
    </Card>
    <ContainerList
      title='Containers'
      titleVariant={Card.titleVariants.medium}
      className='mt-2'
      containers={d.selectors.containers(deployment)} />
    <rs.List
      title='Replica Sets'
      titleVariant={Card.titleVariants.medium}
      className='mt-2'
      ownerId={metadata.selectors.uid(deployment)} />
    <pods.List
      title='Pods'
      titleVariant={Card.titleVariants.medium}
      className='mt-2'
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