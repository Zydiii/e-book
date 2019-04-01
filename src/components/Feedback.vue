<template>
  <div>
    <div class="feedback-container">
      <div class="feedback-img-box">
        <img src="../../static/img/feedback.jpg">
      </div>
      <div class="feedback-box-border">
        <div class="feedback-box">
            <h1>意见反馈</h1>
          <div class="feedback-content">
            <div class="feedback-form">
              <Form :model="formItem" :label-width="80">
                <FormItem>
                  <i-input v-model="formItem.content" type="textarea" :autosize="{minRows: 8,maxRows: 10}" placeholder="请输入反馈信息"></i-input>
                </FormItem>
                <FormItem>
                  <Button type="primary">提交</Button>
                </FormItem>
              </Form>
            </div>
          </div>
        </div>
      </div>
    </div>
    <Footer></Footer>
  </div>
</template>

<script>
  import Footer from '@/components/footer/Footer';
  export default {
    name: 'Feedback',
    data () {
      return {
        formItem: {
          title: '',
          content: ''
        }
      };
    },
    components: {
      Footer
    }
  };
</script>

<style scoped>
  .feedback-container {
    margin: 15px auto;
    width: 80%;
    height: 600px;
    display: flex;
    align-items: center;
    /* background-color: #ccc; */
  }
  .feedback-img-box {
    width: 50%;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  .feedback-img-box img {
    width: 80%;
  }
  .feedback-box-border {
    width: 50%;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  .feedback-box {
    width: 480px;
  }
  .feedback-content {
    margin: 15px auto;
  }
  .feedback-form {
    margin: 30px auto;
    width: 100%;
  }
</style>
