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
import {bindActionCreators} from 'redux';
import {connect} from 'react-redux';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import {Error404Page} from 'tabler-react';
import events from './events'
import nodes from './nodes'
import Home from './Home';

const eventSources = [];

const onMount = ({addEvent, clearEvents, addNode, deleteNode, clearNodes}) => {
  eventSources.push(
    events.startEventSource({addEvent, clearEvents}),
    nodes.startNodesEventSource({addNode, deleteNode, clearNodes})
  );
};

const onUnmount = () => {
  eventSources.forEach(eventSource => {
    if (eventSource.close) {
      eventSource.close();
    }
  });
}

const App = (props) => {
  useEffect(() =>{
    onMount(props);
    return onUnmount;
  }, []); // eslint-disable-line react-hooks/exhaustive-deps
  return (
      <Router>
        <Switch>
          <Route exact path='/' component={Home} />
          <Route exact path='/nodes' component={nodes.NodesPage} />
          <Route component={Error404Page} />
        </Switch>
      </Router>
  );
}

const mapStateToProps = state => ({
  events: state.events
});

const mapDispatchToProps = dispatch => bindActionCreators({
  addEvent: events.addEvent,
  clearEvents: events.clearEvents,
  addNode: nodes.addNode,
  deleteNode: nodes.deleteNode,
  clearNodes: nodes.clearNodes
}, dispatch);

export default connect(mapStateToProps, mapDispatchToProps)(App);
