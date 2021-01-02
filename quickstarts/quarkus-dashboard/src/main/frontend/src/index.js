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
import ReactDOM from 'react-dom';
import {Provider} from 'react-redux';
import {combineReducers, createStore} from 'redux';
import apis from './apis';
import crb from './clusterrolebindings';
import cRoles from './clusterroles';
import configMaps from './configmaps';
import crd from './customresourcedefinitions'
import ds from './daemonsets';
import dc from './deploymentconfigs'
import deployments from './deployments';
import events from './events';
import ing from './ingresses';
import job from './jobs';
import ns from './namespaces';
import nodes from './nodes';
import pvc from './persistentvolumeclaims';
import pv from './persistentvolumes';
import pods from './pods';
import replicaSets from './replicasets';
import rc from './replicationcontrollers';
import redux from './redux';
import roles from './roles';
import routes from './routes';
import secrets from './secrets';
import services from './services';
import sidebar from './sidebar';
import statefulSets from './statefulsets';
import App from './App';

import 'typeface-open-sans/index.css';
import '@fortawesome/fontawesome-free/css/all.min.css';
import './assets/tailwind.css';
import './assets/scroll.css';

const storeEnhancer = () => {
  if (process.env.NODE_ENV === 'development' && window.__REDUX_DEVTOOLS_EXTENSION__) {
    return window.__REDUX_DEVTOOLS_EXTENSION__();
  }
};

const store = createStore(combineReducers({
  apiGroups: apis.apiGroupsReducer,
  clusterRoleBindings: crb.reducer,
  clusterRoles: cRoles.reducer,
  configMaps: configMaps.reducer,
  customResourceDefinitions: crd.reducer,
  daemonSets: ds.reducer,
  deploymentConfigs: dc.reducer,
  deployments: deployments.reducer,
  events: events.reducer,
  ingresses: ing.reducer,
  jobs: job.reducer,
  namespaces: ns.reducer,
  nodes: nodes.reducer,
  persistentVolumeClaims: pvc.reducer,
  persistentVolumes: pv.reducer,
  pods: pods.reducer,
  replicaSets: replicaSets.reducer,
  replicationControllers: rc.reducer,
  roles: roles.reducer,
  routes: routes.reducer,
  secrets: secrets.reducer,
  services: services.reducer,
  statefulSets: statefulSets.reducer,
  sidebar: sidebar.reducer,
  ui: redux.uiReducer
}), storeEnhancer());

ReactDOM.render(
  <React.StrictMode>
    <Provider store={store}>
      <App />
    </Provider>
  </React.StrictMode>,
  document.getElementById('root')
);

