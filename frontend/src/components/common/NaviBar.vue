<template>
<div id="navi-bar">
  <ul>
    <li class="active"><RouterLink to="/dashboard">Dashboard</RouterLink></li>
    <li><RouterLink to="/clients">Clients</RouterLink></li>
    <li><RouterLink to="/server">Server</RouterLink></li>
    <li><RouterLink to="/properties">Properties</RouterLink></li>
  </ul>
</div>
</template>

<script setup>
</script>

<style scoped>
#navi-bar {
  background-color: #ccc;
}

ul {
  padding: 0;
  margin: 0;
  list-style: none;
}
li {
  padding: 10px;
}
</style>