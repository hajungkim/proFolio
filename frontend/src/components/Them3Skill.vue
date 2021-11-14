<template>
  <div class="them3-skill" v-if="portfolio.technologyStack.length">
      <div class="name">Skills</div>
      <div v-for="(skill) in portfolio.technologyStack" :key="skill.id" style="display: flex">
        <div class="skill-level">
          <span v-if=" skill.level == 1">하</span>
          <span v-else-if=" skill.level == 2">중하</span>
          <span v-else-if=" skill.level == 3">중</span>
          <span v-else-if=" skill.level == 4">중상</span>
          <span v-else>상</span>
          <!-- <span>{{skill.level}}</span> -->
          </div>
        <div class="skill-name">{{skill.name}}</div>
      </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them3Skill',
  data() {
    return {
    };
  },
  computed: {
    ...mapState([
      'portfolio',
    ]),
  },
};
</script>

<style>
@import '../assets/styles/Them3.css';
</style>
