<template>
  <div>
    <div class="resume-part-title">part2</div>
    <div class="resume-part-sub">학력, 경력, 경험을 입력해주세요.</div>
    <div>
      <strong class="plus-btn-box">
        <div>학력</div>
      </strong>
      <UpdateEducation
      :education="educationUpdate" @updateEducation="updateEducation"
      />
    </div>
    <div class="hr-border-m-40"></div>
    <div>
      <strong class="plus-btn-box">
        <div>경력</div>
        <div class="plus-btn" @click="addCreateCareer">+</div>
      </strong>
      <CreateCareer
        v-for="(career) in career" :key="career.id" :career="career"
      />
    </div>
    <div class="hr-border-m-40"></div>
    <div>
      <strong class="plus-btn-box">
        <div>경험</div>
        <div class="plus-btn" @click="addCreateExperience">+</div>
      </strong>
      <CreateExperience
        v-for="(activity) in activity" :key="activity.id" :activity="activity"
      />
    </div>
  </div>
</template>

<script>
import CreateCareer from './CreateCareer.vue';
import CreateExperience from './CreateExperience.vue';
import UpdateEducation from './UpdateEducation.vue';

export default {
  name: 'ResumePart2',
  components: {
    CreateCareer,
    CreateExperience,
    UpdateEducation,
  },
  props: {
    resumeEdit: {
      type: Object,
    },
  },
  data() {
    return {
      career: this.resumeEdit.career,
      activity: this.resumeEdit.activity,
      educationUpdate: null,
      educationCreate: [],
    };
  },
  methods: {
    addCreateCareer() {
      const newCareer = {
        id: this.career.length + 1, company: '', duty: '', description: '', startDate: '', endDate: '',
      };
      this.career.unshift(newCareer);
    },
    addCreateExperience() {
      const newExp = {
        id: this.activity.length + 1, name: '', organization: '', description: '', startDate: '', endDate: '',
      };
      this.activity.unshift(newExp);
    },
    updateEducation(updateEducation) {
      if (updateEducation.isCreated) {
        this.$emit('createEducationData', updateEducation.education);
      } else if (updateEducation.isUpdated) {
        this.$emit('updateEducationData', updateEducation.education);
      }
    },
  },
  beforeMount() {
    if (this.resumeEdit.education.id === undefined) {
      this.educationUpdate = {
        id: 'create', university: '', graduation: null, admissionDate: '', graduationDate: '', score: '', totalScore: '', major: '', minor: '', mainSchool: false, isCreated: true,
      };
    } else {
      this.educationUpdate = this.resumeEdit.education;
      this.educationUpdate.isCreated = false;
    }
  },
};
</script>

<style>
@import '../assets/styles/ResumePart.css';
</style>
