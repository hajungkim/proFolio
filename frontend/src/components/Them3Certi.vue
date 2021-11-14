<template>
  <div class="them3-certi" v-if="portfolio.certificate.length||portfolio.foreignLang.length">
      <div class="name">Certificate / Language</div>
      <div v-for="(cer) in portfolio.certificate" :key="'cert'+cer.id" style="margin: 5% 0">
          <span>{{cer.certifiedDate}}</span>
          <span  style="margin: 10%">{{cer.name}}</span>
      </div>
      <div v-for="(lag) in portfolio.foreignLang" :key="'lang'+lag.id">
          <span>{{lag.certifiedDate}}</span>
          <span style="margin: 10%">{{lag.name}}</span>
          <span style="margin: 10%">{{lag.score}}
            <span v-if=" !isNaN(lag.score) ">점</span>
          </span>
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
      'portfolio',
    ]),
  },
};
</script>

<style>
@import '../assets/styles/Them3.css';
</style>
