/* eslint-disable indent */
<template>
    <div class="income">
        <table class="table table-striped" id="tableComponent">
          <thead>
              <tr>
                <th scope="col">TEST</th>
                <th scope="col">QWER</th>
                <th v-for='field in fields' :key='field' @click="sortTable(field)">
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

<script>
import axios from 'axios';

export default {
  name: 'TableComponent',
  data() {
    return {
      fields: ['first_name', 'last_name', 'age'],
      items: [
        { age: 40, first_name: 'name' },
      ],
    };
  },
  created() {
    // eslint-disable-next-line @typescript-eslint/no-this-alias
    const vm = this;

    axios.get('http://localhost:8080').then((response) => {
      console.log(response);
      vm.items = response.data;
    }).catch((error) => {
      console.log(error);
    });
  },
};
</script>
