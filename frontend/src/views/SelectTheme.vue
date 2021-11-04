<template>
  <div class="select-theme">
      <div class="name">포트폴리오 테마를 선택해주세요</div>
      <div class="theme-list">
        <div class="theme-item" @click="goToThem1">
          <div class="theme-name">테마1</div>
          <div class="theme-card">
            <img class="theme-img" src="../assets/images/them1.png"/>
          </div>
        </div>
        <div class="theme-item" @click="goToThem2">
          <div class="theme-name">테마2</div>
          <div class="theme-card">
            <img class="theme-img" src="../assets/images/them2.png"/>
          </div>
        </div>
        <div class="theme-item" @click="goToThem3">
          <div class="theme-name">테마3</div>
          <div class="theme-card">
            <img class="theme-img" src="../assets/images/them3.png"/>
          </div>
        </div>
      </div>
  </div>
</template>

<script>
export default {
  name: 'SelectTheme',
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
@import '../assets/styles/SelectThem.css';
</style>
