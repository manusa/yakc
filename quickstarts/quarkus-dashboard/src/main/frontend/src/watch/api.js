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
import {getApiURL} from '../env';
import {bindActionCreators} from 'redux';
import redux from '../redux';

const startEventSource =
  ({dispatch}) => {
    const actions = bindActionCreators({
      ...redux.actions
    }, dispatch);
    const eventSource = new EventSource(`${getApiURL()}/watch`);
    eventSource.onopen = () => {
      actions.clear();
    }
    eventSource.onmessage = ({data}) => {
      const message = JSON.parse(data);
      if (message.object) {
        switch (message.type) {
          case 'MODIFIED':
          case 'ADDED':
            actions.crudAddOrReplace(message.object);
            break;
          case 'DELETED':
            actions.crudDelete(message.object);
            break;
          case 'ERROR':
            actions.setError(`${message.object.code ?? ''} ${message.object.message}`);
            break;
          default:
            // NOOP
        }
      }
    }
    eventSource.onerror = () => {
      console.error('Error starting watch');
      actions.setError('Connection error');
    }
    return eventSource;
  };

export default {
  startEventSource,
};
