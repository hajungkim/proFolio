<template>
  <div class="resume-part2-box">
  <table class="resume-part2-input">
    <tr>
      <th>대회명</th>
      <td><input type="text" @change="awardName"></td>
    </tr>
    <tr>
      <th>수상내역</th>
      <td><input type="text" @change="awardPrize"></td>
      <th class="pl-15">날짜</th>
      <td style="padding-left:10px;">
        <v-app class="date-pick">
          <v-menu
            ref="menu1"
            v-model="menu1"
            :close-on-content-click="false"
            :return-value.sync="awardCreate.awards.awardsDate"
            transition="scale-transition"
            offset-y
            min-width="auto"
          >
            <template v-slot:activator="{ on, attrs }">
              <v-text-field
                v-model="awardCreate.awards.awardsDate"
                label="수상일"
                prepend-icon="mdi-calendar"
                readonly
                v-bind="attrs"
                v-on="on"
              ></v-text-field>
            </template>
            <v-date-picker
              v-model="awardCreate.awards.awardsDate"
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
        <textarea type="text" @change="awardDescription" class="resume-p2-award"/>
      </td>
    </tr>
  </table>
  <div class="delete-btn" @click="deleteAward">X</div>
</div>
</template>

<script>
export default {
  name: 'CreateAward',
  props: {
    awards: {
      type: Object,
    },
  },
  data() {
    return {
      menu1: false,
      awardCreate: {},
    };
  },
  methods: {
    dataUpdate() {
      this.$emit('createAward', this.awardCreate);
    },
    awardsDateUpdate() {
      this.$refs.menu1.save(this.awardCreate.awards.awardsDate);
      this.dataUpdate();
    },
    awardName(event) {
      this.awardCreate.awards.name = event.target.value;
      this.dataUpdate();
    },
    awardPrize(event) {
      this.awardCreate.awards.prize = event.target.value;
      this.dataUpdate();
    },
    awardDescription(event) {
      this.awardCreate.awards.description = event.target.value;
      this.dataUpdate();
    },
    deleteAward() {
      this.awardCreate.isDeleted = true;
      this.dataUpdate();
    },
  },
  beforeMount() {
    this.awardCreate.awards = this.awards;
    this.awardCreate.isDeleted = false;
  },
};
</script>

<style>
@import '../assets/styles/LookResume.css'
</style>
