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
              <tr>
                <td>Journey Under the Midnight Sun</td>
              </tr>
              <tr>
                <td>Keigo Higashino</td>
              </tr>
              <tr>
                <td>$16.23</td>
              </tr>
            </table>
          </li>
          <li>
            <img src="../assets/detective.jpg" width=200px>
            <table cellspacing="5">
              <tr>
                <td>A Detective Galileo Novel </td>
              </tr>
              <tr>
                <td>Keigo Higashino</td>
              </tr>
              <tr>
                <td>$13.51</td>
              </tr>
            </table>
          </li>

          <li>
            <img src="../assets/fine.jpg" width=200px>
            <table cellspacing="5">
              <tr>
                <td>I'm Fine and Neither Are You</td>
              </tr>
              <tr>
                <td>Camille Pagán</td>
              </tr>
              <tr>
                <td>$4.99</td>
              </tr>
            </table>
          </li>
          <li>
            <img src="../assets/lily.jpg" width=200px>
            <table cellspacing="5">
              <tr>
                <td>A Lily in the Light</td>
              </tr>
              <tr>
                <td>Kristin Fields</td>
              </tr>
              <tr>
                <td>$4.99</td>
              </tr>
            </table>
          </li>
          <li>
            <img src="../assets/where.jpg" width=200px>
            <table cellspacing="5">
              <tr>
                <td>Where the Crawdads Sing</td>
              </tr>
              <tr>
                <td>Delia Owens</td>
              </tr>
              <tr>
                <td>$12.99</td>
              </tr>
            </table>
          </li>
          <li>
            <img src="../assets/king.jpg" width=200px>
            <table cellspacing="5">
              <tr>
                <td>A Clash of Kings</td>
              </tr>
              <tr>
                <td>George R. R. Martin </td>
              </tr>
              <tr>
                <td>$23.99</td>
              </tr>
            </table>
          </li>



        </ul>

      </div>



    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'page01',
  data () {
    return {

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


</style>
