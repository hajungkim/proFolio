import Vue from 'vue';
import Vuex from 'vuex';
import { getUserInfo } from './modules/UserAPI';
import { getEducation, putEducation, postEducation } from './modules/ResumeAPI';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    isLogin: true,
    userId: 1,
    resume: {
      user: {
        profilePath: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-DjoQ3H0LFCWXLurl6qeHzGnbox2_cJTAmg&usqp=CAU', name: '아무개', birthday: '2000.01.01', phone: '010-0000-0000', email: 'qwer@qwer.com',
      },
      education: {
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
          title: '포트폴리오 만들기!',
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
    GET_USER_INFO(state, userinfo) {
      state.resume.user = userinfo;
    },
    EDUCATION_INFO(state, education) {
      state.resume.education = education;
    },
  },
  actions: {
    getUser(context, userId) {
      getUserInfo(userId).then((res) => {
        context.commit('GET_USER_INFO', res.data.data);
      });
    },
    updateEducation(context, eduInfo) {
      putEducation(eduInfo.id, eduInfo.data).then(() => {
        getEducation(context.state.userId).then((res) => {
          console.log(res.data.data);
          context.commit('EDUCATION_INFO', res.data.data);
        });
      });
    },
    createEducation(context, data) {
      postEducation(data).then(() => {
        getEducation(context.state.userId).then((res) => {
          context.commit('EDUCATION_INFO', res.data.data);
        });
      });
    },
  },
  modules: {
  },
});
