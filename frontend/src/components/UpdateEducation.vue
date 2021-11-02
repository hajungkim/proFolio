<template>
  <div class="resume-part2-box">
    <table class="resume-part2-input">
      <tr>
        <th>대학교</th>
        <td><input type="text" :placeholder="education.university" @change="eduUniversity"></td>
        <th class="pl-15">졸업여부</th>
        <td>
          <div class="graduation">
            <select class="select-graduation" @change="eduGraduation">
              <option disabled selected hidden>{{graduation}}</option>
              <option value="1">졸업</option>
              <option value="2">졸업예정</option>
            </select>
          </div></td>
      </tr>
      <tr>
        <th>전공</th>
        <td><input type="text" :placeholder="education.major" @change="eduMajor"></td>
        <th class="pl-15">부전공</th>
        <td><input type="text" :placeholder="education.minor" @change="eduMinor"></td>
      </tr>
      <tr>
        <th>학점</th>
        <td>
          <input type="text" :placeholder="education.score" @change="eduScore"
          style="width: 50px; margin-right: 5px;">
          <span>/</span>
          <input type="text" :placeholder="education.totalScore" @change="eduTotalScore"
          style="width: 50px;">
        </td>
      </tr>
      <tr>
        <th style="padding-top:10px">입학</th>
        <td>
          <v-app class="date-pick">
            <v-menu
              ref="menu1"
              v-model="menu1"
              :close-on-content-click="false"
              :return-value.sync="educationUpdate.education.admissionDate"
              transition="scale-transition"
              offset-y
              min-width="auto"
            >
              <template v-slot:activator="{ on, attrs }">
                <v-text-field
                  v-model="educationUpdate.education.admissionDate"
                  :label="education.admissionDate"
                  prepend-icon="mdi-calendar"
                  readonly
                  v-bind="attrs"
                  v-on="on"
                ></v-text-field>
              </template>
              <v-date-picker
                v-model="educationUpdate.education.admissionDate"
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
              :return-value.sync="educationUpdate.education.graduationDate"
              transition="scale-transition"
              offset-y
              min-width="auto"
            >
              <template v-slot:activator="{ on, attrs }">
                <v-text-field
                  v-model="educationUpdate.education.graduationDate"
                  :label="education.graduationDate"
                  prepend-icon="mdi-calendar"
                  readonly
                  v-bind="attrs"
                  v-on="on"
                ></v-text-field>
              </template>
              <v-date-picker
                v-model="educationUpdate.education.graduationDate"
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
    <div class="delete-btn" @click="deleteEdu">X</div>
  </div>
</template>

<script>
export default {
  name: 'UpdateEducation',
  props: {
    education: {
      type: Object,
    },
  },
  data() {
    return {
      menu1: false,
      menu2: false,
      educationUpdate: {},
      graduation: '',
    };
  },
  methods: {
    dataUpdate() {
      this.$emit('updateEducation', this.educationUpdate);
    },
    eduUniversity(event) {
      this.educationUpdate.education.university = event.target.value;
      this.educationUpdate.isUpdated = true;
      this.dataUpdate();
    },
    eduGraduation(event) {
      if (event.target.value === '1') {
        this.educationUpdate.education.graduation = true;
        this.graduation = '졸업';
      } else {
        this.educationUpdate.education.graduation = false;
        this.graduation = '졸업예정';
      }
      this.educationUpdate.isUpdated = true;
      this.dataUpdate();
    },
    eduMajor(event) {
      this.educationUpdate.education.major = event.target.value;
      this.educationUpdate.isUpdated = true;
      this.dataUpdate();
    },
    eduMinor(event) {
      this.educationUpdate.education.minor = event.target.value;
      this.educationUpdate.isUpdated = true;
      this.dataUpdate();
    },
    eduScore(event) {
      this.educationUpdate.education.score = event.target.value;
      this.educationUpdate.isUpdated = true;
      this.dataUpdate();
    },
    eduTotalScore(event) {
      this.educationUpdate.education.totalScore = parseFloat(event.target.value);
      this.educationUpdate.isUpdated = true;
      this.dataUpdate();
    },
    admissionDateUpdate() {
      this.$refs.menu1.save(this.educationUpdate.education.admissionDate);
      this.educationUpdate.isUpdated = true;
      this.dataUpdate();
    },
    graduationDateUpdate() {
      this.$refs.menu2.save(this.educationUpdate.education.graduationDate);
      this.educationUpdate.isUpdated = true;
      this.dataUpdate();
    },
    deleteEdu() {
      this.educationUpdate.isDeleted = true;
      this.dataUpdate();
    },
  },
  beforeMount() {
    this.educationUpdate.education = this.education;
    this.educationUpdate.isUpdated = false;
    this.educationUpdate.isDeleted = false;
    if (this.educationUpdate.graduation === true) this.graduation = '졸업';
    else this.graduation = '졸업예정';
  },
};
</script>

<style>

</style>
