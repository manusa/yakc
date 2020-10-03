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
import podsModule from './';
import Card from '../components/Card';
import ContainerList from '../components/ContainerList';
import DashboardPage from '../components/DashboardPage';
import Form from '../components/Form';
import Icon from '../components/Icon';
import Link from '../components/Link';

const PodsDetailPage = ({pod}) => (
  <DashboardPage
    title={`Pods - ${metadata.selectors.namespace(pod)} - ${metadata.selectors.name(pod)}`}
  >
    <Card>
      <Card.Title className='flex items-center'>
        <div className='flex-1'>
          {metadata.selectors.namespace(pod)} - {metadata.selectors.name(pod)}
        </div>
        <Link.RouterLink
          className='justify-self-end text-sm font-normal'
          variant={Link.variants.outline}
          to={`/pods/${metadata.selectors.uid(pod)}/logs`}
          title='Logs'
        >
          <Icon stylePrefix='far' icon='fa-file-alt' className='mr-2'/>Logs
        </Link.RouterLink>
      </Card.Title>
      <Card.Body>
        <Form>
          <metadata.Details resource={pod} />
          <Form.Field label='Node'>
            <Link.Node to={`/nodes/${podsModule.selectors.nodeName(pod)}`}>
              {podsModule.selectors.nodeName(pod)}
            </Link.Node>
          </Form.Field>
          <Form.Field label='Phase'>
            <podsModule.StatusIcon
              className='mr-1'
              statusPhase={podsModule.selectors.statusPhase(pod)}
            />
            {podsModule.selectors.statusPhase(pod)}
          </Form.Field>
          <Form.Field label='Restart Policy'>
            {podsModule.selectors.restartPolicy(pod)}
          </Form.Field>
          <Form.Field label='Pod IP'>
            {podsModule.selectors.statusPodIP(pod)}
          </Form.Field>
        </Form>
      </Card.Body>
    </Card>
    <ContainerList
      title='Containers'
      className='mt-4'
      containers={podsModule.selectors.containers(pod)} />
  </DashboardPage>
);

const mapStateToProps = ({pods}) => ({
  pods
});

const mergeProps = (stateProps, dispatchProps, ownProps) => ({
  ...stateProps,
  ...dispatchProps,
  ...ownProps,
  pod: stateProps.pods[ownProps.match.params.uid]
});

export default connect(mapStateToProps, null, mergeProps)(PodsDetailPage);