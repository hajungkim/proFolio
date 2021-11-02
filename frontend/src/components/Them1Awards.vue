<template>
  <div class="skill">
      <div class="name">Awards</div>
      <div v-for="(award) in resume.awards" :key="award.id" class="card">
          <div style="margin-bottom: 20px">
              <span style="font-weight: bold; margin-right: 15px">{{award.name}}</span>
              <span
                style="font-weight: bold; margin-right: 15px; color: #656060">
                {{award.prize}}
              </span>
              <span style="color: #656060">{{award.awardsDate}}</span>
          </div>
          <div style="display:flex">
              <div style="color: #656060; margin-right: 15px; width:100px">수상 내용</div>
              <div>{{award.description}}</div>
          </div>
      </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them1Awards',
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
