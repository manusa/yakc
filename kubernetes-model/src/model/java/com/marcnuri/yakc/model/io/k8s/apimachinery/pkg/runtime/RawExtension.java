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

package com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.runtime;

import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * RawExtension is used to hold extensions in external versions.<br><p> <br><p> To use this, make a field which has RawExtension as its type in your external, versioned struct, and Object in your internal struct. You also need to register your various plugin types.<br><p> <br><p> // Internal package:<br><p> <br><p> 	type MyAPIObject struct {<br><p> 		runtime.TypeMeta `json:",inline"`<br><p> 		MyPlugin runtime.Object `json:"myPlugin"`<br><p> 	}<br><p> <br><p> 	type PluginA struct {<br><p> 		AOption string `json:"aOption"`<br><p> 	}<br><p> <br><p> // External package:<br><p> <br><p> 	type MyAPIObject struct {<br><p> 		runtime.TypeMeta `json:",inline"`<br><p> 		MyPlugin runtime.RawExtension `json:"myPlugin"`<br><p> 	}<br><p> <br><p> 	type PluginA struct {<br><p> 		AOption string `json:"aOption"`<br><p> 	}<br><p> <br><p> // On the wire, the JSON will look something like this:<br><p> <br><p> 	{<br><p> 		"kind":"MyAPIObject",<br><p> 		"apiVersion":"v1",<br><p> 		"myPlugin": {<br><p> 			"kind":"PluginA",<br><p> 			"aOption":"foo",<br><p> 		},<br><p> 	}<br><p> <br><p> So what happens? Decode first uses json or yaml to unmarshal the serialized data into your external MyAPIObject. That causes the raw JSON to be stored, but not unpacked. The next step is to copy (using pkg/conversion) into the internal struct. The runtime package's DefaultScheme has conversion functions installed which will unpack the JSON stored in RawExtension, turning it into the correct object type, and storing it in the Object. (TODO: In the case where the object is of an unknown type, a runtime.Unknown object will be created and stored.)
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@Data
@ToString
public class RawExtension implements Model {


}

