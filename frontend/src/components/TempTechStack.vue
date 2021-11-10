<template>
  <div>
    <strong  class="plus-btn-box">
      <div>기술스택</div>
      <div class="plus-btn" @click="addTech">+</div>
    </strong>
    <div
      class="resume-part2-box"
      v-for="(tech) in resume.technologyStack" :key="tech.id"
    >
      <table class="resume-part2-input">
        <tr>
          <th>기술스택 종류</th>
          <td class="pl-15">
            <div
              :class="[
                tech.kind === 1 ? techStackBoxSelected : '',
                techStackBox,
              ]"
              data-stack="1"
              name="kind"
              @click="changeKind($event, tech)"
            >
              Language
            </div>
            <div
              :class="[
                tech.kind === 2 ? techStackBoxSelected : '',
                techStackBox,
              ]"
              data-stack="2"
              @click="changeKind($event, tech)"
            >
              Management
            </div>
            <div
              :class="[
                tech.kind === 3 ? techStackBoxSelected : '',
                techStackBox,
              ]"
              data-stack="3"
              @click="changeKind($event, tech)"
            >
              Framework
            </div>
          </td>
        </tr>
        <tr>
          <th>기술스택명</th>
          <td>
            <input
              type="text"
              :value="tech.name"
              name="name"
              @change="changeInput($event, tech)"
            />
          </td>
        </tr>
        <tr>
          <th>레벨</th>
          <td class="pl-15">
            <input
              type="range" min="1" max="5"
              class="range"
              v-model="tech.level"
              name="level"
              @change="changeInput($event, tech)"
            />
            <span class="range-value">{{ tech.level }}</span>
          </td>
        </tr>
      </table>
      <div class="delete-btn-2" @click="deleteTech(tech)">X</div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import _ from 'lodash';

export default {
  name: 'TechStack',
  data() {
    return {
      techStackBox: 'tech-stack-box',
      techStackBoxSelected: 'tech-stack-selected',
      techCreate: {},
    };
  },
  computed: {
    ...mapState([
      'resume',
    ]),
  },
  methods: {
    addTech() {
      const newItem = {
        id: `${Date.now()}`,
        name: '',
        level: '',
        kind: null,
      };
      this.$store.commit('CHANGE_TECHNOLOGY_LIST', [...this.resume.technologyStack, newItem]);
    },
    deleteTech(item) {
      const newList = _.differenceWith(this.resume.technologyStack, [item], _.isEqual);
      this.$store.commit('CHANGE_TECHNOLOGY_LIST', newList);
    },
    changeInput(event, tech) {
      const { name, value } = event.target;
      this.$store.commit('CHANGE_TECHNOLOGY_INFO', { name, value, tech });
    },
    changeKind(event, tech) {
      const name = 'kind';
      const value = Number(event.target.getAttribute('data-stack'));
      this.$store.commit('CHANGE_TECHNOLOGY_INFO', { name, value, tech });
    },
    isSelected(kind, des) {
      return kind === des;
    },
  },
};
</script>

<style>

</style>
