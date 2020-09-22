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
import React, {useEffect, useRef, useState} from 'react';
import {connect} from 'react-redux';
import {Link} from 'react-router-dom';
import throttle from 'lodash/throttle';
import {Card, Container, Form, Header} from 'tabler-react';
import {AutoSizer, List} from 'react-virtualized';
import DashboardPage from '../components/DashboardPage';
import metadata from '../metadata';
import pods from '../pods';
import './PodsLogsPage.css'

const PodsLogsPage = ({uid, namespace, name}) => {
  const [log, setLog] = useState(['Loading logs...']);
  const [follow, setFollow] = useState(true);
  const throttledSetLog = throttle(setLog, 100, {trailing: true});
  const listRef = useRef();
  const [eventSource, setEventSource] = useState();
  useEffect(() => {
    if (!eventSource && namespace && name) {
      const es = pods.api.logs(namespace, name);
      es.onopen = () => {
        es.currentLog = [];
      }
      es.onmessage = ({data}) => {
        es.currentLog.push(data);
        throttledSetLog([...es.currentLog]);
      };
      setEventSource(es);
    }
  }, [eventSource, namespace, name, throttledSetLog]);
  useEffect(() => {
        if (follow) {
          listRef.current.scrollToRow(log.length);
        }
      },
    [log, follow]);
  useEffect(() => () =>  eventSource && eventSource.close(), [eventSource]);
  const rowRenderer = ({key, index, style}) => (
    <span key={key} className='pods-logs-page__log-row' style={style}>{log[index]}</span>
  );
  return (
    <DashboardPage className='pods-logs-page'>
      <Card
        className='mb-0'
      >
        <Card.Header>
          <Header RootComponent='h3' size={3} className='card-title'>
            Pod - {namespace} - <Link to={`/pods/${uid}`}>{name}</Link>
          </Header>
          <Container className='justify-content-end'>
            <Form.Switch label='Follow' checked={follow} onChange={() => setFollow(!follow)}/>
          </Container>
        </Card.Header>
        <Card.Body>
          <div className='pods-logs-page__log-container'>
            <AutoSizer>
              {({height, width}) =>(
                <List
                  ref={listRef}
                  height={height}
                  width={width}
                  rowCount={log.length}
                  rowHeight={19}
                  rowRenderer={rowRenderer}
                />
              )}
            </AutoSizer>
          </div>
        </Card.Body>
      </Card>
    </DashboardPage>
  );
};

const mapStateToProps = ({pods}) => ({
  pods
});

const mergeProps = (stateProps, dispatchProps, ownProps) => ({
  ...stateProps,
  ...dispatchProps,
  ...ownProps,
  uid: ownProps.match.params.uid,
  namespace: metadata.selectors.namespace(stateProps.pods[ownProps.match.params.uid]),
  name: metadata.selectors.name(stateProps.pods[ownProps.match.params.uid])
});

export default connect(mapStateToProps, null, mergeProps)(PodsLogsPage);