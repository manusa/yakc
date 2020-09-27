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
import metadata from './';
import Form from '../components/Form';

const LabelsRow = ({labels}) => labels && Object.values(labels).length > 0 && (
  <Form.Field width={Form.widths.full} label='Labels'>
    <metadata.Labels  maxLabels={4} labels={labels} />
  </Form.Field>
);

const Details = ({resource}) => {
  const namespace = metadata.selectors.namespace(resource);
  const creationTimestamp = metadata.selectors.creationTimestamp(resource);
  return (
    <>
      <Form.Field label='Name'>{metadata.selectors.name(resource)}</Form.Field>
      {namespace && <Form.Field label='Namespace'>{namespace}</Form.Field>}
      <Form.Field label='Creation timestamp'>
        {`${creationTimestamp?.toLocaleDateString()} ${creationTimestamp?.toLocaleTimeString()}`}
      </Form.Field>
      <LabelsRow labels={metadata.selectors.labels(resource)} />
    </>
  );
};

export default Details;
