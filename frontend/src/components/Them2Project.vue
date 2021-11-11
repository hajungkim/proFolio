<template>
  <div class="them2-box" id="remove"  v-if="edit || portfolio.project">
    <div class="them2-subtitle">Project</div>
    <AddItemButton type="project" v-if="edit"/>
    <!-- test -->
    <draggable
      ghost-class="ghost"
    >
      <div v-for="(pro) in portfolio.project" :key="pro.id" class="them2-card">
        <span class="them2-cardname">{{pro.title}}</span>
        <span class="them2-grayfont">({{pro.startDate}} ~ {{pro.endDate}})</span>
        <RemoveItemButton
          v-if="edit"
          type="project"
          :item="pro"
          :edit="edit"
        />
        <div class="them2-summary">
          <span>{{pro.summary}}</span>
          <span style="float: right; font-weight:bold">{{pro.link}}</span>
        </div>
        <div class="them2-grayfont">{{pro.description}}</div>
        <div class="grid2 margin">
          <div>
            <span style="color: #0014BC; margin-right: 5%">팀원</span>
            <span>{{pro.memberCnt}}명</span>
          </div>
          <div>
            <span style="color: #0014BC; margin-right: 5%">역할</span>
            <span>{{pro.role}}</span>
          </div>
            <div style="margin-top: 5%">
            <span style="color: #0014BC; margin-right: 5%">기술스택</span>
            <span>{{pro.technologyStack}}</span>
          </div>
        </div>
      </div>
    </draggable>
  </div>
</template>

<script>
import draggable from "vuedraggable";
import { mapState } from 'vuex';
import RemoveItemButton from './RemoveItemButton.vue';
import AddItemButton from './AddItemButton.vue';

export default {
  name: 'Them2Project',
  props: {
    edit: {
      type: Boolean,
    },
  },
  components: {
    draggable,
    RemoveItemButton,
    AddItemButton,
  },
  data() {
    return {
      skills: [],
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
@import '../assets/styles/Them2.css';

</style>
