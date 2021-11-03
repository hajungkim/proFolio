<template>
  <div class="skill">
    <div class="certiedu">
      <div class="celeft">
        <div class="name">CERTIFICATE / LANGUAGE</div>
        <div v-for="cer in resume.certificate" :key="cer.id" class="mini-card">
          <span style="color: #656060; margin-right: 5%">{{
            cer.certifiedDate
          }}</span>
          <span style="font-weight: bold">{{ cer.name }}</span>
        </div>
        <div v-for="lag in resume.foreignLang" :key="lag.id" class="mini-card">
          <span style="color: #656060; margin-right: 5%">{{
            lag.certifiedDate
          }}</span>
          <span style="font-weight: bold; margin-right: 20%">{{ lag.name }}</span>
          <span style="color: #656060">{{ lag.score }}</span>
        </div>
      </div>
      <div class="ceright">
        <div class="name">EDUCATION</div>
        <div class="university">{{ resume.education.university }}</div>
        <div class="raw">
          <div class="sub">
            {{ resume.education.admissionDate }} ~
            {{ resume.education.graduationDate }}
          </div>
          <div v-if="resume.education.graduation">졸업</div>
        </div>
        <div class="raw">
          <div class="sub">전공</div>
          {{ resume.education.major }}
        </div>
        <div class="raw">
          <div class="sub">부전공</div>
          {{ resume.education.minor }}
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them1Certi',
  data() {
    return {};
  },
  computed: {
    ...mapState(['resume']),
  },
};
</script>

<style>
@import "../assets/styles/Them1.css";
</style>
