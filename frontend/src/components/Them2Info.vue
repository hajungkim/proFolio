<template>
  <div class="them2-box" style="margin-botton:5%;">
    <div class="them2-subtitle">About Me</div>
      <div class="them2-info-box">
          <div class="user-img">
              <img :src = "portfolio.user.profilePath" class="user-profile-img">
          </div>
          <div class="them2-detail">
            <div class="them2-username">{{portfolio.user.name}}</div>
            <div class="them2-info-detail">
                <div class="line2">
                    <div class="line-title2">Email</div>
                    <div class="line-content2">{{portfolio.user.email}}</div>
                </div>
                <div class="line2">
                    <div class="line-title2">Contact</div>
                    <div class="line-content2">{{portfolio.user.phone}}</div>
                </div>
                <div class="line2" v-if="portfolio.user.githubId">
                    <div class="line-title2">Github</div>
                    <div class="line-content2">{{portfolio.user.githubId}}</div>
                </div>
            </div>
          </div>
      </div>
        <div class="blue_box">Let me Introduce myself</div>
        <div class="introduce" v-html="descriptionForHtml">
      </div>
      <div class="them2-space"></div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them2Info',
  computed: {
    ...mapState([
      'portfolio',
    ]),
    descriptionForHtml() {
      return this.portfolio.user.description.replace(/(\n|\r\n)/g, '<br>');
    },
  },
};
</script>

<style>
@import '../assets/styles/Them2.css';
.hidden {
  visibility: hidden;
}
</style>
