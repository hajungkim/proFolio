<template>
  <div class="login">
    <div class="login-box">
      <div class="login-letter">
        <div class="font-40 font-w-800 font-padding">Login</div>
        <div>proFolio로</div>
        <div>쉽게 포트폴리오를 완성해보세요</div>
      </div>
      <div class="social-outer-box">
        <div>
          <div class="social-box">
            <div class="inline-block">
              <img src="../assets/images/google.png" alt="" class="social-logo">
            </div>
            <div class="inline-block padding-l">Login in with Google</div>
          </div>
          <div class="social-box naver">
            <div class="inline-block">
              <span class="social-logo-letter">N</span>
            </div>
            <div class="inline-block padding-l">Login in with Naver</div>
          </div>
          <div class="social-box github">
            <div class="inline-block">
              <img src="../assets/images/github.png" alt="" class="social-logo">
            </div>
            <div class="inline-block padding-l">Login in with Github</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Login',
};
</script>

<style>
@import '../assets/styles/Login.css';
</style>
