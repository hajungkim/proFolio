<template>
  <div class="them3-skill" v-if="portfolio.technologyStack.length">
      <div class="name">Skills</div>
      <div v-for="(skill) in portfolio.technologyStack" :key="skill.id" style="display: flex">
        <div class="skill-level">
          <div class = "skill-level-detail" v-if=" skill.level == 1">하</div>
          <div class = "skill-level-detail" v-else-if=" skill.level == 2">중하</div>
          <div class = "skill-level-detail" v-else-if=" skill.level == 3">중</div>
          <div class = "skill-level-detail" v-else-if=" skill.level == 4">중상</div>
          <div class = "skill-level-detail" v-else>상</div>
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
