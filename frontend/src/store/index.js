import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    isLogin: true,
    resume: {
      user: {
        profile_path: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-DjoQ3H0LFCWXLurl6qeHzGnbox2_cJTAmg&usqp=CAU', name: '아무개', birth: '2000.01.01', phone: '010-0000-0000', email: 'qwer@qwer.com',
      },
      education: {
        university: '싸피대학교',
        graduation: '졸업',
        admission_date: '2020.03',
        graduation_date: '2023.02',
        score: '4.0',
        total_score: '4.5',
        major: '컴공',
        minor: '',
      },
      activity: [
        {
          id: '1',
          name: '삼성청년SW아카데미',
          organization: '삼성전자',
          description: 'Java, DB, 알고리즘에 대해 배우고 해당 내용을 바탕으로 다수의 프로젝트를 진행함',
          start_date: '2021.01',
          end_date: '2021.12',
        },
        {
          id: '2',
          name: '삼성청년SW아카데미',
          organization: '삼성전자',
          description: 'Python, Javascript, 알고리즘에 대해 배우고 해당 내용을 바탕으로 다수의 프로젝트를 진행함',
          start_date: '2021.01',
          end_date: '2021.12',
        },
      ],
      career: [
        {
          id: '1',
          company: '삼성청년SW아카데미',
          duty: '교육생111',
          description: 'Java, DB, 알고리즘에 대해 배우고 해당 내용을 바탕으로 다수의 프로젝트를 진행함',
          start_date: '2021.01',
          end_date: '2021.12',
        },
        {
          id: '2',
          company: '삼성청년SW아카데미',
          duty: '교육생222',
          description: 'Python, Javascript, 알고리즘에 대해 배우고 해당 내용을 바탕으로 다수의 프로젝트를 진행함',
          start_date: '2021.01',
          end_date: '2021.12',
        },
      ],
      certificate: [
        {
          id: '1',
          name: '정보처리기사',
          organization: '한국산업인력공단',
          certified_date: '2021.10.23',
        },
        {
          id: '2',
          name: 'SQLD',
          organization: '한국산업인력공단',
          certified_date: '2021.02.23',
        },
      ],
      foreign_lang: [
        {
          id: '1',
          language: '영어',
          name: '토익',
          score: '900',
          certified_date: '2021.10.23',
        },
      ],
      awards: [
        {
          id: '1',
          name: 'SSAFY 공모전',
          prize: '우수상',
          description: '와아아아 활동을 해서 어디어디서 우수상을 수상 와아아아 활동을 해서 어디어디서 우수상을 수상 와아아아 활동을 해서 어디어디서 우수상을 수상',
          awards_date: '2021.10.23',
        },
        {
          id: '2',
          name: 'SSAFY 알고리즘',
          prize: '우수상',
          description: '와아아아 활동을 해서 어디어디서 우수상을 수상',
          awards_date: '2021.10.23',
        },
      ],
      technology_stack: [
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
      ],
      project: [
        {
          id: '1',
          title: '포트폴리오 만들기!',
          summary: '개발자 준비생을 위한 포트폴리오 사이트',
          description: '쉬운 포트폴리오 만들기 와아아아아아아',
          member_cnt: 5,
          technology_stack: 'Java, Django, Vue, SpringBoot',
          role: 'FE',
          link: 'https://ssafy.com',
          start_date: '2021.10',
          end_date: '2021.11',
        },
      ],
    },
  },
  mutations: {
    CHANGE_HAMBURGER(state, hamburger) {
      state.hamburger = !hamburger;
    },
  },
  actions: {
    changeHamburger(context, hamburger) {
      context.commit('CHANGE_HAMBURGER', hamburger);
    },
  },
  modules: {
  },
});
