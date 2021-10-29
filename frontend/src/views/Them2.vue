<template>
  <div class="them2">
    <div class="them2-title">Portfolio</div>
    <Them2Info/>
    <Them2Skill/>
    <Them2Project/>
    <Them2Exp/>
    <Them2Certi/>
    <Them2Awards/>
  </div>
</template>

<script>
import Them2Awards from '../components/Them2Awards.vue';
import Them2Certi from '../components/Them2Certi.vue';
import Them2Exp from '../components/Them2Exp.vue';
import Them2Info from '../components/Them2Info.vue';
import Them2Project from '../components/Them2Project.vue';
import Them2Skill from '../components/Them2Skill.vue';

export default {
  components: {
    Them2Info,
    Them2Skill,
    Them2Project,
    Them2Certi,
    Them2Awards,
    Them2Exp,
  },
  name: 'Them2',
};
</script>

<style>
@import '../assets/styles/Them2.css';
</style>
