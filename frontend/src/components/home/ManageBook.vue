<template>
  <div>
    <div>
      <i-input v-model="searchData" class="search" placeholder="输入你想查找的书籍">
        <Button slot="append" icon="md-search" @click="handleSearch"></Button>
      </i-input>
    </div>
    <Table border :columns="columns" :data="bookShow" no-data-text="请您添加书籍~"></Table>
    <Button type="primary" @click="edit(index)">
      <Icon type="md-add"/>
      添加书籍
    </Button>
    <Modal v-model="modal" width="530" @on-ok="ok" :loading="loading">
      <p slot="header">
        <Icon type="edit"></Icon>
        <span>请填写书籍信息</span>
      </p>
      <div>
        <Form ref="formData" :model="formData" label-position="left" :label-width="100" :rules="ruleInline">
          <FormItem label="标题" prop="title">
            <i-input v-model="formData.title" size="large"></i-input>
          </FormItem>
          <FormItem label="封面" prop="cover">
            <input type="file" @change="getFile($event)">
          </FormItem>
          <!--<FormItem label="封面" prop="cover">-->
            <!--<Upload action="http://localhost:8088/image/upload">-->
              <!--<Button icon="ios-cloud-upload-outline">请上传图片</Button>-->
            <!--</Upload>-->
          <!--</FormItem>-->
          <!--<FormItem label="封面" prop="cover">-->
            <!--<i-input v-model="formData.cover" size="large"></i-input>-->
          <!--</FormItem>-->
          <FormItem label="作者" prop="writer">
            <i-input v-model="formData.writer" size="large"></i-input>
          </FormItem>
          <FormItem label="ISBN" prop="ISBN">
            <i-input v-model="formData.ISBN" size="large"></i-input>
          </FormItem>
          <FormItem label="库存量" prop="remains">
            <i-input v-model="formData.remains" size="large"></i-input>
          </FormItem>
          <FormItem label="价格" prop="price">
            <i-input v-model="formData.price" size="large"></i-input>
          </FormItem>
          <FormItem label="出版商" prop="shopName">
            <i-input v-model="formData.shopName" size="large"></i-input>
          </FormItem>
          <FormItem label="书籍简介" prop="intro">
            <Input v-model="formData.intro" type="textarea" :autosize="{minRows: 2,maxRows: 5}"></Input>
          </FormItem>
          <!--<FormItem>-->
          <!--<Button type="primary" @click="editAction">确认</Button>-->
          <!--<Button style="margin-left: 8px">取消</Button>-->
          <!--</FormItem>-->
        </Form>
      </div>
    </Modal>
  </div>
</template>

