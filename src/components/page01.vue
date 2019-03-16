<template>
  <div>
    <ul class="toolbar">
      <li>
        <a href="#" class="filter-item active" data-group="all">All Categories</a>
        <a href="#" class="filter-item" data-group="fantasy">Fantasy</a>
        <a href="#" class="filter-item" data-group="sci-fi">Sci-Fi</a>
        <a href="#" class="filter-item" data-group="classic">Classics</a>
        <a href="#" class="filter-item" data-group="fairy">Fairy Tale</a>
        <a href="#" class="filter-item" data-group="young">Young Adult</a>
      </li>

      <li>
        <select class="sort-options">
          <option value="" disabled selected>Sort by</option>
          <option value="" >Featured</option>
          <option value="title">Alphabetical</option>
          <option value="date-created">Published</option>
        </select>
      </li>
    </ul>

      <div class="review">
        <ul>
          <li>
            <img src="../assets/baiyexing.png" width=200px>
            <table cellspacing="5">
                <tr v-for="(item,$index) in items1" @click="selectStyle1 (item, $index) " :class="{'active':item.active,'unactive':!item.active}" >
                    {{item.select}}
                </tr>
            </table>
          </li>
          <li>
            <img src="../assets/detective.jpg" width=200px>
            <table cellspacing="5">
              <tr v-for="(item,$index) in items2" @click="selectStyle2 (item, $index) " :class="{'active':item.active,'unactive':!item.active}" >
                {{item.select}}
              </tr>
            </table>
          </li>

          <li>
            <img src="../assets/fine.jpg" width=200px>
            <table cellspacing="5">
              <tr v-for="(item,$index) in items3" @click="selectStyle3 (item, $index) " :class="{'active':item.active,'unactive':!item.active}" >
                {{item.select}}
              </tr>
            </table>
          </li>
          <li>
            <img src="../assets/lily.jpg" width=200px>
            <table cellspacing="5">
              <tr v-for="(item,$index) in items4" @click="selectStyle4 (item, $index) " :class="{'active':item.active,'unactive':!item.active}" >
                {{item.select}}
              </tr>
            </table>
          </li>
          <li>
            <img src="../assets/where.jpg" width=200px>
            <table cellspacing="5">
              <tr v-for="(item,$index) in items5" @click="selectStyle5 (item, $index) " :class="{'active':item.active,'unactive':!item.active}" >
                {{item.select}}
              </tr>
            </table>
          </li>
          <li>
            <img src="../assets/king.jpg" width=200px>
            <table cellspacing="5">
              <tr v-for="(item,$index) in items6" @click="selectStyle6 (item, $index) " :class="{'active':item.active,'unactive':!item.active}" >
                {{item.select}}
              </tr>
            </table>
          </li>

        </ul>

      </div>



    <router-view></router-view>
  </div>
</template>

<script>
  import Vue from 'vue'

export default {
  name: 'page01',
  data () {
    return {
      active: true,
      count1: 0,
      count2: 0,
      count3: 0,
      count4: 0,
      count5: 0,
      count6: 0,
      items1: [
        {select:'Under the Midnight Sun'},
        {select:'Keigo Higashino'},
        {select:'$16.23'}
      ],
      items2: [
        {select:'A Detective Galileo Novel'},
        {select:'Keigo Higashino'},
        {select:'$13.51'}
      ],
      items3:[
        {select:'I\'m Fine and Neither Are You'},
        {select:'Camille Pagán'},
        {select:'$4.99'}
      ],
      items4:[
        {select:'A Lily in the Light'},
        {select:'Kristin Fields'},
        {select:'$4.99'}
      ],
      items5:[
        {select:'Where the Crawdads Sing'},
        {select:'Delia Owens'},
        {select:'$12.99'}
      ],
      items6:[
        {select:'A Clash of Kings'},
        {select:'George R. R. Martin'},
        {select:'$23.99'}
      ]
    }
  },
  methods: {
    selectStyle1 (item, index) {
      if(index==0){
        this.$nextTick(function () {
          this.count1++;
          //this.items1.forEach(function (item) {
            if(this.count1%2)
              Vue.set(item,'active',true);
          //});
          else
           Vue.set(item,'active',false);
        });
      }
    },
    selectStyle2 (item, index) {
      if(index==0){
        this.$nextTick(function () {
          this.count2++;
          //this.items1.forEach(function (item) {
          if(this.count2%2)
            Vue.set(item,'active',true);
          //});
          else
            Vue.set(item,'active',false);
        });
      }
    },
    selectStyle3 (item, index) {
      if(index==0){
        this.$nextTick(function () {
          this.count3++;
          //this.items1.forEach(function (item) {
          if(this.count3%2)
            Vue.set(item,'active',true);
          //});
          else
            Vue.set(item,'active',false);
        });
      }
    },
    selectStyle4 (item, index) {
      if(index==0){
        this.$nextTick(function () {
          this.count4++;
          //this.items1.forEach(function (item) {
          if(this.count4%2)
            Vue.set(item,'active',true);
          //});
          else
            Vue.set(item,'active',false);
        });
      }
    },
    selectStyle5 (item, index) {
      if(index==0){
        this.$nextTick(function () {
          this.count5++;
          //this.items1.forEach(function (item) {
          if(this.count5%2)
            Vue.set(item,'active',true);
          //});
          else
            Vue.set(item,'active',false);
        });
      }
    },
    selectStyle6 (item, index) {
      if(index==0){
        this.$nextTick(function () {
          this.count6++;
          //this.items1.forEach(function (item) {
          if(this.count6%2)
            Vue.set(item,'active',true);
          //});
          else
            Vue.set(item,'active',false);
        });
      }
    }
  }
}


</script>

<style>
.toolbar a{
  display: inline;
  width: 20%;

}

.review a{
    display: inline;
  }


.tbl-header{
  background-color: rgba(255,255,255,0.3);
}

.tbl-content{
  height:100px;
  overflow-x:auto;
  margin-top: 0px;
  border: 1px solid rgba(255,255,255,0.3);
}
th{
  padding: 2px 5px;
  text-align: left;
  font-weight: 100;
  font-size: 12px;
  color: #fff;
  text-transform: uppercase;
}
td{
  padding: 1px;
  text-align: left;
  vertical-align:middle;
  font-weight: 300;
  font-size: 12px;
  color: #fff;
  border-bottom: solid 1px rgba(255,255,255,0.1);
}

.review ul li {
  display: inline-block;
  margin-right: 2px;
  width: 400px;
}

.active{
  color:red;
}
.unactive{
  　　　　color:#000;
}
.icon{
  　　float: right;
  　　font-size:12px;
}

</style>
