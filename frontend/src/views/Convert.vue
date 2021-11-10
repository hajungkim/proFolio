<template>
  <div class="convert">
    <h1 class="name">원하는 취업사진 스타일을 선택해주세요.</h1>
    <div class="convert-content">
    <form class="input-box" enctype="multipart/form-data">
      <div class="input">
        <span class="name upload">사진 업로드</span>
        <img
          src="../assets/images/question.png"
          id="question"
          @mouseover="showQuestion"
          @mouseout="hideQuestion"/>
        <div id="balloon" style="display: none">
          <div>- 앞머리를 눈썹 위로 올린 정면 사진을 올려주세요.</div>
          <div>- 밝은 조명에서 찍은 사진을 올려주세요.</div>
        </div>
        <!-- input image -->
        <div class="img-box">
          <img
            class="img-btn"
            ref="input-btn"
            @click="click('input')"
            src="../assets/images/plus.png"/>
          <input
            id="input-img"
            ref="input-image-input"
            type="file" accept="image/*"
            @change="uploadImage('input')"
          >
          <img
            hidden
            class="img"
            ref="input-image"
            style="cursor: pointer"
            :src="inputImgUrl"
            @click="click('input')"
            @error="setDefaultImage('input')"
          />
        </div>
      </div>
      <!-- style image -->
      <div class="select-box">
        <img
          v-for="(img, index) in imgArr"
          :key="index"
          class="sample-img"
          :src="img"
          @click="selectImg(index)"
        />
        <!-- <div class="img-btn" @click="click('style')" >Select</div>
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
        /> -->
      </div>
      <input type="submit" ref="submit-btn" @click="onSubmit" hidden/>
    </form>
    <div class="output">
      <div class="btn-box">
        <!-- convert button -->
        <div class="convert-btn" @click="convert">
          CONVERT
        </div>
        <!-- reset button -->
        <div class="reset-btn" @click="reset">
          RESET
        </div>
      </div>
      <!-- output image -->
      <div class="img-box">
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
      </div>
      <div
        class="download-btn"
        @click="downloadImage"
      >
        DOWNLOAD
      </div>
      </div>
    </div>
  </div>
</template>

<script>
import defaultImage from '../assets/images/defaultProfileRect.png';
import convert from '../store/modules/ConvertAPI';
import img0 from '../assets/images/idPhoto0.jpg';
import img1 from '../assets/images/idPhoto1.jpg';
import img2 from '../assets/images/idPhoto2.jpg';
import img3 from '../assets/images/idPhoto3.jpg';
import img4 from '../assets/images/idPhoto4.jpg';
import img5 from '../assets/images/idPhoto5.jpg';

import img00 from '../assets/images/idPhoto00.jpg';
import img11 from '../assets/images/idPhoto11.jpg';
import img22 from '../assets/images/idPhoto22.jpg';
import img33 from '../assets/images/idPhoto33.jpg';
import img44 from '../assets/images/idPhoto44.jpg';
import img55 from '../assets/images/idPhoto55.jpg';

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
      imgArr: [img0, img1, img2, img3, img4, img5],
      imgCvtArr: [img00, img11, img22, img33, img44, img55],
      styleImgFile: '',
    };
  },
  methods: {
    uploadImage(source) {
      if (source === 'input') {
        const image = this.$refs['input-image-input'].files[0];
        this.inputImgUrl = URL.createObjectURL(image);
        const imageBox = this.$refs['input-image'];
        imageBox.style.display = 'block';
        const btn = this.$refs['input-btn'];
        btn.style.display = 'none';
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
      // console.log(this.$refs['input-image-input'].files[0]);
      // console.log(this.styleImgFile);
      // form data 작성 및 submit
      const formData = new FormData();
      formData.append('input_image', this.$refs['input-image-input'].files[0]);
      formData.append('style_image', this.styleImgFile);
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
      const imageBox = this.$refs['input-image'];
      imageBox.style.display = 'none';
      const btn = this.$refs['input-btn'];
      btn.style.display = 'inline-block';
      let i;
      for (i = 0; i < 6; i += 1) {
        const img = document.getElementsByClassName('sample-img')[i];
        img.classList.remove('select-img');
      }
    },
    showQuestion() {
      const balloon = document.getElementById('balloon');
      balloon.style.display = 'block';
    },
    hideQuestion() {
      const balloon = document.getElementById('balloon');
      balloon.style.display = 'none';
    },
    selectImg(id) {
      let i;
      for (i = 0; i < 6; i += 1) {
        const img = document.getElementsByClassName('sample-img')[i];
        img.classList.remove('select-img');
      }
      const img = document.getElementsByClassName('sample-img')[id];
      // this.click('style');
      img.className += ' select-img';
      this.styleImgUrl = this.imgCvtArr[id];
      // console.log(this.imgArr[id]);
      this.convertURLtoFile(this.imgCvtArr[id])
        .then((res) => {
          this.styleImgFile = res;
          // console.log(res);
        });
    },
    async convertURLtoFile(url) {
      const response = await fetch(url);
      const data = await response.blob();
      const ext = url.split(".").pop();
      const filename = url.split("/").pop();
      const metadata = { type: `image/${ext}` };
      return new File([data], filename, metadata);
    },
  },
  created() {
  },
};
</script>

<style>
@import '../assets/styles/Convert.css';
</style>
