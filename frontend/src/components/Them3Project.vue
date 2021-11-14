<template>
  <div class="them3-exp" v-if="edit || portfolio.project.length">
    <div class="name">Project</div>
    <AddItemButton type="project" v-if="edit"/>
    <draggable class="draggable-container-row">
      <div v-for="(pro) in portfolio.project" :key="pro.id" class="them3-card">
        <div class="name">{{pro.title}}</div>
        <div style="float: right; font-weight:bold">
          <RemoveItemButton
            v-if="edit"
            type="project"
            :item="pro"
          />
          <p>{{pro.link}}</p>
        </div>
        <div class="summary">{{pro.summary}}</div>
        <div style="color: #656060">{{pro.description}}</div>
        <div class="grid2">
          <div>
            <div class="subtitle">역할</div>
            <div>{{pro.role}}</div>
          </div>
          <div>
            <div class="subtitle">기술스택</div>
            <div>{{pro.technologyStack}}</div>
          </div>
          <div>
            <div class="subtitle">개발기간</div>
            <div>{{pro.startDate}} ~ {{pro.endDate}}</div>
          </div>
          <div>
            <div class="subtitle">참여인원</div>
            <div>{{pro.memberCnt}}명</div>
          </div>
        </div>
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
  name: 'Them3Project',
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
@import '../assets/styles/Them3.css';
</style>
