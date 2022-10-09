<template>
<div class="bg">
  <div id="login-form">
    <h2>Login</h2>
    <div class="form-item">
      <span class="form-label">Username:</span>
      <input type="text">
    </div>
    <div class="form-item">
      <span class="form-label">Password:</span>
      <input type="password">
    </div>
    <button class="login-btn">Login-></button>
  </div>
  <div class="bg-txt">WireGuard Console</div>
</div>
</template>

<script setup>
</script>

<style scoped>
.bg {
  width: 100vw;
  height: 100vh;
  background-color: #ccc;
  display: flex;
  align-items: center;
  justify-content: center;
  position: relative;
}

.bg-txt {
  position: absolute;
  color: #dddddd;
  right: 0;
  bottom: 0;
  font-size: 80px;
}

#login-form {
  padding: 20px 20px;
  background-color: #fff;
  display: flex;
  flex-direction: column;
  gap: 20px;
}

.form-item {
  display: flex;
}

.login-btn {
  height: 30px;
}

.form-label {
  width: 100px;
}
</style>