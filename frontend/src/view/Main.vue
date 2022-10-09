<template>
<div id="frame">
  <Header />
  <div class="main-frame">
    <NaviBar class="navi-bar" />
    <div class="main-view">
      <RouterView />
    </div>
  </div>
  <footer id="footer">Copyright 2022-2022 Zhengyi All Right Resolved</footer>
</div>
</template>

<script setup>
import Header from "../components/common/Header.vue";
import NaviBar from "../components/common/NaviBar.vue";
</script>

<style scoped>
#frame {
  display: flex;
  flex-direction: column;
  height: 100vh;
}

.main-frame {
  display: flex;
  flex: 1;
  height: 0;
}

.main-view {
  height: 100%;
  overflow: scroll;
  flex: 1;
}

.navi-bar {
  width: 200px;
}

#footer {
  padding: 10px;
  color: #999999;
}
</style>