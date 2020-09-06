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
import nodes from './';
import DashboardPage from '../components/DashboardPage';
import {Grid} from 'tabler-react';

const NodesPage = () => (
  <DashboardPage>
    <Grid>
      <Grid.Row cards={true}>
        <Grid.Col width={12} >
          <nodes.NodesCard />
        </Grid.Col>
      </Grid.Row>
      <Grid.Row>
        <Grid.Col>
          <nodes.List />
        </Grid.Col>
      </Grid.Row>
    </Grid>
  </DashboardPage>
);

export default NodesPage;