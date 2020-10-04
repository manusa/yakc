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
import deployments from './deployments';
import events from './events';
import ing from './ingresses';
import nodes from './nodes';
import pods from './pods';
import replicaSets from './replicasets';
import redux from './redux';
import services from './services';
import App from './App';

import 'typeface-open-sans/index.css';
import '@fortawesome/fontawesome-free/css/all.min.css';
import './assets/tailwind.css';
import 'simplebar/dist/simplebar.min.css';

const storeEnhancer = () => {
  if (process.env.NODE_ENV === 'development' && window.__REDUX_DEVTOOLS_EXTENSION__) {
    return window.__REDUX_DEVTOOLS_EXTENSION__();
  }
};

const store = createStore(combineReducers({
  deployments: deployments.reducer,
  events: events.reducer,
  ingresses: ing.reducer,
  nodes: nodes.reducer,
  pods: pods.reducer,
  replicaSets: replicaSets.reducer,
  services: services.reducer,
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

