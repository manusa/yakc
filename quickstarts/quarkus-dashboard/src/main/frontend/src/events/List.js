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
import {Link} from 'react-router-dom';
import {Card, Table, Tooltip} from 'tabler-react';
import TableNoResults from '../components/TableNoResults';
import metadata from "../metadata";

const headers = [
  'Type',
  'Name',
  'Time',
  'Reason',
  'Event'
]

const EventName = ({event}) => {
  let url;
  switch (event.involvedObject.kind) {
    case 'Deployment':
      url = `/deployments/${event.involvedObject.uid}`;
      break;
    case 'Pod':
      url = `/pods/${event.involvedObject.uid}`;
      break;
    default:
      url = null;
  }
  if (url) {
    return <Link to={url}>{event.involvedObject.name}</Link>;
  }
  return event.involvedObject.name;
}

const sort = (ev1, ev2) =>
  new Date(ev2.lastTimestamp) - new Date(ev1.lastTimestamp);

const Rows = ({events}) => {
  const allEvents = Object.values(events);
  if (allEvents.length === 0) {
    return <TableNoResults colSpan={headers.length} />;
  }
  return allEvents
    .sort(sort)
    .slice(0, 10)
    .map(event => (
        <Table.Row key={metadata.selectors.uid(event)}>
          <Table.Col className='text-nowrap'>
            {event.involvedObject.kind}
          </Table.Col>
          <Table.Col>
            <EventName event={event} />
          </Table.Col>
          <Table.Col>
            <Tooltip content={event.lastTimestamp} placement='right'>
              <span>{new Date(event.lastTimestamp).toLocaleDateString()}</span>
            </Tooltip>
          </Table.Col>
          <Table.Col>
            {event.reason}
          </Table.Col>
          <Table.Col>
            {event.message}
          </Table.Col>
        </Table.Row>
    ));
}

const List = ({events}) => (
  <Card title='Latest Events' className='table-responsive-sm'>
    <Table
      responsive
      className='card-table table-vcenter table-striped'
    >
      <Table.Header>
        <Table.Row>
          {headers.map((header, idx) => (
            <Table.ColHeader key={idx}>{header}</Table.ColHeader>
          ))}
        </Table.Row>
      </Table.Header>
      <Table.Body>
        <Rows events={events} />
      </Table.Body>
    </Table>
  </Card>
);

const mapStateToProps = ({events}) => ({
  events
});

export default connect(mapStateToProps)(List);

