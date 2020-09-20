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

const reducer = (state = {}, action = {}) => {
  switch (action.type) {
    case Types.ADD_NODE: {
      const newState = {...state};
      newState[action.payload.metadata.uid] = action.payload;
      return newState;
    }
    case Types.DELETE_NODE: {
      const newState = {...state};
      delete newState[action.payload.metadata.uid];
      return newState;
    }
    case Types.CLEAR:
    case Types.CLEAR_NODES: {
      return {};
    }
    default:
      return {...state};
  }
};

export default reducer;