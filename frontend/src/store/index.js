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
      activity: [],
      career: [],
      certificate: [],
      foreignLang: [],
      technologyStack: [],
      project: [],
    },
    portfolio: {},
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
    // ABOUT PORTFOLIO
    PORTFOLIO_COPY_RESUME(state) {
      const newObject = JSON.parse(JSON.stringify(state.resume));
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
      getProject(context.state.userId).then((response) => {
        context.commit('PROJECT_INFO', response.data.data);
      });
      getTech(context.state.userId).then((response) => {
        context.commit('TECHNOLOGY_INFO', response.data.data);
      });
    },
    logout(context) {
      context.commit('CHANGE_ISLOGIN', false);
      context.commit('SET_USER_ID', null);
      const resume = {
        user: {},
        education: {},
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
    techStackCreate(context, data) {
      postTech(data).then(() => {
        getTech(context.state.userId).then((response) => {
          context.commit('TECHNOLOGY_INFO', response.data.data);
        });
      });
    },
    techStackUpdate(context, data) {
      putTech(data.id, data).then(() => {
        getTech(context.state.userId).then((response) => {
          context.commit('TECHNOLOGY_INFO', response.data.data);
        });
      });
    },
    techStackDelete(context, data) {
      deleteTech(data).then(() => {
        getTech(context.state.userId).then((response) => {
          context.commit('TECHNOLOGY_INFO', response.data.data);
        });
      });
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
    // pjt
    projectCreate(context, data) {
      postProject(data).then(() => {
        getProject(context.state.userId).then((response) => {
          context.commit('PROJECT_INFO', response.data.data);
        });
      });
    },
    projectUpdate(context, data) {
      putProject(data.id, data).then(() => {
        getProject(context.state.userId).then((response) => {
          context.commit('PROJECT_INFO', response.data.data);
        });
      });
    },
    projectDelete(context, data) {
      deleteProject(data).then(() => {
        getProject(context.state.userId).then((response) => {
          context.commit('PROJECT_INFO', response.data.data);
        });
      });
    },
  },
  modules: {
  },
});
