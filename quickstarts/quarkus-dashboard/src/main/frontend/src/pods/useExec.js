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
import {useEffect, useRef, useState} from 'react';
import {Terminal} from 'xterm';
import {AttachAddon} from 'xterm-addon-attach';
import {FitAddon} from 'xterm-addon-fit';
import {WebLinksAddon} from 'xterm-addon-web-links';
import p from './index';

const useExec = (namespace, name, containers) => {
  const ref = useRef(null);
  const [terminal, setTerminal] = useState(null);
  useEffect(() => {
    if (!terminal && ref.current && namespace && name && containers) {
      const xterm = new Terminal();
      const fitAddon = new FitAddon();
      xterm.loadAddon(fitAddon);
      xterm.loadAddon(new WebLinksAddon());
      xterm.open(ref.current);
      fitAddon.fit();
      const ws = p.api.exec(namespace, name, containers[0]?.name);
      const attachAddon = new AttachAddon(ws);
      xterm.loadAddon(attachAddon);
      setTerminal(xterm);
      xterm.focus();
      xterm.resizeEventListener = () => {
        fitAddon.fit();
      };
      window.addEventListener('resize', xterm.resizeEventListener);
    }
  }, [terminal, setTerminal, namespace, name, containers]);
  useEffect(() => () => {
    if (terminal && terminal.resizeEventListener) {
      window.removeEventListener('resize', terminal.resizeEventListener);
    }
  }, [terminal])
  return {ref};
};

export default useExec;