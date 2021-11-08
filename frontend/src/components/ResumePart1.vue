<template>
  <div>
    <div class="resume-part-title">part1</div>
    <div class="resume-part-sub">인적사항을 입력해주세요.</div>
    <div class="resume-part-box">
      <form enctype="multipart/form-data">
        <label for="imageInput" class="image-label">
          <img v-if="user.profilePath" :src="user.profilePath" alt="" class="image-file-size">
          <img v-else src="../assets/images/gallery.png" alt="" class="gallery-icon">
        </label>
        <input type="file" id="imageInput" @change="loadFile">
      </form>
      <table class="resume-part-table">
        <tr>
          <th><label for="name">이름</label></th>
          <td><input type="text" :placeholder="resume.user.name" @input="userName"></td>
        </tr>
        <tr>
          <th><label for="name">생년월일</label></th>
          <td><input type="text" :placeholder="resume.user.birthday" @input="userBirth"></td>
        </tr>
        <tr>
          <th><label for="name">연락처</label></th>
          <td><input type="text" :placeholder="resume.user.phone" @input="userPhone"></td>
        </tr>
        <tr>
          <th><label for="name">이메일</label></th>
          <td><input type="text" :placeholder="resume.user.email" @input="userEmail"></td>
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
      user: null,
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
      this.user.profilePath = URL.createObjectURL(fileInput.files[0]);
      URL.revokeObjectURL(fileInput.files[0]);
      this.$emit('part1Data', this.user);
    },
    userName(event) {
      this.user.name = event.target.value;
      this.$emit('part1Data', this.user);
    },
    userBirth(event) {
      this.user.birthday = event.target.value;
      this.$emit('part1Data', this.user);
    },
    userPhone(event) {
      this.user.phone = event.target.value;
      this.$emit('part1Data', this.user);
    },
    userEmail(event) {
      this.user.email = event.target.value;
      this.$emit('part1Data', this.user);
    },
  },
  beforeMount() {
    this.user = JSON.parse(JSON.stringify(this.resume.user));
  },
};
</script>

<style>
@import '../assets/styles/ResumePart.css';
</style>
