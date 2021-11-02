<template>
  <div class="them2-box">
      <div class="them2-subtitle">Education &amp; Experience</div>
      <ul class="tl">
        <li v-for="(exp) in resume.activity" :key="exp.id" class="tl-item">
          <div class="timestamp">{{exp.start_date}} ~ {{exp.end_date}}</div>
          <div class="item-title">{{exp.name}}</div>
          <div class="item-detail">{{exp.description}}</div>
        </li>
      </ul>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them2Exp',
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
