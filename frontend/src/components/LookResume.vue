<template>
  <div class="read-resume">
    <div class="read-resume-profile">
      <div class="read-resume-box">
        <img :src="resume.user.profilePath" class="read-resume-image">
        <div class="font-30 ml-5" style="font-weight:bold">About</div>
        <div class="mt-10 ml-5">
          <table class="read-resume-profile-table">
            <tr>
              <th>name</th>
              <td>{{ resume.user.name }}</td>
            </tr>
            <tr>
              <th>github</th>
              <td>{{ resume.user.githubId }}</td>
            </tr>
            <tr>
              <th>contact</th>
              <td>{{ resume.user.phone }}</td>
            </tr>
            <tr>
              <th>e-mail</th>
              <td>{{ resume.user.email }}</td>
            </tr>
              <tr>
              <th>description</th>
              <td>{{ resume.user.description }}</td>
            </tr>
          </table>
        </div>
      </div>
      <div class="buttons">
        <div class="resum-btn">
          <a href="#"><button class="round-shadow rbtn1" @click="goToResume">이력서 수정</button></a>
        </div>
        <div class="resum-btn">
          <a href="#"><button class="round-shadow rbtn2" @click="goToSelect">포트폴리오 생성</button></a>
        </div>
      </div>
    </div>
    <div class="read-resume-edu mt-50">
      <div class="font-30 font-weight-b mb-20">Education</div>
      <div class="ml-15">
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
          <td>{{ lang.score }}점</td>
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
            <span>{{ award.description }}</span>
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
  },
  methods: {
    goToResume() {
      this.$router.push({ name: 'ResumeTemp' });
    },
    goToSelect() {
      this.$router.push({ name: 'SelectTheme' });
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
