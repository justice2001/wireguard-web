<template>
  <div class="container">
    <h2>Clients List</h2>
    <button class="add-btn">+ Add Client</button>
    <div class="client-list">
      <ClientCard :info="client" v-for="client in info" />
    </div>
  </div>
</template>

<script setup>
import ClientCard from "../../components/clients/ClientCard.vue";

const code = 'data:image/png;base64,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'
const info = [
  {qr: code, platform: 'ios', friendlyName: '刘正义的iPhone', ip: '10.0.8.3', allowedIp: '10.0.8.3/32, 192.168.31.0/24', lastHandShake: '10s'},
  {qr: code, platform: 'macOS', friendlyName: '刘正义的MacbookAir', ip: '10.0.8.4', allowedIp: '10.0.8.4/32', lastHandShake: '1m'},
  {qr: code, platform: 'Server', friendlyName: 'HomeServer', ip: '10.0.8.2', allowedIp: '10.0.8.2/32', lastHandShake: '2m'},
  {qr: code, platform: 'Server', friendlyName: 'HomeServer', ip: '10.0.8.2', allowedIp: '10.0.8.2/32', lastHandShake: '2m'},
  {qr: code, platform: 'Server', friendlyName: 'HomeServer', ip: '10.0.8.2', allowedIp: '10.0.8.2/32', lastHandShake: '2m'}
]
</script>

<style scoped>
.container {
  padding: 20px;
}

.add-btn {
  margin-top: 20px;
}

.client-list {
  display: grid;
  grid-template-columns: auto auto;
  gap: 20px;
  margin-top: 20px;
}
</style>