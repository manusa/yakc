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
import {NavLink, useHistory, withRouter} from 'react-router-dom';
import {
  Button,
  Nav,
  Page,
  Site,
} from 'tabler-react';

import yakcLogo from '../assets/YAKC-logo.png';

import './DashboardPage.css'

const withStaticContextFix = BaseComponent => ({staticContext, ...other}) => (
  <BaseComponent {...other} />
)

const RoutedLink = withRouter(withStaticContextFix(NavLink));

const Header = ({toggleMenu}) => {
  const history = useHistory();
  const goHome = () => history.push('/');
  return (
    <Site.Header>
      <Page.Title className='d-flex w-100 align-items-center'>
        <Button link className='header-brand' href='#' onClick={goHome}>
          <img src={yakcLogo} className='header-brand-img' alt='YAKC logo' />
        </Button>
        Kubernetes Dashboard
        <Button
          link
          className="header-toggler d-lg-none ml-auto"
          onClick={toggleMenu}
        >
          <span className="header-toggler-icon" />
        </Button>
      </Page.Title>
    </Site.Header>
  );
};

const Footer = () => (
  <Site.Footer
    copyright={<>
      Copyright © 2020 - <a href='https://www.marcnuri.com'>Marc Nuri</a> -
      Licensed under the <a href='https://www.apache.org/licenses/LICENSE-2.0'>
      Apache License 2.0</a>
    </>}
  />
)


const MainNavItem = ({to, icon, value}) => (
  <Nav.Item
    key={to} value={value} useExact={true} to={to}
    icon={icon}
    LinkComponent={RoutedLink}
  />
)

const NavBar = ({collapse}) => (
  <Site.Nav collapse={collapse}>
    <Nav>
      <MainNavItem value='Home' to='/' icon='k8s' />
      <MainNavItem value='Nodes' to='/nodes' icon='node' />
      <MainNavItem value='Deployments' to='/deployments' icon='deployment' />
      <MainNavItem value='Pods' to='/pods' icon='pod' />
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
        subItems={[
          <Nav.SubItem key={1}><a href='https://github.com/manusa/yakc/tree/master/quickstarts/quarkus-dashboard'>
            Quarkus Kubernetes Dashboard</a>
          </Nav.SubItem>,
          <Nav.SubItem key={2}><a href='https://github.com/manusa/yakc'>YAKC</a></Nav.SubItem>
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
        <Footer />
      </Page.Main>
    </Page>
  );
}

export default DashboardPage;