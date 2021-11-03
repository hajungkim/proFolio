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
      <ResumePart2 v-if="resumePart==1"
       @updateEducationData="updateEducationData"
       @createEducationData="createEducationData"
       @createCareerData="createCareerData" @deleteCareer="deleteCareer"
       @updateCareerData="updateCareerData"
       @createActivityData="createActivityData" @updateActivityData="updateActivityData"
       @deleteActivity="deleteActivity"
       />
      <ResumePart3 v-if="resumePart==2"
      @createLangData="createLangData" @deleteLanguage="deleteLanguage"
      @updateLanguageData="updateLanguageData" @createCertData="createCertData"
      @deleteCertificate="deleteCertificate" @updateCertificateData="updateCertificateData"
      @createAwardtData="createAwardtData" @deleteAwards="deleteAwards"
      @updateAwardsData="updateAwardsData"
      />
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
      educationUpdate: [],
      educationCreate: [],
      careerCreate: [],
      careerUpdate: [],
      careerDelete: new Set(),
      activityCreate: [],
      activityUpdate: [],
      activityDelete: new Set(),
      langCreate: [],
      langUpdate: [],
      langDelete: new Set(),
      certCreate: [],
      certUpdate: [],
      certDelete: new Set(),
      awardCreate: [],
      awardUpdate: [],
      awardDelete: new Set(),
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
        Object.values(this.careerCreate).forEach((careerInfo) => {
          this.$store.dispatch('careerCreate', careerInfo.data);
        });
        Object.values(this.careerUpdate).forEach((careerInfo) => {
          this.$store.dispatch('careerUpdate', careerInfo.data);
        });
        Object.values([...this.careerDelete]).forEach((careerInfo) => {
          this.$store.dispatch('careerDelete', careerInfo);
        });
        Object.values(this.activityCreate).forEach((activityInfo) => {
          this.$store.dispatch('activityCreate', activityInfo.data);
        });
        Object.values(this.activityUpdate).forEach((activityInfo) => {
          this.$store.dispatch('activityUpdate', activityInfo.data);
        });
        Object.values([...this.activityDelete]).forEach((activityInfo) => {
          this.$store.dispatch('activityDelete', activityInfo);
        });
        this.educationUpdate = [];
        this.educationCreate = [];
        this.careerCreate = [];
        this.careerUpdate = [];
        this.careerDelete = new Set();
        this.activityCreate = [];
        this.activityUpdate = [];
        this.activityDelete = new Set();
      } else if (this.resumePart === 2) {
        Object.values(this.langCreate).forEach((langInfo) => {
          this.$store.dispatch('languageCreate', langInfo.data);
        });
        Object.values(this.langUpdate).forEach((langInfo) => {
          this.$store.dispatch('languageUpdate', langInfo.data);
        });
        Object.values([...this.langDelete]).forEach((langInfo) => {
          this.$store.dispatch('languageDelete', langInfo);
        });
        Object.values(this.certCreate).forEach((certInfo) => {
          this.$store.dispatch('certificateCreate', certInfo.data);
        });
        Object.values(this.certUpdate).forEach((certInfo) => {
          this.$store.dispatch('certificateUpdate', certInfo.data);
        });
        Object.values([...this.certDelete]).forEach((certInfo) => {
          this.$store.dispatch('certificateDelete', certInfo);
        });
        Object.values(this.awardCreate).forEach((awardInfo) => {
          this.$store.dispatch('awardsCreate', awardInfo.data);
        });
        Object.values(this.awardUpdate).forEach((awardInfo) => {
          this.$store.dispatch('awardsUpdate', awardInfo.data);
        });
        Object.values([...this.awardDelete]).forEach((awardInfo) => {
          this.$store.dispatch('awardsDelete', awardInfo);
        });
        this.langCreate = [];
        this.langUpdate = [];
        this.langDelete = new Set();
        this.certCreate = [];
        this.certUpdate = [];
        this.certDelete = new Set();
        this.awardCreate = [];
        this.awardUpdate = [];
        this.awardDelete = new Set();
      }
    },
    updateEducationData(updateEducationData) {
      const updateData = {};
      updateData.id = updateEducationData.id;
      updateEducationData.userId = this.userId;
      updateData.data = updateEducationData;
      let flag = false;
      Object.values(this.educationUpdate).forEach((update) => {
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
      const createData = {};
      createData.id = createEducationData.id;
      createEducationData.userId = this.userId;
      createData.data = createEducationData;
      let flag = false;
      Object.values(this.educationCreate).forEach((create) => {
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
    },
    createCareerData(createCareerData) {
      const createData = {};
      createData.id = createCareerData.id;
      createCareerData.userId = this.userId;
      createData.data = createCareerData;
      let flag = false;
      Object.values(this.careerCreate).forEach((create) => {
        if (create.id === createData.id) {
          // 있으면 내용 대체
          this.careerCreate.splice(create[0], 1, createData);
          flag = true;
        }
      });
      // 없으면 추가
      if (!flag) {
        this.careerCreate.push(createData);
      }
    },
    deleteCareer(deleteCareer) {
      this.careerDelete.add(deleteCareer);
    },
    updateCareerData(updateCareerData) {
      const updateData = {};
      updateData.id = updateCareerData.id;
      updateCareerData.userId = this.userId;
      updateData.data = updateCareerData;
      let flag = false;
      Object.values(this.careerUpdate).forEach((update) => {
        if (update.id === updateData.id) {
          this.careerUpdate.splice(update[0], 1, updateData);
          flag = true;
        }
      });
      if (!flag) {
        this.careerUpdate.push(updateData);
      }
    },
    createActivityData(createActivityData) {
      const createData = {};
      createData.id = createActivityData.id;
      createActivityData.userId = this.userId;
      createData.data = createActivityData;
      let flag = false;
      Object.values(this.activityCreate).forEach((create) => {
        if (create.id === createData.id) {
          // 있으면 내용 대체
          this.careerCreate.splice(create[0], 1, createData);
          flag = true;
        }
      });
      // 없으면 추가
      if (!flag) {
        this.activityCreate.push(createData);
      }
    },
    updateActivityData(updateActivityData) {
      const updateData = {};
      updateData.id = updateActivityData.id;
      updateActivityData.userId = this.userId;
      updateData.data = updateActivityData;
      let flag = false;
      Object.values(this.activityUpdate).forEach((update) => {
        if (update.id === updateData.id) {
          this.activityUpdate.splice(update[0], 1, updateData);
          flag = true;
        }
      });
      if (!flag) {
        this.activityUpdate.push(updateData);
      }
    },
    deleteActivity(deleteActivity) {
      this.activityDelete.add(deleteActivity);
    },
    createLangData(createLangData) {
      const createData = {};
      createData.id = createLangData.id;
      createLangData.userId = this.userId;
      createData.data = createLangData;
      let flag = false;
      Object.values(this.langCreate).forEach((create) => {
        if (create.id === createData.id) {
          // 있으면 내용 대체
          this.langCreate.splice(create[0], 1, createData);
          flag = true;
        }
      });
      // 없으면 추가
      if (!flag) {
        this.langCreate.push(createData);
      }
    },
    updateLanguageData(updateLanguageData) {
      const updateData = {};
      updateData.id = updateLanguageData.id;
      updateLanguageData.userId = this.userId;
      updateData.data = updateLanguageData;
      let flag = false;
      Object.values(this.langUpdate).forEach((update) => {
        if (update.id === updateData.id) {
          this.langUpdate.splice(update[0], 1, updateData);
          flag = true;
        }
      });
      if (!flag) {
        this.langUpdate.push(updateData);
      }
    },
    deleteLanguage(deleteLanguage) {
      this.langDelete.add(deleteLanguage);
    },
    createCertData(createCertData) {
      const createData = {};
      createData.id = createCertData.id;
      createCertData.userId = this.userId;
      createData.data = createCertData;
      let flag = false;
      Object.values(this.certCreate).forEach((create) => {
        if (create.id === createData.id) {
          this.certCreate.splice(create[0], 1, createData);
          flag = true;
        }
      });
      if (!flag) {
        this.certCreate.push(createData);
      }
    },
    updateCertificateData(updateCertificateData) {
      const updateData = {};
      updateData.id = updateCertificateData.id;
      updateCertificateData.userId = this.userId;
      updateData.data = updateCertificateData;
      let flag = false;
      Object.values(this.certUpdate).forEach((update) => {
        if (update.id === updateData.id) {
          this.certUpdate.splice(update[0], 1, updateData);
          flag = true;
        }
      });
      if (!flag) {
        this.certUpdate.push(updateData);
      }
    },
    deleteCertificate(deleteCertificate) {
      this.certDelete.add(deleteCertificate);
    },
    createAwardtData(createAwardtData) {
      const createData = {};
      createData.id = createAwardtData.id;
      createAwardtData.userId = this.userId;
      createData.data = createAwardtData;
      let flag = false;
      Object.values(this.awardCreate).forEach((create) => {
        if (create.id === createData.id) {
          this.awardCreate.splice(create[0], 1, createData);
          flag = true;
        }
      });
      if (!flag) {
        this.awardCreate.push(createData);
      }
    },
    updateAwardsData(updateAwardsData) {
      const updateData = {};
      updateData.id = updateAwardsData.id;
      updateAwardsData.userId = this.userId;
      updateData.data = updateAwardsData;
      let flag = false;
      Object.values(this.awardUpdate).forEach((update) => {
        if (update.id === updateData.id) {
          this.awardUpdate.splice(update[0], 1, updateData);
          flag = true;
        }
      });
      if (!flag) {
        this.awardUpdate.push(updateData);
      }
    },
    deleteAwards(deleteAwards) {
      this.awardDelete.add(deleteAwards);
    },
  },
};
</script>

<style>
@import '../assets/styles/Resume.css';
</style>
