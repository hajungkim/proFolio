<template>
  <div class="them2-box">
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
                <!-- <div class="line2">
                    <div class="line-title2">Link</div>
                    <div class="line-content2">{{portfolio.user.link}}</div>
                </div> -->
            </div>
          </div>
      </div>
      <div class="blue_box">Let me Introduce myself</div>
      <div class="introduce">
        {{portfolio.user.description}}
      </div>
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
  },
};
</script>

<style>
@import '../assets/styles/Them2.css';
.hidden {
  visibility: hidden;
}
</style>
