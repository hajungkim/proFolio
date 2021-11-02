<template>
  <div class="resume-part2-box">
    <table class="resume-part2-input">
      <tr>
        <th>프로젝트명</th>
        <td colspan="4">
          <textarea class="resume-p5-summary" :placeholder="project.title"></textarea>
        </td>
      </tr>
      <tr>
        <th>인원</th>
        <td><input type="number" :placeholder="project.member_cnt"></td>
        <th class="pl-15">역할</th>
        <td><input type="text" :placeholder="project.role"></td>
      </tr>
      <tr>
        <th>시작일</th>
        <td style="padding-left:10px;">
          <v-app class="date-pick">
            <v-menu
              ref="menu1"
              v-model="menu1"
              :close-on-content-click="false"
              :return-value.sync="date1"
              transition="scale-transition"
              offset-y
              min-width="auto"
            >
              <template v-slot:activator="{ on, attrs }">
                <v-text-field
                  v-model="date1"
                  :label="start"
                  prepend-icon="mdi-calendar"
                  readonly
                  v-bind="attrs"
                  v-on="on"
                ></v-text-field>
              </template>
              <v-date-picker
                v-model="date1"
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
                  @click="$refs.menu1.save(date1)"
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
              :return-value.sync="date2"
              transition="scale-transition"
              offset-y
              min-width="auto"
            >
              <template v-slot:activator="{ on, attrs }">
                <v-text-field
                  v-model="date2"
                  :label="end"
                  prepend-icon="mdi-calendar"
                  readonly
                  v-bind="attrs"
                  v-on="on"
                ></v-text-field>
              </template>
              <v-date-picker
                v-model="date2"
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
                  @click="$refs.menu2.save(date2)"
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
          <textarea class="resume-p5-summary" :placeholder="project.summary"></textarea>
        </td>
      </tr>
      <tr>
        <th>설명</th>
        <td colspan="4">
          <textarea class="resume-p5-project" :placeholder="project.description"></textarea>
        </td>
      </tr>
      <tr>
        <th>사용스택</th>
        <td colspan="4">
          <input type="text" :placeholder="project.title" class="project-input-width">
        </td>
      </tr>
      <tr>
        <th>링크</th>
        <td colspan="4">
          <input type="text" :placeholder="project.title" class="project-input-width">
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: 'CreateProject',
  props: {
    project: {
      type: Object,
    },
  },
  data() {
    return {
      date1: null,
      date2: null,
      menu1: false,
      menu2: false,
      start: this.project.startDate,
      end: this.project.endDate,
    };
  },
};
</script>

<style>

</style>
