<template>
  <div>
    <div class="resume-part-title">part2</div>
    <div class="resume-part-sub">학력, 경력, 경험을 입력해주세요.</div>
    <div><strong>학력</strong></div>
    <div class="resume-part2-box">
      <table class="resume-part2-input">
        <tr>
          <th>대학교</th>
          <td><input type="text"></td>
          <th class="pl-15">졸업여부</th>
          <td>
            <div class="graduation">
              <select class="select-graduation">
                <option value="1">졸업 여부</option>
                <option value="2">졸업</option>
                <option value="3">졸업예정</option>
              </select>
            </div></td>
        </tr>
        <tr>
          <th>전공</th>
          <td><input type="text"></td>
          <th class="pl-15">부전공</th>
          <td><input type="text"></td>
        </tr>
        <tr>
          <th style="padding-top:10px">입학</th>
          <td>
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
                    label="입학년월"
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
          <th class="pl-15" style="padding-top:10px">졸업</th>
          <td>
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
                    label="졸업년월"
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
      </table>
    </div>
    <div class="hr-border-m-40"></div>
    <div>
      <strong class="plus-btn-box">
        <div>경력</div>
        <div class="plus-btn" @click="addCreateCareer">+</div>
      </strong>
      <CreateCareer
        v-for="(career) in career" :key="career.id" :career="career"
      />
    </div>
    <div class="hr-border-m-40"></div>
    <div>
      <strong class="plus-btn-box">
        <div>경험</div>
        <div class="plus-btn" @click="addCreateExperience">+</div>
      </strong>
      <CreateExperience
        v-for="(activity) in activity" :key="activity.id" :activity="activity"
      />
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import CreateCareer from './CreateCareer.vue';
import CreateExperience from './CreateExperience.vue';

export default {
  name: 'ResumePart2',
  components: {
    CreateCareer,
    CreateExperience,
  },
  data() {
    return {
      career: null,
      activity: null,
      date1: null,
      date2: null,
      menu1: false,
      menu2: false,
    };
  },
  computed: {
    ...mapState([
      'resume',
    ]),
  },
  methods: {
    addCreateCareer() {
      const newCareer = {
        id: this.career.length + 1, company: '', duty: '', description: '', start_date: '', end_date: '',
      };
      this.career.unshift(newCareer);
    },
    addCreateExperience() {
      const newExp = {
        id: this.activity.length + 1, name: '', organization: '', description: '', start_date: '', end_date: '',
      };
      this.activity.unshift(newExp);
    },
  },
  beforeMount() {
    this.career = JSON.parse(JSON.stringify(this.resume.career));
    this.activity = JSON.parse(JSON.stringify(this.resume.activity));
  },
};
</script>

<style>
@import '../assets/styles/ResumePart.css';
</style>
