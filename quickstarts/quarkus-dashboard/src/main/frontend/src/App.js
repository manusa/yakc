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
import apis from './apis';
import crb from './clusterrolebindings';
import cRoles from './clusterroles';
import configMaps from './configmaps';
import cj from './cronjobs';
import crd from './customresourcedefinitions';
import dc from './deploymentconfigs';
import ds from './daemonsets';
import deployments from './deployments';
import ingresses from './ingresses';
import jobs from './jobs';
import nodes from './nodes';
import ns from './namespaces';
import pvc from './persistentvolumeclaims';
import pv from './persistentvolumes';
import pods from './pods';
import redux from './redux';
import roles from './roles';
import routes from './routes';
import search from './search';
import secrets from './secrets';
import services from './services';
import sts from './statefulsets';
import watch from './watch';
import Home from './Home';

let eventSource;
let pollResourcesTimeout;

const pollResources = dispatch => {
  const dispatchedPoll = async () => {
    const handleResourceList = kind => async resources => {
      await dispatch(redux.actions.crudSetAll({kind, resources}));
      dispatch(redux.actions.setResourceLoaded({kind, loaded: true}));
    };
    try {
      await Promise.all([
        apis.api.listGroups().then(apiGroups => dispatch(redux.actions.apiGroupsSet(apiGroups))),
        ingresses.api.list().then(handleResourceList('Ingress')),
        pvc.api.list().then(handleResourceList('PersistentVolumeClaim')),
        pv.api.list().then(handleResourceList('PersistentVolume'))
      ]);
    } catch (e) {
      dispatch(redux.actions.setError('Error when polling resources (retrying)'));
    }
    if (eventSource.readyState === EventSource.CLOSED) {
      console.error('EventSource connection was lost, reconnecting');
      redux.actions.setOffline(true);
      eventSource.close();
      eventSource = watch.api.startEventSource({dispatch});
    }
    pollResourcesTimeout = setTimeout(dispatchedPoll, 3000)
  };
  return dispatchedPoll;
};

const onMount = ({dispatch}) => {
  eventSource = watch.api.startEventSource({dispatch});
  pollResources(dispatch)();
};

const onUnmount = () => {
  clearTimeout(pollResourcesTimeout);
  if (eventSource.close) {
    eventSource.close();
  }
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
          <Route exact path='/clusterrolebindings' component={crb.ClusterRoleBindingsPage} />
          <Route exact path='/clusterrolebindings/:uidOrName' component={crb.ClusterRoleBindingsDetailPage} />
          <Route exact path='/clusterrolebindings/:uid/edit' component={crb.ClusterRoleBindingsEditPage} />
          <Route exact path='/clusterroles' component={cRoles.ClusterRolesPage} />
          <Route exact path='/clusterroles/:uidOrName' component={cRoles.ClusterRolesDetailPage} />
          <Route exact path='/clusterroles/:uid/edit' component={cRoles.ClusterRolesEditPage} />
          <Route exact path='/configmaps' component={configMaps.ConfigMapsPage} />
          <Route exact path='/configmaps/:uid' component={configMaps.ConfigMapsDetailPage} />
          <Route exact path='/configmaps/:uid/edit' component={configMaps.ConfigMapsEditPage} />
          <Route exact path='/cronjobs' component={cj.CronJobsPage} />
          <Route exact path='/cronjobs/:uid' component={cj.CronJobsDetailPage} />
          <Route exact path='/cronjobs/:uid/edit' component={cj.CronJobsEditPage} />
          <Route exact path='/customresourcedefinitions' component={crd.CustomResourceDefinitionsPage} />
          <Route exact path='/customresourcedefinitions/:uid' component={crd.CustomResourceDefinitionsDetailPage} />
          <Route exact path='/customresourcedefinitions/:uid/edit' component={crd.CustomResourceDefinitionsEditPage} />
          <Route exact path='/daemonsets' component={ds.DaemonSetsPage} />
          <Route exact path='/daemonsets/:uid' component={ds.DaemonSetsDetailPage} />
          <Route exact path='/daemonsets/:uid/edit' component={ds.DaemonSetsEditPage} />
          <Route exact path='/deploymentconfigs' component={dc.DeploymentConfigsPage} />
          <Route exact path='/deploymentconfigs/:uid' component={dc.DeploymentConfigsDetailPage} />
          <Route exact path='/deploymentconfigs/:uid/edit' component={dc.DeploymentConfigsEditPage} />
          <Route exact path='/deployments' component={deployments.DeploymentsPage} />
          <Route exact path='/deployments/:uid' component={deployments.DeploymentsDetailPage} />
          <Route exact path='/deployments/:uid/edit' component={deployments.DeploymentsEditPage} />
          <Route exact path='/ingresses' component={ingresses.IngressesPage} />
          <Route exact path='/ingresses/:uid' component={ingresses.IngressesDetailPage} />
          <Route exact path='/ingresses/:uid/edit' component={ingresses.IngressEditPage} />
          <Route exact path='/jobs' component={jobs.JobsPage} />
          <Route exact path='/jobs/:uid' component={jobs.JobsDetailPage} />
          <Route exact path='/jobs/:uid/edit' component={jobs.JobsEditPage} />
          <Route exact path='/namespaces' component={ns.NamespacesPage} />
          <Route exact path='/namespaces/:uidOrName' component={ns.NamespacesDetailPage} />
          <Route exact path='/nodes' component={nodes.NodesPage} />
          <Route exact path='/nodes/:name' component={nodes.NodesDetailPage} />
          <Route exact path='/nodes/:uid/edit' component={nodes.NodesEditPage} />
          <Route exact path='/persistentvolumeclaims' component={pvc.PersistentVolumeClaimsPage} />
          <Route exact path='/persistentvolumeclaims/:uid' component={pvc.PersistentVolumeClaimsDetailPage} />
          <Route exact path='/persistentvolumeclaims/:uid/edit' component={pvc.PersistentVolumeClaimsEditPage} />
          <Route exact path='/persistentvolumes' component={pv.PersistentVolumesPage} />
          <Route exact path='/persistentvolumes/:uid' component={pv.PersistentVolumesDetailPage} />
          <Route exact path='/persistentvolumes/:uid/edit' component={pv.PersistentVolumesEditPage} />
          <Route exact path='/pods' component={pods.PodsPage} />
          <Route exact path='/pods/:uid' component={pods.PodsDetailPage} />
          <Route exact path='/pods/:uid/edit' component={pods.PodsEditPage} />
          <Route exact path='/pods/:uid/exec' component={pods.PodsExecPage} />
          <Route exact path='/pods/:uid/logs' component={pods.PodsLogsPage} />
          <Route exact path='/roles' component={roles.RolesPage} />
          <Route exact path='/roles/:uid' component={roles.RolesDetailPage} />
          <Route exact path='/roles/:uid/edit' component={roles.RolesEditPage} />
          <Route exact path='/routes' component={routes.RoutesPage} />
          <Route exact path='/routes/:uid' component={routes.RoutesDetailPage} />
          <Route exact path='/routes/:uid/edit' component={routes.RoutesEditPage} />
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
