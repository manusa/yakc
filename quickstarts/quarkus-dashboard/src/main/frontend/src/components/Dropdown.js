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
import React, {useLayoutEffect, useRef, useState} from 'react';
import Icon from './Icon';

const DropdownPanel = ({visible, items, onClick}) => (
  <div
    onClick={onClick}
    className={`${visible ? '' : 'hidden'}
      z-20 origin-top-right absolute right-0 mt-2 w-full rounded-md shadow-lg`}>
    <div className='rounded-md bg-white shadow-xs overflow-y-auto'
         style={{maxHeight: '15rem'}}
    >
      <div className='py-1' role='menu'
           aria-orientation='vertical' aria-labelledby='options-menu'
      >
        {items}
      </div>
    </div>
  </div>
);

const DropdownMain = ({text, borderColor, onClick, ...props}) => (
  <div className='z-10'>
    <span className='rounded-md shadow-sm'>
      <button
        type='button' aria-haspopup='true' aria-expanded='true' onClick={onClick}
        className={`inline-flex justify-center items-center w-full rounded-md
          border ${borderColor} px-4 py-2 bg-white text-sm leading-5 font-medium text-gray-700 hover:text-gray-500 focus:outline-none focus:border-blue-300 focus:shadow-outline-blue active:bg-gray-50 active:text-gray-800 transition ease-in-out duration-150`}
      >
        <span className='flex-1 text-left'>{text}</span>
        <Icon icon='fa-chevron-down' className='ml-3'/>
      </button>
    </span>
  </div>
);

const Dropdown = ({
  children,
  className = '',
  text = 'Options',
  borderColor = 'border-gray-300',
  minWidth = '14rem',
  maxWidth = '30rem',
  closeOnPanelClick = false,
  ...props}) => {
  const ddRef = useRef(null);
  const [panelVisible, setPanelVisible] = useState(false);
  const togglePanel = () => children.length > 0 && setPanelVisible(!panelVisible);
  useLayoutEffect(() => {
    const handleOutsideClick = event => {
      if (ddRef.current && !ddRef.current.contains(event.target)) {
        setPanelVisible(false);
      }
    }
    document.addEventListener('mousedown', handleOutsideClick);
    return () => document.removeEventListener('mousedown', handleOutsideClick);
  }, [ddRef]);
  return (
    <div
      ref={ddRef} className={`relative inline-block text-left ${className}`}
      style={{minWidth, maxWidth}}
      {...props}
    >
      <DropdownMain borderColor={borderColor} text={text} onClick={togglePanel} />
      <DropdownPanel
        visible={panelVisible} items={children}
        onClick={() => closeOnPanelClick && togglePanel()}
      />
    </div>
  );
};

Dropdown.Item = ({children, ...props}) => (
  <a
    className='block px-4 py-2 text-sm leading-5 text-gray-700 cursor-pointer select-none hover:bg-gray-100 hover:text-gray-900 focus:outline-none focus:bg-gray-100 focus:text-gray-900'
    {...props}
  >
    {children}
  </a>
);

Dropdown.Divider = ({...props}) => (
  <div className='border-t border-gray-200' {...props} />
);

export default Dropdown;
