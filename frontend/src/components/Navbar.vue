<template>
  <div class="nav">
    <div class="logo" @click="goToMain">
      <img src="../assets/images/logo2.png" style="width:55px; margin-top:10px">
    </div>
    <div class="wrapper-box">
      <input type="checkbox" id="active">
      <label for="active" class="menu-btn"><span></span></label>
      <label for="active" class="close"></label>
      <div v-if="isLogin" class="wrapper">
        <ul>
          <li style="margin-top: 20px"><a href="#" @click="goToConvertingPage">증명사진</a></li>
          <li><a href="#" @click="goToMyPage">마이페이지</a></li>
          <li><a href="#" @click="logout">로그아웃</a></li>
        </ul>
      </div>
      <div v-else class="wrapper">
        <ul>
          <li style="margin-top: 50px"><a href="#" @click="goToConvertingPage">증명사진</a></li>
          <li><a href="#" @click="goToLogin">로그인</a></li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Navbar',
  computed: {
    ...mapState([
      'isLogin',
    ]),
  },
  methods: {
    goToLogin() {
      this.$router.push({ name: 'Login' });
      this.$router.go();
    },
    goToMain() {
      this.$router.push({ name: 'Main' });
    },
    goToMyPage() {
      this.$router.push({ name: 'MyPage' });
      this.$router.go();
    },
    goToConvertingPage() {
      this.$router.push({ name: 'Convert' });
      this.$router.go();
    },
    logout() {
      document.cookie = 'userId = ; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;';
      this.$store.dispatch('logout');
      this.$router.push({ name: 'Main' });
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
@import '../assets/styles/Navbar.css';
</style>
