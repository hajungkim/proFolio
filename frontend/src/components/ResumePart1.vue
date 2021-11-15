<template>
  <div>
    <div class="resume-part-title">part1</div>
    <div class="resume-part-sub">인적사항을 입력해주세요.</div>
    <div class="resume-part-box">
      <form enctype="multipart/form-data">
        <label for="imageInput" class="image-label">
          <img
            v-if="resume.user.profilePath"
            :src="resume.user.profilePath"
            alt=""
            class="image-file-size"
          >
          <img v-else src="../assets/images/gallery.png" alt="" class="gallery-icon">
        </label>
        <input type="file" id="imageInput" @change="loadFile">
      </form>
      <table class="resume-part-table">
        <tr>
          <th><label for="name">이름</label></th>
          <td><input type="text" :value="resume.user.name" @change="userName"></td>
        </tr>
        <tr>
          <th><label for="phone">연락처</label></th>
          <td><input type="text" :value="resume.user.phone" @change="userPhone"></td>
        </tr>
        <tr>
          <th><label for="email">이메일</label></th>
          <td><input type="text" :value="resume.user.email" @change="userEmail"></td>
        </tr>
        <tr>
          <th><label for="githubId">Github</label></th>
          <td><input type="text" :value="resume.user.githubId" @change="userGithubId"></td>
        </tr>
        <tr>
          <th><label for="description">자기소개</label></th>
          <td><textarea :value="resume.user.description" @change="userDescription" /></td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'ResumePart1',
  data() {
    return {
      // user: null,
    };
  },
  computed: {
    ...mapState([
      'resume',
    ]),
  },
  methods: {
    loadFile() {
      const fileInput = document.querySelector('#imageInput');
      this.resume.user.profilePath = URL.createObjectURL(fileInput.files[0]);
      URL.revokeObjectURL(fileInput.files[0]);
    },
    userName(event) {
      this.resume.user.name = event.target.value;
      this.$emit('part1Data');
    },
    userBirth(event) {
      this.resume.user.birthday = event.target.value;
      this.$emit('part1Data');
    },
    userPhone(event) {
      this.resume.user.phone = event.target.value;
      this.$emit('part1Data');
    },
    userEmail(event) {
      this.resume.user.email = event.target.value;
      this.$emit('part1Data');
    },
    userGithubId(event) {
      this.resume.user.githubId = event.target.value;
      this.$emit('part1Data');
    },
    userDescription(event) {
      this.resume.user.description = event.target.value;
      this.$emit('part1Data');
    },
  },
  beforeMount() {
    // this.user = JSON.parse(JSON.stringify(this.resume.user));
    // console.log(JSON.parse(JSON.stringify(this.resume.user)).profilePath);
    // console.log(this.resume.user.profilePath);
  },
  beforeDestroy() {
    this.$emit('save');
  },
};
</script>

<style>
@import '../assets/styles/ResumePart.css';
</style>
