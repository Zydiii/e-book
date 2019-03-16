<template>
  <div>
    <ul>
      <li v-for="item in links"><a @click="$goRoute(item.route)">{{item.text}}</a></li>
      <li>
        <el-button @click="dialogFormVisible = true">Sign Up</el-button>
        <el-dialog title="Create Your Account" :visible.sync="dialogFormVisible">
          <el-form :model="form">
            <el-form-item label="Your name" :label-width="formLabelWidth">
              <el-input v-model="form.name" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="Email" :label-width="formLabelWidth">
              <el-input v-model="form.email" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="Password" :label-width="formLabelWidth">
              <el-input v-model="form.password" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="Re-enter password" :label-width="formLabelWidth">
              <el-input v-model="form.pass" autocomplete="off"></el-input>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible = false">Quit</el-button>
            <el-button type="primary" @click="dialogFormVisible = false">Create your account</el-button>
          </div>
        </el-dialog>
      </li>
      <li>
        <el-button @click="dialogFormVisible1 = true">Log In</el-button>
        <el-dialog title="Log In" :visible.sync="dialogFormVisible1">
          <el-form :model="form1">
            <el-form-item label="Your name" :label-width="formLabelWidth1">
              <el-input v-model="form1.name" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="Password" :label-width="formLabelWidth1">
              <el-input v-model="form1.password" autocomplete="off"></el-input>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible1 = false">Quit</el-button>
            <el-button type="primary" @click="dialogFormVisible1 = false">Log In</el-button>
          </div>
        </el-dialog>
      </li>
      <li>



      </li>
    </ul>

    <router-view></router-view>
  </div>
</template>

<script>
  export default {
    name: 'app',
    data () {
      return {
        links: [
          {
            text: 'Home',
            route: '/home'
          },
          {
            text: 'Shop',
            route: '/page01'
          },
          {
            text: 'Search',
            route: '/page02'
          },
          {
            text: 'Detail',
            route: '/page02'
          },
          {
            text: 'Favorite',
            route: '/page02'
          },
          {
            text: 'Cart',
            route: '/page02'
          }
        ],
        dialogFormVisible: false,
        form: {
          name: '',
          email:'',
          password:'',
          pass:'',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        },
        formLabelWidth: '120px',
        dialogFormVisible1: false,
        form1: {
          name: '',
          email:'',
          password:'',
          pass:'',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        },
        formLabelWidth1: '120px'
      };


    }
  }
</script>

<style>
  #app {
    font-family: Helvetica, sans-serif;
    text-align: center;
  }

  .text-center {
    text-align: center;
  }
  .spacing {
    margin-top: 30px;
  }
  .red {
    color: darkred;
  }
  ul li {
    display: inline-block;
    margin-right: 10px;
  }
  ul li a{
    display: inherit;
    padding: 5px 10px;
    border: 1px solid #ccc;
  }
  ul li a:hover{
    cursor: pointer;
    color: #fff;
    background-color: #138bec;
    border: 1px solid #138bec;
  }

  a {
    display: block;
    width: 100px;
  }
</style>
