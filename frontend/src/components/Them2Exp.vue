<template>
  <div class="them2-box">
      <div class="them2-subtitle">Education &amp; Experience</div>
      <ul class="tl">
        <li v-for="(exp) in resume.activity" :key="exp.id" class="tl-item">
          <div class="timestamp">{{exp.startDate}} ~ {{exp.endDate}}</div>
          <div class="item-title">{{exp.name}}</div>
          <div class="item-detail">{{exp.description}}</div>
        </li>
          <li v-for="(edu) in resume.education" :key="edu.id" class="tl-item">
          <div class="timestamp">{{edu.admissionDate}} ~ {{edu.graduationDate}}</div>
          <div class="item-title">{{edu.university}}</div>
          <div class="item-detail">전공 : {{edu.major}}</div>
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
