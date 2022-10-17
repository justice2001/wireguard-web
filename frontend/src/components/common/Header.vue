<template>
  <header id="frame-header">
    <h3 id="logo">WireGuard Console</h3>
    <select @change="ifChange" id="interface-selector">
      <option v-for="ifn in interfaces" :value="ifn" :selected="ifn === currentInterface">{{ifn}}</option>
    </select>
    <div id="login-user">admin</div>
    <a @click="logout" style="color: #ffffff">Logout</a>
  </header>
</template>

<script setup>
import { onMounted, ref } from 'vue';
import {useRouter} from 'vue-router'
import {useStore} from 'vuex'
import wireguard_api from '../../api/wireguard_api';

const router = useRouter()
const store = useStore()

const interfaces = ref([])
const currentInterface = ref('')

const logout = () => {
  window.localStorage.removeItem('user')
  router.push('/login')
}

const getInterfaceList = () => {
  wireguard_api.getInterfaceList().then(res => {
    interfaces.value = res.data
    if (window.localStorage.getItem("interface") === "") {
      window.localStorage.setItem('interface', ev.target.value)
    }
  })
}

const ifChange = ev => {
  console.log(ev.target.value);
  window.localStorage.setItem('interface', ev.target.value)
  router.go(0)
}

onMounted(() => {
  currentInterface.value = window.localStorage.getItem('interface')
  getInterfaceList()
})
</script>

<style scoped>
#frame-header {
  color: #ffffff;
  display: flex;
  align-items: center;
  gap: 10px;
  padding: 10px 20px;
  background-color: #333;
}

#logo {
  margin: 0;
  flex: 1;
}
</style>