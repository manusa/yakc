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
import {Link as OriginalRouterLink} from 'react-router-dom';
import Deployment from './icons/Deployment';
import Ingress from './icons/Ingress';
import Namespace from './icons/Namespace';
import Node from './icons/Node';
import Pod from './icons/Pod';
import Service from './icons/Service';

const variants = ({
  none: '',
  default: 'text-blue-600 hover:text-blue-800 hover:underline',
  danger: 'text-red-600 hover:text-red-800 hover:underline',
  outline: 'text-blue-600 border-blue-600 border rounded py-1 px-3 hover:bg-blue-600 hover:text-white',
  outlineDanger: 'text-red-600 border-red-600 border rounded py-1 px-3 hover:bg-red-600 hover:text-white'
});

const Link = ({className, children, href = '#', variant = variants.default, ...props}) => (
  <a
    className={`${variant} ${className ?? ''}`}
    href={href}
    {...props}
  >{children}</a>
);

Link.variants = variants;

Link.RouterLink = ({className, children, variant = variants.default, ...props}) => (
  <OriginalRouterLink
    className={`${variant} ${className ?? ''}`}
    {...props}
  >{children}</OriginalRouterLink>
);

Link.ResourceLink = ({className, Icon, iconClassName, children, ...props}) => (
  <Link.RouterLink
    className={`flex ${className ?? ''}`}
    {...props}
  >
    <Icon className={`w-5 mr-1 ${iconClassName ?? ''}`} />
    <div className='flex-1'>{children}</div>
  </Link.RouterLink>
);

Link.Deployment = ({...props}) => <Link.ResourceLink Icon={Deployment} {...props} />;
Link.Ingress = ({...props}) => <Link.ResourceLink Icon={Ingress} {...props} />;
Link.Namespace = ({...props}) => <Link.ResourceLink Icon={Namespace} {...props} />;
Link.Node = ({...props}) => <Link.ResourceLink Icon={Node} {...props} />;
Link.Pod = ({...props}) => <Link.ResourceLink Icon={Pod} {...props} />;
Link.Service = ({...props}) => <Link.ResourceLink Icon={Service} {...props} />;

export default Link;
