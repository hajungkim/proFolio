<template>
  <div class="them3-projects">
      <div v-for="(pro) in resume.project" :key="pro.id" class="them3-card">
          <div class="name">{{pro.title}}</div>
          <div style="float: right; font-weight:bold">{{pro.link}}</div>
          <div class="summary">{{pro.summary}}</div>
          <div style="color: #656060">{{pro.description}}</div>
          <div class="grid2">
            <div>
                <div class="subtitle">역할</div>
                <div>{{pro.role}}</div>
            </div>
            <div>
                <div class="subtitle">기술스택</div>
                <div>{{pro.technologyStack}}</div>
            </div>
            <div>
                <div class="subtitle">개발기간</div>
                <div>{{pro.startDate}} ~ {{pro.endDate}}</div>
            </div>
            <div>
                <div class="subtitle">참여인원</div>
                <div>{{pro.memberCnt}}명</div>
            </div>
          </div>
      </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them3Project',
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
