<template>
  <div class="them1_info">
      <div class="left">
          <div class="title">
              <div class="them1-box">
                <img :src="imgSrc" class="profile-img" crossorigin="anonymous">
                <!-- <img :src = "portfolio.user.profilePath" class="profile-img"> -->
              </div>
              <div class="detail">
                <div class="username">{{portfolio.user.name}}</div>
                <div class="tel">Tel. {{portfolio.user.phone}}</div>
                <div class="email">Email. {{portfolio.user.email}}</div>
                <div class="tel" v-if="portfolio.user.githubId">
                  Github. {{portfolio.user.githubId}}
                </div>
              </div>
          </div>
      </div>
      <div class="right">
        <div class="intro">
            <div class="name">INTRODUCE</div>
            <div class="slogan">
                <h3 v-html="descriptionForHtml">
                </h3>
            </div>
        </div>
      </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them1Info',
  props: {
    edit: Boolean,
  },
  data() {
    return {
    };
  },
  computed: {
    ...mapState([
      'portfolio',
    ]),
    descriptionForHtml() {
      return this.portfolio.user.description.replace(/(\n|\r\n)/g, '<br>');
    },
    imgSrc() {
      const ret = `${this.portfolio.user.profilePath}?timestamp=${Date.now()}`;
      return ret;
    },
  },
};
</script>

<style>
@import '../assets/styles/Them1.css';
</style>
