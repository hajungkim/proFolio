<template>
  <div class="info">
      <div class="left">
          <div class="title">
              <div class="them1-box">
                <img :src = "resume.user.profilePath" class="profile-img">
              </div>
              <div class="slogan">
                <h3>안녕하세요👋<br>
                    프론트엔드 개발자를 꿈꾸는 김싸피입니다.<br>
                    React, TypeScript와 같은 JS분야에 관심이 있습니다.<br>
                    항상 성장하기 위해 새로운 것들을 많이 접하고 배우고 있습니다.</h3>
              </div>
          </div>
      </div>
      <div class="right">
        <div class="detail">
            <div class="name">{{resume.user.name}}</div>
            <div class="tel">Tel. {{resume.user.phone}}</div>
            <div class="email">Email. {{resume.user.email}}</div>

        </div>
        <div class="education">
            <div class="name">EDUCATION</div>
            <div class="university">{{resume.education.university}}</div>
            <div class="raw">
                <div class="sub">
                    {{resume.education.admissionDate}} ~ {{resume.education.graduationDate}}
                </div>
                    <div v-if="resume.education.graduation">졸업</div>
            </div>
            <div class="raw">
                <div class="sub">전공</div>
                {{resume.education.major}}
            </div>
            <div class="raw">
                <div class="sub">부전공</div>
                {{resume.education.minor}}
            </div>
        </div>
      </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them1Info',
  data() {
    return {
    };
  },
  computed: {
    ...mapState([
      'resume',
    ]),
  },
};
</script>

<style>
@import '../assets/styles/Them1.css';
</style>
