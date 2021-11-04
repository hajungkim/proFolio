<template>
  <div class="select-theme">
      <div class="name">포트폴리오 테마를 선택해주세요</div>
      <div class="theme-list">
        <div class="theme-item" @click="selectTheme(1)">
          <div class="theme-name">테마1</div>
          <div class="theme-card">
            <img class="theme-img" src="../assets/images/them1.png"/>
          </div>
        </div>
        <div class="theme-item" @click="selectTheme(2)">
          <div class="theme-name">테마2</div>
          <div class="theme-card">
            <img class="theme-img" src="../assets/images/them2.png"/>
          </div>
        </div>
        <div class="theme-item" @click="selectTheme(3)">
          <div class="theme-name">테마3</div>
          <div class="theme-card">
            <img class="theme-img" src="../assets/images/them3.png"/>
          </div>
        </div>
      </div>
      <div @click="goTothem(themeNum)" class="btn-hover color-9 createbtn">생성하기</div>
  </div>
</template>

<script>
export default {
  name: 'SelectTheme',
  data() {
    return {
      themeNum: 0,
    };
  },
  methods: {
    selectTheme(id) {
      let i;
      for (i = 0; i < 3; i += 1) {
        const another = document.getElementsByClassName('theme-card')[i];
        another.classList.remove('test');
        const item = document.getElementsByClassName('theme-item')[i];
        item.style.transform = 'translateY(0) scale(1) translateZ(0)';
        const name = document.getElementsByClassName('theme-name')[i];
        name.style.color = 'black';
        name.style.fontSize = 'medium';
      }
      const card = document.getElementsByClassName('theme-card')[id - 1];
      card.className += ' test';
      const item = document.getElementsByClassName('theme-item')[id - 1];
      item.style.transform = 'translateY(-10px) scale(1.105) translateZ(0)';
      const name = document.getElementsByClassName('theme-name')[id - 1];
      name.style.color = '#7953c2';
      name.style.fontSize = 'large';
      this.themeNum = id;
    },
    goTothem(id) {
      if (id === 0) return;
      this.$router.push({ name: `Them${id}` });
    },
  },
};
</script>

<style>
@import '../assets/styles/SelectThem.css';
</style>
