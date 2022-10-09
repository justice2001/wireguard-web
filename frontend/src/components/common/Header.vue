<template>
  <header id="frame-header">
    <h3 id="logo">WireGuard Console</h3>
    <select id="interface-selector">
      <option value="wg0">wg0</option>
    </select>
    <div id="login-user">admin</div>
  </header>
</template>

<script setup>
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