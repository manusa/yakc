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
import React from 'react';
import {useHistory} from 'react-router-dom';
import icons from '../icons';

const Progress = ({bg = 'bg-grey-light', fg = 'bg-blue-700', progress = 0}) => (
  <div className='self-stretch mx-6'>
    <div className={`w-full rounded ${bg}`}>
      <div className={`leading-none py-1 rounded ${fg}`} style={{width: `${progress}%`}} />
    </div>
  </div>
);

const StatusCard = ({
  header,
  icon = icons.k8s,
  ready = 0,
  total = 0,
  progressWidth = 0,
  responsiveClassName = '',
  className = '',
  to
}) => {
  const history = useHistory();
  const onClick = () => {
    if (to) {
      history.push(to);
    }
  }
  return (
    <div className={responsiveClassName}>
      <div className={`
        flex flex-col items-center py-6 shadow-sm rounded-md bg-white border-gray-700
        ${className}
      `}>
        <h2 className='font-semibold text-lg mb-2'>{header}</h2>
        <img
          src={icon}
          onClick={onClick}
          className='cursor-pointer'
          alt={`Icon for ${header} status`}
        />
        <h3 className='text-lg my-2'>{ready} / {total}</h3>
        <Progress progress={progressWidth} bg='bg-orange-400'/>
      </div>
    </div>
  );
}

export default StatusCard;