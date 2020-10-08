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
const statusPhase = pod => pod?.status?.phase ?? '';

const statusPodIP = pod => pod?.status?.podIP ?? '';

const nodeName = pod => pod?.spec?.nodeName ?? '';

const restartPolicy = pod => pod?.spec?.restartPolicy ?? '';

const containers = pod => (pod?.spec?.containers ?? []);

const containerStatuses = pod => (pod?.status?.containerStatuses ?? []);

const containersReady = pod => {
  const css = containerStatuses(pod);
  return css.length > 0 && css.every(cs => cs.ready);
};

const succededOrContainersReady = pod =>
  statusPhase(pod) === 'Succeded' || containersReady(pod);

const restartCount = pod => containerStatuses(pod).reduce(
  (acc, containerStatus) => acc + containerStatus.restartCount,
  0
);

// Selectors for array of Pods

const readyCount = pods => pods.reduce(
  (count, pod) => containersReady(pod) ? ++count : count,
  0
);

export default {
  statusPhase,
  statusPodIP,
  nodeName,
  restartPolicy,
  containers,
  containersReady,
  succededOrContainersReady,
  restartCount,
  readyCount
};
