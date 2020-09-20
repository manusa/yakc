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
import {Error404Page} from 'tabler-react';
import deployments from './deployments';
import nodes from './nodes';
import pods from './pods';
import watch from './watch';
import Home from './Home';

const eventSources = [];

const onMount = ({dispatch}) => {
  eventSources.push(
    watch.api.startEventSource({dispatch})
  );
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
          <Route exact path='/nodes' component={nodes.NodesPage} />
          <Route exact path='/nodes/:name' component={nodes.NodesDetailPage} />
          <Route exact path='/pods' component={pods.PodsPage} />
          <Route exact path='/pods/:uid' component={pods.PodsDetailPage} />
          <Route component={Error404Page} />
        </Switch>
      </Router>
  );
}

const mapStateToProps = () => ({});

const mapDispatchToProps = dispatch => ({dispatch});

export default connect(mapStateToProps, mapDispatchToProps)(App);
