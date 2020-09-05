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
import {NavLink, withRouter} from 'react-router-dom';
import {
  Nav,
  Page,
  Site,
} from 'tabler-react';

import yakcLogo from './assets/YAKC-logo.png';

import './DashboardPage.css'

const withStaticContextFix = BaseComponent => ({staticContext, ...other}) => (
  <BaseComponent {...other} />
)

const RoutedLink = withRouter(withStaticContextFix(NavLink));

const Header = ({toggleMenu}) => (
  <Site.Header>
    <Page.Title className='d-flex w-100 align-items-center'>
      <Site.Logo src={yakcLogo} alt='YAKC logo' />
      Kubernetes Dashboard
      <a
        className="header-toggler d-lg-none ml-auto"
        onClick={toggleMenu}
      >
        <span className="header-toggler-icon" />
      </a>
    </Page.Title>
  </Site.Header>
);

const NavBar = ({collapse}) => (
  <Site.Nav collapse={collapse}>
    <Nav>
      <Nav.Item
        key='/' value='Home' useExact={true} to='/'
        icon='k8s'
        LinkComponent={RoutedLink}
      />
      <Nav.Item
        key='about'
        value='About'
        hasSubNav={true}
        subItemsObjects={[
          {
            value: 'Nodes',
            useExact: true,
            to:'/nodes',
            LinkComponent: RoutedLink
          },
          {
            value: 'Namespaces',
            // LinkComponent: RoutedLink
          }
        ]}
      />
    </Nav>
  </Site.Nav>
)

const DashboardPage = ({children}) => {
  const [menuCollapsed, setMenuCollapsed] = useState(true);
  const toggleMenu = () => setMenuCollapsed(!menuCollapsed);
  return (
    <Page>
      <Page.Main>
        <Header toggleMenu={toggleMenu} />
        <NavBar collapse={menuCollapsed} />
        <Page.Content>
          {children}
        </Page.Content>
      </Page.Main>
    </Page>
  );
}

export default DashboardPage;