<template>
  <div>
    <div class="resume-part-title">part2</div>
    <div class="resume-part-sub">학력, 경력, 경험을 입력해주세요.</div>
    <Education />
    <div class="hr-border-m-40"></div>
    <Career />
    <div class="hr-border-m-40"></div>
    <Experience />
  </div>
</template>

<script>
import { mapState } from 'vuex';
import Career from './TempCareer.vue';
import Experience from './TempExperience.vue';
import Education from './TempEducation.vue';

export default {
  name: 'ResumePart2',
  components: {
    Career,
    Experience,
    Education,
  },
  computed: {
    ...mapState([
      'resume',
    ]),
  },
  data() {
    return {
      educationUpdate: null,
      educationCreate: [],
      careerCreate: [],
      careerUpdate: null,
      activityCreate: [],
      activityUpdate: null,
    };
  },
  methods: {
    addCreateExperience() {
      const newExp = {
        id: `create${Math.random()}`, name: '', organization: '', description: '', startDate: '', endDate: '',
      };
      this.activityCreate.unshift(newExp);
    },
    updateEducation(updateEducation) {
      if (updateEducation.isCreated) {
        this.$emit('createEducationData', updateEducation.education);
      } else if (updateEducation.isUpdated) {
        this.$emit('updateEducationData', updateEducation.education);
      }
    },
    createCareerData(createCareer) {
      if (createCareer.isDeleted) {
        let sliceIndex = null;
        const idx = createCareer.career.id;
        Object.entries(this.careerCreate).forEach((career) => {
          if (Object.keys(career[1]).find((key) => career[1][key] === idx)) {
            [sliceIndex] = career;
          }
        });
        this.careerCreate.splice(sliceIndex, 1);
      } else {
        this.$emit('createCareerData', createCareer.career);
      }
    },
    updateCareer(updateCareer) {
      if (updateCareer.isDeleted) {
        let sliceIndex = null;
        const idx = updateCareer.career.id;
        Object.entries(this.careerUpdate).forEach((career) => {
          if (Object.keys(career[1]).find((key) => career[1][key] === idx)) {
            [sliceIndex] = career;
          }
        });
        this.careerUpdate.splice(sliceIndex, 1);
        this.$emit('deleteCareer', updateCareer.career.id);
      } else if (updateCareer.isUpdated) {
        this.$emit('updateCareerData', updateCareer.career);
      }
    },
    createActivity(createActivity) {
      if (createActivity.isDeleted) {
        let sliceIndex = null;
        const idx = createActivity.activity.id;
        Object.entries(this.activityCreate).forEach((activity) => {
          if (Object.keys(activity[1]).find((key) => activity[1][key] === idx)) {
            [sliceIndex] = activity;
          }
        });
        this.activityCreate.splice(sliceIndex, 1);
      } else {
        this.$emit('createActivityData', createActivity.activity);
      }
    },
    updateActivity(updateActivity) {
      if (updateActivity.isDeleted) {
        let sliceIndex = null;
        const idx = updateActivity.activity.id;
        Object.entries(this.activityUpdate).forEach((activity) => {
          if (Object.keys(activity[1]).find((key) => activity[1][key] === idx)) {
            [sliceIndex] = activity;
          }
        });
        this.activityUpdate.splice(sliceIndex, 1);
        this.$emit('deleteActivity', updateActivity.activity.id);
      } else if (updateActivity.isUpdated) {
        this.$emit('updateActivityData', updateActivity.activity);
      }
    },
  },
  beforeMount() {
    if (this.resume.education.id === undefined) {
      this.educationUpdate = {
        id: 'create', university: '', graduation: null, admissionDate: '', graduationDate: '', score: '', totalScore: '', major: '', minor: '', mainSchool: false, isCreated: true,
      };
    } else {
      this.educationUpdate = this.resume.education;
      this.educationUpdate.isCreated = false;
    }
    this.careerUpdate = JSON.parse(JSON.stringify(this.resume.career));
    this.activityUpdate = JSON.parse(JSON.stringify(this.resume.activity));
  },
  beforeDestroy() {
    this.$emit('save', 1);
  },
};
</script>

<style>
@import '../assets/styles/ResumePart.css';
</style>
