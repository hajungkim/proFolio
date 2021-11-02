<template>
  <div class="them2-box">
      <div class="them2-subtitle">Project</div>
      <div v-for="(pro) in resume.project" :key="pro.id" class="them2-card">
          <span class="them2-cardname">{{pro.title}}</span>
          <span class="them2-grayfont">({{pro.startDate}} ~ {{pro.endDate}})</span>
          <div style="float: right; font-weight:bold">{{pro.link}}</div>
          <div class="them2-summary">{{pro.summary}}</div>
          <div class="them2-grayfont">{{pro.description}}</div>
          <div class="grid2 margin">
            <div>
                <span style="color: #0014BC; margin-right: 5%">팀원</span>
                <span>{{pro.memberCnt}}명</span>
            </div>
            <div>
                <span style="color: #0014BC; margin-right: 5%">역할</span>
                <span>{{pro.role}}</span>
            </div>
              <div style="margin-top: 5%">
                <span style="color: #0014BC; margin-right: 5%">기술스택</span>
                <span>{{pro.technologyStack}}</span>
            </div>
          </div>
      </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them2Project',
  data() {
    return {
      skills: [],
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
