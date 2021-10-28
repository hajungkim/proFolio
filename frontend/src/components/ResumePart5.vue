<template>
  <div>
    <div class="resume-part-title">part5</div>
    <div class="resume-part-sub">프로젝트를 입력해주세요.</div>
    <div>
      <strong>프로젝트</strong>
      <div class="plus-btn" @click="addCreateProject">+</div>
      <CreateProject
      v-for="(project) in project" :key="project.id" :project="project"
      />
    </div>
    <div class="hr-border-m-40"></div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import CreateProject from './CreateProject.vue';

export default {
  name: 'ResumePart5',
  components: {
    CreateProject,
  },
  data() {
    return {
      project: null,
    };
  },
  computed: {
    ...mapState([
      'resume',
    ]),
  },
  methods: {
    addCreateProject() {
      const newPjt = {
        id: this.project.length + 1, title: '', summary: '', description: '', member_cnt: null, technology_stack: '', role: '', link: '', start_date: '', end_date: '',
      };
      this.project.unshift(newPjt);
    },
  },
  beforeMount() {
    this.project = JSON.parse(JSON.stringify(this.resume.project));
  },
};
</script>

<style>

</style>
