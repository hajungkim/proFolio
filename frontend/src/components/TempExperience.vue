<template>
  <div>
    <strong class="plus-btn-box">
      <div>경험</div>
      <div class="plus-btn" @click="addActivity">+</div>
    </strong>
    <div
      class="resume-part2-box"
      v-for="(activity) in resume.activity" :key="activity.id"
    >
      <table class="resume-part2-input">
        <tr>
          <th>활동명</th>
          <td>
            <input
              type="text"
              :value="activity.name"
              name="name"
              @change="changeInput($event, activity)"
            />
          </td>
          <th class="pl-15">활동기관</th>
          <td>
            <input
              type="text"
              :value="activity.organization"
              name="organization"
              @change="changeInput($event, activity)"
            />
          </td>
        </tr>
        <!-- <tr> -->
        <Calendar :item="activity"/>
        <!-- </tr> -->
        <tr>
          <th>내용</th>
          <td colspan="4">
            <textarea
              class="resume-p2-exp"
              :value="activity.description"
              name="description"
              @change="changeInput($event, activity)"
            />
          </td>
        </tr>
      </table>
      <div class="delete-btn-2" @click="deleteActivity(activity)">x</div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import _ from 'lodash';
import Calendar from './TempCalendar.vue';

export default {
  name: 'Experience',
  components: {
    Calendar,
  },
  props: {
    activity: {
      type: Object,
    },
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
    addActivity() {
      const newActivity = {
        id: `${Date.now()}`,
        name: '',
        organization: '',
        description: '',
        startDate: '',
        endDate: '',
        userId: this.userId,
      };
      if (!this.resume.activity) {
        this.$store.commit('CHANGE_ACTIVITY_LIST', [newActivity]);
      } else {
        this.$store.commit('CHANGE_ACTIVITY_LIST', [...this.resume.activity, newActivity]);
      }
    },
    deleteActivity(item) {
      const newList = _.differenceWith(this.resume.activity, [item], _.isEqual);
      this.$store.commit('CHANGE_ACTIVITY_LIST', newList);
    },
    changeInput(event, activity) {
      const { name, value } = event.target;
      this.$store.commit('CHANGE_ACTIVITY_INFO', { name, value, activity });
    },
  },
};
</script>

<style>
@import '../assets/styles/ResumePart.css';
</style>
