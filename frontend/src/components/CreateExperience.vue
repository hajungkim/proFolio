<template>
  <div class="resume-part2-box">
    <table class="resume-part2-input">
      <tr>
        <th>활동명</th>
        <td><input type="text" @change="activityName"></td>
        <th class="pl-15">활동기관</th>
        <td><input type="text" @change="activityOrganization"></td>
      </tr>
      <tr>
        <th>시작일</th>
        <td style="padding-left:10px;">
          <v-app class="date-pick">
            <v-menu
              ref="menu1"
              v-model="menu1"
              :close-on-content-click="false"
              :return-value.sync="activityCreate.activity.startDate"
              transition="scale-transition"
              offset-y
              min-width="auto"
            >
              <template v-slot:activator="{ on, attrs }">
                <v-text-field
                  v-model="activityCreate.activity.startDate"
                  label="시작일"
                  prepend-icon="mdi-calendar"
                  readonly
                  v-bind="attrs"
                  v-on="on"
                ></v-text-field>
              </template>
              <v-date-picker
                v-model="activityCreate.activity.startDate"
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
              :return-value.sync="activityCreate.activity.endDate"
              transition="scale-transition"
              offset-y
              min-width="auto"
            >
              <template v-slot:activator="{ on, attrs }">
                <v-text-field
                  v-model="activityCreate.activity.endDate"
                  label="종료일"
                  prepend-icon="mdi-calendar"
                  readonly
                  v-bind="attrs"
                  v-on="on"
                ></v-text-field>
              </template>
              <v-date-picker
                v-model="activityCreate.activity.endDate"
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
        <th>활동내용</th>
        <td colspan="4">
          <textarea class="resume-p2-exp" @change="activityDescription"></textarea>
        </td>
      </tr>
    </table>
    <div class="delete-btn" @click="deleteActivity">X</div>
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
      menu1: false,
      menu2: false,
      activityCreate: {},
    };
  },
  methods: {
    dataUpdate() {
      this.$emit('createActivity', this.activityCreate);
    },
    startDateUpdate() {
      this.$refs.menu1.save(this.activityCreate.activity.startDate);
      this.dataUpdate();
    },
    endDateUpdate() {
      this.$refs.menu2.save(this.activityCreate.activity.endDate);
      this.dataUpdate();
    },
    activityName(event) {
      this.activityCreate.activity.name = event.target.value;
      this.dataUpdate();
    },
    activityOrganization(event) {
      this.activityCreate.activity.organizagion = event.target.value;
      this.dataUpdate();
    },
    activityDescription(event) {
      this.activityCreate.activity.description = event.target.value;
      this.dataUpdate();
    },
    deleteActivity() {
      this.activityCreate.isDeleted = true;
      this.dataUpdate();
    },
  },
  beforeMount() {
    this.activityCreate.activity = this.activity;
    this.activityCreate.isDeleted = false;
  },
};
</script>

<style>
@import '../assets/styles/ResumePart.css';
</style>
