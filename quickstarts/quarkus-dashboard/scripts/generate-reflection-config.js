#!/usr/bin/env node
const fs = require('fs')

const reflectionClasses = [
  'com.marcnuri.yakc.quickstarts.dashboard.ApiResource',
  'com.marcnuri.yakc.quickstarts.dashboard.clusterroles.ClusterRoleResource',
  'com.marcnuri.yakc.quickstarts.dashboard.configmaps.ConfigMapResource',
  'com.marcnuri.yakc.quickstarts.dashboard.deployment.DeploymentResource',
  'com.marcnuri.yakc.quickstarts.dashboard.events.EventResource',
  'com.marcnuri.yakc.quickstarts.dashboard.ingresses.IngressResource',
  'com.marcnuri.yakc.quickstarts.dashboard.namespaces.NamespaceResource',
  'com.marcnuri.yakc.quickstarts.dashboard.node.NodeResource',
  'com.marcnuri.yakc.quickstarts.dashboard.persistentvolumeclaims.PersistentVolumeClaimResource',
  'com.marcnuri.yakc.quickstarts.dashboard.persistentvolumes.PersistentVolumeResource',
  'com.marcnuri.yakc.quickstarts.dashboard.pod.PodResource',
  'com.marcnuri.yakc.quickstarts.dashboard.replicaset.ReplicaSetResource',
  'com.marcnuri.yakc.quickstarts.dashboard.roles.RoleResource',
  'com.marcnuri.yakc.quickstarts.dashboard.secrets.SecretResource',
  'com.marcnuri.yakc.quickstarts.dashboard.service.ServiceResource',
  'com.marcnuri.yakc.quickstarts.dashboard.statefulsets.StatefulSetResource',
  'com.marcnuri.yakc.quickstarts.dashboard.watch.WatchResource',
];

let content = '[';
content += reflectionClasses.map(c =>
  `{
    "name" : "${c}",
    "allDeclaredConstructors" : true,
    "allPublicConstructors" : true,
    "allDeclaredMethods" : true,
    "allPublicMethods" : true,
    "allDeclaredClasses" : true,
    "allPublicClasses" : true
  }`
).join(',');
content += ']';

fs.writeFileSync(`${__dirname}/../src/main/resources/reflection-config.json`, content);