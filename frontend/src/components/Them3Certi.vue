<template>
  <div class="them3-certi">
      <div class="name">Certificate / Language</div>
      <div v-for="(cer) in resume.certificate" :key="cer.id" style="margin: 5% 0">
          <span>{{cer.certifiedDate}}</span>
          <span  style="margin: 10%">{{cer.name}}</span>
      </div>
      <div v-for="(lag) in resume.foreignLang" :key="lag.id">
          <span>{{lag.certifiedDate}}</span>
          <span style="margin: 10%">{{lag.name}}</span>
          <span style="margin: 10%">{{lag.score}}</span>
      </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them3Certi',
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
@import '../assets/styles/Them3.css';
</style>
