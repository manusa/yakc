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
import {Form, Grid} from 'tabler-react';
import Field from '../components/Field';
import metadata from './';

const LabelsRow = ({labels}) => labels && Object.values(labels).length > 0 && (
  <Grid.Row>
    <Grid.Col width={12} >
      <Form.Group label='Labels'>
        <metadata.Labels labels={labels} />
      </Form.Group>
    </Grid.Col>
  </Grid.Row>
);

const Details = ({resource}) => {
  const namespace = metadata.selectors.namespace(resource);
  const creationTimestamp = metadata.selectors.creationTimestamp(resource);
  return (
    <>
      <Grid.Row>
        <Field label='Name'>{metadata.selectors.name(resource)}</Field>
        {namespace && <Field label='Namespace'>{namespace}</Field>}
        <Field label='Creation timestamp'>
          {`${creationTimestamp?.toLocaleDateString()} ${creationTimestamp?.toLocaleTimeString()}`}
        </Field>
      </Grid.Row>
      <LabelsRow labels={metadata.selectors.labels(resource)} />
    </>
  );
};

export default Details;
