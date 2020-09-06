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
import {useHistory} from 'react-router-dom';
import {Card, Header, Progress} from 'tabler-react';
import icons from '../icons';

import './StatusCard.css';

const StatusCard = ({
  header,
  icon = icons.k8s,
  ready = 0,
  total = 0,
  progressWidth = 0,
  to
}) => {
  const history = useHistory();
  const onClick = () => {
    if (to) {
      history.push(to);
    }
  }
  return (
    <Card className='status-card'>
      <Card.Body className='text-center'>
        <Header size={5}>{header}</Header>
        <img
          src={icon}
          onClick={onClick}
          className='status-card__icon img-fluid mb-2'
          alt={`Icon for ${header} status`}
        />
        <h5>{ready} / {total}</h5>
        <Progress size='sm'>
          <Progress.Bar width={progressWidth}/>
        </Progress>
      </Card.Body>
    </Card>

  );
}

export default StatusCard;