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
const creationTimestamp = object => {
  const ct = object?.metadata?.creationTimestamp;
  if (ct) {
    return new Date(ct);
  }
}

const annotations = object => object?.metadata?.annotations ?? {};

const labels = object => object?.metadata?.labels ?? {};

const name = object => object?.metadata?.name ?? '';

const namespace = object => object?.metadata?.namespace ?? '';

const uid = object => object?.metadata?.uid ?? '';

const ownerReferencesUids = object => (object?.metadata?.ownerReferences ?? [])
  .map(or => or.uid);

// Selectors for Map<uid, resource> of Metadata Resources

const byUidOrName = (metadataResources, uidOrName) => {
  if (metadataResources[uidOrName]) {
    return metadataResources[uidOrName];
  }
  return Object.values(metadataResources)
  .find(resource => name(resource) === uidOrName);
}
export default {
  creationTimestamp,
  annotations,
  labels,
  name,
  namespace,
  uid,
  ownerReferencesUids,
  byUidOrName
};
