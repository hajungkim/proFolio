import Vue from 'vue';
import Vuex from 'vuex';
import createPersistedState from 'vuex-persistedstate';
import { getUserInfo } from './modules/UserAPI';
import {
  putEducation, getEducation, postEducation, postCareer, getCareer, deleteCareer, putCareer,
  postActivity, getActivity, putActivity, deleteActivity, postLanguage, getLanguage,
  putLanguage, deleteLanguage, getCertificate, postCertificate, deleteCertificate,
  putCertificate, getAwards, postAwards, deleteAwards, putAwards,
} from './modules/ResumeAPI';

Vue.use(Vuex);

export default new Vuex.Store({
  plugins: [
    createPersistedState(),
  ],
  state: {
    isLogin: false,
    userId: 1,
    resume: {
      user: {
        profilePath: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-DjoQ3H0LFCWXLurl6qeHzGnbox2_cJTAmg&usqp=CAU', name: '아무개', birthday: '2000.01.01', phone: '010-0000-0000', email: 'qwer@qwer.com',
      },
      education: {
        id: 1,
        university: '싸피대학교',
        graduation: true,
        admissionDate: '2020.03',
        graduationDate: '2023.02',
        score: '4.0',
        totalScore: 4.5,
        major: '컴공',
        minor: '',
        mainSchool: false,
      },
      activity: [
        {
          id: '1',
          name: '삼성청년SW아카데미',
          organization: '삼성전자',
          description: 'Java, DB, 알고리즘에 대해 배우고 해당 내용을 바탕으로 다수의 프로젝트를 진행함',
          startDate: '2021.01',
          endDate: '2021.12',
        },
        {
          id: '2',
          name: '삼성청년SW아카데미',
          organization: '삼성전자',
          description: 'Python, Javascript, 알고리즘에 대해 배우고 해당 내용을 바탕으로 다수의 프로젝트를 진행함',
          startDate: '2021.01',
          endDate: '2021.12',
        },
      ],
      career: [
        {
          id: '1',
          company: '삼성청년SW아카데미',
          duty: '교육생111',
          description: 'Java, DB, 알고리즘에 대해 배우고 해당 내용을 바탕으로 다수의 프로젝트를 진행함',
          startDate: '2021.01',
          endDate: '2021.12',
        },
        {
          id: '2',
          company: '삼성청년SW아카데미',
          duty: '교육생222',
          description: 'Python, Javascript, 알고리즘에 대해 배우고 해당 내용을 바탕으로 다수의 프로젝트를 진행함',
          startDate: '2021.01',
          endDate: '2021.12',
        },
      ],
      certificate: [
        {
          id: '1',
          name: '정보처리기사',
          organization: '한국산업인력공단',
          certifiedDate: '2021.10.23',
        },
        {
          id: '2',
          name: 'SQLD',
          organization: '한국산업인력공단',
          certifiedDate: '2021.02.23',
        },
      ],
      foreignLang: [
        {
          id: '1',
          language: '영어',
          name: '토익',
          score: '900',
          certifiedDate: '2021.10.23',
        },
      ],
      awards: [
        {
          id: '1',
          name: 'SSAFY 공모전',
          prize: '우수상',
          description: '와아아아 활동을 해서 어디어디서 우수상을 수상 와아아아 활동을 해서 어디어디서 우수상을 수상 와아아아 활동을 해서 어디어디서 우수상을 수상',
          awardsDate: '2021.10.23',
        },
        {
          id: '2',
          name: 'SSAFY 알고리즘',
          prize: '우수상',
          description: '와아아아 활동을 해서 어디어디서 우수상을 수상',
          awardsDate: '2021.10.23',
        },
      ],
      technologyStack: [
        {
          id: '1',
          name: 'Java',
          level: '3',
          description: '????',
          kind: 1,
        },
        {
          id: '2',
          name: 'Spring boot',
          level: '3',
          description: '????',
          kind: 2,
        },
        {
          id: '3',
          name: 'Vue',
          level: '4',
          description: '????',
          kind: 2,
        },
        {
          id: '4',
          name: 'Git',
          level: '3',
          description: '????',
          kind: 3,
        },
        {
          id: '5',
          name: 'Python',
          level: '1',
          description: '????',
          kind: 1,
        },
      ],
      project: [
        {
          id: '1',
          title: 'proFoilo',
          summary: '개발자 준비생을 위한 포트폴리오 사이트',
          description: '포트폴리오를 처음 만드는 개발자를 위한 서비스로 작성 가이드를 제공하고, 작성한 내용으로 템플릿을 적용한 포트폴리오를 PDF로 생성해줍니다.',
          memberCnt: 5,
          technologyStack: 'Java, Django, Vue, SpringBoot',
          role: 'FE',
          link: 'https://ssafy.com',
          startDate: '2021.10',
          endDate: '2021.11',
        },
        {
          id: '2',
          title: 'proFoilo',
          summary: '개발자 준비생을 위한 포트폴리오 사이트',
          description: '쉬운 포트폴리오 만들기 와아아아아아아',
          memberCnt: 5,
          technologyStack: 'Java, Django, Vue, SpringBoot',
          role: 'FE',
          link: 'https://ssafy.com',
          startDate: '2021.10',
          endDate: '2021.11',
        },
      ],
    },
  },
  mutations: {
    CHANGE_ISLOGIN(state, isLogin) {
      state.isLogin = isLogin;
    },
    SET_USER_ID(state, userId) {
      state.userId = userId;
    },
    GET_USER_INFO(state, userinfo) {
      state.resume.user = userinfo;
    },
    EDUCATION_INFO(state, education) {
      state.resume.education = education;
    },
    CAREER_INFO(state, career) {
      state.resume.career = career;
    },
    ACTIVITY_INFO(state, activity) {
      state.resume.activity = activity;
    },
    LANGUAGE_INFO(state, language) {
      state.resume.foreignLang = language;
    },
    CERTIFICATION_INFO(state, certInfo) {
      state.resume.certificate = certInfo;
    },
    AWARDS_INFO(state, awardsInfo) {
      state.resume.awards = awardsInfo;
    },
  },
  actions: {
    socialLogin(context, userId) {
      context.commit('SET_USER_ID', userId);
      context.commit('CHANGE_ISLOGIN', true);
      context.dispatch('getUser', userId);
      getEducation(context.state.userId).then((response) => {
        if (response.data.data === null) {
          response.data.data = {};
        }
        context.commit('EDUCATION_INFO', response.data.data);
      });
      getCareer(context.state.userId).then((response) => {
        context.commit('CAREER_INFO', response.data.data);
      });
      getActivity(context.state.userId).then((response) => {
        context.commit('ACTIVITY_INFO', response.data.data);
      });
      getLanguage(context.state.userId).then((response) => {
        context.commit('LANGUAGE_INFO', response.data.data);
      });
      getCertificate(context.state.userId).then((response) => {
        context.commit('CERTIFICATION_INFO', response.data.data);
      });
      getAwards(context.state.userId).then((response) => {
        context.commit('AWARDS_INFO', response.data.data);
      });
    },
    getUser(context, userId) {
      getUserInfo(userId).then((res) => {
        context.commit('GET_USER_INFO', res.data.data);
      });
    },
    updateEducation(context, data) {
      putEducation(data.id, data.data).then(() => {
        getEducation(context.state.userId).then((response) => {
          context.commit('EDUCATION_INFO', response.data.data);
        });
      });
    },
    educationCreate(context, data) {
      postEducation(data).then(() => {
        getEducation(context.state.userId).then((response) => {
          context.commit('EDUCATION_INFO', response.data.data);
        });
      });
    },
    careerCreate(context, data) {
      postCareer(data).then(() => {
        getCareer(context.state.userId).then((response) => {
          context.commit('CAREER_INFO', response.data.data);
        });
      });
    },
    careerDelete(context, data) {
      deleteCareer(data).then(() => {
        getCareer(context.state.userId).then((response) => {
          context.commit('CAREER_INFO', response.data.data);
        });
      });
    },
    careerUpdate(context, data) {
      putCareer(data.id, data).then(() => {
        getCareer(context.state.userId).then((response) => {
          context.commit('CAREER_INFO', response.data.data);
        });
      });
    },
    activityCreate(context, data) {
      postActivity(data).then(() => {
        getActivity(context.state.userId).then((response) => {
          context.commit('ACTIVITY_INFO', response.data.data);
        });
      });
    },
    activityUpdate(context, data) {
      putActivity(data.id, data).then(() => {
        getActivity(context.state.userId).then((response) => {
          context.commit('ACTIVITY_INFO', response.data.data);
        });
      });
    },
    activityDelete(context, data) {
      deleteActivity(data).then(() => {
        getActivity(context.state.userId).then((response) => {
          context.commit('ACTIVITY_INFO', response.data.data);
        });
      });
    },
    languageCreate(context, data) {
      postLanguage(data).then(() => {
        getLanguage(context.state.userId).then((response) => {
          context.commit('LANGUAGE_INFO', response.data.data);
        });
      });
    },
    languageUpdate(context, data) {
      putLanguage(data.id, data).then(() => {
        getLanguage(context.state.userId).then((response) => {
          context.commit('LANGUAGE_INFO', response.data.data);
        });
      });
    },
    languageDelete(context, data) {
      deleteLanguage(data).then(() => {
        getLanguage(context.state.userId).then((response) => {
          context.commit('LANGUAGE_INFO', response.data.data);
        });
      });
    },
    certificateCreate(context, data) {
      postCertificate(data).then(() => {
        getCertificate(context.state.userId).then((response) => {
          context.commit('CERTIFICATION_INFO', response.data.data);
        });
      });
    },
    certificateUpdate(context, data) {
      putCertificate(data.id, data).then(() => {
        getCertificate(context.state.userId).then((response) => {
          context.commit('CERTIFICATION_INFO', response.data.data);
        });
      });
    },
    certificateDelete(context, data) {
      deleteCertificate(data).then(() => {
        getCertificate(context.state.userId).then((response) => {
          context.commit('CERTIFICATION_INFO', response.data.data);
        });
      });
    },
    awardsCreate(context, data) {
      postAwards(data).then(() => {
        getAwards(context.state.userId).then((response) => {
          context.commit('AWARDS_INFO', response.data.data);
        });
      });
    },
    awardsUpdate(context, data) {
      putAwards(data.id, data).then(() => {
        getAwards(context.state.userId).then((response) => {
          context.commit('AWARDS_INFO', response.data.data);
        });
      });
    },
    awardsDelete(context, data) {
      deleteAwards(data).then(() => {
        getAwards(context.state.userId).then((response) => {
          context.commit('AWARDS_INFO', response.data.data);
        });
      });
    },
  },
  modules: {
  },
});
