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
const Types = {
  CLEAR: 'CLEAR',
  CRUD_CLEAR: 'CRUD_CLEAR',
  CRUD_ADD_OR_REPLACE: 'CRUD_ADD_OR_REPLACE',
  CRUD_DELETE: 'CRUD_DELETE',
  CRUD_SET_ALL: 'CRUD_SET_ALL',
  UI_SET_OFFLINE: 'UI_SET_OFFLINE',
  UI_SET_ERROR: 'UI_SET_ERROR',
  UI_SET_RESOURCE_LOADED: 'UI_SET_RESOURCE_LOADED',
  UI_CLEAR_ERROR: 'UI_CLEAR_ERROR'
}

const clear = () => ({
  type: Types.CLEAR
});

const crudAddOrReplace = object => ({
  type: Types.CRUD_ADD_OR_REPLACE,
  payload: object
});

const crudDelete = object => ({
  type: Types.CRUD_DELETE,
  payload: object
});

const crudSetAll = ({kind, resources}) => ({
  type: Types.CRUD_SET_ALL,
  payload: {kind, resources}
});

const setOffline = (offline = false) => ({
  type: Types.UI_SET_OFFLINE,
  payload: offline
});

const setError = error => ({
  type: Types.UI_SET_ERROR,
  payload: error
});

const setResourceLoaded = ({kind, loaded = false}) => ({
  type: Types.UI_SET_RESOURCE_LOADED,
  payload: {kind, loaded}
});

const clearError = () => ({
  type: Types.UI_CLEAR_ERROR
});

export default {
  Types,
  clear,
  crudAddOrReplace,
  crudDelete,
  crudSetAll,
  setOffline,
  setError,
  setResourceLoaded,
  clearError
};
