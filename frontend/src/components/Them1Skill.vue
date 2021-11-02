<template>
  <div class="skill">
      <div class="name">SKILLS</div>
      <div class="skill-content">
          <div class="language">
              <div class="content-title">Language</div>
              <div v-for="(skill) in resume.technologyStack" :key="skill.id">
                <div style="display: flex" v-if="skill.kind == 1">
                  <div class="them1-skill-name">{{skill.name}}</div>
                  <div v-for="i in 5" :key=i class="them1-skill">
                    <div v-if="i > skill.level" class="skill-gray">&nbsp;</div>
                    <div v-if="i <= skill.level" class="skill-purple">&nbsp;</div>
                  </div>
                </div>
              </div>
          </div>
          <div class="management">
              <div class="content-title">Management</div>
              <div v-for="(skill) in resume.technologyStack" :key="skill.id">
                <div style="display: flex" v-if="skill.kind == 3">
                  <div class="them1-skill-name">{{skill.name}}</div>
                  <div v-for="i in 5" :key=i class="them1-skill">
                    <div v-if="i > skill.level" class="skill-gray">&nbsp;</div>
                    <div v-if="i <= skill.level" class="skill-purple">&nbsp;</div>
                  </div>
                </div>
              </div>
          </div>
          <div class="framework">
              <div class="content-title">Framework</div>
              <div v-for="(skill) in resume.technologyStack" :key="skill.id">
                <div style="display: flex" v-if="skill.kind == 2">
                  <div class="them1-skill-name">{{skill.name}}</div>
                  <div v-for="i in 5" :key=i class="them1-skill">
                    <div v-if="i > skill.level" class="skill-gray">&nbsp;</div>
                    <div v-if="i <= skill.level" class="skill-purple">&nbsp;</div>
                  </div>
                </div>
              </div>
          </div>
      </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'Them1Skill',
  data() {
    return {
    };
  },
  computed: {
    ...mapState([
      'resume',
    ]),
  },
};
</script>

<style>
@import '../assets/styles/Them1.css';
</style>
