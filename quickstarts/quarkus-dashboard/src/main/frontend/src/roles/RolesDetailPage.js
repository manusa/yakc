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
import {withParams} from '../router';
import metadata from '../metadata';
import cRoles from '../clusterroles';
import r from './';
import Form from '../components/Form';
import ResourceDetailPage from '../components/ResourceDetailPage';

const RolesDetailPage = ({role}) => (
  <ResourceDetailPage
    kind='Roles'
    path='roles'
    resource={role}
    deleteFunction={r.api.delete}
    body={
      <Form>
        <metadata.Details resource={role}/>
      </Form>
    }
  >
    <cRoles.RuleList className='mt-2' rules={r.selectors.rules(role)}/>
  </ResourceDetailPage>
);

const mapStateToProps = ({roles}) => ({
  roles
});

const mergeProps = (stateProps, dispatchProps, ownProps) => ({
  ...stateProps,
  ...dispatchProps,
  ...ownProps,
  role: stateProps.roles[ownProps.params.uid],
});

export default withParams(connect(mapStateToProps, null, mergeProps)(RolesDetailPage));
