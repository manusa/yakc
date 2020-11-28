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
import React, {useEffect, useState} from 'react';
import {connect} from 'react-redux';
import metadata from '../metadata';
import crd from './';
import cr from '../customresources'
import Card from '../components/Card';
import Form from '../components/Form';
import ResourceDetailPage from '../components/ResourceDetailPage';

const useCustomResourceList = customResourceDefinition => {
  const [customResourceList, setCustomResourceList] = useState([]);
  const [timeoutHandle, setTimeoutHandle] = useState(null);
  useEffect(() => {
    if (!timeoutHandle && customResourceDefinition) {
      const updateCustomResources = async () => {
        try {
          const customResources = await cr.api.list(customResourceDefinition)();
          setCustomResourceList(customResources);
        } catch (e) {
          setCustomResourceList(null);
        }
        setTimeoutHandle(setTimeout(updateCustomResources, 5000));
      }
      updateCustomResources().then(() => {});
    }
  }, [timeoutHandle, setTimeoutHandle, setCustomResourceList, customResourceDefinition]);
  useEffect(() => () => {
    clearTimeout(timeoutHandle)
  }, [timeoutHandle]);
  return [customResourceList, setCustomResourceList];
};

const CustomResourceDefinitionsDetailPage = ({customResourceDefinition}) => {
  const [customResourceList, setCustomResourceList] = useCustomResourceList(customResourceDefinition);
  return (
    <ResourceDetailPage
      name='CustomResourceDefinitions'
      path='customresourcedefinitions'
      resource={customResourceDefinition}
      body={
        <Form>
          <metadata.Details resource={customResourceDefinition} />
          <Form.Field label='Group'>{crd.selectors.specGroup(customResourceDefinition)}</Form.Field>
          <Form.Field label='Versions'>
            {crd.selectors.specVersions(customResourceDefinition).map(v => (
              <div key={v}>{v}</div>
            ))}
          </Form.Field>
          <Form.Field label='Scope'>{crd.selectors.specScope(customResourceDefinition)}</Form.Field>
          <Form.Field label='Kind'>{crd.selectors.specNamesKind(customResourceDefinition)}</Form.Field>
        </Form>
      }>
      <cr.List
        customResourceDefinition={customResourceDefinition}
        customResources={customResourceList}
        deleteResourceCallback={customResource => {
          setCustomResourceList(customResourceList.filter(c => c !== customResource));
        }}
        title={crd.selectors.specVersionsLatest(customResourceDefinition)}
        titleVariant={Card.titleVariants.small}
        className='mt-2'
      />
    </ResourceDetailPage>
  );
}

const mapStateToProps = ({customResourceDefinitions}) => ({
  customResourceDefinitions
});

const mergeProps = (stateProps, dispatchProps, ownProps) => ({
  ...stateProps,
  ...dispatchProps,
  ...ownProps,
  customResourceDefinition: stateProps.customResourceDefinitions[ownProps.match.params.uid],
});

export default connect(mapStateToProps, null, mergeProps)(CustomResourceDefinitionsDetailPage);