<template>
  <div class="info">
      <div class="left">
          <div class="title">
              <div class="box"><img :src = "resume.user.profile_path" class="profile-img"></div>
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
            <div class="birth">{{resume.user.birth}}</div>
            <div class="tel">Tel. {{resume.user.phone}}</div>
            <div class="email">Email. {{resume.user.email}}</div>

        </div>
        <div class="education">
            <div class="name">EDUCATION</div>
            <div class="university">{{resume.education.university}}</div>
            <div class="raw">
                <div class="sub">
                    {{resume.education.admission_date}} ~ {{resume.education.graduation_date}}
                </div>
                    {{resume.education.graduation}}
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
