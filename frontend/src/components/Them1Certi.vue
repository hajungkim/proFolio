<template>
  <div class="skill">
    <div class="certiedu">
      <div class="celeft">
        <div class="name">CERTIFICATE / LANGUAGE</div>
        <div v-for="cer in portfolio.certificate" :key="'cert'+cer.id" class="mini-card">
          <span style="color: #656060; margin-right: 5%">{{
            cer.certifiedDate
          }}</span>
          <span style="font-weight: bold">{{ cer.name }}</span>
        </div>
        <div v-for="lag in portfolio.foreignLang" :key="'lang'+lag.id" class="mini-card">
          <span style="color: #656060; margin-right: 5%">{{
            lag.certifiedDate
          }}</span>
          <span style="font-weight: bold; margin-right: 20%">{{ lag.name }}</span>
          <span style="color: #656060">{{ lag.score }}</span>
        </div>
      </div>
      <div class="ceright">
        <div class="name">EDUCATION</div>
        <div class="university">{{ portfolio.education.university }}</div>
        <div class="raw">
          <div class="sub">
            {{ portfolio.education.admissionDate }} ~
            {{ portfolio.education.graduationDate }}
          </div>
          <div v-if="portfolio.education.graduation">졸업</div>
        </div>
        <div class="raw">
          <div class="sub">전공</div>
          {{ portfolio.education.major }}
        </div>
        <div class="raw">
          <div class="sub">부전공</div>
          {{ portfolio.education.minor }}
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them1Certi',
  props: {
    edit: Boolean,
  },
  data() {
    return {};
  },
  computed: {
    ...mapState(['portfolio']),
  },
};
</script>

<style>
@import "../assets/styles/Them1.css";
</style>
