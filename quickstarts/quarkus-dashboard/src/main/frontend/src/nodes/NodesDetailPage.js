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
import DashboardPage from '../components/DashboardPage';
import metadata from '../metadata';
import pods from '../pods';
import Card from '../components/Card';
import Form from '../components/Form';

const NodesDetailPage = ({node}) => (
  <DashboardPage title={`Nodes - ${metadata.selectors.name(node)}`}>
    <Card>
      <Card.Title>
        {`${metadata.selectors.name(node)}`}
      </Card.Title>
      <Card.Body>
        <Form>
          <metadata.Details resource={node} />
        </Form>
      </Card.Body>
    </Card>
    <pods.List title='Pods' className='mt-4' nodeName={metadata.selectors.name(node)} />
  </DashboardPage>
);

const mapStateToProps = ({nodes}) => ({
  nodes
});

const mergeProps = (stateProps, dispatchProps, ownProps) => ({
  ...stateProps,
  ...dispatchProps,
  ...ownProps,
  node: Object.values(stateProps.nodes).find(node =>
    metadata.selectors.name(node) === ownProps.match.params.name)
});

export default connect(mapStateToProps, null, mergeProps)(NodesDetailPage);