<template>
  <div>
    <strong  class="plus-btn-box">
      <div>프로젝트</div>
      <div class="plus-btn" @click="addProject">+</div>
    </strong>
    <div
      class="resume-part2-box"
      v-for="(project) in resume.project" :key="project.id"
    >
      <table class="resume-part2-input">
        <tr>
          <th>프로젝트명</th>
          <td>
            <input
              class="resume-p5-summary"
              type="text"
              :value="project.title"
              name="title"
              @change="changeInput($event, project)"
            />
          </td>
        </tr>
        <tr>
          <th>인원</th>
          <td>
            <input
              type="number"
              :value="project.memberCnt"
              name="memberCnt"
              @change="changeInput($event, project)"
            />
          </td>
          <th class="pl-15">역할</th>
          <td>
            <input
              type="text"
              :value="project.role"
              name="role"
              @change="changeInput($event, project)"
            />
          </td>
        </tr>
        <Calender :item="project"/>
        <tr>
          <th>요약</th>
          <td colspan="4">
            <textarea
              class="resume-p5-summary"
              :value="project.summary"
              name="summary"
              @change="changeInput($event, project)"
            />
          </td>
        </tr>
        <tr>
          <th>설명</th>
          <td colspan="4">
            <textarea
              class="resume-p5-project"
              :value="project.description"
              name="description"
              @change="changeInput($event, project)"
            />
          </td>
        </tr>
        <tr>
          <th>사용스택</th>
          <td colspan="4">
            <input
              type="text"
              class="project-input-width"
              :value="project.technologyStack"
              name="technologyStack"
              @change="changeInput($event, project)"
            />
          </td>
        </tr>
        <tr>
          <th>링크</th>
          <td colspan="4">
            <input
              type="text"
              class="project-input-width"
              :value="project.link"
              name="link"
              @change="changeInput($event, project)"
            />
          </td>
        </tr>
      </table>
      <div class="delete-btn-2" @click="deleteProject(project)">x</div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import _ from 'lodash';
import Calender from './TempCalendar.vue';

export default {
  name: 'Project',
  components: {
    Calender,
  },
  data() {
    return {
    };
  },
  computed: {
    ...mapState([
      'resume',
    ]),
  },
  methods: {
    addProject() {
      const newItem = {
        id: `${Date.now()}`,
        title: '',
        technologyStack: '',
        summary: '',
        role: '',
        memberCnt: '',
        description: '',
        link: '',
      };
      if (!this.resume.project) {
        this.$store.commit('CHANGE_PROJECT_LIST', [{}, newItem]);
      } else {
        this.$store.commit('CHANGE_PROJECT_LIST', [...this.resume.project, newItem]);
      }
    },
    deleteProject(item) {
      const newList = _.differenceWith(this.resume.project, [item], _.isEqual);
      this.$store.commit('CHANGE_PROJECT_LIST', newList);
    },
    changeInput(event, project) {
      const { name, value } = event.target;
      this.$store.commit('CHANGE_PROJECT_INFO', { name, value, project });
    },
  },
};
</script>

<style>

</style>
