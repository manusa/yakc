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
import React, {useState} from 'react';
import {bindActionCreators} from 'redux';
import {withRouter} from 'react-router-dom';
import {connect} from 'react-redux';
import SimpleBar from 'simplebar-react';
import redux from '../redux';
import i from './icons';
import nm from '../nodes';
import Alert from './Alert';
import Icon from './Icon';
import Link from './Link';
import Tooltip from './Tooltip';

import './DashboardPage.css';

const DashboardNavLink = ({match: {path}, to, staticContext, className = '', ...props}) => (
  <Link.RouterLink
    variant={Link.variants.none}
    to={to}
    className={`${className}
      flex items-center border-l-4 px-6 py-1 md:py-2 lg:py-3
      ${path === to ?
        'bg-gray-600 bg-opacity-25 text-gray-100 border-gray-100' : 
        'border-transparent text-gray-500 hover:bg-gray-600 hover:bg-opacity-25 hover:text-gray-100'}`}
    {...props}
  />
)

const RoutedLink = withRouter(DashboardNavLink);

const NavItem = ({to, Icon: ComponentIcon, children}) => (
  <RoutedLink to={to}>
    <ComponentIcon className='h-4 mr-2 md:mr-3 md:h-5 lg:h-8 lg:mr-4'/>
    {children}
  </RoutedLink>
);

const ExtNavItem = ({href, children}) => (
  <Link
    variant={Link.variants.none}
    href={href}
    className={`flex items-center border-l-4 px-6 py-1 md:py-2 lg:py-3
      border-transparent text-gray-500 hover:bg-gray-600 hover:bg-opacity-25 hover:text-gray-100`}
  >{children}</Link>
)


const SideBar = ({sideBarOpen}) => {
  return (
    <div
      className={`${sideBarOpen ? 'translate-x-0 ease-out' : '-translate-x-full ease-in'}
          side-bar
          fixed z-30 inset-y-0 left-0 w-64 flex flex-col
          transition duration-300 transform bg-gray-900 lg:translate-x-0 lg:static lg:inset-0`}
    >
        <div className='flex items-center justify-center mt-8'>
          <Link.RouterLink
            to='/' variant={Link.variants.none} className='flex flex-col items-center'
          >
            <i.YAKCLogo kubernetesColor='#FFFFFF' className='block h-8 lg:h-12' />
            <div className='text-white text-lg lg:text-xl mt-2 mx-2 font-semibold'>
              Kubernetes Dashboard
            </div>
          </Link.RouterLink>
        </div>
      <SimpleBar className='mt-4 lg:mt-6 flex-1 h-1 overflow-x-hidden'>
        <nav>
          <NavItem to='/' Icon={i.Kubernetes}>Home</NavItem>
          <NavItem to='/nodes' Icon={i.Node}>Nodes</NavItem>
          <NavItem to='/namespaces' Icon={i.Namespace}>Namespaces</NavItem>
          <NavItem to='/pods' Icon={i.Pod}>Pods</NavItem>
          <NavItem to='/deployments' Icon={i.Deployment}>Deployments</NavItem>
          <NavItem to='/statefulsets' Icon={i.StatefulSet}>StatefulSets</NavItem>
          <NavItem to='/services' Icon={i.Service}>Services</NavItem>
          <NavItem to='/ingresses' Icon={i.Ingress}>Ingresses</NavItem>
          <NavItem to='/configmaps' Icon={i.ConfigMap}>ConfigMaps</NavItem>
          <NavItem to='/secrets' Icon={i.Secret}>Secrets</NavItem>
          <NavItem to='/persistentvolumes' Icon={i.PersistentVolume}>PersistentVolumes</NavItem>
          <NavItem to='/persistentvolumeclaims' Icon={i.PersistentVolumeClaim}>PersistentVolume Claims</NavItem>
          <h2 className='mt-6 mb-2 px-6 text-gray-100 text-xl'>About</h2>
          <ExtNavItem href='https://github.com/manusa/yakc/tree/master/quickstarts/quarkus-dashboard'>
            Quarkus Kubernetes Dashboard</ExtNavItem>
          <ExtNavItem href='https://github.com/manusa/yakc'>YAKC</ExtNavItem>
        </nav>
      </SimpleBar>
    </div>
  );
};

const OfflineIcon = () => (
  <div className='fa-stack text-red-700' title='Watchers stopped (No network)'>
    <Icon icon='fa-wifi fa-stack-1x'/>
    <Icon icon='fa-slash fa-stack-1x'/>
  </div>
);

const Header = ({isMinikube, offline, setSideBarOpen, title}) => {
  return (
    <header className='flex justify-between items-center py-4 px-6 bg-white border-b-2 border-blue-700 border-opacity-75'>
      <div className='flex w-full items-center'>
        <button
          onClick={() => setSideBarOpen(true)}
          className='flex items-center text-gray-500 focus:outline-none lg:hidden'
        >
          <svg className="h-6 w-6" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path d="M4 6H20M4 12H20M4 18H11" stroke="currentColor" strokeWidth="2" strokeLinecap="round"
                  strokeLinejoin="round"/>
          </svg>
          <i.YAKCLogo className='block ml-2 h-6' />
        </button>
        <div className='flex relative items-center mx-4 lg:text-xl lg:mx-0 flex-1 truncate'>
          {isMinikube && <Tooltip content='Minikube cluster detected'>
            <i.Minikube className='h-6 mr-2' />
          </Tooltip>}
          {title}
        </div>
        {offline && <OfflineIcon />}
      </div>
    </header>
  );
};

const Footer = () => (
  <footer className='flex items-center p-3 text-sm bg-white border-t border-blue-700 border-opacity-75 text-gray-700'>
    <div>
      Copyright © 2020 - <Link href='https://www.marcnuri.com'>Marc Nuri</Link> -
      Licensed under the <Link href='https://www.apache.org/licenses/LICENSE-2.0'>
      Apache License 2.0</Link>
    </div>
  </footer>
);

const DashboardPage = ({
  className, isMinikube, offline, error, clearError, title, children
}) => {
  const [sideBarOpen, setSideBarOpen] = useState(false);
  return (
    <div className={`dashboard-page flex h-screen bg-gray-200 overflow-hidden ${className ?? ''}`}>
      <div onClick={() => setSideBarOpen(false)}
        className={`${sideBarOpen ? 'visible opacity-50' : 'invisible'}
          fixed z-20 inset-0 bg-black opacity-0 transition-all duration-300 lg:hidden`}
      />
      <SideBar sideBarOpen={sideBarOpen} />
      <div className='flex-1 flex flex-col overflow-hidden'>
        <Header
          isMinikube={isMinikube} offline={offline} setSideBarOpen={setSideBarOpen}
          title={title}
        />
        <main className='flex-1 flex flex-col overflow-x-hidden overflow-y-auto bg-gray-200'>
          <Alert clearError={clearError}>{error}</Alert>
          <div className='flex-1 w-100 p-4 relative'>
            {children}
          </div>
          <Footer />
        </main>
      </div>
    </div>
  );
};


const mapStateToProps = ({nodes, ui: {offline, error}}) => ({
  isMinikube: nm.selectors.isMinikube(nodes),
  offline,
  error
});

const mapDispatchToProps = dispatch =>  bindActionCreators({
  clearError: redux.actions.clearError
}, dispatch);

export default connect(mapStateToProps, mapDispatchToProps)(DashboardPage);