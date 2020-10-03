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
import Card from './Card';

const Table = ({title, titleVariant, className, children, ...props}) => (
  <Card className={className} {...props}>
    {title && (
      <Card.Title titleVariant={titleVariant}>{title}</Card.Title>
    )}
    <table className='min-w-full'>
      {children}
    </table>
  </Card>
);

Table.Head = ({columns}) => (
  <thead>
    <tr className='border-b border-blue-700 border-opacity-25'>
      {columns.map((col, idx) => (
        <th
          key={idx}
          className='px-3 py-2 text-left leading-4 font-semibold text-sm text-gray-600 uppercase'>
          {col}
        </th>
      ))}
    </tr>
  </thead>
);

Table.Body = ({children}) => (
  <tbody className='divide-y divide-gray-300'>{children}</tbody>
);

// For stripes to work need to add 'even' variant to specific property in tailwind.config.js
Table.Row = ({children}) => <tr className='even:bg-opacity-50 even:bg-gray-200'>{children}</tr>;

Table.Cell = ({children, textColor = 'text-gray-800', textSize = 'text-sm', className = '', ...properties}) => (
  <td
    className={`px-3 py-2 ${textColor} ${textSize} ${className}`}
    {...properties}
  >{children}</td>
)
Table.NoResultsRow = ({colSpan = 1}) => (
  <Table.Row>
    <Table.Cell colSpan={colSpan}>No results found</Table.Cell>
  </Table.Row>
)

export default Table;
