<template>
  <!-- 登陆页面 -->
  <div>
    <Row class="container">
      <i-col span="13" offset="2" class="login-img-box">
        <img src="../../static/img/sale.jpg" alt="">
      </i-col>
      <i-col span="7" class="login-box">
        <div class="login-container">
          <div class="login-header">
            <p>欢迎登陆</p>
          </div>
          <div class="form-box">
            <Form ref="formInline" :model="formDate" :rules="ruleInline">
              <FormItem prop="username">
                <i-input type="text" v-model="formDate.username" clearable size="large" placeholder="用户名">
                  <Icon type="person" slot="prepend"></Icon>
                </i-input>
              </FormItem>
              <FormItem prop="password">
                <i-input type="password" v-model="formDate.password" clearable size="large" placeholder="密码">
                  <Icon type="ios-locked-outline" slot="prepend"></Icon>
                </i-input>
              </FormItem>
              <FormItem>
                <Button type="success" size="large" @click="submit()" long>登陆</Button>
              </FormItem>
            </Form>
          </div>
        </div>
      </i-col>
    </Row>
    <Footer></Footer>
  </div>
</template>

<script>
  import Footer from '@/components/footer/Footer';
  import store from '@/vuex/store';
  import axios from 'axios'
  import {mapMutations, mapActions} from 'vuex';

  export default {
    name: 'Login',
    data() {
      return {
        // success: "",
        // logged: false,
        // do_submit: 0,
        formDate: {
          username: '',
          password: ''
        },
        ruleInline: {
          username: [
            {required: true, message: '请输入用户名', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '请输入密码', trigger: 'blur'},
            {type: 'string', min: 6, message: '密码不能少于6位', trigger: 'blur'}
          ]
        },
        logg: {}
      };
    },
    // updated: function() {
    //   sessionStorage.setItem("userInfo",JSON.stringify(this.logg));
    //   if(this.logg !== "")
    //     sessionStorage.setItem("isLog", "true");
    //   console.log("login");
    //   console.log((sessionStorage.getItem("userInfo")));
    //  },
    methods: {
      setInfo() {
        let that = this;
        axios.get('http://localhost:8088/user/detail?id=' + that.formDate.username.toString())
          .then((response) => {
            that.log = response.data;
            console.log("log2");
            console.log(this.logg);
            that.success++;
            that.do_submit++;
            that.sessionStorage.setItem("userInfo", JSON.stringify(this.logg));
            that.sessionStorage.setItem("isLog", "true");
            // that.storage();
            that.$emit("logged", "logged");
          });
      },
      submit() {
        let that = this;
        axios.post('http://localhost:8088/user/login', {
          'logid': this.formDate.username,
          'password': this.formDate.password
        }).then((response) => {
          var status = response.data;
          if (status.in === 1) {
            this.$Message.success('登陆成功');
            console.log("log1");
            axios.get('http://localhost:8088/user/detail?id=' + that.formDate.username.toString())
              .then((response) => {
                that.logg = response.data;
                sessionStorage.setItem("userInfo", JSON.stringify(this.logg));
                sessionStorage.setItem("isLog", "true");
                this.$emit("logged", "logged");
                that.$router.push('/');
              });
            // that.$router.push('/');
          } else if (status.in === -1) {
            that.$Message.error('用户名或密码错误');
          } else if (status.in === 2) {
            that.$Message.error('您的账号已经被禁用');
          }
          else {
            that.$Message.error('请填写正确的用户名或密码');
          }
        }).catch((error) => {
          console.log(response);
        });
      }
    },
    watch: {
      logg: {
        handler() {
          console.log(111111);
          sessionStorage.setItem("userInfo", JSON.stringify(this.logg));
          sessionStorage.setItem("isLog", "true");
          this.$emit("logged", "logged");
        },
        deep: true,
      }
    },
    components: {
      Footer
    }
  };
</script>

<style scoped>
  .container {
    margin-top: 30px;
    height: 485px;
    background-color: #fff;
  }

  .login-img-box {
    height: 485px;
    overflow: hidden;
    display: flex;
    align-items: center;
    justify-content: center;
  }

  .login-img-box > img {
    width: 68%;
  }

  .login-box {
    height: 485px;
    display: flex;
    align-items: center;
    justify-content: center;
  }

  .login-container {
    width: 80%;
    height: 280px;
    border: #25b7c4 solid 1px;
  }

  .login-header {
    height: 50px;
    font-size: 20px;
    text-align: center;
    line-height: 50px;
    letter-spacing: 5px;
    color: #fff;
    background-color: #25b7c4;
  }

  .form-box {
    width: 80%;
    margin: 30px auto;
  }
</style>
