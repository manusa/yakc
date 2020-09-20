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
import Types from '../actions';

export const addNode = node => {
  return {
    type: Types.ADD_NODE,
    payload: node
  }
}

export const deleteNode = node => {
  return {
    type: Types.DELETE_NODE,
    payload: node
  }
}

export const clearNodes = () => {
  return {
    type: Types.CLEAR_NODES
  }
}

export default {
  addNode,
  deleteNode,
  clearNodes
};