<template>
  <div class="projects">
    <div>Projects</div>
    <AddButton type="project"/>
    <draggable>
      <div v-for="(pro) in resume.project" :key="pro.id" class="project-card">
        <RemoveButton
          :type="'portfolioProjectDelete'"
          :project="pro"
        />
        <div>
          <div class="name">{{pro.title}}</div>
          <div class="summary">{{pro.summary}}</div>
          <div style="color: #656060">{{pro.description}}</div>
        </div>
        <draggable>
          <div>
            <div class="subtitle">사용한 기술스택</div>
            <div>{{pro.technologyStack}}</div>
          </div>
          <div>
            <div class="subtitle">개발기간</div>
            <div>{{pro.startDate}} ~ {{pro.endDate}}</div>
          </div>
          <div>
            <div class="subtitle">역할</div>
            <div>{{pro.role}}</div>
          </div>
          <div>
            <div class="subtitle">참여인원</div>
            <div>{{pro.memberCnt}}</div>
          </div>
        </draggable>
        <div style="float: right; font-weight:bold">{{pro.link}}</div>
      </div>
    </draggable>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import draggable from 'vuedraggable';
import RemoveButton from './RemoveButton.vue';
import AddButton from './AddButton.vue';

export default {
  name: 'Them1Project',
  components: {
    draggable,
    RemoveButton,
    AddButton,
  },
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
