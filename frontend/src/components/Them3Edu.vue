<template>
  <div class="them3-edu" v-if="!isEmpty(portfolio.education)">
    <div class="name">Education</div>
      <div class="university">{{portfolio.education.university}}</div>
      <div class="raw">
        <div class="sub">
          {{portfolio.education.admissionDate}} ~ {{portfolio.education.graduationDate}}
        </div>
        <div v-if="portfolio.education.graduation">졸업</div>
      </div>
      <div class="raw">
        <div class="sub">전공</div>
        {{portfolio.education.major}}
      </div>
      <div class="raw">
        <div class="sub">부전공</div>
        {{portfolio.education.minor}}
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them3Edu',
  data() {
    return {
    };
  },
  computed: {
    ...mapState([
      'portfolio',
    ]),
  },
  methods: {
    isEmpty(obj) {
      if (obj.constructor === Object
        && Object.keys(obj).length === 0) {
        return true;
      }
      return false;
    },
  },
};
</script>

<style>
@import '../assets/styles/Them3.css';
</style>
