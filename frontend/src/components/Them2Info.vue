<template>
  <div class="them2-box" id='remove'>
    <!-- test -->
      <button
        id="remove-btn"
        :class="[edit ? '' : 'hidden']"
        @click="removeComponent()"
      >
      X
      </button>
    <div class="them2-subtitle">About Me</div>
      <div class="them2-info-box">
          <div class="user-img">
              <img :src = "resume.user.profilePath" class="user-profile-img">
          </div>
          <div class="them2-detail">
            <div class="them2-username">{{resume.user.name}}</div>
            <div class="them2-info-detail">
                <div class="line2">
                    <div class="line-title2">Email</div>
                    <div>{{resume.user.email}}</div>
                </div>
                <div class="line2">
                    <div class="line-title2">Contact</div>
                    <div>{{resume.user.phone}}</div>
                </div>
                <div class="line2">
                    <div class="line-title2">Link</div>
                    <div>{{resume.user.link}}</div>
                </div>
            </div>
          </div>
      </div>
      <div class="blue_box">Let me Introduce myself</div>
      <div class="introduce">
          <div>안녕하세요~</div>
          <div>백엔드 개발자를 꿈꾸는 {{resume.user.name}}입니다.</div>
          <div>{{resume.technologyStack[0].name}}, {{resume.technologyStack[1].name}}
              와 같은 분야에 관심이 있습니다.
          </div>
          <div>항상 성장하기 위해 새로운 것들을 많이 접하고 배우고 있습니다.</div>
      </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them2Info',
  props: {
    edit: {
      type: Boolean,
    },
  },
  data() {
    return {
      // edit: '',
    //   editBtn: '편집',
    };
  },
  methods: {
    clickEdit() {
      if (this.edit) {
        this.editBtn = '완료';
        this.edit = false;
      } else {
        this.editBtn = '편집';
        this.edit = true;
      }
    },
    removeComponent() {
      const content = document.getElementById('remove');
      content.remove();
    },
  },
  computed: {
    ...mapState([
      'resume',
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
