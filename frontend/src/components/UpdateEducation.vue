<template>
  <div class="resume-part2-box">
    <table class="resume-part2-input">
      <tr>
        <th>대학교</th>
        <td><input type="text" :value="resume.education.university"></td>
        <th class="pl-15">졸업여부</th>
        <td>
          <div class="graduation">
            <select class="select-graduation" :value="resume.education.graduation">
              <option disabled selected hidden>선택하세요</option>
              <option value="true">졸업</option>
              <option value="false">졸업예정</option>
            </select>
          </div></td>
      </tr>
      <tr>
        <th>전공</th>
        <td><input type="text" :value="resume.education.major"></td>
        <th class="pl-15">부전공</th>
        <td><input type="text" :value="resume.education.minor"></td>
      </tr>
      <!-- <tr>
        <th>학점</th>
        <td>
          <input type="text" :placeholder="education.score" @change="eduScore"
          style="width: 50px; margin-right: 5px;">
          <span>/</span>
          <input type="text" :placeholder="education.totalScore" @change="eduTotalScore"
          style="width: 50px;">
        </td>
      </tr> -->
      <tr>
        <th style="padding-top:10px">입학</th>
        <td>
          <v-app class="date-pick">
            <v-menu
              ref="menu1"
              v-model="menu1"
              :close-on-content-click="false"
              :return-value.sync="resume.education.admissionDate"
              transition="scale-transition"
              offset-y
              min-width="auto"
            >
              <template v-slot:activator="{ on, attrs }">
                <v-text-field
                  v-model="resume.education.admissionDate"
                  :label="resume.education.admissionDate"
                  prepend-icon="mdi-calendar"
                  readonly
                  v-bind="attrs"
                  v-on="on"
                ></v-text-field>
              </template>
              <v-date-picker
                v-model="resume.education.admissionDate"
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
                  @click="admissionDateUpdate"
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
              :return-value.sync="resume.education.graduationDate"
              transition="scale-transition"
              offset-y
              min-width="auto"
            >
              <template v-slot:activator="{ on, attrs }">
                <v-text-field
                  v-model="resume.education.graduationDate"
                  :label="resume.education.graduationDate"
                  prepend-icon="mdi-calendar"
                  readonly
                  v-bind="attrs"
                  v-on="on"
                ></v-text-field>
              </template>
              <v-date-picker
                v-model="resume.education.graduationDate"
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
                  @click="graduationDateUpdate"
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
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'UpdateEducation',
  computed: {
    ...mapState([
      'resume',
    ]),
  },
  data() {
    return {
      menu1: false,
      menu2: false,
      educationUpdate: {},
    };
  },
  methods: {
    eduUniversity(event) {
      this.resume.education.university = event.target.value;
    },
    eduGraduation(event) {
      if (event.target.value === true) {
        this.resume.education.graduation = true;
      } else {
        this.resume.education.graduation = false;
      }
    },
    eduMajor(event) {
      this.resume.education.major = event.target.value;
    },
    eduMinor(event) {
      this.resume.education.minor = event.target.value;
    },
    admissionDateUpdate() {
      this.$refs.menu1.save(this.resume.education.admissionDate);
    },
    graduationDateUpdate() {
      this.$refs.menu2.save(this.resume.education.graduationDate);
      // this.dataUpdate();
    },
  },
  beforeMount() {
  },
};
</script>

<style>

</style>
