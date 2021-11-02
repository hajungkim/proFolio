<template>
  <div class="info">
      <div class="left">
          <div class="title">
              <div class="them1-box">
                <img :src = "resume.user.profilePath" class="profile-img">
              </div>
              <div class="slogan">
                <div>성장하는</div>
                <div style="color: #7B61FF; font-size: 3vw">개발자</div>
                <div>{{resume.user.name}}입니다</div>
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
            <div v-for="(edu) in resume.education" :key="edu.id">
              <div class="university">{{edu.university}}</div>
              <div class="raw">
                  <div class="sub">
                      {{edu.admissionDate}} ~ {{edu.graduationDate}}
                  </div>
                      <div v-if="edu.graduation">졸업</div>
              </div>
              <div class="raw">
                  <div class="sub">전공</div>
                  {{edu.major}}
              </div>
              <div class="raw">
                  <div class="sub">부전공</div>
                  {{edu.minor}}
              </div>

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
