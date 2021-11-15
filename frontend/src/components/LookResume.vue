<template>
  <div class="read-resume">
    <div class="read-resume-profile">
      <div class="read-resume-box">
        <img :src="resume.user.profilePath" class="read-resume-image">
        <div class="font-30" style="font-weight:bold; margin-left:3vw;">About</div>
        <div class="mt-10" style="margin-left:3vw;">
          <table class="read-resume-profile-table">
            <tr>
              <th>name</th>
              <th>{{ resume.user.name }}</th>
            </tr>
            <tr>
              <th>github</th>
              <th>{{ resume.user.githubId }}</th>
            </tr>
            <tr>
              <th>contact</th>
              <th>{{ resume.user.phone }}</th>
            </tr>
            <tr>
              <th>e-mail</th>
              <th>{{ resume.user.email }}</th>
            </tr>
              <tr>
              <th>description</th>
              <!-- <td>{{ resume.user.description }}</td> -->
              <td v-html="descriptionForHtml"></td>
            </tr>
          </table>
        </div>
      </div>
      <div class="buttons">
        <div class="resum-btn">
          <!-- <a href="#">
            <button class="round-shadow rbtn1" @click="goToResume">이력서 수정</button>
          </a> -->
          <button class="round-shadow rbtn1" @click="goToResume">이력서 수정</button>
        </div>
        <div class="resum-btn">
          <!-- <a href="#">
            <button class="round-shadow rbtn2" @click="goToSelect">포트폴리오 생성</button>
          </a> -->
          <button class="round-shadow rbtn2" @click="goToSelect">포트폴리오 생성</button>
        </div>
      </div>
    </div>
    <div class="read-resume-edu mt-50">
      <div class="font-30 font-weight-b mb-20">Education</div>
      <div class="ml-15" v-if=" !isEmpty(resume.education) ">
        <div>{{ resume.education.university }}</div>
        <table class="read-resume-table">
          <tr>
            <th>{{ resume.education.admissionDate }} ~ {{ resume.education.graduationDate }}</th>
            <td>{{ graduation }}</td>
          </tr>
          <tr>
            <th>전공</th>
            <td>{{ resume.education.major }}</td>
          </tr>
          <tr>
            <th>부전공</th>
            <td>{{ resume.education.minor }}</td>
          </tr>
        </table>
      </div>
    </div>
    <div class="hr-border-mt-50"></div>
    <div class="read-resume-exp mt-50">
      <div class="font-30 font-weight-b mb-20">Experience</div>
      <LookExperience v-for="(act) in resume.activity" :key="'act'+act.id" :act="act" />
    </div>
    <div class="hr-border-mt-50"></div>
    <div class="read-resume-exp mt-50">
      <div class="font-30 font-weight-b mb-20">Work Experience</div>
      <LookCareer v-for="(career) in resume.career" :key="'career'+career.id" :career="career" />
    </div>
    <div class="hr-border-mt-50"></div>
    <div class="mt-50">
      <div class="font-30 font-weight-b mb-20">Certificate / Language</div>
      <table class="read-resume-table">
        <tr v-for="(cert) in resume.certificate" :key="'cert'+cert.id">
          <th>{{ cert.certifiedDate }}</th>
          <td class="font-weight-b">{{ cert.name }}</td>
        </tr>
        <tr v-for="(lang) in resume.foreignLang" :key="'lang'+lang.id">
          <th>{{ lang.certifiedDate }}</th>
          <td class="font-weight-b">{{ lang.name }}</td>
          <td>{{ lang.score }}<span v-if=" !isNaN(lang.score) ">점</span></td>
        </tr>
      </table>
    </div>
    <div class="hr-border-mt-50"></div>
    <div class="mt-50">
      <div class="font-30 font-weight-b mb-20">Awards</div>
      <table class="read-resume-table">
        <tr v-for="(award) in resume.awards" :key="'award'+award.id">
          <th style="line-height: 250%;">{{ award.awardsDate }}</th>
          <td>
            <span class="font-weight-b" style="line-height: 250%;">{{ award.name }}</span>
             <span class="ml-9">{{ award.prize }}</span>
            <br>
            <!-- <span>{{ award.description }}</span> -->
            <span v-html="adjustHtml(award.description)"></span>
          </td>
        </tr>
      </table>
    </div>
    <div class="hr-border-mt-50"></div>
    <div class="mt-50">
      <div class="font-30 font-weight-b mb-20">Technology Stack</div>
      <table class="read-resume-table">
        <tr>
          <th>Language</th>
          <td v-for="(tech) in techLanguage" :key="'techL'+tech.id">
            <span>{{ tech.name }} </span>
            <div class="lang-level">{{ tech.level }}</div>
          </td>
        </tr>
        <tr>
          <th>Management</th>
          <td v-for="(tech) in techManagement" :key="'techM'+tech.id">
            <span>{{ tech.name }} </span>
            <div class="lang-level">{{ tech.level }}</div>
          </td>
        </tr>
        <tr>
          <th>FrameWork</th>
          <td v-for="(tech) in techFrameWork" :key="'techF'+tech.id">
            <span>{{ tech.name }} </span>
            <div class="lang-level">{{ tech.level }}</div>
          </td>
        </tr>
      </table>
    </div>
    <div class="hr-border-mt-50"></div>
    <div class="mt-50">
      <div class="font-30 font-weight-b mb-20">Project</div>
      <LookProject v-for="(project) in resume.project" :key="'pjt'+project.id" :project="project"/>
    </div>
    <div class="hr-border-mt-50"></div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import LookExperience from './LookExperience.vue';
import LookCareer from './LookCareer.vue';
import LookProject from './LookProject.vue';

export default {
  name: 'LookResume',
  components: {
    LookExperience,
    LookCareer,
    LookProject,
  },
  data() {
    return {
      graduation: '',
      techLanguage: [],
      techManagement: [],
      techFrameWork: [],
    };
  },
  computed: {
    ...mapState([
      'resume',
    ]),
    descriptionForHtml() {
      return this.resume.user.description.replace(/(\n|\r\n)/g, '<br>');
    },
  },
  methods: {
    goToResume() {
      this.$router.push({ name: 'Resume' });
    },
    goToSelect() {
      this.$router.push({ name: 'SelectTheme' });
    },
    adjustHtml(strVal) {
      // console.log(strVal, typeof (strVal));
      return strVal.replace(/(\n|\r\n)/g, '<br>');
    },
    isEmpty(obj) {
      if (obj.constructor === Object
        && Object.keys(obj).length === 0) {
        return true;
      }
      return false;
    },
  },
  beforeMount() {
    if (this.resume.education.graduation === true) this.graduation = '졸업';
    else if (this.resume.education.graduation === false) this.graduation = '졸업예정';
    Object.values(this.resume.technologyStack).forEach((tech) => {
      if (tech.kind === 1) {
        this.techLanguage.push(tech);
      } else if (tech.kind === 2) {
        this.techManagement.push(tech);
      } else if (tech.kind === 3) {
        this.techFrameWork.push(tech);
      }
    });
  },
};
</script>

<style>
@import '../assets/styles/LookResume.css'
</style>
