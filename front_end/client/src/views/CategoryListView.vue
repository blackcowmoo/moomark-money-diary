/* eslint-disable indent */
<template>
    <div class="income">

        <MyModal @close="closeModal" v-if="modal">
      <!-- default 슬롯 콘텐츠 -->
          <p>Vue.js Modal Window!</p>
          <div><input v-model="message"></div>
      <!-- /default -->
      <!-- footer 슬롯 콘텐츠 -->
          <template v-slot:footer>
            <button @click="doSend">제출</button>
          </template>
           <!-- /footer -->
        </MyModal>

        <table class="table table-striped" id="tableComponent">
          <thead>
              <tr>
                <th scope="col" v-for='field in fields' :key='field' @click="sortTable(field)">
                  {{field}}
                  <i class="bi bi-sort-alpha-down" aria-label="Sort Icon" ></i>
                </th>
              </tr>
          </thead>
          <tbody>
              <tr>
                <td>TEST</td>
                <td>qwer</td>
              </tr>
          </tbody>
        </table>
    </div>
</template>

<script lang="js">
import axios from 'axios';
// import categoryModal from '@/components/CategoryListModalComponent.vue';

export default {
  name: 'TableComponent',
  data() {
    return {
      fields: ['title', 'last_name', 'age'],
      items: [
        {
          dataCategories: [
            {
              id: 0,
              name: 'string',
            },
          ],
          id: 0,
          itemName: 'string',
          localDateTime: '2022-05-17T14:17:43.223Z',
          memo: 'string',
          money: 0,
        },
      ],
    };
  },
  created() {
    // eslint-disable-next-line @typescript-eslint/no-this-alias
    const vm = this;

    axios.get('http://localhost:7070/category/list').then((response) => {
      console.log(response);
      vm.items = response.data;
    }).catch((error) => {
      console.log(error);
    });
  },
};
</script>
