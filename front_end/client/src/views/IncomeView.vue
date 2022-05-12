/* eslint-disable indent */
<template>
    <div class="income">
        <table class="table table-striped">
          <thead>
              <tr>
                <th scope="col">TEST</th>
                <th scope="col">QWER</th>
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
export default {
  data() {
    return {
      fields: ['first_name', 'last_name', 'age'],
      items: [
        { age: 40, first_name: 'name' },
      ],
    };
  },
};
</script>
