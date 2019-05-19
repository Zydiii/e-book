<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <form>
      <input type="file" @change="getFile($event)">
      <Button type="primary" @click="submit($event)">提交</Button>
    </form>
    <img src="http://localhost:8088/image/2019030515454352754.jpg">

    <Upload action="http://localhost:8088/image/upload">
      <Button icon="ios-cloud-upload-outline">请上传图片</Button>
    </Upload>
  </div>
</template>

<script>
  import axios from 'axios';

  export default {
    name: 'HelloWorld',
    data() {
      return {
        msg: 'Welcome to Your Vue.js App',
        file: ''
      }
    },
    methods: {
      getFile: function (event) {
        this.file = event.target.files[0];
        console.log(this.file);
      },
      submit: function (event) {
        //阻止元素发生默认的行为
        event.preventDefault();
        let formData = new FormData();
        formData.append("file", this.file);
        axios.post('http://localhost:8088/image/upload', formData)
          .then(function (response) {
            alert(response.data);
            console.log(response);
            //window.location.reload();
          })
          .catch(function (error) {
            alert("上传失败");
            console.log(error);
            window.location.reload();
          });
      }
    }
  }
</script>
