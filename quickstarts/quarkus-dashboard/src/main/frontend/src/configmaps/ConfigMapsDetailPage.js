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
import cm from './';
import metadata from '../metadata';
import Card from '../components/Card';
import DashboardPage from '../components/DashboardPage';
import Form from '../components/Form';
import Link from '../components/Link';

const DataField = ({label, value}) => (
  <Form.Field width={Form.widths.full} label={label}>
    <div
      className='bg-black text-white font-mono text-sm p-2 overflow-auto'
      style={{maxHeight: '10rem'}}
    >
      <pre>{value}</pre>
    </div>
  </Form.Field>
)
const ConfigMapsDetailPage = ({configMap}) => (
  <DashboardPage
    title={`ConfigMaps - ${metadata.selectors.namespace(configMap)} - ${metadata.selectors.name(configMap)}`}
  >
    <Card>
      <Card.Title className='flex items-center'>
        <div className='flex-1'>
          {metadata.selectors.namespace(configMap)} - {metadata.selectors.name(configMap)}
        </div>
        <Link.EditLink path='configmaps' resource={configMap} />
      </Card.Title>
      <Card.Body>
        <Form>
          <metadata.Details resource={configMap} />
          {Object.entries(cm.selectors.data(configMap)).map(([key, value]) =>
            <DataField key={key} label={key} value={value} />)}
        </Form>
      </Card.Body>
    </Card>
  </DashboardPage>
);

const mapStateToProps = ({configMaps}) => ({
  configMaps
});

const mergeProps = (stateProps, dispatchProps, ownProps) => ({
  ...stateProps,
  ...dispatchProps,
  ...ownProps,
  configMap: stateProps.configMaps[ownProps.match.params.uid],
});

export default connect(mapStateToProps, null, mergeProps)(ConfigMapsDetailPage);