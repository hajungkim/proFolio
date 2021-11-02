<template>
  <div class="resume">
    <div class="resume-wrapper">
      <ul class="step-progress">
        <li class="step-progress-item current" data-step="1" @click="stepChange">
          <strong data-step="1" @click="stepChange">인적사항</strong>
        </li>
        <li class="step-progress-item" data-step="2" @click="stepChange">
          <strong data-step="2" @click="stepChange">학력/경력/활동</strong>
        </li>
        <li class="step-progress-item" data-step="3" @click="stepChange">
          <strong data-step="3" @click="stepChange">어학/자격증/수상</strong>
        </li>
        <li class="step-progress-item" data-step="4" @click="stepChange">
          <strong data-step="4" @click="stepChange">기술스택</strong>
        </li>
        <li class="step-progress-item" data-step="5" @click="stepChange">
          <strong data-step="5" @click="stepChange">프로젝트</strong>
        </li>
      </ul>
      <div class="resume-btn-box">
        <div>
          <div class="resume-save-btn" @click="save">저장하기</div>
          <div class="resume-next-btn" @click="next">Next</div>
        </div>
      </div>
    </div>
    <div class="resume-part">
      <ResumePart1 v-if="resumePart==0" @part1Data="part1Data"/>
      <ResumePart2 v-if="resumePart==1" :resumeEdit="resumeEdit"
       @deleteEducation="deleteEducation" @updateEducationData="updateEducationData"
       @createEducationData="createEducationData"/>
      <ResumePart3 v-if="resumePart==2"/>
      <ResumePart4 v-if="resumePart==3"/>
      <ResumePart5 v-if="resumePart==4"/>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import ResumePart1 from '../components/ResumePart1.vue';
import ResumePart2 from '../components/ResumePart2.vue';
import ResumePart3 from '../components/ResumePart3.vue';
import ResumePart4 from '../components/ResumePart4.vue';
import ResumePart5 from '../components/ResumePart5.vue';
import { putUserInfo } from '@/store/modules/UserAPI';

export default {
  name: 'Resume',
  components: {
    ResumePart1,
    ResumePart2,
    ResumePart3,
    ResumePart4,
    ResumePart5,
  },
  data() {
    return {
      resumePart: 0,
      resumeEdit: null,
      educationDelete: [],
      educationUpdate: [],
      educationCreate: [],
    };
  },
  computed: {
    ...mapState([
      'userId',
      'resume',
    ]),
  },
  methods: {
    stepChange(event) {
      const Now = event.target.getAttribute('data-step') - 1;
      const stepList = document.querySelectorAll('.step-progress-item');
      for (let i = 0; i < 5; i += 1) {
        if (i < Now) stepList[i].className = 'step-progress-item is-done';
        else if (i === Now) stepList[i].className = 'step-progress-item current';
        else stepList[i].className = 'step-progress-item';
      }
      this.resumePart = Now;
    },
    next() {
      const Next = this.resumePart + 1;
      const stepList = document.querySelectorAll('.step-progress-item');
      for (let i = 0; i < 5; i += 1) {
        if (i < Next) stepList[i].className = 'step-progress-item is-done';
        else if (i === Next) stepList[i].className = 'step-progress-item current';
        else stepList[i].className = 'step-progress-item';
      }
      this.resumePart = Next;
    },
    part1Data(user) {
      this.resumeEdit.user = user;
    },
    save() {
      if (this.resumePart === 0) {
        const part1 = {
          birthday: this.resumeEdit.user.birthday,
          email: this.resumeEdit.user.email,
          name: this.resumeEdit.user.name,
          phone: this.resumeEdit.user.phone,
          profile_path: this.resumeEdit.user.profile_path,
        };
        putUserInfo(this.userId, part1).then(() => {
          this.$store.dispatch('getUser', this.userId);
        });
      } else if (this.resumePart === 1) {
        Object.values(this.educationUpdate).forEach((educationInfo) => {
          this.$store.dispatch('updateEducation', { id: educationInfo.id, data: educationInfo.data });
        });
        Object.values(this.educationCreate).forEach((educationInfo) => {
          this.$store.dispatch('educationCreate', educationInfo.data);
        });
      }
    },
    deleteEducation(deleteEducation) {
      // api 보낼 삭제할 인덱스 추가하기
      this.educationDelete.push(deleteEducation);
      // vue 보여지는 부분에서 삭제한 부분 제거하기 -> 저장 안하면 다시 되돌아오게
      let sliceIndex = null;
      Object.entries(this.resumeEdit.education).forEach((education) => {
        if (Object.keys(education[1]).find((key) => education[1][key] === deleteEducation)) {
          [sliceIndex] = education;
        }
      });
      this.resumeEdit.education.splice(sliceIndex, 1);
    },
    updateEducationData(updateEducationData) {
      console.log('update');
      const updateData = {};
      updateData.id = updateEducationData.id;
      delete updateEducationData.id;
      updateEducationData.userId = this.userId;
      updateData.data = updateEducationData;
      let flag = false;
      Object.entries(this.educationUpdate).forEach((update) => {
        if (update.id === updateData.id) {
          // educationUpdate에 있으면 내용 대체
          this.educationUpdate.splice(update[0], 1, updateData);
          flag = true;
        }
      });
      // 없으면 추가
      if (!flag) {
        this.educationUpdate.push(updateData);
      }
    },
    createEducationData(createEducationData) {
      console.log('create');
      // console.log(createEducationData);
      const createData = {};
      createData.id = createEducationData.id;
      delete createEducationData.id;
      createEducationData.userId = this.userId;
      createData.data = createEducationData;
      let flag = false;
      Object.entries(this.educationCreate).forEach((create) => {
        if (create.id === createData.id) {
          // 있으면 내용 대체
          this.educationCreate.splice(create[0], 1, createData);
          flag = true;
        }
      });
      // 없으면 추가
      if (!flag) {
        this.educationCreate.push(createData);
      }
      console.log(this.educationCreate);
      console.log('---------------');
    },
  },
  beforeMount() {
    this.resumeEdit = JSON.parse(JSON.stringify(this.resume));
  },
};
</script>

<style>
@import '../assets/styles/Resume.css';
</style>
