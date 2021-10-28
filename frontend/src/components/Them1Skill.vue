<template>
  <div class="skill">
      <div class="name">SKILLS</div>
      <div class="skill-content">
          <div class="language">
              <div class="content-title">Language</div>
              <div v-for="(skill) in resume.technology_stack" :key="skill.id">
                <div style="display: flex" v-if="skill.kind == 1">
                  <div>{{skill.name}}</div>
                  <div>{{skill.level}}</div>
                </div>
              </div>
          </div>
          <div class="management">
              <div class="content-title">Management</div>
              <div v-for="(skill) in resume.technology_stack" :key="skill.id">
                <div style="display: flex" v-if="skill.kind == 3">
                  <div>{{skill.name}}</div>
                  <div>{{skill.level}}</div>
                </div>
              </div>
          </div>
          <div class="framework">
              <div class="content-title">Framework</div>
              <div v-for="(skill) in resume.technology_stack" :key="skill.id">
                <div style="display: flex" v-if="skill.kind == 2">
                  <div>{{skill.name}}</div>
                  <div>{{skill.level}}</div>
                </div>
              </div>
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
