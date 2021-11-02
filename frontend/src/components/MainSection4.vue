<template>
  <div class="main-container">
    <h1 class="main-header">포트폴리오 변환 기능</h1>
    <div class="section-text">
      <p>마음에 드는 템플릿을 간편하게 사용하세요.</p>
    </div>
    <div class='template-box'>
      <div class="main-card" @click="goToThem1">
        <img style="width:250px" src="../assets/images/them1.jpg" alt="">
      </div>
      <div class="main-card" @click="goToThem2">
        <img style="width:250px" src="../assets/images/them1.jpg" alt="">
      </div>
      <div class="main-card" @click="goToThem3">
        <img style="width:250px" src="../assets/images/them3.jpg" alt="">
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'MainSection4',
  methods: {
    goToThem1() {
      this.$router.push({ name: 'Them1' });
    },
    goToThem2() {
      this.$router.push({ name: 'Them2' });
    },
    goToThem3() {
      this.$router.push({ name: 'Them3' });
    },
  },
};

</script>

<style>
@import '../assets/styles/MainSection4.css';
@import '../assets/styles/Main.css';
</style>
