<template>
  <div class="them3-info">
      <div class="info-box">
        <div class="them3-box">
            <img :src="portfolio.user.profilePath" class="them3-profile-img"/>
        </div>
        <div class="them3-info-detail">
          <!-- <div class="user-name">{{portfolio.user.name}}</div> -->
          <div class="info-detail">
            <div class="user-name">{{portfolio.user.name}}</div>
              <div class="line">
                <div class="line-title">연락처</div>
                <div>{{portfolio.user.phone}}</div>
              </div>
              <div class="line">
                <div class="line-title">이메일</div>
                <div>{{portfolio.user.email}}</div>
              </div>
              <div class="line" v-if="portfolio.user.githubId">
                <div class="line-title">깃허브</div>
                <div>{{portfolio.user.githubId}}</div>
              </div>
          </div>
          <div>
            <!-- <div class="them3-intro-title">인사말</div> -->
            <!-- <div class="them3-intro">{{portfolio.user.description}}</div> -->
          </div>
        </div>
      </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them3Info',
  data() {
    return {
    };
  },
  computed: {
    ...mapState([
      'portfolio',
    ]),
  },
};
</script>

<style>
@import '../assets/styles/Them3.css';
</style>
