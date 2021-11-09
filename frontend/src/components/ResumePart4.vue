<template>
  <div>
    <div class="resume-part-title">part4</div>
    <div class="resume-part-sub">기술스택을 입력해주세요.</div>
    <!-- 설명 -->
    <div class="skill-desc">
        <div class="flex">
              <div class="red level-color">5</div>
              <div class="skill-desc-detail">대규모 프로그램 및 시스템을 참고사항(책/인터넷)없이 개발할 수 있음</div>
        </div>
        <div class="flex">
              <div class="levelgreen level-color">3 - 4</div>
              <div class="skill-desc-detail">중간 규모 프로그램 및 시스템을 개발할 수 있으며, 능숙하게 다룰 수 있음</div>
        </div>
        <div class="flex">
              <div class="yellow level-color">1 - 2</div>
              <div class="skill-desc-detail">능숙하지는 않지만 책/인터넷을 참고하며 개발할 수 있음</div>
        </div>
    </div>
    <div>
      <strong  class="plus-btn-box">
        <div>기술스택</div>
        <div class="plus-btn" @click="addCreateStack">+</div>
      </strong>
      <CreateTechStack v-for="(technologyStack, index) in techStackCreate"
      :key="index" :technologyStack="technologyStack"
      @createTech="createTech"/>
      <UpdateTechStack v-for="(technologyStack, index) in techStackUpdate"
      :key="index" :technologyStack="technologyStack"
      @updateTech="updateTech"/>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import CreateTechStack from './CreateTechStack.vue';
import UpdateTechStack from './UpdateTechStack.vue';

export default {
  name: 'ResumePart4',
  components: {
    CreateTechStack,
    UpdateTechStack,
  },
  data() {
    return {
      techStackCreate: [],
      techStackUpdate: [],
    };
  },
  computed: {
    ...mapState([
      'resume',
    ]),
  },
  methods: {
    addCreateStack() {
      const newStack = {
        id: `create${Math.random()}`, name: '', level: '', description: '', kind: '1',
      };
      this.techStackCreate.push(newStack);
    },
    createTech(createTech) {
      if (createTech.isDeleted) {
        let sliceIndex = null;
        const idx = createTech.technologyStack.id;
        Object.entries(this.techStackCreate).forEach((tech) => {
          if (Object.keys(tech[1]).find((key) => tech[1][key] === idx)) {
            [sliceIndex] = tech;
          }
        });
        this.techStackCreate.splice(sliceIndex, 1);
      } else {
        this.$emit('createTechData', createTech.technologyStack);
      }
    },
    updateTech(updateTech) {
      if (updateTech.isDeleted) {
        let sliceIndex = null;
        const idx = updateTech.technologyStack.id;
        Object.entries(this.techStackUpdate).forEach((tech) => {
          if (Object.keys(tech[1]).find((key) => tech[1][key] === idx)) {
            [sliceIndex] = tech;
          }
        });
        this.techStackUpdate.splice(sliceIndex, 1);
        this.$emit('deleteTech', updateTech.technologyStack.id);
      } else if (updateTech.isUpdated) {
        this.$emit('updateTechData', updateTech.technologyStack);
      }
    },
  },
  beforeMount() {
    this.techStackUpdate = JSON.parse(JSON.stringify(this.resume.technologyStack));
  },
};
</script>

<style>
@import '../assets/styles/ResumePart.css';
</style>
