<template>
<div id="container">
  <h1>System Status</h1>

  <div class="wireguard-interface">
    <p>Name: {{wgServer.name}}</p>
    <p>Public Key: {{wgServer.publicKey}}</p>
    <p>Listen Port: {{wgServer.listenPort}}</p>
  </div>

  <h2>Clients</h2>
  <table>
    <tr>
      <th>Public Key</th>
      <th>EndPoint</th>
      <th>AllowedIps</th>
      <th>LatestHandShake</th>
      <th>TransferReceived</th>
      <th>TransferSent</th>
    </tr>
    <tr v-for="peer in wgServer.peers">
      <td>{{peer.publicKey}}</td>
      <td>{{peer.endPoint}}</td>
      <td>{{peer.allowedIps}}</td>
      <td>{{peer.latestHandShake}}</td>
      <td>{{peer.transferReceived}}</td>
      <td>{{peer.transferSent}}</td>
    </tr>
  </table>


  <div class="debug-area" v-if="false">
    <h2>Debug Span</h2>
    <div>
      <button @click="getInfo">Get Info</button>
    </div>
    <code>{{response}}</code>
  </div>
</div>
</template>

<script setup>
import {onMounted, ref} from "vue";
import { useStore } from "vuex";
import wireguard_api from "../../api/wireguard_api";

const store = useStore()

const response = ref('')

const wgServer = ref({})

let currentInterface = ''

const getInfo = () => {
  wireguard_api.getInterfaceInfo(currentInterface).then(res => {
    response.value = res.data
    wgServer.value = res.data
  })
}

onMounted(() => {
  currentInterface = window.localStorage.getItem('interface')
  console.log(window.localStorage.getItem('interface'));
  setInterval(getInfo, 1000)
})
</script>

<style scoped>
td, th {
  border: 1px solid grey;
  padding: 5px 10px;
}

table {
  border-spacing: 0;
  border-collapse: collapse;
}
</style>