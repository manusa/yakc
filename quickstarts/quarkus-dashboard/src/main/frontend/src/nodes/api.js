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

export const startNodesEventSource = ({addNode, deleteNode, clearNodes}) => {
  const eventSource = new EventSource(`${getApiURL()}/nodes`);
  eventSource.onopen = () => {
    clearNodes();
  }
  eventSource.onmessage = ({data}) => {
    const message = JSON.parse(data);
    if (message.object && message.type === 'ADDED') {
      switch (message.type) {
        case 'ADDED':
          addNode(message.object);
          break;
        case 'DELETED':
          deleteNode(message.object);
          break;
        default:
          // NOOP
      }
    }
  }
  eventSource.onerror = ({status, message}) => {
    console.error(`${status}: ${message}`);
  }
  return eventSource;
}

