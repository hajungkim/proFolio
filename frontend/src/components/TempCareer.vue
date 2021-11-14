<template>
  <div>
    <strong class="plus-btn-box">
      <div>경력</div>
      <div class="plus-btn" @click="addCareer">+</div>
    </strong>
    <div
      class="resume-part2-box"
      v-for="(career) in resume.career" :key="career.id"
    >
      <table
        class="resume-part2-input"
      >
        <tr>
          <th>기업명</th>
          <td>
            <input
              type="text"
              :value="career.company"
              name="company"
              @change="changeInput($event, career)"
            />
          </td>
          <th class="pl-15">직무</th>
          <td>
            <input
              type="text"
              :value="career.duty"
              name="duty"
              @change="changeInput($event, career)"
            />
          </td>
        </tr>
        <!-- <tr> -->
        <Calendar :item="career"/>
        <!-- </tr> -->
        <tr>
          <th>내용</th>
          <td colspan="4">
            <textarea
              class="resume-p2-career"
              :value="career.description"
              name="description"
              @change="changeInput($event, career)"
            />
          </td>
        </tr>
      </table>
      <div class="delete-btn" @click="deleteCareer(career)">x</div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import _ from 'lodash';
import Calendar from './TempCalendar.vue';

export default {
  name: 'Career',
  components: {
    Calendar,
  },
  data() {
    return {
    };
  },
  computed: {
    ...mapState([
      'resume',
      'userId',
    ]),
  },
  methods: {
    addCareer() {
      const newCareer = {
        id: `${Date.now()}`,
        company: '',
        duty: '',
        description: '',
        startDate: '',
        endDate: '',
        userId: this.userId,
      };
      if (!this.resume.career) {
        this.$store.commit('CHANGE_CAREER_LIST', [newCareer]);
      } else {
        this.$store.commit('CHANGE_CAREER_LIST', [...this.resume.career, newCareer]);
      }
    },
    deleteCareer(item) {
      const newList = _.differenceWith(this.resume.career, [item], _.isEqual);
      this.$store.commit('CHANGE_CAREER_LIST', newList);
    },
    changeInput(event, career) {
      const { name, value } = event.target;
      this.$store.commit('CHANGE_CAREER_INFO', { name, value, career });
    },
  },
};
</script>

<style>
@import '../assets/styles/ResumePart.css';
</style>
