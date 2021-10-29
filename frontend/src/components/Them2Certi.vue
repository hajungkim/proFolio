<template>
  <div class="them2-box">
      <div class="them2-subtitle">Certificate / Language</div>
      <div class="padding">
        <div v-for="(cer) in resume.certificate" :key="cer.id" style="margin: 5% 0">
            <span class="them2-grayfont">{{cer.certified_date}}</span>
            <span class="them2-bluefont">{{cer.name}}</span>
        </div>
        <div v-for="(lag) in resume.foreign_lang" :key="lag.id">
            <span class="them2-grayfont">{{lag.certified_date}}</span>
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
@import '../assets/styles/Them2.css';
</style>
