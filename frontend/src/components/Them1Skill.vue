<template>
  <div class="skill">
      <div class="name">SKILLS</div>
      <div class="skill-content">
          <div class="language">
              <div class="content-title">Language</div>
          </div>
          <div class="database">
              <div class="content-title">DataBase</div>
          </div>
          <div class="framework">
              <div class="content-title">Framework</div>
          </div>
      </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them1Skill',
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
