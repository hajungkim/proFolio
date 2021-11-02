<template>
  <div class="projects">
      <div v-for="(pro) in resume.project" :key="pro.id" class="project-card">
          <div class="name">{{pro.title}}</div>
          <div class="summary">{{pro.summary}}</div>
          <div style="color: #656060">{{pro.description}}</div>
          <div class="subtitle">사용한 기술스택</div>
          <div>{{pro.technologyStack}}</div>
          <div class="subtitle">개발기간</div>
          <div>{{pro.startDate}} ~ {{pro.endDate}}</div>
          <div class="subtitle">역할</div>
          <div>{{pro.role}}</div>
          <div class="subtitle">참여인원</div>
          <div>{{pro.memberCnt}}</div>
          <div style="float: right; font-weight:bold">{{pro.link}}</div>
      </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them1Project',
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
