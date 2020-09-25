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
import svc from './';
import Card from '../components/Card';
import DashboardPage from '../components/DashboardPage';
import Form from '../components/Form';

const ServicesDetailPage = ({service}) => (
  <DashboardPage
    title={`Services - ${metadata.selectors.namespace(service)} - ${metadata.selectors.name(service)}`}
  >
    <Card>
      <Card.Title>
        {metadata.selectors.namespace(service)} - {metadata.selectors.name(service)}
      </Card.Title>
      <Card.Body>
        <Form>
          <metadata.Details resource={service} />
          <Form.Field label='Cluster IP'>{svc.selectors.specClusterIP(service)}</Form.Field>
        </Form>
      </Card.Body>
    </Card>
  </DashboardPage>
);

const mapStateToProps = ({services}) => ({
  services
});

const mergeProps = (stateProps, dispatchProps, ownProps) => ({
  ...stateProps,
  ...dispatchProps,
  ...ownProps,
  service: stateProps.services[ownProps.match.params.uid],
});

export default connect(mapStateToProps, null, mergeProps)(ServicesDetailPage);