<template>
  <div class="resume-part2-box">
    <table class="resume-part2-input">
      <tr>
        <th>프로젝트명</th>
        <td colspan="4">
          <textarea class="resume-p5-summary" @change="projectTitle"
          :placeholder="project.title"></textarea>
        </td>
      </tr>
      <tr>
        <th>인원</th>
        <td><input type="number" @change="projectMemberCnt"
        :placeholder="project.memberCnt"></td>
        <th class="pl-15">역할</th>
        <td><input type="text" @change="projectRole"
        :placeholder="project.role"></td>
      </tr>
      <tr>
        <th>시작일</th>
        <td style="padding-left:10px;">
          <v-app class="date-pick">
            <v-menu
              ref="menu1"
              v-model="menu1"
              :close-on-content-click="false"
              :return-value.sync="projectUpdate.project.startDate"
              transition="scale-transition"
              offset-y
              min-width="auto"
            >
              <template v-slot:activator="{ on, attrs }">
                <v-text-field
                  v-model="projectUpdate.project.startDate"
                  label="시작일"
                  prepend-icon="mdi-calendar"
                  readonly
                  v-bind="attrs"
                  v-on="on"
                ></v-text-field>
              </template>
              <v-date-picker
                v-model="projectUpdate.project.startDate"
                no-title
                scrollable
                type="month"
              >
                <v-spacer></v-spacer>
                <v-btn
                  text
                  color="primary"
                  @click="menu1 = false"
                >
                  Cancel
                </v-btn>
                <v-btn
                  text
                  color="primary"
                  @click="startDateUpdate"
                >
                  OK
                </v-btn>
              </v-date-picker>
            </v-menu>
          </v-app>
        </td>
        <th class="pl-15">종료일</th>
        <td style="padding-left:10px;">
          <v-app class="date-pick">
            <v-menu
              ref="menu2"
              v-model="menu2"
              :close-on-content-click="false"
              :return-value.sync="projectUpdate.project.endDate"
              transition="scale-transition"
              offset-y
              min-width="auto"
            >
              <template v-slot:activator="{ on, attrs }">
                <v-text-field
                  v-model="projectUpdate.project.endDate"
                  label="종료일"
                  prepend-icon="mdi-calendar"
                  readonly
                  v-bind="attrs"
                  v-on="on"
                ></v-text-field>
              </template>
              <v-date-picker
                v-model="projectUpdate.project.endDate"
                no-title
                scrollable
                type="month"
              >
                <v-spacer></v-spacer>
                <v-btn
                  text
                  color="primary"
                  @click="menu2 = false"
                >
                  Cancel
                </v-btn>
                <v-btn
                  text
                  color="primary"
                  @click="endDateUpdate"
                >
                  OK
                </v-btn>
              </v-date-picker>
            </v-menu>
          </v-app>
        </td>
      </tr>
      <tr>
        <th>요약</th>
        <td colspan="4">
          <textarea class="resume-p5-summary" @change="projectSummary"
          :placeholder="project.summary"></textarea>
        </td>
      </tr>
      <tr>
        <th>설명</th>
        <td colspan="4">
          <textarea class="resume-p5-project" @change="projectDescription"
          :placeholder="project.description"></textarea>
        </td>
      </tr>
      <tr>
        <th>사용스택</th>
        <td colspan="4">
          <input type="text" class="project-input-width" @change="projectTechStack"
          :placeholder="project.technologyStack">
        </td>
      </tr>
      <tr>
        <th>링크</th>
        <td colspan="4">
          <input type="text" class="project-input-width" @change="projectLink"
          :placeholder="project.link">
        </td>
      </tr>
    </table>
    <div class="delete-btn-2" @click="deleteProject">X</div>
  </div>
</template>

<script>
export default {
  name: 'UpdateProject',
  props: {
    project: {
      type: Object,
    },
  },
  data() {
    return {
      menu1: false,
      menu2: false,
      projectUpdate: {},
    };
  },
  methods: {
    dataUpdate() {
      this.projectUpdate.isUpdated = true;
      this.$emit('updateProject', this.projectUpdate);
    },
    startDateUpdate() {
      this.$refs.menu1.save(this.projectUpdate.project.startDate);
      this.dataUpdate();
    },
    endDateUpdate() {
      this.$refs.menu2.save(this.projectUpdate.project.endDate);
      this.dataUpdate();
    },
    projectTitle(event) {
      this.projectUpdate.project.title = event.target.value;
      this.dataUpdate();
    },
    projectTechStack(event) {
      this.projectUpdate.project.technologyStack = event.target.value;
      this.dataUpdate();
    },
    projectSummary(event) {
      this.projectUpdate.project.summary = event.target.value;
      this.dataUpdate();
    },
    projectRole(event) {
      this.projectUpdate.project.role = event.target.value;
      this.dataUpdate();
    },
    projectMemberCnt(event) {
      this.projectUpdate.project.memberCnt = event.target.value;
      this.dataUpdate();
    },
    projectDescription(event) {
      this.projectUpdate.project.description = event.target.value;
      this.dataUpdate();
    },
    projectLink(event) {
      this.projectUpdate.project.link = event.target.value;
      this.dataUpdate();
    },
    deleteProject() {
      this.projectUpdate.isDeleted = true;
      this.dataUpdate();
    },
  },
  beforeMount() {
    this.projectUpdate.project = this.project;
    this.projectUpdate.isDeleted = false;
    this.projectUpdate.isUpdated = false;
  },
};
</script>

<style>

</style>
