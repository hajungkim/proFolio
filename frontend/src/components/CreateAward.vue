<template>
  <div class="resume-part2-box">
  <table class="resume-part2-input">
    <tr>
      <th>대회명</th>
      <td><input type="text" :placeholder="award.name"></td>
    </tr>
    <tr>
      <th>성적</th>
      <td><input type="text" :placeholder="award.prize"></td>
      <th>날짜</th>
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
                :label="award_date"
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
    </tr>
    <tr>
      <th>내용</th>
      <td colspan="4" >
        <textarea type="text" :placeholder="award.description" class="resume-p2-award"/>
      </td>
    </tr>
  </table>
</div>
</template>

<script>
export default {
  name: 'CreateAward',
  props: {
    award: {
      type: Object,
    },
  },
  data() {
    return {
      date1: null,
      menu1: false,
      award_date: this.award.awardsdate,
    };
  },
};
</script>

<style>
@import '../assets/styles/LookResume.css'
</style>
