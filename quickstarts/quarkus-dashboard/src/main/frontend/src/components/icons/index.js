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
import Deployment from './Deployment';
import Ingress from './Ingress';
import Kubernetes from './Kubernetes';
import Minikube from './Minikube';
import Namespace from './Namespace';
import Node from './Node';
import Pod from './Pod';
import Service from './Service';
import YAKCLogo from './YAKCLogo';

const icons = {};

icons.Deployment = Deployment
icons.Ingress = Ingress;
icons.Kubernetes = Kubernetes;
icons.Minikube = Minikube;
icons.Namespace = Namespace;
icons.Node = Node;
icons.Pod = Pod;
icons.Service = Service;
icons.YAKCLogo = YAKCLogo;

export default icons;