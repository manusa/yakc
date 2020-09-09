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
import React, {useState} from 'react';
import {Button, Tag} from "tabler-react";

const Labels = ({labels = {}, maxLabels = 10}) => {
  const labelPairs = Object.entries(labels).map(([key, value]) => `${key}: ${value}`);
  const [collapsed, setCollapsed] = useState(true);
  const toggle = () => setCollapsed(!collapsed);
  const truncate = labelPairs.length > maxLabels;
  const displayedLabels = truncate && collapsed ? labelPairs.slice(0, maxLabels) : labelPairs;
  return (
    <div className='d-flex flex-wrap align-items-center'>
      {displayedLabels.map((label, idx) =>
        <Tag key={idx} rounded color='blue' className='mr-1 mb-1'>{label}</Tag>
      )}
      {truncate && <Button link onClick={toggle}>{collapsed ? '...' : 'Show less'}</Button>}
    </div>
  );
};

export default Labels;