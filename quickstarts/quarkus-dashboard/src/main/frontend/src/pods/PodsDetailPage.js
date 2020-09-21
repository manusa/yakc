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
import {Link} from 'react-router-dom';
import {Card, Form, Grid, Icon} from 'tabler-react';
import ContainerList from '../components/ContainerList';
import DashboardPage from '../components/DashboardPage';
import metadata from '../metadata';
import podsModule from './';

const Field = ({label, children}) => (
  <Grid.Col width={12} md={6} lg={4}>
    <Form.Group label={label}>
      <Form.StaticText>{children}</Form.StaticText>
    </Form.Group>
  </Grid.Col>
);

const PodsDetailPage = ({pod}) => (
  <DashboardPage>
    <Card title={`Pod - ${metadata.selectors.namespace(pod)} - ${metadata.selectors.name(pod)}`}>
      <Card.Body>
        <Grid.Row>
          <Grid.Col width={12} className='text-right mb-2'>
            <Link
              className='btn btn-outline-primary btn-icon'
              to={`/pods/${metadata.selectors.uid(pod)}/logs`}
            ><Icon name='file-text' className='mr-2' />Logs</Link>
          </Grid.Col>
          <Field label='Name'>{metadata.selectors.name(pod)}</Field>
          <Field label='Namespace'>{metadata.selectors.namespace(pod)}</Field>
          <Field label='Node'>
            <Link to={`/nodes/${podsModule.selectors.nodeName(pod)}`}>
              {podsModule.selectors.nodeName(pod)}
            </Link>
          </Field>
          <Grid.Col width={12} >
            <Form.Group label='Labels'>
              <metadata.Labels labels={metadata.selectors.labels(pod)} />
            </Form.Group>
          </Grid.Col>
          <Field label='Phase'>{podsModule.selectors.statusPhase(pod)}</Field>
        </Grid.Row>
      </Card.Body>
    </Card>
    <ContainerList containers={podsModule.selectors.containers(pod)} />
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