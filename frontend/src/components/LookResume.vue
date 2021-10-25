<template>
  <div class="read-resume">
    <div class="read-resume-profile">
      <div class="read-resume-box">
        <img :src="resume.user.profile_path" class="read-resume-image">
        <div class="font-30">About</div>
        <div class="mt-15 ml-15">
          <table>
            <tr>
              <th>name</th>
              <td>{{ resume.user.name }}</td>
            </tr>
            <tr>
              <th>date of birth</th>
              <td>{{ resume.user.birth }}</td>
            </tr>
            <tr>
              <th>contact</th>
              <td>{{ resume.user.phone }}</td>
            </tr>
            <tr>
              <th>e-mail</th>
              <td>{{ resume.user.email }}</td>
            </tr>
          </table>
        </div>
      </div>
      <div class="resume-edit-btn">
        <div>수정</div>
      </div>
    </div>
    <div class="read-resume-edu mt-50">
      <div class="font-30 font-weight-b mb-20">Education</div>
      <div class="ml-15">
        <div>{{ resume.education.university }}</div>
        <table class="read-resume-table">
          <tr>
            <th>{{ resume.education.admission_day }} ~ {{ resume.education.graduation_day }}</th>
            <td>{{ resume.education.graduation }}</td>
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
      <LookExperience v-for="(act) in resume.activity" :key="act.id" :act="act" />
    </div>
    <div class="hr-border-mt-50"></div>
    <div class="read-resume-exp mt-50">
      <div class="font-30 font-weight-b mb-20">Work Experience</div>
      <LookCareer v-for="(career) in resume.career" :key="career.id" :career="career" />
    </div>
    <div class="hr-border-mt-50"></div>
    <div class="mt-50">
      <div class="font-30 font-weight-b mb-20">Certificate / Language</div>
      <table class="read-resume-table">
        <tr v-for="(cert) in resume.certificate" :key="cert.id">
          <th>{{ cert.certified_date }}</th>
          <td class="font-weight-b">{{ cert.name }}</td>
        </tr>
        <tr v-for="(lang) in resume.foreign_lang" :key="lang.id">
          <th>{{ lang.certified_date }}</th>
          <td class="font-weight-b">{{ lang.name }}</td>
          <td>{{ lang.score }}점</td>
        </tr>
      </table>
    </div>
    <div class="hr-border-mt-50"></div>
    <div class="mt-50">
      <div class="font-30 font-weight-b mb-20">Awards</div>
      <table class="read-resume-table">
        <tr v-for="(award) in resume.awards" :key="award.id">
          <th style="line-height: 250%;">{{ award.awards_date }}</th>
          <td>
            <span class="font-weight-b" style="line-height: 250%;">{{ award.name }}</span>
             {{ award.prize }}
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
          <td v-for="(lang) in resume.technology_stack" :key="lang.id">
            <span>{{ lang.name }} </span>
            <div class="lang-level">{{ lang.level }}</div>
          </td>
        </tr>
        <tr>
          <th>DataBase</th>
        </tr>
        <tr>
          <th>FrameWork</th>
        </tr>
      </table>
    </div>
    <div class="hr-border-mt-50"></div>
    <div class="mt-50">
      <div class="font-30 font-weight-b mb-20">Project</div>
      <LookProject v-for="(project) in resume.project" :key="project.id" :project="project"/>
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
  computed: {
    ...mapState([
      'resume',
    ]),
  },
};
</script>

<style>
@import '../assets/styles/LookResume.css'
</style>
