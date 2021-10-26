<template>
  <div>
    <div class="resume-part-title">part2</div>
    <div class="resume-part-sub">학력, 경력, 경험을 입력해주세요.</div>
    <div><strong>학력</strong></div>
    <div class="resume-part2-box">
      <table class="resume-part2-input">
        <tr>
          <th>대학교</th>
          <td><input type="text"></td>
        </tr>
        <tr>
          <th>전공</th>
          <td><input type="text"></td>
          <th class="pl-15">부전공</th>
          <td><input type="text"></td>
        </tr>
        <tr>
          <th>입학</th>
          <td><input type="text"></td>
          <th class="pl-15">졸업</th>
          <td><input type="text"></td>
          <td>
            <div class="graduation">
              <select class="select-graduation">
                <option value="1">졸업 여부</option>
                <option value="2">졸업</option>
                <option value="3">졸업예정</option>
              </select>
            </div>
          </td>
        </tr>
      </table>
    </div>
    <div class="hr-border-m-40"></div>
    <div>
      <strong>경력</strong>
      <div class="plus-btn" @click="addCreateCareer">+</div>
      <CreateCareer
        v-for="(career) in career" :key="career.id" :career="career"
      />
    </div>
    <div class="hr-border-m-40"></div>
    <div>
      <strong>경험</strong>
      <div class="plus-btn" @click="addCreateExperience">+</div>
      <CreateExperience
        v-for="(activity) in activity" :key="activity.id" :activity="activity"
      />
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import CreateCareer from './CreateCareer.vue';
import CreateExperience from './CreateExperience.vue';

export default {
  name: 'ResumePart2',
  components: {
    CreateCareer,
    CreateExperience,
  },
  data() {
    return {
      career: null,
      activity: null,
    };
  },
  computed: {
    ...mapState([
      'resume',
    ]),
  },
  methods: {
    addCreateCareer() {
      const newCareer = {
        id: this.career.length + 1, company: '', duty: '', description: '', start_date: '', end_date: '',
      };
      this.career.unshift(newCareer);
    },
    addCreateExperience() {
      const newExp = {
        id: this.activity.length + 1, name: '', organization: '', description: '', start_date: '', end_date: '',
      };
      this.activity.unshift(newExp);
    },
  },
  beforeMount() {
    this.career = JSON.parse(JSON.stringify(this.resume.career));
    this.activity = JSON.parse(JSON.stringify(this.resume.activity));
  },
};
</script>

<style>
@import '../assets/styles/ResumePart.css';
</style>
