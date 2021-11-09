<template>
  <div class="resume-part2-box">
    <table class="resume-part2-input">
      <tr>
        <th>기술스택 종류</th>
        <td class="pl-15">
          <div
          :class="[techUpdate.technologyStack.kind === 1 ? techStackBoxSelected : '', techStackBox]"
          data-stack="1" @click="changeKind">
            Language
          </div>
          <div
          :class="[techUpdate.technologyStack.kind === 2 ? techStackBoxSelected : '', techStackBox]"
          data-stack="2" @click="changeKind">
            Management
          </div>
          <div
          :class="[techUpdate.technologyStack.kind === 3 ? techStackBoxSelected : '', techStackBox]"
          data-stack="3" @click="changeKind">
            Framework
          </div>
        </td>
      </tr>
      <tr>
        <th>기술스택명</th>
        <td><input type="text" @change="techName" :placeholder="technologyStack.name"></td>
      </tr>
      <tr>
        <th>레벨</th>
        <td class="pl-15">
          <input type="range" min="1" max="5"
          v-model="techUpdate.technologyStack.level" class="range" @change="dataUpdate"/>
          <span class="range-value">{{ techUpdate.technologyStack.level }}</span>
        </td>
      </tr>
      <tr>
        <th>설명</th>
        <td colspan="4">
          <textarea class="resume-p2-career" @change="techDescription"
          :placeholder="technologyStack.description"
          ></textarea>
        </td>
      </tr>
    </table>
    <div class="delete-btn-2" @click="deleteTech">X</div>
  </div>
</template>

<script>
export default {
  name: 'UpdateTechStack',
  props: {
    technologyStack: {
      type: Object,
    },
  },
  data() {
    return {
      techStackBox: 'tech-stack-box',
      techStackBoxSelected: 'tech-stack-selected',
      techUpdate: {},
    };
  },
  methods: {
    changeKind(event) {
      const Now = event.target.getAttribute('data-stack') - 1;
      this.techUpdate.technologyStack.kind = Now + 1;
      const stackList = document.querySelectorAll('.tech-stack-box');
      for (let i = this.index * 3; i < this.index * 3 + 3; i += 1) {
        if (Now === (i % 3)) {
          stackList[i].className = 'tech-stack-box tech-stack-selected';
        } else stackList[i].className = 'tech-stack-box';
      }
      this.dataUpdate();
    },
    dataUpdate() {
      this.techUpdate.isUpdated = true;
      this.$emit('updateTech', this.techUpdate);
    },
    techName(event) {
      this.techUpdate.technologyStack.name = event.target.value;
      this.dataUpdate();
    },
    techDescription(event) {
      this.techUpdate.technologyStack.description = event.target.value;
      this.dataUpdate();
    },
    deleteTech() {
      this.techUpdate.isDeleted = true;
      this.dataUpdate();
    },
  },
  beforeMount() {
    this.techUpdate.technologyStack = this.technologyStack;
    this.techUpdate.isUpdated = false;
    this.techUpdate.isDeleted = false;
  },
};
</script>

<style>

</style>
