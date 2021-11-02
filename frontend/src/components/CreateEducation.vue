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
              :return-value.sync="educationCreate.education.admissionDate"
              transition="scale-transition"
              offset-y
              min-width="auto"
            >
              <template v-slot:activator="{ on, attrs }">
                <v-text-field
                  v-model="educationCreate.education.admissionDate"
                  :label="education.admissionDate"
                  prepend-icon="mdi-calendar"
                  readonly
                  v-bind="attrs"
                  v-on="on"
                ></v-text-field>
              </template>
              <v-date-picker
                v-model="educationCreate.education.admissionDate"
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
              :return-value.sync="educationCreate.education.graduationDate"
              transition="scale-transition"
              offset-y
              min-width="auto"
            >
              <template v-slot:activator="{ on, attrs }">
                <v-text-field
                  v-model="educationCreate.education.graduationDate"
                  :label="education.graduationDate"
                  prepend-icon="mdi-calendar"
                  readonly
                  v-bind="attrs"
                  v-on="on"
                ></v-text-field>
              </template>
              <v-date-picker
                v-model="educationCreate.education.graduationDate"
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
    <div class="delete-btn" @click="deleteCreateEdu">X</div>
  </div>
</template>

<script>
export default {
  name: 'CreateEducation',
  props: {
    education: {
      type: Object,
    },
  },
  data() {
    return {
      menu1: false,
      menu2: false,
      educationCreate: {},
      graduation: '',
    };
  },
  methods: {
    dataUpdate() {
      this.$emit('createEducation', this.educationCreate);
    },
    eduUniversity(event) {
      this.educationCreate.education.university = event.target.value;
      this.dataUpdate();
    },
    eduGraduation(event) {
      if (event.target.value === '1') {
        this.educationCreate.education.graduation = true;
        this.graduation = '졸업';
      } else {
        this.educationCreate.education.graduation = false;
        this.graduation = '졸업예정';
      }
      this.dataUpdate();
    },
    eduMajor(event) {
      this.educationCreate.education.major = event.target.value;
      this.dataUpdate();
    },
    eduMinor(event) {
      this.educationCreate.education.minor = event.target.value;
      this.dataUpdate();
    },
    eduScore(event) {
      this.educationCreate.education.score = event.target.value;
      this.dataUpdate();
    },
    eduTotalScore(event) {
      this.educationCreate.education.totalScore = parseFloat(event.target.value);
      this.dataUpdate();
    },
    admissionDateUpdate() {
      this.$refs.menu1.save(this.educationCreate.education.admissionDate);
      this.dataUpdate();
    },
    graduationDateUpdate() {
      this.$refs.menu2.save(this.educationCreate.education.graduationDate);
      this.dataUpdate();
    },
    deleteCreateEdu() {
      this.educationCreate.isDeleted = true;
      this.dataUpdate();
    },
  },
  beforeMount() {
    this.educationCreate.education = this.education;
    this.educationCreate.isDeleted = false;
    this.graduation = '졸업 여부';
  },
};
</script>

<style>

</style>
