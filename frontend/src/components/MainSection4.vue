<template>
  <div class="main-container">
    <h1 class="main-header4">포트폴리오 변환</h1>
    <div class="line-container4">
      <h1 class="line4"></h1>
    </div>
    <div class="section-text4">
      <p>마음에 드는 템플릿을 간편하게 사용하세요.</p>
    </div>
    <div class='template-box'>
      <div class="main-card" @click="goToThem1">
        <img style="height:100%" src="../assets/images/them1.png" alt="">
      </div>
      <div class="main-card" @click="goToThem2">
        <img style="width:250px" src="../assets/images/them2.png" alt="">
      </div>
      <div class="main-card" @click="goToThem3">
        <img style="width:250px" src="../assets/images/them3.png" alt="">
      </div>
    </div>
    <div class="desc">
      <p>클릭하시면 Sample을 볼 수 있습니다.</p>
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

<style lang="scss">
@import '../assets/styles/MainSection4.css';
@import '../assets/styles/Main.css';
</style>
