<template>
  <div class="convert">
    <form class="input-box" enctype="multipart/form-data">
      <!-- input image -->
      <div class="img-box">
        <div class="img-box-title">My Image</div>
        <div class="img-btn" @click="click('input')" >Select</div>
        <input
          hidden
          ref="input-image-input"
          type="file" accept="image/*"
          @change="uploadImage('input')"
        >
        <img
          class="img"
          ref="input-image"
          :src="inputImgUrl"
          @error="setDefaultImage('input')"
        />
      </div>
      <!-- style image -->
      <div class="img-box">
        <div class="img-box-title">Style Image</div>
        <div class="img-btn" @click="click('style')" >Select</div>
        <input
          hidden
          ref="style-image-input"
          type="file" accept="image/*"
          @change="uploadImage('style')"
        >
        <img
          class="img"
          :src="styleImgUrl"
          ref="style-image"
          @error="setDefaultImage('style')"
        />
      </div>
      <input type="submit" ref="submit-btn" @click="onSubmit" hidden/>
    </form>
    <div class="btn-box">
      <!-- convert button -->
      <div class="convert-btn" @click="convert">
        convert
      </div>
      <!-- reset button -->
      <div class="reset-btn" @click="reset">
        reset
      </div>
    </div>
    <!-- output image -->
    <div class="img-box">
      <div class="img-box-title">Output</div>
      <div v-if="imageLoading">
        <v-progress-circular
          class=""
          :size="50"
          color="#3c4bff"
          indeterminate
        />
      </div>
      <div v-else>
        <img
          class="img"
          :src="outputImgUrl"
          ref="output-image"
          @error="setDefaultImage('output')"
        />
      </div>
      <div
        class="download-btn"
        v-if="outputLoaded"
        @click="downloadImage"
      >
        save
      </div>
    </div>
  </div>
</template>

<script>
import defaultImage from '../assets/images/defaultProfileRect.png';
import convert from '../store/modules/ConvertAPI';

export default {
  name: 'Convert',
  components: {},
  data() {
    return {
      inputImgUrl: '',
      styleImgUrl: '',
      outputImgUrl: '',
      imageLoading: false,
      outputLoaded: false,
    };
  },
  methods: {
    uploadImage(source) {
      if (source === 'input') {
        const image = this.$refs['input-image-input'].files[0];
        this.inputImgUrl = URL.createObjectURL(image);
      } else if (source === 'style') {
        const image = this.$refs['style-image-input'].files[0];
        this.styleImgUrl = URL.createObjectURL(image);
      } else if (source === 'output') {
        console.log(this.$refs['output-image']);
      }
    },
    click(source) {
      if (source === 'input') {
        this.$refs['input-image-input'].click();
      } else if (source === 'style') {
        this.$refs['style-image-input'].click();
      }
    },
    setDefaultImage(source) {
      if (source === 'input') {
        this.inputImgUrl = defaultImage;
      } else if (source === 'style') {
        this.styleImgUrl = defaultImage;
      } else if (source === 'output') {
        this.outputImgUrl = defaultImage;
      }
    },
    convert() {
      this.$refs['submit-btn'].click();
    },
    onSubmit(event) {
      event.preventDefault();
      if ((this.inputImgUrl === defaultImage) || (this.styleImgUrl === defaultImage)) {
        alert('이미지를 첨부해주세요');
        return;
      }
      // 초기화
      this.outputImgUrl = defaultImage;
      this.imageLoading = true;
      this.outputLoaded = false;

      // form data 작성 및 submit
      const formData = new FormData();
      formData.append('input_image', this.$refs['input-image-input'].files[0]);
      formData.append('style_image', this.$refs['style-image-input'].files[0]);
      convert(formData)
        .then((res) => {
          const { data } = res;
          const src = `data:image/jpeg;base64,${(data)}`;
          this.outputImgUrl = src;
          this.outputLoaded = true;
        }).catch(() => {
          // console.log(e);
          this.outputImgUrl = defaultImage;
        });
      this.imageLoading = false;
    },
    downloadImage() {
      const link = document.createElement('a');
      link.href = this.outputImgUrl;
      link.download = 'output.jpg';
      link.click();
    },
    reset() {
      this.inputImgUrl = '';
      this.styleImgUrl = '';
      this.outputImgUrl = '';
      this.imageLoading = false;
      this.outputLoaded = false;
    },
  },
  created() {
  },
};
</script>

<style>
@import '../assets/styles/Convert.css';
</style>
