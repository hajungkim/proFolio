<template>
  <button
    id="remove-btn"
    :class="[edit ? '' : 'hidden']"
    @click="removeComponent()"
  >
  X
  </button>
</template>

<script>
export default {
  name: 'DeleteBtn',
  props: {
    edit: {
      type: Boolean,
    },
  },
  methods: {
    removeComponent() {
      const content = document.getElementById('remove');
      content.remove();
    },
  },
};
</script>

<style>

</style>
