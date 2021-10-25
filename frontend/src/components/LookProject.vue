<template>
  <div class="read-resume-project">
    <div>
      <span class="font-weight-b font-20">{{ project.title }}</span>
      <span class="ml-15">{{ project.start_date }} ~ {{ project.end_date }}</span>
      <div class="font-weight-b mt-15">{{ project.summary }}</div>
    </div>
    <table class="read-resume-table">
      <tr>
        <th>설명</th>
        <td>{{ project.description }}</td>
      </tr>
      <tr>
        <th>역할</th>
        <td>{{ project.role }}</td>
      </tr>
      <tr>
        <th>사용스택</th>
        <td>{{ project.technology_stack }}</td>
      </tr>
      <tr>
        <th>link</th>
        <td>{{ project.link }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: 'LookProject',
  props: {
    project: {
      type: Object,
    },
  },
};
</script>

<style>
@import '../assets/styles/LookProject.css'
</style>
