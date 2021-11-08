<template>
  <div class="login">
    <div class="login-box">
      <div class="login-letter">
        <img src="../assets/images/logo1.png" alt="" class="login-logo">
        <div class="font-40 font-w-800 font-padding">로그인</div>
        <div>proFolio로</div>
        <div>쉽게 포트폴리오를 완성해보세요</div>
      </div>
      <div class="vertical-line"></div>
      <div class="social-outer-box">
        <div>
          <div class="social-box" @click="googleLogin">
            <div class="inline-block">
              <img src="../assets/images/google.png" alt="" class="social-logo">
            </div>
            <div class="inline-block padding-l">구글 계정으로 로그인</div>
          </div>
          <div class="social-box naver" @click="naverLogin">
            <div class="inline-block">
              <span class="social-logo-letter">N</span>
            </div>
            <div class="inline-block padding-l">네이버 계정으로 로그인</div>
          </div>
          <div class="social-box github" @click="githubLogin">
            <div class="inline-block">
              <img src="../assets/images/github.png" alt="" class="social-logo">
            </div>
            <div class="inline-block padding-l">깃허브 계정으로 로그인</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { login } from '../store/modules/UserAPI';

export default {
  name: 'Login',
  methods: {
    googleLogin() {
      login('GOOGLE');
    },
    naverLogin() {
      login('NAVER');
    },
    githubLogin() {
      login('GITHUB');
    },
  },
};
</script>

<style>
@import '../assets/styles/Login.css';
</style>
