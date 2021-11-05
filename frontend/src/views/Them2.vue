<template>
  <div class="them2">
     <div class="menu">
          <div class="checkmark">
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
          <h4>complete</h4>
          <div class="buttons">
            <button class="btn-hover color-9">저장하기</button>
            <button class="btn-hover color-9" @click="savePDF">PDF변환</button>
            <!-- edit -->
            <button id="edit-btn" @click="clickEdit">{{editBtn}}</button>
          </div>
     </div>
    <div class="them2-content">
      <div id="them2-pdf">
        <div class="them2-title">Portfolio</div>
        <!-- test -->
          <draggable
            ghost-class="ghost"
          >
            <Them2Info :edit="edit"/>
            <Them2Skill :edit="edit"/>
            <Them2Project :edit="edit"/>
            <Them2Exp :edit="edit"/>
            <Them2Certi :edit="edit"/>
            <Them2Awards :edit="edit"/>
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
import draggable from "vuedraggable";
import html2pdf from 'html2pdf.js';
import Them2Awards from '../components/Them2Awards.vue';
import Them2Certi from '../components/Them2Certi.vue';
import Them2Exp from '../components/Them2Exp.vue';
import Them2Info from '../components/Them2Info.vue';
import Them2Project from '../components/Them2Project.vue';
import Them2Skill from '../components/Them2Skill.vue';
import { postPortfolio } from '../store/modules/PortfolioAPI';

export default {
  components: {
    draggable,
    Them2Info,
    Them2Skill,
    Them2Project,
    Them2Certi,
    Them2Awards,
    Them2Exp,
  },
  name: 'Them2',
  data() {
    return {
      edit: false,
      editBtn: '편집',
      isOpenModal: false,
      pdfName: '',
    };
  },
  methods: {
    savePDF() {
      const element = document.getElementById('them2-pdf');
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
          pdfFile.append('userId', 1);
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
    this.$store.dispatch('portfolioCopyResume');
  },
};
</script>

<style>
@import '../assets/styles/Them2.css';
.ghost {
  opacity: 0.5;
  background: #c8ebfb;
}

#edit-btn {
  /* display: flex;
  justify-content: center;
  align-items: center; */
  width: 50px;
  height: 35px;
  border-radius: 10px;
  background-color: darkgray;
  margin-left: 10px;
  /* position: absolute; */
  /* top: 14%; */
  /* right: 20%; */
  cursor: pointer;
  box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.25);
}
#remove-btn {
  width: 50px;
  height: 35px;
  border-radius: 10px;
  background-color: #d9534f;
  /* margin-left: 10px; */
  cursor: pointer;
  box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.25);
}

</style>
