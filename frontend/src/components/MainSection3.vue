<template>
  <div class="main-container main-section3">
    <div>
      <h1 class="main-header">PDF 변환 기능</h1>
      <div class="section-text">
        <p>완성된 포트폴리오를 pdf 파일로 저장해보세요.</p>
        <p>포트폴리오를 쉽게 완성하고 제출할 수 있어요.</p>
      </div>
    </div>
    <div>
      <img style="height:500px;" src="../assets/images/portfolio.jpg" alt="">
      <img style="height:200px;" class="pdf-img" src="../assets/images/pdf.svg" alt="pdf-image">
    </div>
  </div>
</template>

<script>
export default {
  name: 'MainSection3',
};

</script>

<style>
.main-section3 {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 8rem;
  /* text-align: center; */
  /* min-height: 300px; */
}

.pdf-img {
  position: relative;
  top: 3.8rem;
  right: 8.2rem;
}
</style>
