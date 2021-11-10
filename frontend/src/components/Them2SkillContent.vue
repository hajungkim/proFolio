<template>
    <div>
        <div class="blue-line">{{title}}</div>
        <div class="skill-item">
            <div v-for="(skill) in list" :key="skill.id">
            <div style="display: flex; margin: 3% 0">
                <div style="line-height: 5vh">{{skill.name}}</div>
                <div class="level-circle"
                :class="{
                    levelred: skill.level==5,
                    levelgreen: skill.level == 3 || skill.level == 4,
                    levelyellow: skill.level == 1 || skill.level == 2
                }">{{skill.level}}</div>
            </div>
            </div>
        </div>
    </div>
</template>

<script>

export default {
  name: 'Them2Skill',
  props: {
    title: {
      type: String,
    },
    list: {
      type: Array,
    },
  },
  data() {
    return {
    };
  },
};
</script>

<style>
@import '../assets/styles/Them2.css';
</style>
