<template>
  <div class="skill">
      <div class="name">EXPERIENCE</div>
      <div v-for="(exp) in resume.activity" :key="exp.id" class="card">
          <div style="margin-bottom: 20px">
              <span style="font-weight: bold; margin-right: 15px">{{exp.name}}</span>
              <span style="color: #656060">{{exp.start_date}} ~ {{exp.end_date}}</span>
          </div>
          <div>
              <span style="color: #656060; margin-right: 15px">활동 기관</span>
              {{exp.organization}}
          </div>
          <div>
              <span style="color: #656060; margin-right: 15px">활동 내용</span>
              {{exp.description}}
          </div>
      </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them1Exp',
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
