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
import React, {useEffect} from 'react';
import {connect} from 'react-redux';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import cRoles from './clusterroles';
import configMaps from './configmaps';
import deployments from './deployments';
import ingresses from './ingresses';
import nodes from './nodes';
import ns from './namespaces';
import pvc from './persistentvolumeclaims';
import pv from './persistentvolumes';
import pods from './pods';
import search from './search';
import secrets from './secrets';
import services from './services';
import sts from './statefulsets';
import watch from './watch';
import redux from './redux';
import Home from './Home';

const eventSources = [];

const pollResources = dispatch => {
  const dispatchedPoll = async () => {
    const handleResourceList = kind => async resources => {
      await dispatch(redux.actions.crudSetAll({kind, resources}));
      dispatch(redux.actions.setResourceLoaded({kind, loaded: true}));
    };
    try {
      await Promise.all([
        cRoles.api.list().then(handleResourceList('ClusterRole')),
        ingresses.api.list().then(handleResourceList('Ingress')),
        ns.api.list().then(handleResourceList('Namespace')),
        pvc.api.list().then(handleResourceList('PersistentVolumeClaim')),
        pv.api.list().then(handleResourceList('PersistentVolume')),
        secrets.api.list().then(handleResourceList('Secret')),
        services.api.list().then(handleResourceList('Service'))
      ]);
    } catch (e) {
      dispatch(redux.actions.setError('Error when polling resources (retrying)'));
    }
    setTimeout(dispatchedPoll, 3000)
  };
  return dispatchedPoll;
};

const onMount = ({dispatch}) => {
  eventSources.push(
    watch.api.startEventSource({dispatch})
  );
  pollResources(dispatch)();
};

const onUnmount = () => {
  eventSources.forEach(eventSource => {
    if (eventSource.close) {
      eventSource.close();
    }
  });
};

const App = ({dispatch}) => {
  useEffect(() => {
    onMount({dispatch});
    return onUnmount;
  }, []); // eslint-disable-line react-hooks/exhaustive-deps
  return (
      <Router>
        <Switch>
          <Route exact path='/' component={Home} />
          <Route exact path='/clusterroles' component={cRoles.ClusterRolesPage} />
          <Route exact path='/clusterroles/:uid' component={cRoles.ClusterRolesDetailPage} />
          <Route exact path='/clusterroles/:uid/edit' component={cRoles.ClusterRolesEditPage} />
          <Route exact path='/configmaps' component={configMaps.ConfigMapsPage} />
          <Route exact path='/configmaps/:uid' component={configMaps.ConfigMapsDetailPage} />
          <Route exact path='/configmaps/:uid/edit' component={configMaps.ConfigMapsEditPage} />
          <Route exact path='/deployments' component={deployments.DeploymentsPage} />
          <Route exact path='/deployments/:uid' component={deployments.DeploymentsDetailPage} />
          <Route exact path='/deployments/:uid/edit' component={deployments.DeploymentsEditPage} />
          <Route exact path='/ingresses' component={ingresses.IngressesPage} />
          <Route exact path='/ingresses/:uid' component={ingresses.IngressesDetailPage} />
          <Route exact path='/ingresses/:uid/edit' component={ingresses.IngressEditPage} />
          <Route exact path='/namespaces' component={ns.NamespacesPage} />
          <Route exact path='/namespaces/:uid' component={ns.NamespacesDetailPage} />
          <Route exact path='/nodes' component={nodes.NodesPage} />
          <Route exact path='/nodes/:name' component={nodes.NodesDetailPage} />
          <Route exact path='/persistentvolumeclaims' component={pvc.PersistentVolumeClaimsPage} />
          <Route exact path='/persistentvolumeclaims/:uid' component={pvc.PersistentVolumeClaimsDetailPage} />
          <Route exact path='/persistentvolumeclaims/:uid/edit' component={pvc.PersistentVolumeClaimsEditPage} />
          <Route exact path='/persistentvolumes' component={pv.PersistentVolumesPage} />
          <Route exact path='/persistentvolumes/:uid' component={pv.PersistentVolumesDetailPage} />
          <Route exact path='/persistentvolumes/:uid/edit' component={pv.PersistentVolumesEditPage} />
          <Route exact path='/pods' component={pods.PodsPage} />
          <Route exact path='/pods/:uid' component={pods.PodsDetailPage} />
          <Route exact path='/pods/:uid/edit' component={pods.PodsEditPage} />
          <Route exact path='/pods/:uid/logs' component={pods.PodsLogsPage} />
          <Route exact path='/search' component={search.SearchPage} />
          <Route exact path='/secrets' component={secrets.SecretsPage} />
          <Route exact path='/secrets/:uid' component={secrets.SecretsDetailPage} />
          <Route exact path='/secrets/:uid/edit' component={secrets.SecretsEditPage} />
          <Route exact path='/services' component={services.ServicesPage} />
          <Route exact path='/services/:uid' component={services.ServicesDetailPage} />
          <Route exact path='/services/:uid/edit' component={services.ServicesEditPage} />
          <Route exact path='/statefulsets' component={sts.StatefulSetsPage} />
          <Route exact path='/statefulsets/:uid' component={sts.StatefulSetsDetailPage} />
          <Route exact path='/statefulsets/:uid/edit' component={sts.StatefulSetsEditPage} />
          {/*<Route component={Error404Page} />*/}
        </Switch>
      </Router>
  );
}

const mapStateToProps = () => ({});

const mapDispatchToProps = dispatch => ({dispatch});

export default connect(mapStateToProps, mapDispatchToProps)(App);
