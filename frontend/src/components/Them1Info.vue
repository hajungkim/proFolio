<template>
  <div class="them1_info">
      <div class="left">
          <div class="title">
              <div class="them1-box">
                <img :src = "portfolio.user.profilePath" class="profile-img">
              </div>
              <div class="detail">
                <div class="username">{{portfolio.user.name}}</div>
                <div class="tel">Tel. {{portfolio.user.phone}}</div>
                <div class="email">Email. {{portfolio.user.email}}</div>
              </div>
          </div>
      </div>
      <div class="right">
        <div class="intro">
            <div class="name">INTRODUCE</div>
            <div class="slogan">
                <h3>안녕하세요👋<br>
                    프론트엔드 개발자를 꿈꾸는 김싸피입니다.<br>
                    React, TypeScript와 같은 JS분야에 관심이 있습니다.<br>
                    항상 성장하기 위해 새로운 것들을 많이 접하고 배우고 있습니다.</h3>
            </div>
        </div>
      </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them1Info',
  props: {
    edit: Boolean,
  },
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
@import '../assets/styles/Them1.css';
</style>
