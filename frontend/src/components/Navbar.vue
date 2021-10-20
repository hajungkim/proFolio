<template>
  <div class="nav">
    <div class="logo">
      proFolio
    </div>
    <div>
      <input type="checkbox" id="active">
      <label for="active" class="menu-btn" @click="changeHamburger"><span></span></label>
      <label for="active" class="close"></label>
      <div v-if="isLogin" class="wrapper">
        <ul>
          <li><a href="#">증명사진</a></li>
          <li><a href="#">마이페이지</a></li>
          <li><a href="#">로그아웃</a></li>
        </ul>
      </div>
      <div v-else class="wrapper">
        <ul>
          <li><a href="#">증명사진</a></li>
          <li><a href="#">로그인</a></li>
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
      'hamburger',
    ]),
  },
  methods: {
    changeHamburger() {
      this.$store.dispatch('changeHamburger', this.hamburger);
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
@import '../assets/styles/Navbar.css';
</style>
