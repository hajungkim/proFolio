<template>
  <div class="resume-exp">
    <div>
      <span class="font-weight-b font-20">{{ act.name }}</span>
      <span class="ml-15">{{ act.start_date }} ~ {{ act.end_date }}</span>
    </div>
    <table class="read-resume-table">
      <tr>
        <th>활동 기관</th>
        <td>{{ act.organization }}</td>
      </tr>
      <tr>
        <th>활동 내용</th>
        <td>{{ act.description }}</td>
      </tr>
    </table>
  </div>
</template>

<script>

export default {
  name: 'LookExperience',
  props: {
    act: {
      type: Object,
    },
  },
};
</script>

<style>
@import '../assets/styles/LookExperience.css';
</style>
