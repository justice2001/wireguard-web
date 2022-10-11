<template>
<div class="client-card">
  <img
      :src="props.info.qr"
      alt="qr-code"
      class="client-qr">
  <div class="client-info-container">
    <div class="client-info-list">
      <h3>{{props.info.friendlyName}} <span class="name">({{props.info.name}})</span></h3>
      <div class="client-info">IP: {{ props.info.ip }}</div>
      <div class="client-info">AllowedIP: {{props.info.allowedIp}}</div>
      <div class="client-info">LatestHandshake: {{props.info.lastHandShake}}</div>
    </div>
    <div class="client-operation">
      <a href="">Download Config</a>
      <a href="">Edit</a>
      <a class="danger" href="">Remove</a>
    </div>
  </div>
</div>
</template>

<script setup>
const props = defineProps({
  info: {
    type: Object,
    required: true,
    default: { qr: '', name: '', friendlyName: '', ip: '', allowedIp: '', lastHandShake: ''}
  }
})
</script>

<style scoped>
.client-card {
  display: flex;
  border: 1px solid #999999;
  padding: 10px;
}

.name {
  font-size: 16px;
  font-weight: normal;
  color: #666666;
}

.client-qr {
  width: 150px;
}

.client-info-container {
  margin-left: 20px;
  display: flex;
  flex-direction: column;
}

.client-info-list {
  flex: 1;
}

.client-info {
  color: #999999;
  margin-top: 5px;
}

.client-operation {
  display: flex;
  gap: 15px;
}
</style>