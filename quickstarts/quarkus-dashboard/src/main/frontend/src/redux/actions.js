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
const actions = {};

actions.Types = {
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

actions.clear = () => ({
  type: actions.Types.CLEAR
});

actions.crudAddOrReplace = object => ({
  type: actions.Types.CRUD_ADD_OR_REPLACE,
  payload: object
});

actions.crudDelete = object => ({
  type: actions.Types.CRUD_DELETE,
  payload: object
});

actions.crudSetAll = ({kind, resources}) => ({
  type: actions.Types.CRUD_SET_ALL,
  payload: {kind, resources}
});

actions.setOffline = (offline = false) => ({
  type: actions.Types.UI_SET_OFFLINE,
  payload: offline
});

actions.setError = error => ({
  type: actions.Types.UI_SET_ERROR,
  payload: error
});

actions.setResourceLoaded = ({kind, loaded = false}) => ({
  type: actions.Types.UI_SET_RESOURCE_LOADED,
  payload: {kind, loaded}
});

actions.clearError = () => ({
  type: actions.Types.UI_CLEAR_ERROR
});

export default actions;
