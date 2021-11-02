<template>
  <div class="them3-info">
      <div class="info-box">
        <div class="them3-box">
            <img :src="resume.user.profilePath" class="profile-img"/>
        </div>
        <div class="them3-info-detail">
          <div class="user-name">{{resume.user.name}}</div>
          <div class="info-detail">
              <div class="line">
                <div class="line-title">생년월일</div>
                <div>{{resume.user.birthday}}</div>
              </div>
              <div class="line">
                <div class="line-title">연락처</div>
                <div>{{resume.user.phone}}</div>
              </div>
              <div class="line">
                <div class="line-title">이메일</div>
                <div>{{resume.user.email}}</div>
              </div>
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
      'resume',
    ]),
  },
};
</script>

<style>
@import '../assets/styles/Them3.css';
</style>
