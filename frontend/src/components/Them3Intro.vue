<template>
  <div class="them3-intro">
      <div class="name">Introduce</div>
      <div>
          <div>안녕하세요~</div>
          <div>백엔드 개발자를 꿈꾸는 {{portfolio.user.name}}입니다.</div>
          <div>{{portfolio.technologyStack[0].name}}, {{portfolio.technologyStack[1].name}}
              와 같은 분야에 관심이 있습니다.
          </div>
          <div>항상 성장하기 위해 새로운 것들을 많이 접하고 배우고 있습니다.</div>
        </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them3Intro',
  data() {
    return {
    };
  },
  computed: {
    ...mapState([
      'portfolio',
    ]),
  },
};
</script>

<style>
@import '../assets/styles/Them3.css';
</style>
