<template>
  <div class="resume-part2-box">
    <table class="resume-part2-input">
      <tr>
        <th>활동명</th>
        <td><input type="text" :placeholder="activity.name"></td>
        <th class="pl-15">활동기관</th>
        <td><input type="text" :placeholder="activity.organization"></td>
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
        <th>활동내용</th>
        <td colspan="4">
          <textarea class="resume-p2-exp" :placeholder="activity.description"></textarea>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: 'CreateExperience',
  props: {
    activity: {
      type: Object,
    },
  },
  data() {
    return {
      date1: null,
      date2: null,
      menu1: false,
      menu2: false,
      start: this.activity.start_date,
      end: this.activity.end_date,
    };
  },
};
</script>

<style>
@import '../assets/styles/ResumePart.css';
</style>
