<template>
  <div class="them2-box"  v-if="portfolio.foreignLang.length || portfolio.certificate.length">
      <div class="them2-subtitle">Certificate / Language</div>
      <div class="padding">
        <div v-for="(cer) in portfolio.certificate" :key="'cert'+cer.id" style="margin: 5% 0">
            <span class="them2-grayfont">{{cer.certifiedDate}}</span>
            <span class="them2-bluefont">{{cer.name}}</span>
        </div>
        <div v-for="(lag) in portfolio.foreignLang" :key="'lang'+lag.id">
            <span class="them2-grayfont">{{lag.certifiedDate}}</span>
            <span class="them2-bluefont">{{lag.name}}</span>
            <span class="them2-bluefont">{{lag.score}}</span>
        </div>
      </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them2Certi',
  props: {
    edit: Boolean,
  },
  computed: {
    ...mapState([
      'portfolio',
    ]),
  },
};
</script>

<style>
@import '../assets/styles/Them2.css';
</style>
