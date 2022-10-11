<template>
<div id="container">
  <h2>System Test</h2>
  <div>
    <button @click="getWeather">Get Weather</button>
    <button @click="loginPve">Login PVE</button>
    <button @click="getPve">Get Pve Status</button>
  </div>

  <code>{{response}}</code>
</div>
</template>

<script setup>
import {ref} from "vue";
import request from "../../api/index.js";

const response = ref('')

const getWeather = () => {
  request.get('https://restapi.amap.com/v3/weather/weatherInfo', {
    params: {
      key: 'a2485a5dbd39ec57d9849731854ffb3b',
      city: 370281
    }
  }).then(res => {
    console.log(res);
    response.value = JSON.stringify(res.data)
  })
}

const loginPve = () => {
  pveRequest.post('access/ticket', {
    username: 'root@pam',
    password: 'justice@2001'
  })
}
</script>

<style scoped>

</style>