<script>
  import axios from 'axios'
  import ManageBookExpand from './ManageBookExpand';

  export default {
    name: "ManageBook",
    created() {
      axios.get('http://localhost:8088/manager/books').then((response) => {
        this.books = response.data;
        var i = 0;
        for (; i < this.books.length; i++) {
          this.books[i].editting = 0;
          this.books[i].saving = 0;
        }
        this.bookShow = this.books;
      }).catch((error) => {
        console.log(error);
      });
    },
    methods: {
      getBook: function(){
        axios.get('http://localhost:8088/manager/books').then((response) => {
          this.books = response.data;
          var i = 0;
          for (; i < this.books.length; i++) {
            this.books[i].editting = 0;
            this.books[i].saving = 0;
          }
          this.bookShow = this.books;
        }).catch((error) => {
          console.log(error);
        })
      },

      submit: function (ISBN) {
        //阻止元素发生默认的行为
        //event.preventDefault();
        let formData = new FormData();
        formData.append("file", this.file);
        console.log("ISBN");
        console.log(ISBN);
        let that = this;
        axios.post('http://localhost:8088/image/upload?ISBN=' + ISBN, formData)
          .then(function (response) {
            //alert(response.data);
            console.log(response);
            that.getBook();
            //window.location.reload();
          })
          .catch(function (error) {
            alert("上传失败");
            console.log(error);
            //window.location.reload();
          });
      },
      getFile: function (event) {
        this.file = event.target.files[0];
        console.log(this.file);
      },
      changeLoading() {
        this.loading = false;
        this.$nextTick(() => {
          this.loading = true;
        });
      },
      ok () {
        this.$refs['formData'].validate(valid => {
          if(!valid) {
            this.$Message.error('书籍信息存在错误');
            return this.changeLoading();
          }
          setTimeout(() => {
            axios.post('http://localhost:8088/manager/addBook', this.formData)
              .then((response) => {
                this.modal = false;
                this.$Message.success('成功添加书籍');
                console.log(response);
                this.changeLoading();
                this.submit(this.formData.ISBN);
              }).catch((error) => {
              console.log(error);
              this.$Message.error('连接出错，请稍后再试');
            })
          }, 1000);
        });
      },
      edit(index) {
        this.modal = true;
      },

      handleEdit(row) {
        this.$set(row, '$isEdit', true)

      },
      handleSave(row) {
        this.$set(row, '$isEdit', false);
        axios.post('http://localhost:8088/manager/updateBook', row)
          .then((response) => {
            this.$Message.success('保存完成');
            console.log(response);
          })
      },
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
        this.bookShow = this.books;
        this.bookShow = this.search(this.books, {title: this.searchData});
      },
      forbid(index, id, valid) {
        if (valid == 1) {
          axios.post('http://localhost:8088/manager/changeN', {
            'id': id
          }).then((response) => {
            this.books = response.data;
            this.bookShow = this.books;
          }).catch((error) => {
            console.log(error);
          })
        }
      },
      add(index, id, valid) {
        if (valid == 0) {
          axios.post('http://localhost:8088/manager/changeY', {
            'id': id
          }).then((response) => {
            this.books = response.data;
            this.bookShow = this.books;
          }).catch((error) => {
            console.log(error);
          })
        }
      },
      remove(index, bookid) {
        this.books.splice(index, 1);
        axios.get('http://localhost:8088/manager/deleteBook?id=' + bookid.toString())
          .then((response) => {
            var status = response.data;
            this.$Message.success("删除成功");
            console.log(response);
          }).catch((error) => {
          console.log(error);
        })
      }
    },
    data() {
      return {
        modal: false,
        books: [],
        bookShow: [],
        loading: true,
        searchData: "",
        cloneDataList: [],
        formData: {
          cover: '',
          title: '',
          writer: '',
          ISBN: '',
          remains: '',
          price: '',
          intro: '',
          shopName: ''
        },
        ruleInline: {
          title: [
            {required: true, message: '标题不能为空', trigger: 'blur'}
          ],
          writer: [
            {required: true, message: '作者名不能为空', trigger: 'blur'}
          ],
          ISBN: [
            {required: true, message: 'ISBN编号不能为空', trigger: 'blur'}
          ],
          remains: [
            {required: true, message: '库存不能为空', trigger: 'blur'},
            {type: 'string', pattern:/^(([1-9]\d{0,3})|0)?$/, message: '库存量只能为正整数且不超过9999', trigger: 'blur'}
          ],
          price: [
            {required: true, message: '价格不能为空', trigger: 'blur'},
            {type: 'string', pattern:/^(([1-9]\d{0,3})|0)(\.\d{0,2})?$/, message: '价格只能为正浮点数且不超过9999.99', trigger: 'blur'}
          ],
          intro: [
            {required: true, message: '简介不能为空', trigger: 'blur'}
          ],
          shopName: [
            {required: true, message: '出版社不能为空', trigger: 'blur'}
          ]
        },
        columns: [
          {
            type: 'expand',
            width: 50,
            render: (h, params) => {
              return h(ManageBookExpand, {
                props: {
                  row: params.row
                }
              })
            }
          },
          {
            title: '图片',
            key: 'img',
            width: 100,
            align: 'center',
            render: (h, params) => {
              if (params.row.$isEdit){
                return h('input', {
                  domProps: {
                    //value: params.row.cover,
                    type: "file",
                    style: "width: 100%; align: center; margin: 0"
                  },
                  on: {
                    getFile: function (event) {
                      this.file = event.target.files[0];
                      console.log(this.file);
                    },
                    // input: function (event) {
                    //   params.row.cover = event.target.value
                    // }
                  }
                });
              }
              else{
                return h('div', [
                  h('img', {
                    attrs: {
                      src: params.row.cover,
                      width: '80px'
                    }
                  })
                ]);
              }
            }
          },
          {
            title: '标题',
            key: 'title',
            align: 'center',
            editable: true,
            render: (h, params) => {
              if (params.row.$isEdit) {
                return h('input', {
                  domProps: {
                    value: params.row.title,
                    style: "width: 100%; align: center; margin: 0"
                  },
                  on: {
                    input: function (event) {
                      params.row.title = event.target.value
                    }
                  }
                });
              } else {
                return h('div', params.row.title);
              }
            }
          },
          {
            title: '作者',
            key: 'writer',
            align: 'center',
            editable: true,
            render: (h, params) => {
              if (params.row.$isEdit) {
                return h('input', {
                  domProps: {
                    value: params.row.writer,
                    style: "width: 100%; align: center; margin: 0"
                  },
                  on: {
                    input: function (event) {
                      params.row.writer = event.target.value
                    }
                  }
                });
              } else {
                return h('div', params.row.writer);
              }
            }
          },
          {
            title: 'ISBN',
            key: 'isbn',
            width: 150,
            align: 'center',
            editable: true,
            render: (h, params) => {
              if (params.row.$isEdit) {
                return h('input', {
                  domProps: {
                    value: params.row.isbn,
                    style: "width: 100%; align: center; margin: 0"
                  },
                  on: {
                    input: function (event) {
                      params.row.isbn = event.target.value
                    }
                  }
                });
              } else {
                return h('div', params.row.isbn);
              }
            }
          },
          {
            title: '库存量',
            key: 'remains',
            width: 75,
            align: 'center',
            editable: true,
            render: (h, params) => {
              if (params.row.$isEdit) {
                return h('input', {
                  domProps: {
                    value: params.row.remains,
                    style: "width: 100%; align: center; margin: 0"
                  },
                  on: {
                    input: function (event) {
                      params.row.remains = event.target.value
                    }
                  }
                });
              } else {
                return h('div', params.row.remains);
              }
            }
          },
          {
            title: '价格',
            width: 65,
            key: 'price',
            align: 'center',
            editable: true,
            render: (h, params) => {
              if (params.row.$isEdit) {
                return h('input', {
                  domProps: {
                    value: params.row.price,
                    style: "width: 100%; align: center; margin: 0"
                  },
                  on: {
                    input: function (event) {
                      params.row.price = event.target.value
                    }
                  }
                });
              } else {
                return h('div', params.row.price);
              }
            }
          },
          {
            title: '操作',
            key: 'action',
            width: 130,
            align: 'center',
            render: (h, params, index) => {
              return h('div', [
                h('Button', {
                  props: {
                    size: 'small',
                    type: params.row.$isEdit ? 'success' : 'primary',
                    loading: params.saving
                  },
                  style: {
                    marginRight: '5px'
                  },
                  on: {
                    click: () => {
                      if (params.row.$isEdit) {
                        this.handleSave(params.row)
                      } else {
                        this.handleEdit(params.row)
                      }
                    }
                  }
                  //
                  // on: {
                  //   click: () => {
                  //     this.change(params.index, params.row.id, params.row.valid)
                  //   }
                  // }
                }, params.row.$isEdit ? '保存' : '编辑'),
                h('Poptip', {
                    props: {
                      confirm: true,
                      title: "确认删除该书籍？",
                      transfer: true,
                      placement: 'left'
                    },
                    on: {
                      'on-ok': () => {
                        this.remove(params.index, params.row.id);
                      }
                    }
                  },
                  [h('Button', {
                    props: {
                      type: 'error',
                      size: 'small'
                    },
                    on: {
                      click: () => {
                        // this.remove(params.index, params.row.id);
                      }
                    }
                  }, '删除')])
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
