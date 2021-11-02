<template>
  <div class="skill">
      <div class="name">CERTIFICATE / LANGUAGE</div>
      <div v-for="(cer) in resume.certificate" :key="cer.id" class="mini-card">
          <span style="color: #656060; margin-right: 5%">{{cer.certifiedDate}}</span>
          <span style="font-weight:bold">{{cer.name}}</span>
      </div>
      <div v-for="(lag) in resume.foreignLang" :key="lag.id" class="mini-card">
          <span style="color: #656060; margin-right: 5%">{{lag.certifiedDate}}</span>
          <span style="font-weight:bold; margin-right: 20%">{{lag.name}}</span>
          <span style="color: #656060;">{{lag.score}}</span>
      </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them1Certi',
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
