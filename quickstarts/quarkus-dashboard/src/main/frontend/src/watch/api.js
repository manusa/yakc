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
import {bindActionCreators} from "redux";
import {clear} from '../actions';
import deployments from '../deployments';
import events from '../events';
import nodes from '../nodes';
import pods from '../pods';
import replicaSets from '../replicasets';

const addOrReplace = (actions, object) => {
  switch (object.kind) {
    case 'Deployment':
      actions.addOrReplaceDeployment(object);
      break;
    case 'Event':
      actions.addEvent(object);
      break;
    case 'Node':
      actions.addNode(object);
      break;
    case 'Pod':
      actions.addOrReplacePod(object);
      break;
    case 'ReplicaSet':
      actions.addOrReplaceReplicaSet(object);
      break;
    default:
      // NOOP
  }
};

const deleteObject = (actions, object) => {
  switch (object.kind) {
    case 'Deployment':
      actions.deleteDeployment(object);
      break;
    case 'Node':
      actions.deleteNode(object);
      break;
    case 'Pod':
      actions.deletePod(object);
      break;
    case 'ReplicaSet':
      actions.deleteReplicaSet(object);
      break;
    default:
    // NOOP
  }
}

const startEventSource =
  ({dispatch}) => {
    const actions = bindActionCreators({
      clear,
      ...deployments.actions,
      ...events.actions,
      ...nodes.actions,
      ...pods.actions,
      ...replicaSets.actions
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
            addOrReplace(actions, message.object);
            break;
          case 'DELETED':
            deleteObject(actions, message.object);
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
  };

export default {
  startEventSource,
};
