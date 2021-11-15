<template>
  <div class="container404">
    <h1> 404 Not Found </h1>
    <div class="imageContainer404">
      <div>
        요청한 페이지를 찾을 수 없습니다.
        아래 고양이를 누르면 처음 화면으로 돌아갑니다.
      </div>
      <img
        class="image404catwalking"
        src="../assets/images/samplecat.gif" alt="pageNotFound"
        @click="home"
      />
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    home() {
      this.$router.push('/');
    },
  },
};
</script>

<style>
.container404 {
  padding-top: 8vh;
  text-align: center;
}
.imageContainer404 {
  text-align: center;
}
.image404catwalking {
  height:30vh;
  cursor: pointer;
}
</style>
