<template>
  <div class="resume-part2-box">
    <table class="resume-part2-input">
      <tr>
        <th>기술스택 종류</th>
        <td class="pl-15">
          <div
          :class="[techCreate.technologyStack.kind === 1 ? techStackBoxSelected : '', techStackBox]"
          data-stack="1" @click="changeKind">
            Language
          </div>
          <div
          :class="[techCreate.technologyStack.kind === 2 ? techStackBoxSelected : '', techStackBox]"
          data-stack="2" @click="changeKind">
            Management
          </div>
          <div
          :class="[techCreate.technologyStack.kind === 3 ? techStackBoxSelected : '', techStackBox]"
          data-stack="3" @click="changeKind">
            Framework
          </div>
        </td>
      </tr>
      <tr>
        <th>기술스택명</th>
        <td><input type="text" @change="techName"></td>
      </tr>
      <tr>
        <th>레벨</th>
        <td class="pl-15">
          <input type="range" min="1" max="5"
          v-model="techCreate.technologyStack.level" class="range" @change="dataUpdate"/>
          <span class="range-value">{{ techCreate.technologyStack.level }}</span>
        </td>
      </tr>
      <tr>
        <th>설명</th>
        <td colspan="4">
          <textarea class="resume-p2-career" @change="techDescription"></textarea>
        </td>
      </tr>
    </table>
    <div class="delete-btn-2" @click="deleteTech">X</div>
  </div>
</template>

<script>
export default {
  name: 'CreateTechStack',
  props: {
    technologyStack: {
      type: Object,
    },
  },
  data() {
    return {
      techStackBox: 'tech-stack-box',
      techStackBoxSelected: 'tech-stack-selected',
      techCreate: {},
    };
  },
  methods: {
    changeKind(event) {
      const Now = event.target.getAttribute('data-stack') - 1;
      this.techCreate.technologyStack.kind = Now + 1;
      const stackList = document.querySelectorAll('.tech-stack-box');
      for (let i = this.index * 3; i < this.index * 3 + 3; i += 1) {
        if (Now === (i % 3)) {
          stackList[i].className = 'tech-stack-box tech-stack-selected';
        } else stackList[i].className = 'tech-stack-box';
      }
      this.dataUpdate();
    },
    dataUpdate() {
      this.$emit('createTech', this.techCreate);
    },
    techName(event) {
      this.techCreate.technologyStack.name = event.target.value;
      this.dataUpdate();
    },
    techDescription(event) {
      this.techCreate.technologyStack.description = event.target.value;
      this.dataUpdate();
    },
    deleteTech() {
      this.techCreate.isDeleted = true;
      this.dataUpdate();
    },
  },
  beforeMount() {
    this.techCreate.technologyStack = this.technologyStack;
    this.techCreate.isDeleted = false;
  },
};
</script>

<style>

</style>
