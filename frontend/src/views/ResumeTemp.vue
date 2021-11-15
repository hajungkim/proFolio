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
          <div class="resume-save-btn" @click="save()">저장</div>
          <!-- <div class="resume-save-btn" @click="exit">완료</div> -->
          <div class="resume-exit-btn" @click="exit">종료</div>
          <!-- <div>{{hasNull}}</div> -->
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
      'isLogin',
      'userId',
      'resume',
      'old_resume',
    ]),
    hasNull() {
      // 하나라도 있으면 true, 없으면 false
      // this.resume에 null값이 포함되어있는지 확인
      const nullList = [null, 'null', undefined, ''];
      const objectHasNull = (obj) => {
        const valList = Object.values(obj);
        const ret = valList.findIndex((v) => nullList.includes(v));
        if (ret === -1) {
          return false;
        }
        return true;
      };
      const listHasNull = (lst) => {
        for (let index = 0; index < lst.length; index += 1) {
          const itemObj = lst[index];
          const ret = objectHasNull(itemObj);
          if (ret) {
            return true;
          }
        }
        return false;
      };
      // Find return value
      let rval = true;
      if (this.resumePart === 0) {
        rval = objectHasNull(this.resume.user);
      } else if (this.resumePart === 1) {
        const r1 = objectHasNull(this.resume.education);
        const r2 = listHasNull(this.resume.activity);
        const r3 = listHasNull(this.resume.career);
        rval = r1 || r2 || r3;
      } else if (this.resumePart === 2) {
        const r1 = listHasNull(this.resume.foreignLang);
        const r2 = listHasNull(this.resume.certificate);
        const r3 = listHasNull(this.resume.awards);
        rval = r1 || r2 || r3;
      } else if (this.resumePart === 3) {
        rval = listHasNull(this.resume.technologyStack);
      } else if (this.resumePart === 4) {
        rval = listHasNull(this.resume.project);
      }
      return rval;
    },
  },
  methods: {
    stepChange(event) {
      // null 값이 있는 경우 넘어가지 못하게
      if (this.hasNull) {
        alert("값을 채워주세요");
        return;
      }
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
      // null 값이 있는 경우 벗어나지 못하게
      if (this.hasNull) {
        alert("값을 채워주세요");
        return;
      }
      // 페이지 벗어나기
      // 컴포넌트 사라지면서 저장하니까 다시 호출할 필요없을듯
      // this.save();
      // console.log('exit');
      this.$router.push('mypage');
    },
    save(index = this.resumePart) {
      // null 값이 있는 경우 저장하지 못하게
      if (this.hasNull) {
        alert("값을 채워주세요");
        return;
      }
      console.log('save', index, '=====');
      if (index === 0) {
        // 인적사항
        const {
          email, name, phone, profilePath, githubId, description, file,
        } = this.resume.user;
        // const part1 = {
        //   email, name, phone, profilePath, githubId, description, file,
        // };
        const user = new FormData();
        if (file) user.append('file', file);
        user.append('email', email);
        user.append('name', name);
        user.append('phone', phone);
        user.append('profilePath', profilePath);
        user.append('githubId', githubId);
        user.append('description', description);
        putUserInfo(this.userId, user)
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
          if (eduData.id === undefined || eduData.id === null) {
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
        // create: resume만, change: resume, old 둘다, deleted: old만
        const createIdCareer = _.difference(newIdCareer, oldIdCareer);
        const changeIdCareer = _.intersection(newIdCareer, oldIdCareer);
        const deletedIdCareer = _.difference(oldIdCareer, newIdCareer);
        // 1. 새로운 사항 저장
        const newItemCareer = this.resume.career.filter(
          (obj) => createIdCareer.includes(obj.id),
        );
        // 2. 수정 사항
        const changeItemCareerTemp = _.differenceWith(
          this.resume.career, this.old_resume.career, _.isEqual,
        ); // 새로운 아이템과 변경 아이템이 포함된 리스트 반환
        const changeItemCareer = changeItemCareerTemp.filter(
          (obj) => changeIdCareer.includes(obj.id),
        );
        // 3. 삭제된 사항
        const deletedItemCareer = this.old_resume.career.filter(
          (obj) => deletedIdCareer.includes(obj.id),
        );
        // 4. 저장
        const saveCareer = async () => {
          const newList = newItemCareer.map(
            async (data) => this.$store.dispatch('careerCreate', data),
          );
          const changeList = changeItemCareer.map(async (data) => {
            const newData = {
              id: data.id,
              data,
            };
            return this.$store.dispatch('careerUpdate', newData);
          });
          const deleteList = deletedItemCareer.map(
            async (data) => this.$store.dispatch('careerDelete', data.id),
          );
          const promiseList = [...newList, ...changeList, ...deleteList];
          const res = await Promise.all(promiseList);
          this.$store.dispatch('resumeUpdate', { key: 'career', res });
        };
        saveCareer();
        // 경험
        const oldIdActivity = this.old_resume.activity.map((obj) => obj.id);
        const newIdActivity = this.resume.activity.map((obj) => obj.id);
        const createIdActivity = _.difference(newIdActivity, oldIdActivity);
        const changeIdActivity = _.intersection(newIdActivity, oldIdActivity);
        const deletedIdActivity = _.difference(oldIdActivity, newIdActivity);
        // 1. 새로운 사항
        const newItemActivity = this.resume.activity.filter(
          (obj) => createIdActivity.includes(obj.id),
        );
        // 2. 수정 사항
        const changeItemActivityTemp = _.differenceWith(
          this.resume.activity, this.old_resume.activity, _.isEqual,
        ); // 새로운 아이템과 변경 아이템이 포함된 리스트 반환
        const changeItemActivity = changeItemActivityTemp.filter(
          (obj) => changeIdActivity.includes(obj.id),
        );
        // 3. 삭제된 사항
        const deletedItemActivity = this.old_resume.activity.filter(
          (obj) => deletedIdActivity.includes(obj.id),
        );
        // 4. 저장
        const saveActivity = async () => {
          const newList = newItemActivity.map(
            async (data) => this.$store.dispatch('activityCreate', data),
          );
          const changeList = changeItemActivity.map(async (data) => {
            const newData = {
              id: data.id,
              data,
            };
            return this.$store.dispatch('activityUpdate', newData);
          });
          const deleteList = deletedItemActivity.map(
            async (data) => this.$store.dispatch('activityDelete', data.id),
          );
          const promiseList = [...newList, ...changeList, ...deleteList];
          const res = await Promise.all(promiseList);
          // console.log(res);
          this.$store.dispatch('resumeUpdate', { key: 'activity', res });
        };
        saveActivity();
      } else if (index === 2) {
        // 어학
        const oldIdLang = this.old_resume.foreignLang.map((obj) => obj.id);
        const newIdLang = this.resume.foreignLang.map((obj) => obj.id);
        // create: resume만, change: resume, old 둘다, deleted: old만
        const createIdLang = _.difference(newIdLang, oldIdLang);
        const changeIdLang = _.intersection(newIdLang, oldIdLang);
        const deletedIdLang = _.difference(oldIdLang, newIdLang);
        // 1. 새로운 사항 저장
        const newItemLang = this.resume.foreignLang.filter(
          (obj) => createIdLang.includes(obj.id),
        );
        // 2. 수정 사항
        const changeItemLangTemp = _.differenceWith(
          this.resume.foreignLang, this.old_resume.foreignLang, _.isEqual,
        ); // 새로운 아이템과 변경 아이템이 포함된 리스트 반환
        const changeItemLang = changeItemLangTemp.filter(
          (obj) => changeIdLang.includes(obj.id),
        );
        // 3. 삭제된 사항
        const deletedItemLang = this.old_resume.foreignLang.filter(
          (obj) => deletedIdLang.includes(obj.id),
        );
        // 4. 저장
        const saveLang = async () => {
          const newList = newItemLang.map(
            async (data) => this.$store.dispatch('languageCreate', data),
          );
          const changeList = changeItemLang.map(async (data) => {
            const newData = {
              id: data.id,
              data,
            };
            return this.$store.dispatch('languageUpdate', newData);
          });
          const deleteList = deletedItemLang.map(
            async (data) => this.$store.dispatch('languageDelete', data.id),
          );
          const promiseList = [...newList, ...changeList, ...deleteList];
          const res = await Promise.all(promiseList);
          // console.log(res);
          this.$store.dispatch('resumeUpdate', { key: 'foreignLang', res });
        };
        saveLang();

        // 자격증
        const oldIdCert = this.old_resume.certificate.map((obj) => obj.id);
        const newIdCert = this.resume.certificate.map((obj) => obj.id);
        // create: resume만, change: resume, old 둘다, deleted: old만
        const createIdCert = _.difference(newIdCert, oldIdCert);
        const changeIdCert = _.intersection(newIdCert, oldIdCert);
        const deletedIdCert = _.difference(oldIdCert, newIdCert);
        // 1. 새로운 사항 저장
        const newItemCert = this.resume.certificate.filter(
          (obj) => createIdCert.includes(obj.id),
        );
        // 2. 수정 사항
        const changeItemCertTemp = _.differenceWith(
          this.resume.certificate, this.old_resume.certificate, _.isEqual,
        ); // 새로운 아이템과 변경 아이템이 포함된 리스트 반환
        const changeItemCert = changeItemCertTemp.filter(
          (obj) => changeIdCert.includes(obj.id),
        );
        // 3. 삭제된 사항
        const deletedItemCert = this.old_resume.certificate.filter(
          (obj) => deletedIdCert.includes(obj.id),
        );
        // 4. 저장
        const saveCert = async () => {
          const newList = newItemCert.map(
            async (data) => this.$store.dispatch('certificateCreate', data),
          );
          const changeList = changeItemCert.map(async (data) => {
            const newData = {
              id: data.id,
              data,
            };
            return this.$store.dispatch('certificateUpdate', newData);
          });
          const deleteList = deletedItemCert.map(
            async (data) => this.$store.dispatch('certificateDelete', data.id),
          );
          const promiseList = [...newList, ...changeList, ...deleteList];
          const res = await Promise.all(promiseList);
          // console.log(res);
          this.$store.dispatch('resumeUpdate', { key: 'certificate', res });
        };
        saveCert();

        // 수상
        const oldIdAward = this.old_resume.awards.map((obj) => obj.id);
        const newIdAward = this.resume.awards.map((obj) => obj.id);
        // create: resume만, change: resume, old 둘다, deleted: old만
        const createIdAward = _.difference(newIdAward, oldIdAward);
        const changeIdAward = _.intersection(newIdAward, oldIdAward);
        const deletedIdAward = _.difference(oldIdAward, newIdAward);
        // 1. 새로운 사항 저장
        const newItemAward = this.resume.awards.filter(
          (obj) => createIdAward.includes(obj.id),
        );
        // 2. 수정 사항
        const changeItemAwardTemp = _.differenceWith(
          this.resume.awards, this.old_resume.awards, _.isEqual,
        ); // 새로운 아이템과 변경 아이템이 포함된 리스트 반환
        const changeItemAward = changeItemAwardTemp.filter(
          (obj) => changeIdAward.includes(obj.id),
        );
        // 3. 삭제된 사항
        const deletedItemAward = this.old_resume.awards.filter(
          (obj) => deletedIdAward.includes(obj.id),
        );
        // 4. 저장
        const saveAward = async () => {
          const newList = newItemAward.map(
            async (data) => this.$store.dispatch('awardsCreate', data),
          );
          const changeList = changeItemAward.map(async (data) => {
            const newData = {
              id: data.id,
              data,
            };
            return this.$store.dispatch('awardsUpdate', newData);
          });
          const deleteList = deletedItemAward.map(
            async (data) => this.$store.dispatch('awardsDelete', data.id),
          );
          const promiseList = [...newList, ...changeList, ...deleteList];
          const res = await Promise.all(promiseList);
          // console.log(res);
          this.$store.dispatch('resumeUpdate', { key: 'awards', res });
        };
        saveAward();
      } else if (index === 3) {
        // 기술스택
        const oldIdTech = this.old_resume.technologyStack.map((obj) => obj.id);
        const newIdTech = this.resume.technologyStack.map((obj) => obj.id);
        // create: resume만, change: resume, old 둘다, deleted: old만
        const createIdTech = _.difference(newIdTech, oldIdTech);
        const changeIdTech = _.intersection(newIdTech, oldIdTech);
        const deletedIdTech = _.difference(oldIdTech, newIdTech);
        // 1. 새로운 사항 저장
        const newItemTech = this.resume.technologyStack.filter(
          (obj) => createIdTech.includes(obj.id),
        );
        // 2. 수정 사항
        const changeItemTechTemp = _.differenceWith(
          this.resume.technologyStack, this.old_resume.technologyStack, _.isEqual,
        ); // 새로운 아이템과 변경 아이템이 포함된 리스트 반환
        const changeItemTech = changeItemTechTemp.filter(
          (obj) => changeIdTech.includes(obj.id),
        );
        // 3. 삭제된 사항
        const deletedItemTech = this.old_resume.technologyStack.filter(
          (obj) => deletedIdTech.includes(obj.id),
        );
        // 4. 저장
        const saveTech = async () => {
          const newList = newItemTech.map(
            async (data) => this.$store.dispatch('techStackCreate', data),
          );
          const changeList = changeItemTech.map(async (data) => {
            const newData = {
              id: data.id,
              data,
            };
            return this.$store.dispatch('techStackUpdate', newData);
          });
          const deleteList = deletedItemTech.map(
            async (data) => this.$store.dispatch('techStackDelete', data.id),
          );
          const promiseList = [...newList, ...changeList, ...deleteList];
          const res = await Promise.all(promiseList);
          // console.log(res);
          this.$store.dispatch('resumeUpdate', { key: 'technologyStack', res });
        };
        saveTech();
      } else if (index === 4) {
        // 프로젝트
        // changeIdArray에 들어가있는 값은 put으로 들어있지 않은 값은 post로
        const oldIdPjt = this.old_resume.project.map((obj) => obj.id);
        const newIdPjt = this.resume.project.map((obj) => obj.id);
        // create: resume만, change: resume, old 둘다, deleted: old만
        const createIdPjt = _.difference(newIdPjt, oldIdPjt);
        const changeIdPjt = _.intersection(newIdPjt, oldIdPjt);
        const deletedIdPjt = _.difference(oldIdPjt, newIdPjt);
        // 1. 새로운 사항 저장
        const newItemPjt = this.resume.project.filter(
          (obj) => createIdPjt.includes(obj.id),
        );
        // 2. 수정 사항
        const changeItemPjtTemp = _.differenceWith(
          this.resume.project, this.old_resume.project, _.isEqual,
        ); // 새로운 아이템과 변경 아이템이 포함된 리스트 반환
        const changeItemPjt = changeItemPjtTemp.filter(
          (obj) => changeIdPjt.includes(obj.id),
        );
        // 3. 삭제된 사항
        const deletedItemPjt = this.old_resume.project.filter(
          (obj) => deletedIdPjt.includes(obj.id),
        );
        // 4. 저장
        const savePjt = async () => {
          const newList = newItemPjt.map(
            async (data) => this.$store.dispatch('projectCreate', data),
          );
          const changeList = changeItemPjt.map(async (data) => {
            const newData = {
              id: data.id,
              data,
            };
            return this.$store.dispatch('projectUpdate', newData);
          });
          const deleteList = deletedItemPjt.map(
            async (data) => this.$store.dispatch('projectDelete', data.id),
          );
          const promiseList = [...newList, ...changeList, ...deleteList];
          const res = await Promise.all(promiseList);
          // console.log(res);
          this.$store.dispatch('resumeUpdate', { key: 'project', res });
        };
        savePjt();
      }
      alert("저장되었습니다.");
    },
  },
  created() {
    this.$store.commit('RESUME_COPY_RESUME');
  },
  mounted() {
    if (!this.isLogin) {
      this.$router.push({ name: 'Login' });
    }
  },
};
</script>

<style>
@import '../assets/styles/Resume.css';
</style>
