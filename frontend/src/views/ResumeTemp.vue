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
          <div class="resume-save-btn" @click="save()">저장하기</div>
          <div class="resume-next-btn" @click="exit">완료</div>
        </div>
      </div>
    </div>
    <div class="resume-part">
      <ResumePart1 v-if="resumePart==0" @save="save"/>
      <ResumePart2 v-else-if="resumePart==1" @save="save"/>
      <ResumePart3 v-else-if="resumePart==2" @save="save"/>
      <ResumePart4 v-else-if="resumePart==3" @save="save"/>
      <ResumePart5 v-else-if="resumePart==4" @save="save"/>
    </div>
  </div>
</template>

<script>
import _ from 'lodash';
import { mapState } from 'vuex';
import ResumePart1 from '../components/TempResumePart1.vue';
import ResumePart2 from '../components/TempResumePart2.vue';
import ResumePart3 from '../components/TempResumePart3.vue';
import ResumePart4 from '../components/TempResumePart4.vue';
import ResumePart5 from '../components/TempResumePart5.vue';
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
    };
  },
  computed: {
    ...mapState([
      'userId',
      'resume',
      'old_resume',
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
    exit() {
      // 페이지 벗어나기
      this.save();
      console.log('exit');
      this.$router.push('mypage');
    },
    save(index = this.resumePart) {
      console.log('save', index);
      if (index === 0) {
        // 인적사항
        const {
          email, name, phone, profilePath, githubId, description,
        } = this.resume.user;
        const part1 = {
          email, name, phone, profilePath, githubId, description,
        };
        putUserInfo(this.userId, part1)
          .then(() => {
            this.$store.dispatch('getUser', this.userId);
          });
      } else if (index === 1) {
        // 학력
        const newItem = _.differenceWith(
          [this.resume.education], [this.old_resume.education], _.isEqual,
        );
        if (!_.isEmpty(newItem)) {
          const eduData = {
            id: newItem[0].id,
            data: newItem[0],
          };
          eduData.data.id = null;
          if (_.isEmpty(this.old_resume.education)) {
            // 생성
            this.$store.dispatch('educationCreate', eduData);
          } else {
            // 수정
            this.$store.dispatch('educationUpdate', eduData);
          }
        }
        // 경력
        // changeIdArray에 들어가있는 값은 put으로 들어있지 않은 값은 post로
        const oldIdCareer = this.old_resume.career.map((obj) => obj.id);
        const newIdCareer = this.resume.career.map((obj) => obj.id);
        const changeIdCareer = _.difference(newIdCareer, oldIdCareer);
        const deletedIdCareer = _.difference(oldIdCareer, newIdCareer);
        // 1. 새로운 사항 저장
        const newItemCareerTemp = _.differenceWith(
          this.resume.career, this.old_resume.career, _.isEqual,
        );
        const newItemCareer = newItemCareerTemp.filter(
          (obj) => changeIdCareer.includes(obj.id),
        );
        // 2. 수정 사항
        const changeItemCareer = newItemCareerTemp.filter(
          (obj) => !changeIdCareer.includes(obj.id),
        );
        // 3. 삭제된 사항
        const deletedItemCareer = this.old_resume.career.filter(
          (obj) => deletedIdCareer.includes(obj.id),
        );
        // 4. 저장
        newItemCareer.forEach((data) => {
          data.id = null;
          this.$store.dispatch('careerCreate', data);
        });
        changeItemCareer.forEach((data) => {
          const newData = {
            id: data.id,
            data,
          };
          newData.data.id = null;
          this.$store.dispatch('careerUpdate', newData);
        });
        deletedItemCareer.forEach(
          (data) => this.$store.dispatch('careerDelete', data.id),
        );

        // 경험
        const oldIdActivity = this.old_resume.activity.map((obj) => obj.id);
        const newIdActivity = this.resume.activity.map((obj) => obj.id);
        const changeIdActivity = _.difference(newIdActivity, oldIdActivity);
        const deletedIdActivity = _.difference(oldIdActivity, newIdActivity);
        // 1. 새로운 사항
        const newItemActivityTemp = _.differenceWith(
          this.resume.activity, this.old_resume.activity, _.isEqual,
        );
        const newItemActivity = newItemActivityTemp.filter(
          (obj) => changeIdActivity.includes(obj.id),
        );
        // 2. 수정 사항
        const changeItemActivity = newItemActivityTemp.filter(
          (obj) => !changeIdActivity.includes(obj.id),
        );
        // 3. 삭제된 사항
        const deletedItemActivity = this.old_resume.activity.filter(
          (obj) => deletedIdActivity.includes(obj.id),
        );
        // 4. 저장
        newItemActivity.forEach((data) => {
          data.id = null;
          this.$store.dispatch('activityCreate', data);
        });
        changeItemActivity.forEach((data) => {
          const newData = {
            id: data.id,
            data,
          };
          newData.data.id = null;
          this.$store.dispatch('activityUpdate', newData);
        });
        deletedItemActivity.forEach(
          (data) => this.$store.dispatch('activityDelete', data.id),
        );

        // old_resume 갱신
        this.$store.commit('RESUME_COPY_RESUME_PART', { key: 'education' });
        this.$store.commit('RESUME_COPY_RESUME_PART', { key: 'career' });
        this.$store.commit('RESUME_COPY_RESUME_PART', { key: 'activity' });
      } else if (index === 2) {
        // 어학
        const oldIdLang = this.old_resume.foreignLang.map((obj) => obj.id);
        const newIdLang = this.resume.foreignLang.map((obj) => obj.id);
        const changeIdLang = _.difference(newIdLang, oldIdLang);
        const deletedIdLang = _.difference(oldIdLang, newIdLang);
        // 1. 새로운 사항
        const newItemLangTemp = _.differenceWith(
          this.resume.foreignLang, this.old_resume.foreignLang, _.isEqual,
        );
        const newItemLang = newItemLangTemp.filter(
          (obj) => changeIdLang.includes(obj.id),
        );
        // 2. 수정 사항
        const changeItemLang = newItemLangTemp.filter(
          (obj) => !changeIdLang.includes(obj.id),
        );
        // 3. 삭제된 사항
        const deletedItemLang = this.old_resume.foreignLang.filter(
          (obj) => deletedIdLang.includes(obj.id),
        );
        // 4. 저장
        newItemLang.forEach((data) => {
          data.id = null;
          this.$store.dispatch('languageCreate', data);
        });
        changeItemLang.forEach((data) => {
          const newData = {
            id: data.id,
            data,
          };
          newData.data.id = null;
          this.$store.dispatch('languageUpdate', newData);
        });
        deletedItemLang.forEach(
          (data) => this.$store.dispatch('languageDelete', data.id),
        );
        // 자격증
        const oldIdCert = this.old_resume.certificate.map((obj) => obj.id);
        const newIdCert = this.resume.certificate.map((obj) => obj.id);
        const changeIdCert = _.difference(newIdCert, oldIdCert);
        const deletedIdCert = _.difference(oldIdCert, newIdCert);
        // 1. 새로운 사항
        const newItemCertTemp = _.differenceWith(
          this.resume.certificate, this.old_resume.certificate, _.isEqual,
        );
        const newItemCert = newItemCertTemp.filter(
          (obj) => changeIdCert.includes(obj.id),
        );
        // 2. 수정 사항
        const changeItemCert = newItemCertTemp.filter(
          (obj) => !changeIdCert.includes(obj.id),
        );
        // 3. 삭제된 사항
        const deletedItemCert = this.old_resume.certificate.filter(
          (obj) => deletedIdCert.includes(obj.id),
        );
        // 4. 저장
        newItemCert.forEach((data) => {
          data.id = null;
          this.$store.dispatch('certificateCreate', data);
        });
        changeItemCert.forEach((data) => {
          const newData = {
            id: data.id,
            data,
          };
          newData.data.id = null;
          this.$store.dispatch('certificateUpdate', newData);
        });
        deletedItemCert.forEach(
          (data) => this.$store.dispatch('certificateDelete', data.id),
        );

        // 수상
        const oldIdAward = this.old_resume.awards.map((obj) => obj.id);
        const newIdAward = this.resume.awards.map((obj) => obj.id);
        const changeIdAward = _.difference(newIdAward, oldIdAward);
        const deletedIdAward = _.difference(oldIdAward, newIdAward);
        // 1. 새로운 사항
        const newItemAwardTemp = _.differenceWith(
          this.resume.awards, this.old_resume.awards, _.isEqual,
        );
        const newItemAward = newItemAwardTemp.filter(
          (obj) => changeIdAward.includes(obj.id),
        );
        // 2. 수정 사항
        const changeItemAward = newItemAwardTemp.filter(
          (obj) => !changeIdAward.includes(obj.id),
        );
        // 3. 삭제된 사항
        const deletedItemAward = this.old_resume.awards.filter(
          (obj) => deletedIdAward.includes(obj.id),
        );
        // 4. 저장
        newItemAward.forEach((data) => {
          data.id = null;
          this.$store.dispatch('awardsCreate', data);
        });
        changeItemAward.forEach((data) => {
          const newData = {
            id: data.id,
            data,
          };
          newData.data.id = null;
          this.$store.dispatch('awardsUpdate', newData);
        });
        deletedItemAward.forEach(
          (data) => this.$store.dispatch('awardsDelete', data.id),
        );
        // old_resume 갱신
        this.$store.commit('RESUME_COPY_RESUME_PART', { key: 'foreignLang' });
        this.$store.commit('RESUME_COPY_RESUME_PART', { key: 'certificate' });
        this.$store.commit('RESUME_COPY_RESUME_PART', { key: 'awards' });
      } else if (index === 3) {
        // 기술스택
        const oldIdTech = this.old_resume.technologyStack.map((obj) => obj.id);
        const newIdTech = this.resume.technologyStack.map((obj) => obj.id);
        const changeIdTech = _.difference(newIdTech, oldIdTech);
        const deletedIdTech = _.difference(oldIdTech, newIdTech);
        // 1. 새로운 사항
        const newItemTechTemp = _.differenceWith(
          this.resume.technologyStack, this.old_resume.technologyStack, _.isEqual,
        );
        const newItemTech = newItemTechTemp.filter(
          (obj) => changeIdTech.includes(obj.id),
        );
        // 2. 수정 사항
        const changeItemTech = newItemTechTemp.filter(
          (obj) => !changeIdTech.includes(obj.id),
        );
        // 3. 삭제된 사항
        const deletedItemTech = this.old_resume.technologyStack.filter(
          (obj) => deletedIdTech.includes(obj.id),
        );
        // 4. 저장
        newItemTech.forEach((data) => {
          data.id = null;
          this.$store.dispatch('techStackCreate', data);
        });
        changeItemTech.forEach((data) => {
          const newData = {
            id: data.id,
            data,
          };
          newData.data.id = null;
          this.$store.dispatch('techStackUpdate', newData);
        });
        deletedItemTech.forEach(
          (data) => this.$store.dispatch('techStackDelete', data.id),
        );
        // old_resume 갱신
        this.$store.commit('RESUME_COPY_RESUME_PART', { key: 'technologyStack' });
      } else if (index === 4) {
        // 프로젝트
        const oldIdPjt = this.old_resume.project.map((obj) => obj.id);
        const newIdPjt = this.resume.project.map((obj) => obj.id);
        const changeIdPjt = _.difference(newIdPjt, oldIdPjt);
        const deletedIdPjt = _.difference(oldIdPjt, newIdPjt);
        // 1. 새로운 사항
        const newItemPjtTemp = _.differenceWith(
          this.resume.project, this.old_resume.project, _.isEqual,
        );
        const newItemPjt = newItemPjtTemp.filter(
          (obj) => changeIdPjt.includes(obj.id),
        );
        // 2. 수정 사항
        const changeItemPjt = newItemPjtTemp.filter(
          (obj) => !changeIdPjt.includes(obj.id),
        );
        // 3. 삭제된 사항
        const deletedItemPjt = this.old_resume.project.filter(
          (obj) => deletedIdPjt.includes(obj.id),
        );
        // 4. 저장
        newItemPjt.forEach((data) => {
          data.id = null;
          this.$store.dispatch('projectCreate', data);
        });
        changeItemPjt.forEach((data) => {
          const newData = {
            id: data.id,
            data,
          };
          newData.data.id = null;
          this.$store.dispatch('projectUpdate', newData);
        });
        deletedItemPjt.forEach(
          (data) => this.$store.dispatch('projectDelete', data.id),
        );
        // old_resume 갱신
        this.$store.commit('RESUME_COPY_RESUME_PART', { key: 'project' });
      }
    },
  },
  created() {
    this.$store.commit('RESUME_COPY_RESUME');
  },
};
</script>

<style>
@import '../assets/styles/Resume.css';
</style>
