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
const actions = {
  CLEAR: 'CLEAR',
  ADD_EVENT: 'ADD_EVENT',
  CLEAR_EVENTS: 'CLEAR_EVENTS',
  ADD_NODE: 'ADD_NODE',
  DELETE_NODE: 'DELETE_NODE',
  CLEAR_NODES: 'CLEAR_NODES',
  ADD_OR_REPLACE_POD: 'ADD_OR_REPLACE_POD',
  DELETE_POD: 'DELETE_POD',
  CLEAR_PODS: 'CLEAR_PODS',
  ADD_OR_REPLACE_DEPLOYMENT: 'ADD_OR_REPLACE_DEPLOYMENT',
  DELETE_DEPLOYMENT: 'DELETE_DEPLOYMENT',
  CLEAR_DEPLOYMENTS: 'CLEAR_DEPLOYMENTS'
}

export const clear = () => ({
  type: actions.CLEAR
});

export default actions;
