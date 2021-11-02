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
.template-box {
  display: flex;
  justify-content: space-around;
  min-width:1000px;
  /* border: solid #928888 6px; */
}

.main-card {
  background: #fff;
  padding: 15px;
  border-radius: 5px;
  display: inline-block;
  height: 300px;
  margin: 2rem;
  position: relative;
  width: 300px;
  box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
  transition: all 0.3s cubic-bezier(.25,.8,.25,1);
}

.main-card:hover {
  box-shadow: 0 14px 28px rgba(0,0,0,0.25), 0 10px 10px rgba(0,0,0,0.22);
}
</style>
