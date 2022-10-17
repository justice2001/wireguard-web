<template>
<div class="container">
  <h2>编辑 - {{info.friendlyName}}</h2>
  <el-form label-width="60px">
    <el-form-item label="名称">
      <el-input />
    </el-form-item>
    <el-form-item label="平台">
      <el-select-v2 v-model="info.platform" :options="platformOptions" />
    </el-form-item>
    <el-form-item label="IP">
      <el-input v-model="info.ip" />
    </el-form-item>
    <el-form-item label="批准IP">
      <el-input class="allowed-ip" v-for="ip in info.allowedIp" v-model="ip">
        <template #suffix>
          <el-icon>
            <Plus />
            <Minus />
          </el-icon>
        </template>
      </el-input>
    </el-form-item>
  </el-form>
</div>
</template>

<script setup>
import {computed, ref} from "vue";

const platformOptions = [
  {label: 'Android', value: 'android'},
  {label: 'IOS', value: 'IOS'},
  {label: 'macOS', value: 'macOS'},
  {label: 'Linux', value: 'Linux'},
  {label: 'Windows', value: 'Windows'}
]

const info = ref({
  id: 1,
  friendlyName: '刘正义的MacbookAir',
  platform: 'macOS',
  ip: '10.0.8.2',
  allowedIp: [
    '10.0.8.2/32'
  ],
  lastHandShake: '2m'
})

info.allowedIps = computed(() => {
  console.log(info.value.allowedIp.split(','))
  return info.value.allowedIp.split(',')
})
</script>

<style scoped>
.container {
  padding: 20px;
}

.allowed-ip:not(:first-child) {
  margin-top: 10px;
}
</style>