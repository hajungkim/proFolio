<template>
  <div class="them3-skill">
      <div class="name">Skills</div>
      <div v-for="(skill) in resume.technologyStack" :key="skill.id" style="display: flex">
        <div class="skill-level">{{skill.level}}</div>
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
      'resume',
    ]),
  },
};
</script>

<style>
@import '../assets/styles/Them3.css';
</style>
