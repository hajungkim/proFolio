<template>
  <div>
    <div class="resume-part-title">part5</div>
    <div class="resume-part-sub">프로젝트를 입력해주세요.</div>
    <div>
      <strong  class="plus-btn-box">
        <div>프로젝트</div>
        <div class="plus-btn" @click="addCreateProject">+</div>
      </strong>
      <CreateProject
      v-for="(project) in projectCreate" :key="project.id" :project="project"
      @createProject="createProject"
      />
      <UpdateProject
      v-for="(project) in projectUpdate" :key="project.id" :project="project"
      @updateProject="updateProject"
      />
    </div>
    <div class="hr-border-m-40"></div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import CreateProject from './CreateProject.vue';
import UpdateProject from './UpdateProject.vue';

export default {
  name: 'ResumePart5',
  components: {
    CreateProject,
    UpdateProject,
  },
  data() {
    return {
      projectUpdate: [],
      projectCreate: [],
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
        id: `create${Math.random()}`, title: '', summary: '', description: '', memberCnt: null, technologyStack: '', role: '', link: '', startDate: '', endDate: '',
      };
      this.projectCreate.unshift(newPjt);
    },
    createProject(createProject) {
      if (createProject.isDeleted) {
        let sliceIndex = null;
        const idx = createProject.project.id;
        Object.entries(this.projectCreate).forEach((project) => {
          if (Object.keys(project[1]).find((key) => project[1][key] === idx)) {
            [sliceIndex] = project;
          }
        });
        this.projectCreate.splice(sliceIndex, 1);
      } else {
        this.$emit('createProjectData', createProject.project);
      }
    },
    updateProject(updateProject) {
      if (updateProject.isDeleted) {
        let sliceIndex = null;
        const idx = updateProject.project.id;
        Object.entries(this.projectUpdate).forEach((project) => {
          if (Object.keys(project[1]).find((key) => project[1][key] === idx)) {
            [sliceIndex] = project;
          }
        });
        this.projectUpdate.splice(sliceIndex, 1);
        this.$emit('deleteProject', updateProject.project.id);
      } else if (updateProject.isUpdated) {
        this.$emit('updateProjectData', updateProject.project);
      }
    },
  },
  beforeMount() {
    this.projectUpdate = JSON.parse(JSON.stringify(this.resume.project));
  },
};
</script>

<style>

</style>
