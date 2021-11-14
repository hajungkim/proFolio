<template>
  <div class="main-section1">
      <div class="logo-container">
        <img class="logo-img" src="../assets/images/logo3.png" alt="">
      </div>
      <div class="post-container">
      <section class="post-header">
        <div class="hero-image-container">
        <div class="window-background"></div>
        <div class="moon"></div>
        <img class="hero-image"
        src="//cssanimation.rocks/images/courses/animation_101/animation_101.svg"
        alt="Daily emails animation">
        <div class="screen-container"></div>
        <div class="notification"></div>
        </div>
      </section>
      </div>
      <div class="typing">
        <div class="typing-demo">
          Portfolio for Developers
        </div>
      </div>
      <!-- <img src="../assets/images/logo3.png" alt="">
      <h2>개발자를 위한 포트폴리오 사이트</h2>
      <button class="main-btn-hover color-9" @click="goToLogin"> GET STARTED </button> -->
    <!-- <div class="section1-img-box">
      <img style="width:40vw;" src="../assets/images/main_person.png" alt="">
      <div class="section1-text-box">
        <p>취업 사진?</p>
        <p>포트폴리오?!</p>
        <p>모두 ProFolio에서 해결하세요.</p>
      </div>
    </div> -->
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'MainSection1',
  methods: {
    goToLogin() {
      if (this.isLogin) {
        this.$router.push({ name: 'MyPage' });
        console.log(this.isLogin);
      } else {
        this.$router.push({ name: 'Login' });
        console.log(this.isLogin);
      }
    },
  },
  computed: {
    ...mapState([
      'isLogin',
    ]),
  },
};

</script>

<style lang="scss">
@import '../assets/styles/MainSection1.css';
@import '../assets/styles/MainSection1.scss';
</style>
