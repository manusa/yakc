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
import React, {useEffect} from 'react';
import {connect} from 'react-redux';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import deployments from './deployments';
import ingresses from './ingresses';
import nodes from './nodes';
import pods from './pods';
import services from './services';
import watch from './watch';
import redux from './redux';
import Home from './Home';

const eventSources = [];

const pollResources = dispatch => {
  const dispatchedPoll = async () => {
    const handleResourceList = kind => async resources => {
      await dispatch(redux.actions.crudSetAll({kind, resources}));
      dispatch(redux.actions.setResourceLoaded({kind, loaded: true}));
    };
    try {
      await Promise.all([
        services.api.list().then(handleResourceList('Service')),
        ingresses.api.list().then(handleResourceList('Ingress'))
      ]);
    } catch (e) {
      dispatch(redux.actions.setError('Error when polling resources (retrying)'));
    }
    setTimeout(dispatchedPoll, 3000)
  };
  return dispatchedPoll;
};

const onMount = ({dispatch}) => {
  eventSources.push(
    watch.api.startEventSource({dispatch})
  );
  pollResources(dispatch)();
};

const onUnmount = () => {
  eventSources.forEach(eventSource => {
    if (eventSource.close) {
      eventSource.close();
    }
  });
}

const App = ({dispatch}) => {
  useEffect(() => {
    onMount({dispatch});
    return onUnmount;
  }, []); // eslint-disable-line react-hooks/exhaustive-deps
  return (
      <Router>
        <Switch>
          <Route exact path='/' component={Home} />
          <Route exact path='/deployments' component={deployments.DeploymentsPage} />
          <Route exact path='/deployments/:uid' component={deployments.DeploymentsDetailPage} />
          <Route exact path='/ingresses' component={ingresses.IngressesPage} />
          <Route exact path='/ingresses/:uid' component={ingresses.IngressesDetailPage} />
          <Route exact path='/nodes' component={nodes.NodesPage} />
          <Route exact path='/nodes/:name' component={nodes.NodesDetailPage} />
          <Route exact path='/pods' component={pods.PodsPage} />
          <Route exact path='/pods/:uid' component={pods.PodsDetailPage} />
          <Route exact path='/pods/:uid/logs' component={pods.PodsLogsPage} />
          <Route exact path='/services' component={services.ServicesPage} />
          <Route exact path='/services/:uid' component={services.ServicesDetailPage} />
          {/*<Route component={Error404Page} />*/}
        </Switch>
      </Router>
  );
}

const mapStateToProps = () => ({});

const mapDispatchToProps = dispatch => ({dispatch});

export default connect(mapStateToProps, mapDispatchToProps)(App);
