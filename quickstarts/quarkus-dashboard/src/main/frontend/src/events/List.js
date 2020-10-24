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
import metadata from '../metadata';
import ev from './'
import Link from '../components/Link';
import Table from '../components/Table';
import Tooltip from '../components/Tooltip';
import Icon from '../components/Icon';
import ResourceList from '../components/ResourceList';

const headers = [
  'Type',
  <span><Icon icon='fa-id-card' /> Name</span>,
  <span><Icon stylePrefix='far' icon='fa-clock' /> Time</span>,
  'Reason',
  'Event'
]

const EventName = ({event}) => {
  let Component = Link.RouterLink;
  let url;
  const uid = ev.selectors.involvedObjectUid(event);
  const name = ev.selectors.involvedObjectName(event);
  switch (ev.selectors.involvedObjectKind(event)) {
    case 'Deployment':
      Component = Link.Deployment;
      url = `/deployments/${uid}`;
      break;
    case 'Ingress':
      Component = Link.Ingress;
      url = `/ingresses/${uid}`;
      break;
    case 'Pod':
      Component = Link.Pod;
      url = `/pods/${uid}`;
      break;
    default:
      url = null;
  }
  if (url) {
    return <Component to={url}>{name}</Component>;
  }
  return name;
}

const sort = (ev1, ev2) =>
  new Date(ev2.lastTimestamp) - new Date(ev1.lastTimestamp);

const Rows = ({events}) => {
  const allEvents = Object.values(events);
  if (allEvents.length === 0) {
    return <Table.NoResultsRow colSpan={headers.length} />;
  }
  return allEvents
    .sort(sort)
    .slice(0, 10)
    .map(event => {
      const lastTimestamp = new Date(event.lastTimestamp);
      return (
        <Table.Row key={metadata.selectors.uid(event)}>
          <Table.Cell className='whitespace-no-wrap'>
            {ev.selectors.involvedObjectKind(event)}
          </Table.Cell>
          <Table.Cell>
            <EventName event={event}/>
          </Table.Cell>
          <Table.Cell>
            <Tooltip
              content={`${lastTimestamp.toLocaleDateString()}
                ${lastTimestamp.toLocaleTimeString()}`}
              className='cursor-default'
            >
              <span>{lastTimestamp.toLocaleDateString()}</span>
            </Tooltip>
          </Table.Cell>
          <Table.Cell>
            {event.reason}
          </Table.Cell>
          <Table.Cell>
            {event.message}
          </Table.Cell>
        </Table.Row>
      );
    });
}

const List = ({events, ...properties}) => (
  <ResourceList title='Latest Events' headers={headers} {...properties}>
    <Rows events={events} />
  </ResourceList>
);

const filterEvents = (events = [], {
  namespace
} = undefined) => Object.entries(events)
.filter(([, event]) => {
  if (namespace) {
    return ev.selectors.involvedObjectNamespace(event) === namespace;
  }
  return true;
})
.reduce((acc, [key, event]) => {
  acc[key] = event;
  return acc;
}, {});

const mapStateToProps = ({events}) => ({
  events
});

const mergeProps = (stateProps, dispatchProps, ownProps) => ({
  ...stateProps,
  ...dispatchProps,
  ...ownProps,
  events: filterEvents(stateProps.events, ownProps)
});

export default connect(mapStateToProps, null, mergeProps)(List);

