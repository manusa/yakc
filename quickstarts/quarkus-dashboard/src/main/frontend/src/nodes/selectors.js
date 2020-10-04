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
import metadata from '../metadata';

const isReady = node => {
  const ready = (node?.status?.conditions ?? [])
    .find(condition => condition.type === 'Ready');
  return ready && ready.status;
};

const statusAddresses = node => node?.status?.addresses ?? [];

const statusAddressesFirstAddress = node =>
  statusAddresses(node).map(a => a.address ?? '').find(a => a) ?? '';

// Selectors for array of Nodes

const readyCount = nodes => nodes.reduce(
  (count, node) => isReady(node) ? ++count : count,
  0
);

const isMinikube = nodes => Object.values(nodes).length === 1 && Object.values(nodes)
  .filter(node => metadata.selectors.name(node) === 'minikube')
  .filter(node => metadata.selectors.labels(node)['minikube.k8s.io/name'] === 'minikube')
  .filter(node => metadata.selectors.labels(node).hasOwnProperty('node-role.kubernetes.io/master'))
  .length === 1;

export default {
  isReady,
  statusAddresses,
  statusAddressesFirstAddress,
  readyCount,
  isMinikube
};
