<template>
  <div>
    <div>
      <i-input v-model="searchData" class="search" placeholder="输入你想查找的用户" >
        <Button slot="append" icon="md-search" @click="handleSearch" ></Button>
      </i-input>
    </div>
    <Table border :columns="columns" :data="usershow" no-data-text=""></Table>
  </div>
</template>

<script>
  import axios from 'axios'

    export default {
        name: "ManageUser",
      created() {
          axios.get('http://localhost:8088/manager/users').then((response) => {
            this.users = response.data;
            this.usershow = this.users;
            console.log(response);
        }).catch((error) => {
          console.log(error);
          });
      },
      methods: {
        search(data, argumentObj) {
          let res = data;
          let dataClone = data;
          for (let argu in argumentObj) {
            if (argumentObj[argu].length > 0) {
              res = dataClone.filter(d => {
                return d[argu].indexOf(argumentObj[argu]) > -1;
              });
              dataClone = res;
            }
          }
          return res;
        },
        handleSearch() {
          this.userShow = this.users;
          this.userShow = this.search(this.users, {logid: this.searchData});
        },
        forbid(index, id, valid) {
          if(valid == 1){
            axios.post('http://localhost:8088/manager/changeN', {
              'id': id
            }).then((response) => {
              this.users = response.data;
              this.usershow = this.users;
            }).catch((error) => {
              console.log(error);
            })
          }
        },
        add(index, id, valid) {
          if(valid == 0){
            axios.post('http://localhost:8088/manager/changeY', {
              'id': id
            }).then((response) => {
              this.users = response.data;
              this.usershow = this.users;
            }).catch((error) => {
              console.log(error);
            })
          }
        }
      },
       data() {
          return {
            users:[],
            usershow: [],
            searchData: "",
            columns: [
              {
                title: '登录名',
                key: 'logid',
                width: 100,
                align: 'center'
              },
              // {
              //   title: '图片',
              //   key: 'img',
              //   width: 86,
              //   render: (h, params) => {
              //     return h('div', [
              //       h('img', {
              //         attrs: {
              //           src: params.row.img
              //         }
              //       })
              //     ]);
              //   },
              //   align: 'center'
              // },
              {
                title: '姓名',
                key: 'name',
                width: 100,
                align: 'center'
              },
              {
                title: '密码',
                key: 'password',
                width: 100,
                align: 'center'
              },
              {
                title: '身份(1为管理员，0为用户)',
                width: 200,
                key: 'identity',
                align: 'center'
              },
              {
                title: '状态(1为有效，0为禁用)',
                width: 200,
                key: 'valid',
                align: 'center'
              },
              {
                title: '操作',
                key: 'action',
                width: 150,
                align: 'center',
                render: (h, params) => {
                  return h('div', [
                    h('Button', {
                      props: {
                        type: 'primary',
                        size: 'small'
                      },
                      style: {
                        marginRight: '5px'
                      },
                      on: {
                        click: () => {
                          this.add(params.index, params.row.id, params.row.valid)
                        }
                      }
                    }, '解禁'),
                    h('Button', {
                      props: {
                        type: 'error',
                        size: 'small'
                      },
                      on: {
                        click: () => {
                          this.forbid(params.index, params.row.id, params.row.valid);
                        }
                      }
                    }, '禁止')
                  ]);
                }
              }
            ]
          }
       }
    }
</script>

<style scoped>

</style>
