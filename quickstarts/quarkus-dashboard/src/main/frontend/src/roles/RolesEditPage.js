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
import md from '../metadata';
import r from './';
import ResourceEditPage from '../components/ResourceEditPage';
import Link from '../components/Link';

const RolesEditPage = ({match: {params: {uid}}}) => (
  <ResourceEditPage
    kind='Roles'
    path='roles'
    cardTitle={resource =>
      <Link.RouterLink to={`/roles/${uid}`}>{md.selectors.name(resource)}</Link.RouterLink>
    }
    save={async resource => await r.api.update(resource)}
    resourceFromState={state => state.roles[uid]}
  />
);

export default RolesEditPage;