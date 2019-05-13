<template>
  <div class="container">
    <p><Icon type="ios-checkmark-circle-outline" ></Icon></p>
    <Button type="success" size="large" long class="btn-success" @click="handleSubmit">注册成功</Button>
  </div>
</template>

<script>
  import axios from 'axios'

export default {
  name: 'SignUpDone',
  methods: {
    handleSubmit() {
      axios.post('http://localhost:8088/user/add', {
        'phone': sessionStorage.getItem("phone"),
        'logid': sessionStorage.getItem("logid"),
        'email': sessionStorage.getItem("email"),
        'password': sessionStorage.getItem("password")
      }).then((response) => {
        console.log(response);
      }).catch((error) => {
        console.log(error);
      });
      this.$router.push({ path: '/Login' });
    }
  }
};
</script>

<style scoped>
.container {
  width: 100%;
  text-align: center;
}
.container p {
  font-size: 90px;
  color: #2d8cf0;
  text-align: center;
}
.btn-success {
  margin-top: 30px;
}
</style>
