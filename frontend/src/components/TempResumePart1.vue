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
          <td><input type="text"
            :value="resume.user.name" @change="changeInput" name="name"
          ></td>
        </tr>
        <tr>
          <th><label for="phone">연락처</label></th>
          <td>
            <input
              type="text"
              :value="resume.user.phone"
              @change="changeInput"
              name="phone"
            />
          </td>
        </tr>
        <tr>
          <th><label for="email">이메일</label></th>
          <td>
            <input
              type="text"
              :value="resume.user.email"
              @change="changeInput"
              name="email"
            />
          </td>
        </tr>
        <tr>
          <th><label for="githubId">Github</label></th>
          <td>
            <input
              type="text"
              :value="resume.user.githubId"
              @change="changeInput"
              name="githubId"
            />
          </td>
        </tr>
        <tr>
          <th><label for="description">자기소개</label></th>
          <td>
            <textarea
              :value="resume.user.description"
              @change="changeInput"
              name="description"
            />
          </td>
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
      const [temp] = fileInput.files;
      this.resume.user.file = temp;
      console.log(this.resume.user.file);
      URL.revokeObjectURL(fileInput.files[0]);
    },
    changeInput(event) {
      const { name, value } = event.target;
      this.resume.user[name] = value;
      this.$store.commit('CHANGE_USER_INFO', { name, value });
    },
  },
  beforeDestroy() {
    this.$emit('save', 0);
  },
};
</script>

<style>
@import '../assets/styles/ResumePart.css';
</style>
