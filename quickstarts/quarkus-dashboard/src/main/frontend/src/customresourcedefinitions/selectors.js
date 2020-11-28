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
const selectors = {};

selectors.specScope = crd => crd?.spec?.scope ?? '';

selectors.specGroup = crd => crd?.spec?.group ?? '';

selectors.specVersions = crd => (crd?.spec?.versions ?? []).map(v => v.name);
selectors.specVersionsLatest = crd => {
  const sorted = selectors.specVersions(crd).sort((a, b) => b.localeCompare(a));
  return sorted.length > 0 ? sorted[0] : '';
};

selectors.specNames = crd => crd?.spec?.names ?? {};
selectors.specNamesKind = crd => selectors.specNames(crd)?.kind ?? '';
selectors.specNamesPlural = crd => selectors.specNames(crd)?.plural ?? '';


export default selectors;
