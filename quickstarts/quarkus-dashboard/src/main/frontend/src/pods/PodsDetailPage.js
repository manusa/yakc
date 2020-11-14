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
import React, {useState, useEffect} from 'react';
import {connect} from 'react-redux';
import metadata from '../metadata';
import mts from "../metrics";
import podsModule from './';
import Card from '../components/Card';
import ContainerList from '../components/ContainerList';
import Form from '../components/Form';
import Icon from '../components/Icon';
import Link from '../components/Link';
import ResourceDetailPage from '../components/ResourceDetailPage';

const useMetrics = pod => {
  const [metrics, setMetrics] = useState(null);
  const [timeoutHandle, setTimeoutHandle] = useState(null);
  useEffect(() => {
    if (!timeoutHandle && pod) {
      const updateMetrics = async () => {
        try {
          const metrics = await podsModule.api.metrics(pod);
          setMetrics(metrics);
        } catch (e) {
          setMetrics(null);
        }
        setTimeoutHandle(setTimeout(updateMetrics, 15000));
      }
      updateMetrics().then(() => {});
    }
  }, [timeoutHandle, setTimeoutHandle, setMetrics, pod]);
  useEffect(() => () => {
    clearTimeout(timeoutHandle)
  }, [timeoutHandle]);
  return metrics;
}

const PodsDetailPage = ({pod}) => {
  const metrics = useMetrics(pod);
  const podMetrics = metrics && mts.selectors.podMetrics(metrics);
  return (
    <ResourceDetailPage
      name='Pods'
      path='pods'
      resource={pod}
      actions={
        <Link.RouterLink
          className='ml-2'
          size={Link.sizes.small}
          variant={Link.variants.outline}
          to={`/pods/${metadata.selectors.uid(pod)}/logs`}
          title='Logs'
        >
          <Icon stylePrefix='far' icon='fa-file-alt' className='mr-2'/>Logs
        </Link.RouterLink>
      }
      body={
        <Form>
          <metadata.Details resource={pod} />
          <Form.Field label='Node'>
            <Link.Node to={`/nodes/${podsModule.selectors.nodeName(pod)}`}>
              {podsModule.selectors.nodeName(pod)}
            </Link.Node>
          </Form.Field>
          <Form.Field label='Phase'>
            <podsModule.StatusIcon
              className='text-gray-700 mr-1'
              statusPhase={podsModule.selectors.statusPhase(pod)}
            />
            {podsModule.selectors.statusPhase(pod)}
          </Form.Field>
          <Form.Field label='Restart Policy'>
            {podsModule.selectors.restartPolicy(pod)}
          </Form.Field>
          <Form.Field label='Pod IP'>
            {podsModule.selectors.statusPodIP(pod)}
          </Form.Field>
          {podMetrics &&
            <>
              <Form.Field label='Used CPU'>
                <Icon icon='fa-microchip' className='text-gray-600 mr-2' />
                {podMetrics.totalCpu()}
              </Form.Field>
              <Form.Field label='Used Memory'>
                <Icon icon='fa-memory' className='text-gray-600 mr-2' />
                {mts.selectors.bytesToHumanReadable(podMetrics.totalMemory())}
              </Form.Field>
            </>
          }
        </Form>
      }
    >
      <ContainerList
        title='Containers'
        titleVariant={Card.titleVariants.medium}
        className='mt-2'
        containers={podsModule.selectors.containers(pod)}
        podMetrics={podMetrics}
      />
    </ResourceDetailPage>
  );
};

const mapStateToProps = ({pods}) => ({
  pods
});

const mergeProps = (stateProps, dispatchProps, ownProps) => ({
  ...stateProps,
  ...dispatchProps,
  ...ownProps,
  pod: stateProps.pods[ownProps.match.params.uid]
});

export default connect(mapStateToProps, null, mergeProps)(PodsDetailPage);