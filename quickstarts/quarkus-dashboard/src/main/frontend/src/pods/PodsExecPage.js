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
import p from './index';
import Card from '../components/Card';
import DashboardPage from '../components/DashboardPage';

import 'xterm/css/xterm.css';

const PodsExecPage = ({namespace, name, containers}) => {
  const {ref} = p.useExec(namespace, name, containers);
  return (
    <DashboardPage
      title={`Pods - ${namespace} - ${name} - Terminal`}
      className='pods-logs-page'
    >
      <div className='absolute inset-0 md:p-4 flex flex-col'>
        <Card className='flex-1 flex flex-col'>
          <Card.Body padding='p-0' className='relative flex-1 bg-black'>
            <div ref={ref} className='absolute' style={{top: '1rem', bottom: '1rem', left: '1rem', right: '1rem'}}/>
          </Card.Body>
        </Card>
      </div>
    </DashboardPage>
  );
};

const mapStateToProps = ({pods}) => ({pods});

const mergeProps = ({pods}, dispatchProps, {match: {params: {uid}}}) => ({
  ...dispatchProps,
  namespace: metadata.selectors.namespace(pods[uid]),
  name: metadata.selectors.name(pods[uid]),
  containers: p.selectors.containers(pods[uid])
});

export default connect(mapStateToProps, null, mergeProps)(PodsExecPage);