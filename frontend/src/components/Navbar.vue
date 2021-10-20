<template>
  <div class="nav">
    <div class="logo">
      proFolio
    </div>
    <div class="nav-right">
      <div class="nav-item">
        증명사진생성
      </div>
      <div v-if="isLogin" class="nav-item-last dropdown">
        <img src="../assets/images/defaultProfile.png" class="profile-image" style="width: 30px;">
        <ul class="dropdown-menu">
          <li>마이페이지</li>
          <li>로그아웃</li>
        </ul>
      </div>
      <div v-else class="nav-item-last">
        로그인
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
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
@import '../assets/styles/Navbar.css';
</style>
