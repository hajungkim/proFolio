import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    isLogin: false,
    hamburger: false,
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
