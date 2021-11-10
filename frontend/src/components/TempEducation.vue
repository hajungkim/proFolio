<template>
  <div>
    <strong class="plus-btn-box">
      <div>학력</div>
    </strong>
    <div class="resume-part2-box">
      <table class="resume-part2-input">
        <tr>
          <th>대학교</th>
          <td>
            <input type="text"
              :value="resume.education.university"
              name="university"
              @change="changeInput"
            />
          </td>
          <th class="pl-15">졸업여부</th>
          <td>
            <div class="graduation">
              <select class="select-graduation"
                :value="resume.education.graduation"
                name="graduation"
                @change="changeInput"
              >
                <option disabled selected hidden>선택하세요</option>
                <option value="true">졸업</option>
                <option value="false">졸업예정</option>
              </select>
            </div></td>
        </tr>
        <tr>
          <th>전공</th>
          <td>
            <input
              type="text"
              :value="resume.education.major"
              name="major"
              @change="changeInput"
            />
          </td>
          <th class="pl-15">부전공</th>
          <td>
            <input
              type="text"
              :value="resume.education.minor"
              name="minor"
              @change="changeInput"
            />
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
    };
  },
  methods: {
    changeInput(event) {
      const { name, value } = event.target;
      this.resume.education[name] = value;
      this.$store.commit('CHANGE_EDUCATION_INFO', { name, value });
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
