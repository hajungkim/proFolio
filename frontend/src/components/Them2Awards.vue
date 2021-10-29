<template>
  <div class="them2-box">
      <div class="them2-subtitle">Awards</div>
      <div v-for="(award) in resume.awards" :key="award.id" class="them2-card">
          <span class="them2-cardname">{{award.name}}</span>
          <span class="them2-grayfont">({{award.awards_date}})</span>
          <div class="them2-summary">{{award.prize}}</div>
          <div class="them2-grayfont">{{award.description}}</div>
      </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them2Awards',
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
