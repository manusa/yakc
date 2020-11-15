/*
 * Copyright 2020 Marc Nuri
 *
 * Licensed under the Apache License, Version 2.0 (the 'License');
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an 'AS IS' BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
import ClusterRole from './ClusterRole';
import ConfigMap from './ConfigMap';
import Deployment from './Deployment';
import Ingress from './Ingress';
import Kubernetes from './Kubernetes';
import Minikube from './Minikube';
import Namespace from './Namespace';
import Node from './Node';
import OpenShift from "./OpenShift";
import PersistentVolume from './PersistentVolume';
import PersistentVolumeClaim from './PersistentVolumeClaim';
import Pod from './Pod';
import Role from './Role';
import Secret from './Secret';
import Service from './Service';
import StatefulSet from './StatefulSet';
import YAKCLogo from './YAKCLogo';

const icons = {};

icons.ClusterRole = ClusterRole;
icons.ConfigMap = ConfigMap;
icons.Deployment = Deployment
icons.Ingress = Ingress;
icons.Kubernetes = Kubernetes;
icons.Minikube = Minikube;
icons.Namespace = Namespace;
icons.Node = Node;
icons.OpenShift = OpenShift;
icons.PersistentVolume = PersistentVolume;
icons.PersistentVolumeClaim = PersistentVolumeClaim;
icons.Pod = Pod;
icons.Role = Role
icons.Secret = Secret;
icons.Service = Service;
icons.StatefulSet = StatefulSet;
icons.YAKCLogo = YAKCLogo;

export default icons;