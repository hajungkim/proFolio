<template>
  <div>
    <div class="resume-part-title">part2</div>
    <div class="resume-part-sub">학력, 경력, 경험을 입력해주세요.</div>
    <div>
      <strong class="plus-btn-box">
        <div>학력</div>
        <div class="plus-btn" @click="addCreateEdu">+</div>
      </strong>
      <CreateEducation
      v-for="(education) in educationCreate" :key="education.id" :education="education"
      @createEducation="createEducation"
      />
      <UpdateEducation
      v-for="(education) in educationUpdate" :key="education.id" :education="education"
      @updateEducation="updateEducation"
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
import CreateEducation from './CreateEducation.vue';
import UpdateEducation from './UpdateEducation.vue';

export default {
  name: 'ResumePart2',
  components: {
    CreateCareer,
    CreateExperience,
    CreateEducation,
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
      educationUpdate: this.resumeEdit.education,
      educationCreate: [],
    };
  },
  methods: {
    addCreateCareer() {
      const newCareer = {
        id: this.career.length + 1, company: '', duty: '', description: '', startdate: '', enddate: '',
      };
      this.career.unshift(newCareer);
    },
    addCreateExperience() {
      const newExp = {
        id: this.activity.length + 1, name: '', organization: '', description: '', startdate: '', enddate: '',
      };
      this.activity.unshift(newExp);
    },
    addCreateEdu() {
      const newEdu = {
        university: '', graduation: '', admissionDate: '', graduationDate: '', score: '', totalScore: '', major: '', minor: '', mainSchool: false,
      };
      if (this.educationCreate.length === 0) newEdu.id = this.educationCreate.length;
      else newEdu.id = this.educationCreate[-1].id + 1;
      this.educationCreate.unshift(newEdu);
    },
    createEducation(createEducation) {
      if (createEducation.isDeleted) {
        let sliceIndex = null;
        const idx = createEducation.education.id;
        Object.entries(this.educationCreate).forEach((education) => {
          if (Object.keys(education[1]).find((key) => education[1][key] === idx)) {
            [sliceIndex] = education;
          }
        });
        this.educationCreate.splice(sliceIndex, 1);
      } else {
        this.$emit('createEducationData', createEducation.education);
      }
    },
    updateEducation(updateEducation) {
      if (updateEducation.isDeleted) {
        this.$emit('deleteEducation', updateEducation.education.id);
      } else if (updateEducation.isUpdated) {
        this.$emit('updateEducationData', updateEducation.education);
      }
    },
  },
};
</script>

<style>
@import '../assets/styles/ResumePart.css';
</style>
