<template>
  <div class="resume-part2-box">
  <table class="resume-part2-input">
    <tr>
      <th>대회명</th>
      <td><input type="text" @change="awardName" :placeholder="awardUpdate.awards.name"></td>
    </tr>
    <tr>
      <th>수상내역</th>
      <td><input type="text" @change="awardPrize" :placeholder="awardUpdate.awards.prize"></td>
      <th class="pl-15">날짜</th>
      <td style="padding-left:10px;">
        <v-app class="date-pick">
          <v-menu
            ref="menu1"
            v-model="menu1"
            :close-on-content-click="false"
            :return-value.sync="awardUpdate.awards.awardsDate"
            transition="scale-transition"
            offset-y
            min-width="auto"
          >
            <template v-slot:activator="{ on, attrs }">
              <v-text-field
                v-model="awardUpdate.awards.awardsDate"
                label="수상일"
                prepend-icon="mdi-calendar"
                readonly
                v-bind="attrs"
                v-on="on"
              ></v-text-field>
            </template>
            <v-date-picker
              v-model="awardUpdate.awards.awardsDate"
              no-title
              scrollable
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
                @click="awardsDateUpdate"
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
      <td colspan="4" >
        <textarea type="text" @change="awardDescription"
        :placeholder="awardUpdate.awards.description" class="resume-p2-award"/>
      </td>
    </tr>
  </table>
  <div class="delete-btn" @click="deleteAward">X</div>
</div>
</template>

<script>
export default {
  name: 'UpdateAward',
  props: {
    awards: {
      type: Object,
    },
  },
  data() {
    return {
      menu1: false,
      awardUpdate: {},
    };
  },
  methods: {
    dataUpdate() {
      this.awardUpdate.isUpdated = true;
      this.$emit('updateAward', this.awardUpdate);
    },
    awardsDateUpdate() {
      this.$refs.menu1.save(this.awardUpdate.awards.awardsDate);
      this.dataUpdate();
    },
    awardName(event) {
      this.awardUpdate.awards.name = event.target.value;
      this.dataUpdate();
    },
    awardPrize(event) {
      this.awardUpdate.awards.prize = event.target.value;
      this.dataUpdate();
    },
    awardDescription(event) {
      this.awardUpdate.awards.description = event.target.value;
      this.dataUpdate();
    },
    deleteAward() {
      this.awardUpdate.isDeleted = true;
      this.dataUpdate();
    },
  },
  beforeMount() {
    this.awardUpdate.awards = this.awards;
    this.awardUpdate.isDeleted = false;
    this.awardUpdate.isUpdated = false;
  },
};
</script>

<style>
@import '../assets/styles/LookResume.css'
</style>
