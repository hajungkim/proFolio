<template>
  <div class="main-container main-section2">
    <div class="img-container">
      <img class="main-section2-img" src="../assets/images/convert.png" alt="">
      <div class="container-btn">
        <button class="btn-hover color" @click="goToConvert">START</button>
      </div>
    </div>
    <div class="main-section2-content">
      <h1 class="main-header2">취업사진 합성</h1>
      <div class="line-container2">
      <h1 class="main-line2"></h1>
      </div>
      <div class="section-text2">
        <p>정장도 없고, 시간도 없고..</p>
        <p>proFolio는 이런 분들을 위해</p>
        <p>가장 빠른 취업사진 생성을 제공해요</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'MainSection2',
  methods: {
    goToConvert() {
      this.$router.push({ name: 'Convert' });
    },
  },
};

</script>

<style lang="scss">
@import '../assets/styles/MainSection2.css';
</style>
