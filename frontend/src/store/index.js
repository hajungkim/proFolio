import _ from 'lodash';
import Vue from 'vue';
import Vuex from 'vuex';
import createPersistedState from 'vuex-persistedstate';
import { getUserInfo } from './modules/UserAPI';
import {
  putEducation, getEducation, postEducation, postCareer, getCareer, deleteCareer, putCareer,
  postActivity, getActivity, putActivity, deleteActivity, postLanguage, getLanguage,
  putLanguage, deleteLanguage, getCertificate, postCertificate, deleteCertificate,
  putCertificate, getAwards, postAwards, deleteAwards, putAwards, postTech, getTech,
  putTech, deleteTech, getProject, postProject, putProject, deleteProject,
} from './modules/ResumeAPI';

Vue.use(Vuex);
export default new Vuex.Store({
  plugins: [
    createPersistedState(),
  ],
  state: {
    isLogin: false,
    userId: null,
    resume: {
      user: {},
      education: {},
      awards: [],
      activity: [],
      career: [],
      certificate: [],
      foreignLang: [],
      technologyStack: [],
      project: [],
    },
    old_resume: {},
    portfolio: {},
    sample: {
      user: {
        profilePath: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-DjoQ3H0LFCWXLurl6qeHzGnbox2_cJTAmg&usqp=CAU', name: '김싸피', githubId: 'qwer@github.com', phone: '010-1234-5678', email: 'qwer@qwer.com',
      },
      education: {
        university: '싸피대학교',
        graduation: '졸업',
        admissionDate: '2020.03',
        graduationDate: '2023.02',
        major: '컴공',
        minor: '',
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
          company: '삼성전자',
          description: '대규모 프로젝트를 진행하며 실무역량을 키움',
          startDate: '2020.12',
          endDate: '2020.09',
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
          organization: '한국데이터산업진흥원',
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
          description: '어떤어떤 프로젝트를 진행하며 싸피 공모전에서 우수상을 수상함',
          awardsDate: '2021.10.23',
        },
        {
          id: '2',
          name: 'SSAFY 알고리즘',
          prize: '최우수상',
          description: '무슨무슨 알고리즘 대회에 출전하여 최우수상을 수상함',
          awardsDate: '2020.09.23',
        },
      ],
      technologyStack: [
        {
          id: '1',
          name: 'Java',
          level: '3',
          kind: 1,
        },
        {
          id: '2',
          name: 'Spring boot',
          level: '3',
          kind: 2,
        },
        {
          id: '3',
          name: 'Vue',
          level: '4',
          kind: 2,
        },
        {
          id: '4',
          name: 'Git',
          level: '3',
          kind: 3,
        },
        {
          id: '5',
          name: 'Python',
          level: '1',
          kind: 1,
        },
      ],
      project: [
        {
          id: '1',
          title: '포트폴리오 만들기!',
          summary: '개발자 준비생을 위한 포트폴리오 사이트',
          description: '유저가 입력한 정보를 바탕으로 포트폴리오를 생성해주고 PDF로 변환해주는 서비스',
          memberCnt: 5,
          technologyStack: 'Java, Django, Vue, SpringBoot',
          role: 'FE',
          link: 'https://ssafy.com',
          startDate: '2021.10',
          endDate: '2021.11',
        },
      ],
    },
    initialResume: {
      user: {},
      education: {},
      awards: [],
      activity: [],
      career: [],
      certificate: [],
      foreignLang: [],
      technologyStack: [],
      project: [],
    },
  },
  mutations: {
    CHANGE_ISLOGIN(state, isLogin) {
      state.isLogin = isLogin;
    },
    RESET_RESUME_INFO(state, resume) {
      state.resume = resume;
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
    TECHNOLOGY_INFO(state, techInfo) {
      state.resume.technologyStack = techInfo;
    },
    PROJECT_INFO(state, pjtInfo) {
      state.resume.project = pjtInfo;
    },
    // new resume function
    CHANGE_USER_INFO(state, payload) {
      const { name, value } = payload;
      state.resume.user[name] = value;
    },
    CHANGE_EDUCATION_INFO(state, payload) {
      const { name, value } = payload;
      state.resume.education[name] = value;
    },
    CHANGE_CAREER_LIST(state, careerList) {
      state.resume.career = careerList;
    },
    CHANGE_CAREER_INFO(state, payload) {
      const { name, value, career } = payload;
      const index = state.resume.career.findIndex((obj) => obj.id === career.id);
      state.resume.career[index][name] = value;
    },
    CHANGE_ACTIVITY_LIST(state, activityList) {
      state.resume.activity = activityList;
    },
    CHANGE_ACTIVITY_INFO(state, payload) {
      const { name, value, activity } = payload;
      const index = state.resume.activity.findIndex((obj) => obj.id === activity.id);
      state.resume.activity[index][name] = value;
    },
    CHANGE_LANGUAGE_LIST(state, languageList) {
      state.resume.foreignLang = languageList;
    },
    CHANGE_LANGUAGE_INFO(state, payload) {
      const { name, value, language } = payload;
      const index = state.resume.foreignLang.findIndex((obj) => obj.id === language.id);
      state.resume.foreignLang[index][name] = value;
    },
    CHANGE_CERTIFICATE_LIST(state, certList) {
      state.resume.certificate = certList;
    },
    CHANGE_CERTIFICATE_INFO(state, payload) {
      const { name, value, certificate } = payload;
      const index = state.resume.certificate.findIndex((obj) => obj.id === certificate.id);
      state.resume.certificate[index][name] = value;
    },
    CHANGE_AWARDS_LIST(state, awardsList) {
      state.resume.awards = awardsList;
    },
    CHANGE_AWARDS_INFO(state, payload) {
      const { name, value, award } = payload;
      const index = state.resume.awards.findIndex((obj) => obj.id === award.id);
      state.resume.awards[index][name] = value;
    },
    CHANGE_TECHNOLOGY_LIST(state, techList) {
      state.resume.technologyStack = techList;
    },
    CHANGE_TECHNOLOGY_INFO(state, payload) {
      const { name, value, tech } = payload;
      const index = state.resume.technologyStack.findIndex((obj) => obj.id === tech.id);
      state.resume.technologyStack[index][name] = value;
    },
    CHANGE_PROJECT_LIST(state, pjtList) {
      state.resume.project = pjtList;
    },
    CHANGE_PROJECT_INFO(state, payload) {
      const { name, value, project } = payload;
      const index = state.resume.project.findIndex((obj) => obj.id === project.id);
      state.resume.project[index][name] = value;
    },
    RESUME_COPY_RESUME(state) {
      // Create newObject, using initial resume
      // const newObject = Object.assign(state.initialResume);
      const newObject = JSON.parse(JSON.stringify(state.initialResume));
      // copy resume values to newObject
      Object.entries(state.resume).forEach((item) => {
        const [key, value] = JSON.parse(JSON.stringify(item));
        if (value) {
          newObject[key] = value;
        } else if (!value && key === 'education') {
          newObject[key] = {};
        } else if (!value) {
          newObject[key] = [];
        }
      });
      // replace portfolio with newObject
      state.old_resume = newObject;
      // state.portfolio = newObject;
    },
    RESUME_UPDATE(state, payload) {
      const { key, data } = payload;
      state.old_resume[key] = data;
    },
    // ABOUT PORTFOLIO
    PORTFOLIO_COPY_RESUME(state) {
      // Create newObject, using initial resume
      const newObject = JSON.parse(JSON.stringify(state.initialResume));
      // copy resume values to newObject
      Object.entries(state.resume).forEach((item) => {
        const [key, value] = JSON.parse(JSON.stringify(item));
        newObject[key] = value;
      });
      // replace portfolio with newObject
      state.portfolio = newObject;
    },
    PORTFOLIO_USER_INFO(state, userinfo) {
      state.portfolio.user = userinfo;
    },
    PORTFOLIO_EDUCATION_INFO(state, education) {
      state.portfolio.education = education;
    },
    PORTFOLIO_CAREER_INFO(state, career) {
      state.portfolio.career = career;
    },
    PORTFOLIO_ACTIVITY_INFO(state, activity) {
      state.portfolio.activity = activity;
    },
    PORTFOLIO_LANGUAGE_INFO(state, language) {
      state.portfolio.foreignLang = language;
    },
    PORTFOLIO_PROJECT_INFO(state, project) {
      state.portfolio.project = project;
    },
    PORTFOLIO_AWARDS_INFO(state, awards) {
      state.portfolio.awards = awards;
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
        if (response.data.data === null) {
          response.data.data = [];
        }
        context.commit('CAREER_INFO', response.data.data);
      });
      getActivity(context.state.userId).then((response) => {
        if (response.data.data === null) {
          response.data.data = [];
        }
        context.commit('ACTIVITY_INFO', response.data.data);
      });
      getLanguage(context.state.userId).then((response) => {
        if (response.data.data === null) {
          response.data.data = [];
        }
        context.commit('LANGUAGE_INFO', response.data.data);
      });
      getCertificate(context.state.userId).then((response) => {
        if (response.data.data === null) {
          response.data.data = [];
        }
        context.commit('CERTIFICATION_INFO', response.data.data);
      });
      getAwards(context.state.userId).then((response) => {
        if (response.data.data === null) {
          response.data.data = [];
        }
        context.commit('AWARDS_INFO', response.data.data);
      });
      getProject(context.state.userId).then((response) => {
        if (response.data.data === null) {
          response.data.data = [];
        }
        context.commit('PROJECT_INFO', response.data.data);
      });
      getTech(context.state.userId).then((response) => {
        if (response.data.data === null) {
          response.data.data = [];
        }
        context.commit('TECHNOLOGY_INFO', response.data.data);
      });
    },
    logout(context) {
      context.commit('CHANGE_ISLOGIN', false);
      context.commit('SET_USER_ID', null);
      const resume = {
        user: {},
        education: {},
        awards: [],
        activity: [],
        career: [],
        certificate: [],
        foreignLang: [],
        technologyStack: [],
        project: [],
      };
      context.commit('RESET_RESUME_INFO', resume);
    },
    getUser(context, userId) {
      getUserInfo(userId).then((res) => {
        context.commit('GET_USER_INFO', res.data.data);
      });
    },
    async educationCreate(context, data) {
      const res1 = await postEducation(data.data);
      if (res1.status !== 200) {
        throw new Error(`status: ${res1.status}`);
      }
      const educationValue = await getEducation(data.id);
      context.commit('RESUME_UPDATE', { key: 'education', data: educationValue.data });
    },
    async educationUpdate(context, data) {
      const res1 = await putEducation(data.id, data.data);
      if (res1.status !== 200) {
        throw new Error(`status: ${res1.status}`);
      }
      const educationValue = await getEducation(data.id);
      context.commit('RESUME_UPDATE', { key: 'education', data: educationValue.data });
    },
    careerCreate(context, data) {
      return postCareer(data);
    },
    careerUpdate(context, data) {
      console.log("careerUpdate", data);
      return putCareer(data.id, data);
    },
    careerDelete(context, id) {
      return deleteCareer(id);
    },
    activityCreate(context, data) {
      postActivity(data);
    },
    activityUpdate(context, data) {
      putActivity(data.id, data);
    },
    activityDelete(context, id) {
      deleteActivity(id);
    },
    languageCreate(context, data) {
      postLanguage(data);
    },
    languageUpdate(context, data) {
      putLanguage(data.id, data);
    },
    languageDelete(context, id) {
      deleteLanguage(id);
    },
    certificateCreate(context, data) {
      postCertificate(data);
    },
    certificateUpdate(context, data) {
      putCertificate(data.id, data);
    },
    certificateDelete(context, id) {
      deleteCertificate(id);
    },
    awardsCreate(context, data) {
      postAwards(data);
    },
    awardsUpdate(context, data) {
      putAwards(data.id, data);
    },
    awardsDelete(context, id) {
      deleteAwards(id);
    },
    techStackCreate(context, data) {
      postTech(data);
    },
    techStackUpdate(context, data) {
      putTech(data.id, data);
    },
    techStackDelete(context, id) {
      deleteTech(id);
    },
    projectCreate(context, data) {
      postProject(data);
    },
    projectUpdate(context, data) {
      putProject(data.id, data);
    },
    projectDelete(context, id) {
      deleteProject(id);
    },
    async resumeUpdate(context, key) {
      switch (key) {
        case 'career': {
          const response = await getCareer(context.state.userId);
          console.log(response);
          if (response.data.data === null) {
            response.data.data = [];
          }
          context.commit('CAREER_INFO', response.data.data);
          context.commit('RESUME_UPDATE', { key, data: response.data.data });
          break;
        }
        case 'activity': {
          const response = await getActivity(context.state.userId);
          if (response.data.data === null) {
            response.data.data = [];
          }
          context.commit('ACTIVITY_INFO', response.data.data);
          context.commit('RESUME_UPDATE', { key, data: response.data.data });
          break;
        }
        case 'foreignLang': {
          const response = await getLanguage(context.state.userId);
          if (response.data.data === null) {
            response.data.data = [];
          }
          context.commit('LANGUAGE_INFO', response.data.data);
          context.commit('RESUME_UPDATE', { key, data: response.data.data });
          break;
        }
        case 'certificate': {
          const response = await getCertificate(context.state.userId);
          if (response.data.data === null) {
            response.data.data = [];
          }
          context.commit('CERTIFICATION_INFO', response.data.data);
          context.commit('RESUME_UPDATE', { key, data: response.data.data });
          break;
        }
        case 'awards': {
          const response = await getAwards(context.state.userId);
          if (response.data.data === null) {
            response.data.data = [];
          }
          context.commit('AWARDS_INFO', response.data.data);
          context.commit('RESUME_UPDATE', { key, data: response.data.data });
          break;
        }
        case 'technologyStack': {
          const response = await getProject(context.state.userId);
          if (response.data.data === null) {
            response.data.data = [];
          }
          context.commit('TECHNOLOGY_INFO', response.data.data);
          context.commit('RESUME_UPDATE', { key, data: response.data.data });
          break;
        }
        case 'project': {
          const response = await getTech(context.state.userId);
          if (response.data.data === null) {
            response.data.data = [];
          }
          context.commit('PROJECT_INFO', response.data.data);
          context.commit('RESUME_UPDATE', { key, data: response.data.data });
          break;
        }
        default:
      }
    },
    // ABOUT PORTFOLIO //////////////////////////
    portfolioCopyResume(context) {
      context.commit('PORTFOLIO_COPY_RESUME');
    },
    portfolioProjectDelete(context, data) {
      // data === project
      const newArray = _.differenceWith(this.state.portfolio.project, [data], _.isEqual);
      context.commit('PORTFOLIO_PROJECT_INFO', newArray);
    },
    portfolioProjectAdd(context, data) {
      // data === project
      const newArray = _.unionWith(this.state.portfolio.project, [data], _.isEqual);
      context.commit('PORTFOLIO_PROJECT_INFO', newArray);
    },
    portfolioAwardsDelete(context, data) {
      // data === award
      const newArray = _.differenceWith(this.state.portfolio.awards, [data], _.isEqual);
      context.commit('PORTFOLIO_AWARDS_INFO', newArray);
    },
    portfolioAwardsAdd(context, data) {
      // data === award
      const newArray = _.unionWith(this.state.portfolio.awards, [data], _.isEqual);
      context.commit('PORTFOLIO_AWARDS_INFO', newArray);
    },
    portfolioActivityDelete(context, data) {
      // data === award
      const newArray = _.differenceWith(this.state.portfolio.activity, [data], _.isEqual);
      context.commit('PORTFOLIO_ACTIVITY_INFO', newArray);
    },
    portfolioActivityAdd(context, data) {
      // data === award
      const newArray = _.unionWith(this.state.portfolio.activity, [data], _.isEqual);
      context.commit('PORTFOLIO_ACTIVITY_INFO', newArray);
    },
  },
  modules: {
  },
});
