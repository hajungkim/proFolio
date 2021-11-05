<template>
  <div class="resume-part2-box">
    <table class="resume-part2-input">
      <tr>
        <th>기업명</th>
        <td>
          <input type="text" @change="careerCompany" :placeholder="career.company">
        </td>
        <th class="pl-15">직무</th>
        <td><input type="text" @change="careerDuty" :placeholder="career.duty"></td>
      </tr>
      <tr>
        <th>시작일</th>
        <td style="padding-left:10px;">
          <v-app class="date-pick">
            <v-menu
              ref="menu1"
              v-model="menu1"
              :close-on-content-click="false"
              :return-value.sync="careerUpdate.career.startDate"
              transition="scale-transition"
              offset-y
              min-width="auto"
            >
              <template v-slot:activator="{ on, attrs }">
                <v-text-field
                  v-model="careerUpdate.career.startDate"
                  label="시작일"
                  prepend-icon="mdi-calendar"
                  readonly
                  v-bind="attrs"
                  v-on="on"
                ></v-text-field>
              </template>
              <v-date-picker
                v-model="careerUpdate.career.startDate"
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
              :return-value.sync="careerUpdate.career.endDate"
              transition="scale-transition"
              offset-y
              min-width="auto"
            >
              <template v-slot:activator="{ on, attrs }">
                <v-text-field
                  v-model="careerUpdate.career.endDate"
                  label="종료일"
                  prepend-icon="mdi-calendar"
                  readonly
                  v-bind="attrs"
                  v-on="on"
                ></v-text-field>
              </template>
              <v-date-picker
                v-model="careerUpdate.career.endDate"
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
        <th>내용</th>
        <td colspan="4">
          <textarea class="resume-p2-career" @change="careerDescription"
          :placeholder="career.description">
          </textarea>
        </td>
      </tr>
    </table>
    <div class="delete-btn" @click="deleteCareer">X</div>
  </div>
</template>

<script>
export default {
  name: 'UpdateCareer',
  props: {
    career: {
      type: Object,
    },
  },
  data() {
    return {
      menu1: false,
      menu2: false,
      careerUpdate: {},
    };
  },
  methods: {
    dataUpdate() {
      this.careerUpdate.isUpdated = true;
      this.$emit('updateCareer', this.careerUpdate);
    },
    startDateUpdate() {
      this.$refs.menu1.save(this.careerUpdate.career.startDate);
      this.dataUpdate();
    },
    endDateUpdate() {
      this.$refs.menu2.save(this.careerUpdate.career.endDate);
      this.dataUpdate();
    },
    careerCompany(event) {
      this.careerUpdate.career.company = event.target.value;
      this.dataUpdate();
    },
    careerDuty(event) {
      this.careerUpdate.career.duty = event.target.value;
      this.dataUpdate();
    },
    careerDescription(event) {
      this.careerUpdate.career.description = event.target.value;
      this.dataUpdate();
    },
    deleteCareer() {
      this.careerUpdate.isDeleted = true;
      this.dataUpdate();
    },
  },
  beforeMount() {
    this.careerUpdate.career = this.career;
    this.careerUpdate.isDeleted = false;
    this.careerUpdate.isUpdated = false;
  },
};
</script>

<style>
@import '../assets/styles/ResumePart.css';
</style>
