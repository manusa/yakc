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
import {Card, Form, Grid, Table} from 'tabler-react';
import DashboardPage from '../components/DashboardPage';
import metadata from '../metadata';
import pods from './';

const Field = ({label, children}) => (
  <Grid.Col width={12} md={6} lg={4}>
    <Form.Group label={label}>
      <Form.StaticText>{children}</Form.StaticText>
    </Form.Group>
  </Grid.Col>
);

const containerHeaders = ['Name', 'Image', 'Ports'];

const ContainerList = ({containers}) => (
    <Card title='Containers'>
      <Table
        responsive
        className='card-table table-vcenter table-striped'
      >
        <Table.Header>
          <Table.Row>
            {containerHeaders.map((header, idx) => (
              <Table.ColHeader key={idx}>{header}</Table.ColHeader>
            ))}
          </Table.Row>
        </Table.Header>
        <Table.Body>
          {containers.map(c => (
            <Table.Row key={c.name}>
              <Table.Col>{c.name}</Table.Col>
              <Table.Col>{c.image}</Table.Col>
              <Table.Col>
                {(c.ports ?? []).map((p, idx) => (
                  <div key={idx}>{p.name} {p.containerPort} {p.protocol}</div>
                ))}
              </Table.Col>
            </Table.Row>
          ))}
        </Table.Body>
      </Table>
    </Card>
);

const PodsDetailPage = ({pod}) => (
  <DashboardPage>
    <Card title={`Pod - ${metadata.selectors.namespace(pod)} - ${metadata.selectors.name(pod)}`}>
      <Card.Body>
        <Grid.Row>
          <Field label='Name'>{metadata.selectors.name(pod)}</Field>
          <Field label='Namespace'>{metadata.selectors.namespace(pod)}</Field>
          <Field label='Node'>
            <Link to={`/nodes/${pods.selectors.nodeName(pod)}`}>
              {pods.selectors.nodeName(pod)}
            </Link>
          </Field>
          <Grid.Col width={12} >
            <Form.Group label='Labels'>
              <metadata.Labels labels={metadata.selectors.labels(pod)} />
            </Form.Group>
          </Grid.Col>
          <Field label='Phase'>{pods.selectors.statusPhase(pod)}</Field>
        </Grid.Row>
      </Card.Body>
    </Card>
    <ContainerList containers={pods.selectors.containers(pod)} />
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