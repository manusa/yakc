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
import {getApiURL} from './env';
import events from './events'
import Home from './Home';

import './App.css';
import {clearEvents} from './events/reducer';

let eventSource;

const onMount = ({addEvent}) => {
  eventSource = new EventSource(`${getApiURL()}/events`);
  eventSource.onopen = () => {
    clearEvents();
  }
  eventSource.onmessage = ({data}) => {
    const message = JSON.parse(data);
    if (message.object && message.type === 'ADDED') {
      addEvent(message.object);
    }
  }
  eventSource.onerror = ({status, message}) => {
    console.error(`${status}: ${message}`);
  }
};

const onUnmount = () => {
  if (eventSource && eventSource.close) {
    eventSource.close();
  }
}

const App = ({addEvent, clearEvents}) => {
  useEffect(() =>{
    onMount({addEvent, clearEvents});
    return onUnmount;
  }, [addEvent, clearEvents])
  return (
      <Router>
        <Switch>
          <Route exact path="/" component={Home} />
          <Route exact path="/other" component={Home} />
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
  clearEvents: events.clearEvents
}, dispatch);

export default connect(mapStateToProps, mapDispatchToProps)(App);
