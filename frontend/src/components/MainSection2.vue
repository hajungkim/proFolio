<template>
  <div class="main-container main-section2">
    <div>
      <h1 class="main-header">취업사진 합성</h1>
      <div class="section-text">
        <p>정장도 없고, 시간도 없고..</p>
        <p>proFolio는 이런 분들을 위해</p>
        <p>가장 빠른 취업사진 생성을 제공해요</p>
      </div>
    </div>
    <img style="width:600px" src="../assets/images/samplecat.gif" alt="">
  </div>
</template>

<script>
export default {
  name: 'MainSection2',
};

</script>

<style>
.main-container {
  /* margin: 10%; */
}

.main-section2 {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 8rem;
  /* text-align: center; */
}

.main-header {
  font-size: 4rem;
}

.section-text {
  margin-top: 1rem;
  margin-left: 5%;
  font-size: 1.5rem;
}
</style>
