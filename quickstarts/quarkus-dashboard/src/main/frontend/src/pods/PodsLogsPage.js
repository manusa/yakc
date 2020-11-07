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
import throttle from 'lodash/throttle';
import {AutoSizer, List} from 'react-virtualized';
import metadata from '../metadata';
import p from '../pods';
import Card from '../components/Card';
import DashboardPage from '../components/DashboardPage';
import Link from '../components/Link';
import Switch from '../components/Switch';

import './PodsLogsPage.css';

const PodsLogsPage = ({uid, namespace, name}) => {
  const [log, setLog] = useState(['Loading logs...']);
  const [follow, setFollow] = useState(true);
  const throttledSetLog = throttle(setLog, 100, {trailing: true});
  const listRef = useRef();
  const [eventSource, setEventSource] = useState();
  useEffect(() => {
    if (!eventSource && namespace && name) {
      const es = p.api.logs(namespace, name);
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
          const {current} = listRef;
          current.scrollToRow(current.props.rowCount);
        }
      },
    [log, follow]);
  useEffect(() => () =>  eventSource && eventSource.close(), [eventSource]);
  const rowRenderer = ({key, index, style}) => (
    <div key={key} className='whitespace-no-wrap' style={{...style, width: 'auto'}}>{log[index]}</div>
  );
  return (
    <DashboardPage
      title={`Pods - ${namespace} - ${name} - Logs`}
      className='pods-logs-page'
    >
      <div className='absolute inset-0 md:p-4 flex flex-col'>
        <Card className='flex-1 flex flex-col'>
          <Card.Title className='flex items-center'>
            <div className='flex-1'>Logs - <Link.RouterLink to={`/pods/${uid}`}>{name}</Link.RouterLink></div>
            <div className='justify-self-end text-sm font-normal'>
              <Switch label='Follow' checked={follow} onChange={() => setFollow(!follow)} />
            </div>
          </Card.Title>
          <Card.Body className='flex-1 bg-black text-white font-mono text-sm'>
            <AutoSizer>
              {({ height, width }) => (
                <List
                  ref={listRef}
                  height={height}
                  width={width}
                  rowCount={log.length}
                  rowHeight={19}
                  rowRenderer={rowRenderer}
                  className='custom-scroll-dark'
                  // style={{'--scrollbar-color': 'rgba(255,255,255, 0.5)'}}
                />
              )}
            </AutoSizer>
          </Card.Body>
        </Card>
      </div>
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