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
const statusReplicas = deployment => deployment?.status?.replicas ?? 0;

const statusReadyReplicas = deployment => deployment?.status?.readyReplicas ?? 0;

const isReady = deployment => statusReplicas(deployment) === statusReadyReplicas(deployment);

const containers = deployment => deployment?.spec?.template?.spec?.containers ?? [];

const images = deployment => containers(deployment).map(c => c.image);

// Selectors for array of Deployments

const readyCount = deployments => deployments.reduce(
  (count, deployment) => isReady(deployment) ? count + 1 : count,
  0
);

export default {
  statusReplicas,
  statusReadyReplicas,
  isReady,
  containers,
  images,
  readyCount
};
