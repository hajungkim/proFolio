<template>
  <div class="them2-box">
      <div class="them2-subtitle">Project</div>
      <div v-for="(pro) in resume.project" :key="pro.id" class="them2-card">
          <span class="them2-cardname">{{pro.title}}</span>
          <span class="them2-grayfont">({{pro.start_date}} ~ {{pro.end_date}})</span>
          <div style="float: right; font-weight:bold">{{pro.link}}</div>
          <div class="them2-summary">{{pro.summary}}</div>
          <div class="them2-grayfont">{{pro.description}}</div>
          <div class="grid2 margin">
            <div>
                <span style="color: #0014BC; margin-right: 5%">팀원</span>
                <span>{{pro.member_cnt}}명</span>
            </div>
            <div>
                <span style="color: #0014BC; margin-right: 5%">역할</span>
                <span>{{pro.role}}</span>
            </div>
          </div>
          <div>
            <span v-for="(skill) in skills" :key="skill.id" class="project-skill">
                {{skill}}
            </span>
          </div>
      </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them2Project',
  data() {
    return {
      skills: [],
    };
  },
  computed: {
    ...mapState([
      'resume',
    ]),
  },
  mounted() {
    const skills = this.resume.project[0].technology_stack;
    const arr = skills.split(',');
    this.skills = arr;
  },
};
</script>

<style>
@import '../assets/styles/Them2.css';
</style>
