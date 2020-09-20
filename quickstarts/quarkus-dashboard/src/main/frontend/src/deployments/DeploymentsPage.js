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
import {Grid} from 'tabler-react';
import DashboardPage from '../components/DashboardPage';
import deployments from './';

const DeploymentsPage = () => (
  <DashboardPage>
    <Grid>
      <Grid.Row cards={true}>
        <Grid.Col width={12} >
          <deployments.DeploymentsCard />
        </Grid.Col>
      </Grid.Row>
      <Grid.Row>
        <Grid.Col>
          <deployments.List />
        </Grid.Col>
      </Grid.Row>
    </Grid>
  </DashboardPage>
);

export default DeploymentsPage;