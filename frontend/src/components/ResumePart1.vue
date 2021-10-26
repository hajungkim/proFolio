<template>
  <div>
    <div class="resume-part-title">part1</div>
    <div class="resume-part-sub">인적사항을 입력해주세요.</div>
    <div class="resume-part-box">
      <form enctype="multipart/form-data">
        <label for="imageInput" class="image-label">
          <img v-if="uploadFile" :src="uploadFile" alt="" class="image-file-size">
          <img v-else src="../assets/images/gallery.png" alt="" class="gallery-icon">
        </label>
        <input type="file" id="imageInput" @change="loadFile">
      </form>
      <table class="resume-part-table">
        <tr>
          <th><label for="name">이름</label></th>
          <td><input type="text" :placeholder="resume.user.name" v-model="name"></td>
        </tr>
        <tr>
          <th><label for="name">생년월일</label></th>
          <td><input type="text" :placeholder="resume.user.birth" v-model="birth"></td>
        </tr>
        <tr>
          <th><label for="name">연락처</label></th>
          <td><input type="text" :placeholder="resume.user.phone" v-model="phone"></td>
        </tr>
        <tr>
          <th><label for="name">이메일</label></th>
          <td><input type="text" :placeholder="resume.user.email" v-model="email"></td>
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
      uploadFile: '',
      name: '',
      birth: '',
      phone: '',
      email: '',
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
      this.uploadFile = URL.createObjectURL(fileInput.files[0]);
      URL.revokeObjectURL(fileInput.files[0]);
    },
  },
};
</script>

<style>
@import '../assets/styles/ResumePart.css';
</style>
