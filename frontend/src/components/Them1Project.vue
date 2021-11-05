<template>
  <div class="skill"  v-if="edit || portfolio.project.length">
    <div class="name">Projects</div>
    <AddItemButton type="project" v-if="edit"/>
    <draggable class="draggable-container-col">
      <div v-for="(pro) in portfolio.project" :key="pro.id" class="project-card">
        <RemoveItemButton
          v-if="edit"
          type="project"
          :item="pro"
        />
        <div>
          <div class="name">{{pro.title}}</div>
          <div class="summary">{{pro.summary}}</div>
          <div style="color: #656060">{{pro.description}}</div>
        </div>
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
        <div style="float: right; font-weight:bold">{{pro.link}}</div>
      </div>
    </draggable>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import draggable from 'vuedraggable';
import RemoveItemButton from './RemoveItemButton.vue';
import AddItemButton from './AddItemButton.vue';

export default {
  name: 'Them1Project',
  props: {
    edit: Boolean,
  },
  components: {
    draggable,
    RemoveItemButton,
    AddItemButton,
  },
  data() {
    return {
    };
  },
  computed: {
    ...mapState([
      'portfolio',
    ]),
  },
};
</script>

<style>
@import '../assets/styles/Them1.css';
</style>
