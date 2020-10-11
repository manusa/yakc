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
import ns from './';
import Card from '../components/Card';
import DashboardPage from '../components/DashboardPage';
import Form from '../components/Form';

const NamespacesDetailPage = ({namespace}) => (
  <DashboardPage
    title={`Namespaces - ${metadata.selectors.name(namespace)}`}
  >
    <Card>
      <Card.Title>
        {metadata.selectors.name(namespace)}
      </Card.Title>
      <Card.Body>
        <Form>
          <metadata.Details resource={namespace} />
          <Form.Field label='Status'>
            {ns.selectors.statusPhase(namespace)}
          </Form.Field>
        </Form>
      </Card.Body>
    </Card>
  </DashboardPage>
);

const mapStateToProps = ({namespaces}) => ({
  namespaces
});

const mergeProps = (stateProps, dispatchProps, ownProps) => ({
  ...stateProps,
  ...dispatchProps,
  ...ownProps,
  namespace: metadata.selectors.byUidOrName(stateProps.namespaces, ownProps.match.params.uid)
});

export default connect(mapStateToProps, null, mergeProps)(NamespacesDetailPage);