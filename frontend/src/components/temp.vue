<template>
    <div class="hello">
        <h1>{{ msg }}</h1>

        <Upload action="http://localhost:8088/image/uploadImage" method="post" enctype="multipart/form-data" :on-success="uploadSuccess">
            <Button icon="ios-cloud-upload-outline">Upload files</Button>
        </Upload>

        <img :src="'http://localhost:8088/image/'+msg">
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
            uploadSuccess(response, file, fileList) {
                this.msg = response;
            },
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
                        window.location.reload();
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
