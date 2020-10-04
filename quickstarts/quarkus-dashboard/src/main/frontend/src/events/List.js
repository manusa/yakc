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
import {connect} from 'react-redux'
import Link from '../components/Link';
import Table from '../components/Table';
import Tooltip from '../components/Tooltip';
import metadata from "../metadata";
import Icon from '../components/Icon';

const headers = [
  'Type',
  <span><Icon className='fa-id-card' /> Name</span>,
  'Time',
  'Reason',
  'Event'
]

const EventName = ({event}) => {
  let Component = Link.RouterLink;
  let url;
  switch (event.involvedObject.kind) {
    case 'Deployment':
      url = `/deployments/${event.involvedObject.uid}`;
      break;
    case 'Ingress':
      Component = Link.Ingress;
      url = `/ingresses/${event.involvedObject.uid}`;
      break;
    case 'Pod':
      Component = Link.Pod;
      url = `/pods/${event.involvedObject.uid}`;
      break;
    default:
      url = null;
  }
  if (url) {
    return <Component to={url}>{event.involvedObject.name}</Component>;
  }
  return event.involvedObject.name;
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
            {event.involvedObject.kind}
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
  <Table title='Latest Events' {...properties}>
    <Table.Head
      columns={headers}
    />
    <Table.Body>
      <Rows events={events} />
    </Table.Body>
  </Table>
);

const mapStateToProps = ({events}) => ({
  events
});

export default connect(mapStateToProps)(List);

