<template>
  <div class="them3-exp">
      <div class="name">Experience</div>
      <div v-for="(exp) in resume.activity" :key="exp.id" class="card">
          <div style="margin-bottom: 20px">
              <span style="font-weight: bold; margin-right: 15px">{{exp.name}}</span>
              <span style="color: #656060">{{exp.startdate}} ~ {{exp.enddate}}</span>
          </div>
          <div style="display: flex">
              <div style="color: #656060; margin-right: 15px">활동 기관</div>
              <div>{{exp.organization}}</div>
          </div>
          <div style="display: flex">
              <div style="color: #656060; margin-right: 15px">활동 내용</div>
              {{exp.description}}
          </div>
      </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them3Exp',
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
