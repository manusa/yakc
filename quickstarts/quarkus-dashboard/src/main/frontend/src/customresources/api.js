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
import {listResource, deleteResource, deleteNamespacedResource} from '../fetch';
import crds from '../customresourcedefinitions';

export default {
  list: crd => listResource(
    `customresources/${
      crds.selectors.specGroup(crd)
    }/${
      crds.selectors.specVersionsLatest(crd)
    }/${
      crds.selectors.specNamesPlural(crd)
    }`,
    crds.selectors.specNamesKind(crd)
  ),
  delete: crd => {
    const basePath = `customresources/${
      crds.selectors.specGroup(crd)}/${
      crds.selectors.specVersionsLatest(crd)}/${
      crds.selectors.specNamesPlural(crd)
    }`;
    const namespaced = crds.selectors.specScope(crd) === 'Namespaced';
    if (namespaced) {
      return deleteNamespacedResource(`${basePath}/namespaces`);
    }
    return deleteResource(basePath);
  }
};

