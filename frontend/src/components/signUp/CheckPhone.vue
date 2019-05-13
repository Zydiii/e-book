<template>
  <div class="info-form">
    <Form ref="formValidate" :model="formValidate" :label-width="80" :rules="ruleValidate">
      <FormItem label="手机号" prop="phone">
          <i-input v-model="formValidate.phone" clearable size="large"  placeholder="请输入手机号"></i-input>
      </FormItem>
      <FormItem label="验证码" prop="checkNum">
          <i-input v-model="formValidate.checkNum" size="large"  placeholder="请输入验证码">
            <Button slot="append" @click="getcheckNum">获取验证码</Button>
          </i-input>
      </FormItem>
      <Button type="success" size="large" long @click="handleSubmit('formValidate')">验证手机号</Button>
    </Form>
  </div>
</template>

<script>
import store from '@/vuex/store';
import { mapMutations } from 'vuex';
import axios from 'axios'
export default {
  name: 'CheckPhone',
  data () {
    return {
      check: [],
      formValidate: {
        phone: '',
        checkNum: ''
      },
      ruleValidate: {
        phone: [
          { required: true, message: '手机号不能为空', trigger: 'blur' },
          { type: 'string', pattern: /^1[3|4|5|7|8][0-9]{9}$/, message: '手机号格式出错', trigger: 'blur' }
        ],
        checkNum: [
          { required: true, message: '必须填写验证码', trigger: 'blur' },
          { type: 'string', min: 4, max: 4, message: '验证码错误', trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    ...mapMutations(['SET_SIGN_UP_SETP']),
    getcheckNum () {
      if (this.formValidate.phone.length === 11) {
        this.$Message.success({
          content: '验证码为: 4839',
          duration: 6,
          closable: true
        });
      } else {
        this.$Message.error({
          content: '请输入正确的手机号',
          duration: 6,
          closable: true
        });
      }
    },
    handleSubmit (name) { // 提交验证
      axios.get('http://localhost:8088/user/checkPhone?phone='+ this.formValidate.phone.toString())
        .then((response) => {
          console.log("check1");
          this.check = response.data;
          console.log(response);
          console.log("check2");
          console.log(this.check);
          if(this.check.status === 0)
            this.$Message.error("该手机号已经被注册");
          else{
            this.$refs[name].validate((valid) => {
              if (valid) {
                this.$router.push({ path: '/SignUp/inputInfo', query: { phone: this.formValidate.phone } });
                this.SET_SIGN_UP_SETP(1);
                sessionStorage.setItem("phone", this.formValidate.phone);
              } else {
                this.$Message.error({
                  content: '验证失败',
                  duration: 6,
                  closable: true
                });
              }
            });
          }
        }).catch((error) => {
        console.log(error);
      });



    }
  },
  store
};
</script>

<style scoped>
.info-form {
  width: 90% !important;
}
</style>
