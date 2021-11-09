<template>
  <div class="them3">
      <div class="menu">
          <div class="checkmark" v-if="userId">
            <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
            x="0px" y="0px" viewBox="0 0 161.2 161.2" enable-background="new 0 0 161.2 161.2"
            xml:space="preserve">
              <path class="path" fill="none" stroke="#17aa1c" stroke-miterlimit="10"
              d="M425.9,52.1L425.9,52.1c-2.2-2.6-6-2.6-8.3-0.1l-42.7,46.2l-14.3-16.4
              c-2.3-2.7-6.2-2.7-8.6-0.1c-1.9,2.1-2,5.6-0.1,7.7l17.6,20.3c0.2,0.3,0.4,
              0.6,0.6,0.9c1.8,2,4.4,2.5,6.6,1.4c0.7-0.3,1.4-0.8,2-1.5
              c0.3-0.3,0.5-0.6,0.7-0.9l46.3-50.1C427.7,57.5,427.7,54.2,425.9,52.1z"/>
              <circle class="circle path" fill="none" stroke="#17aa1c" stroke-width="4"
              stroke-miterlimit="10" cx="80.6" cy="80.6" r="62.1"/>
              <polyline class="check" fill="none" stroke="#17aa1c" stroke-width="6"
              stroke-linecap="round" stroke-miterlimit="10"
              points="113,52.8 74.1,108.4 48.2,86.4 "/>
            </svg>
          </div>
          <h4 class="complete-text" v-if="userId">complete</h4>
          <div class="menu-buttons">
            <button class="btn-hover color-9" @click="openModal">PDF변환</button>
            <!-- edit -->
            <button class="btn-hover color-9" @click="clickEdit">{{editBtn}}</button>
          </div>
      </div>
      <div class="them3-content">
        <div id="them3-pdf">
          <draggable
            ghost-class="ghost"
          >
            <Them3Info :edit="edit"/>
            <Them3Intro :edit="edit"/>
            <Them3Edu :edit="edit"/>
            <Them3Certi :edit="edit"/>
            <Them3Exp :edit="edit"/>
            <div class="draggable-container-col p-5">
              <Them3Skill :edit="edit"/>
              <Them3Awards :edit="edit"/>
            </div>
            <Them3Project :edit="edit"/>
          </draggable>
        </div>
      </div>
    <div v-if="isOpenModal" class="modal-bg">
        <div class="modal">
          <h2>PDF 변환</h2>
          <div>
            <p>PDF로 저장 할 이름을 입력하세요.</p>
            <input type="text" placeholder='저장 할 이름' v-model="pdfName" class="pdfName-input">
            <div>
              <button class="btn-hover color-1" @click="savePDF">PDF저장</button>
              <button class="btn-hover color-1" @click="closeModal">닫기</button>
            </div>
          </div>
        </div>
    </div>
  </div>
</template>

<script>
import draggable from 'vuedraggable';
import html2pdf from 'html2pdf.js';
import { mapState } from 'vuex';
import Them3Awards from '../components/Them3Awards.vue';
import Them3Certi from '../components/Them3Certi.vue';
import Them3Edu from '../components/Them3Edu.vue';
import Them3Exp from '../components/Them3Exp.vue';
import Them3Info from '../components/Them3Info.vue';
import Them3Intro from '../components/Them3Intro.vue';
import Them3Project from '../components/Them3Project.vue';
import Them3Skill from '../components/Them3Skill.vue';
import { postPortfolio } from '../store/modules/PortfolioAPI';

export default {
  name: 'Them3',
  components: {
    draggable,
    Them3Info,
    Them3Edu,
    Them3Certi,
    Them3Exp,
    Them3Skill,
    Them3Awards,
    Them3Project,
    Them3Intro,
  },
  data() {
    return {
      isOpenModal: false,
      pdfName: '',
      edit: false,
      editBtn: '편집',
    };
  },
  computed: {
    ...mapState([
      'userId',
    ]),
  },
  methods: {
    savePDF() {
      const element = document.getElementById('them3-pdf');
      html2pdf().from(element).set({
        margin: 10,
        filename: this.pdfName,
        html2canvas: {
          scale: 1,
          allowTaint: false,
          useCORS: true,
        },
        jsPDF: {
          orientation: 'portrait',
          unit: 'mm',
          format: 'a3',
          compress: true,
        },
      }).output('blob')
        .then((res) => {
          const pdfFile = new FormData();
          pdfFile.append('file', res, this.pdfName);
          pdfFile.append('name', this.pdfName);
          pdfFile.append('userId', this.userId);
          postPortfolio(pdfFile);
          this.pdfName = '';
        })
        .save();
      this.closeModal();
    },
    openModal() {
      this.isOpenModal = true;
    },
    closeModal() {
      this.isOpenModal = false;
    },
    clickEdit() {
      if (this.edit) {
        this.editBtn = '편집';
        this.edit = false;
      } else {
        this.editBtn = '완료';
        this.edit = true;
      }
    },
  },
  created() {
    if (!this.userId) {
      this.$store.dispatch('portfolioCopySample');
    } else {
      this.$store.dispatch('portfolioCopyResume');
    }
  },
};
</script>

<style>
@import '../assets/styles/Them3.css';
</style>
