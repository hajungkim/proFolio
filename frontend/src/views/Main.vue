<template>
  <div>
    <div class="sections-menu">
      <span
         class="menu-point"
         v-bind:class="{active: activeSection == index}"
         v-on:click="scrollToSection(index)"
         v-for="(offset, index) in offsets"
         v-bind:key="index">
      </span>
    </div>
    <section class="fullpage puppy">
      <MainSection1 />
    </section>
    <section class="fullpage beige">
      <MainSection2 />
    </section>
    <section class="fullpage blue">
      <MainSection3 />
    </section>
    <section class="fullpage pink">
      <MainSection4 />
    </section>
  </div>
</template>

<script>
// @ is an alias to /src
import MainSection1 from '../components/MainSection1.vue';
import MainSection2 from '../components/MainSection2.vue';
import MainSection3 from '../components/MainSection3.vue';
import MainSection4 from '../components/MainSection4.vue';

export default {
  name: 'Main',
  components: {
    MainSection1,
    MainSection2,
    MainSection3,
    MainSection4,
  },
  data() {
    return {
      inMove: false,
      activeSection: 0,
      offsets: [],
      touchStartY: 0,
      index: 0,
    };
  },
  methods: {
    calculateSectionOffsets() {
      const sections = document.getElementsByTagName('section');
      const length = [sections.length];
      // console.log(sections);
      // console.log(length);
      for (let i = 0; i < length; i += 1) {
        const sectionOffset = sections[i].offsetTop;
        this.offsets.push(sectionOffset);
        // console.log(this.offsets);
      }
    },
    handleMouseWheel(e) {
      if (e.wheelDelta < 30 && !this.inMove) {
        this.moveUp();
      } else if (e.wheelDelta > 30 && !this.inMove) {
        this.moveDown();
      }
      e.preventDefault();
      return false;
    },
    handleMouseWheelDOM(e) {
      if (e.detail > 0 && !this.inMove) {
        this.moveUp();
      } else if (e.detail < 0 && !this.inMove) {
        this.moveDown();
      }
      return false;
    },
    moveDown() {
      this.inMove = true;
      this.activeSection -= 1;
      if (this.activeSection < 0) this.activeSection = this.offsets.length - 1;
      this.scrollToSection(this.activeSection, true);
    },
    moveUp() {
      this.inMove = true;
      this.activeSection += 1;
      if (this.activeSection > this.offsets.length - 1) this.activeSection = 0;
      this.scrollToSection(this.activeSection, true);
    },
    scrollToSection(id, force = false) {
      if (this.inMove && !force) return false;
      this.activeSection = id;
      this.inMove = true;
      document.getElementsByTagName('section')[id].scrollIntoView({ behavior: 'smooth' });
      // console.log(document.getElementsByTagName('section')[id]);
      setTimeout(() => {
        this.inMove = false;
      }, 400);
      return true;
    },
  },
  mounted() {
    this.calculateSectionOffsets();
    window.addEventListener('DOMMouseScroll', this.handleMouseWheelDOM);
    window.addEventListener('mousewheel', this.handleMouseWheel, { passive: false });
    if (document.cookie.length) {
      const cookies = document.cookie.split((/=|;| /));
      let idx = null;
      // console.log(cookies);
      Object.entries(cookies).forEach((cook) => {
        if (cook[1] === 'userId') {
          idx = parseInt(cook[0], 10);
        }
      });
      const userId = cookies[idx + 1];
      this.$store.dispatch('socialLogin', userId);
    }
  },
  destroyed() {
    window.removeEventListener('mousewheel', this.handleMouseWheel, { passive: false });
    window.removeEventListener('DOMMouseScroll', this.handleMouseWheelDOM);
  },
};

</script>
<style>
@import '../assets/styles/Main.css';
</style>
