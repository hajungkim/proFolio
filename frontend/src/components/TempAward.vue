<template>
  <div>
    <strong  class="plus-btn-box">
      <div>수상</div>
      <div class="plus-btn" @click="addAward">+</div>
    </strong>
    <div
      class="resume-part2-box"
      v-for="(award) in resume.awards" :key="award.id"
    >
      <table class="resume-part2-input">
        <tr>
          <th>대회명</th>
          <td style="grid-column: 1 / span2">
            <input
              type="text"
              :value="award.name"
              name="name"
              @change="changeInput($event, award)"
            />
          </td>
        </tr>
        <tr>
          <th>수상내역</th>
          <td>
            <input
              type="text"
              :value="award.prize"
              name="prize"
              @change="changeInput($event, award)"
            />
          </td>
          <th>날짜</th>
          <td>
            <SingleCalender :item="award" />
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td colspan="4" >
            <textarea
              type="text"
              class="resume-p2-award"
              :value="award.description"
              name="description"
              @change="changeInput($event, award)"
            />
          </td>
        </tr>
      </table>
      <div class="delete-btn" @click="deleteAward(award)">x</div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import _ from 'lodash';
import SingleCalender from './TempSingleCalenderForAward.vue';

export default {
  name: 'Award',
  components: {
    SingleCalender,
  },
  data() {
    return {
    };
  },
  computed: {
    ...mapState([
      'resume',
    ]),
  },
  methods: {
    addAward() {
      const newItem = {
        id: `${Date.now()}`,
        name: '',
        certifiedDate: '',
        description: '',
      };
      if (!this.resume.awards) {
        this.$store.commit('CHANGE_AWARDS_LIST', [newItem]);
      } else {
        this.$store.commit('CHANGE_AWARDS_LIST', [...this.resume.awards, newItem]);
      }
    },
    deleteAward(item) {
      const newList = _.differenceWith(this.resume.awards, [item], _.isEqual);
      this.$store.commit('CHANGE_AWARDS_LIST', newList);
    },
    changeInput(event, award) {
      const { name, value } = event.target;
      this.$store.commit('CHANGE_AWARDS_INFO', { name, value, award });
    },
  },
};
</script>

<style>
</style>
