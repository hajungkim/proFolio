<template>
  <div class="read-resume-project">
    <div>
      <span class="font-weight-b font-20">{{ project.title }}</span>
      <span class="ml-15">{{ project.startDate }} ~ {{ project.endDate }}</span>
      <div class="font-weight-b mt-5">{{ project.summary }}</div>
    </div>
    <table class="read-resume-table mt-5">
      <tr>
        <th>설명</th>
        <!-- <td>{{ project.description }}</td> -->
        <td v-html="adjustHtml(project.description)"></td>
      </tr>
      <tr>
        <th>역할</th>
        <td>{{ project.role }}</td>
      </tr>
      <tr>
        <th>사용스택</th>
        <td>{{ project.technologyStack }}</td>
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
  methods: {
    adjustHtml(strVal) {
      return strVal.replace(/(\n|\r\n)/g, '<br>');
    },
  },
};
</script>

<style>
@import '../assets/styles/LookProject.css'
</style>
