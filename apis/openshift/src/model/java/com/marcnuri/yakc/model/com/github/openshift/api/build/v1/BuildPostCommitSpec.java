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
 */

package com.marcnuri.yakc.model.com.github.openshift.api.build.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * A BuildPostCommitSpec holds a build post commit hook specification. The hook executes a command in a temporary container running the build output image, immediately after the last layer of the image is committed and before the image is pushed to a registry. The command is executed with the current working directory ($PWD) set to the image's WORKDIR.<br><p> <br><p> The build will be marked as failed if the hook execution fails. It will fail if the script or command return a non-zero exit code, or if there is any other error related to starting the temporary container.<br><p> <br><p> There are five different ways to configure the hook. As an example, all forms below are equivalent and will execute `rake test --verbose`.<br><p> <br><p> 1. Shell script:<br><p> <br><p>        "postCommit": {<br><p>          "script": "rake test --verbose",<br><p>        }<br><p> <br><p>     The above is a convenient form which is equivalent to:<br><p> <br><p>        "postCommit": {<br><p>          "command": ["/bin/sh", "-ic"],<br><p>          "args":    ["rake test --verbose"]<br><p>        }<br><p> <br><p> 2. A command as the image entrypoint:<br><p> <br><p>        "postCommit": {<br><p>          "commit": ["rake", "test", "--verbose"]<br><p>        }<br><p> <br><p>     Command overrides the image entrypoint in the exec form, as documented in<br><p>     Docker: https://docs.docker.com/engine/reference/builder/#entrypoint.<br><p> <br><p> 3. Pass arguments to the default entrypoint:<br><p> <br><p>        "postCommit": {<br><p> 		      "args": ["rake", "test", "--verbose"]<br><p> 	      }<br><p> <br><p>     This form is only useful if the image entrypoint can handle arguments.<br><p> <br><p> 4. Shell script with arguments:<br><p> <br><p>        "postCommit": {<br><p>          "script": "rake test $1",<br><p>          "args":   ["--verbose"]<br><p>        }<br><p> <br><p>     This form is useful if you need to pass arguments that would otherwise be<br><p>     hard to quote properly in the shell script. In the script, $0 will be<br><p>     "/bin/sh" and $1, $2, etc, are the positional arguments from Args.<br><p> <br><p> 5. Command with arguments:<br><p> <br><p>        "postCommit": {<br><p>          "command": ["rake", "test"],<br><p>          "args":    ["--verbose"]<br><p>        }<br><p> <br><p>     This form is equivalent to appending the arguments to the Command slice.<br><p> <br><p> It is invalid to provide both Script and Command simultaneously. If none of the fields are specified, the hook is not executed.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BuildPostCommitSpec implements Model {


  /**
   * args is a list of arguments that are provided to either Command, Script or the container image's default entrypoint. The arguments are placed immediately after the command to be run.
   */
  @JsonProperty("args")
  @Singular(value = "addToArgs", ignoreNullCollections = true)
  private List<String> args;

  /**
   * command is the command to run. It may not be specified with Script. This might be needed if the image doesn't have `/bin/sh`, or if you do not want to use a shell. In all other cases, using Script might be more convenient.
   */
  @JsonProperty("command")
  @Singular(value = "addToCommand", ignoreNullCollections = true)
  private List<String> command;

  /**
   * script is a shell script to be run with `/bin/sh -ic`. It may not be specified with Command. Use Script when a shell script is appropriate to execute the post build hook, for example for running unit tests with `rake test`. If you need control over the image entrypoint, or if the image does not have `/bin/sh`, use Command and/or Args. The `-i` flag is needed to support CentOS and RHEL images that use Software Collections (SCL), in order to have the appropriate collections enabled in the shell. E.g., in the Ruby image, this is necessary to make `ruby`, `bundle` and other binaries available in the PATH.
   */
  @JsonProperty("script")
  private String script;

}

