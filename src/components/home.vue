<template>
  <div>
    <div class="home">
      <ul>
        <li>
          <table cellspacing="20">
            <tr>
              <td>Popular in Books</td>
            </tr>
            <tr>
              <td>Textbooks</td>
            </tr>
            <tr>
              <td>Books</td>
            </tr>
            <tr>
              <td>Format</td>
            </tr>
            <tr>
              <td>Author</td>
            </tr>
            <tr>
              <td>Book Series</td>
            </tr>
            <tr>
              <td>Language</td>
            </tr>
            <tr>
              <td>Avg. Customer Review</td>
            </tr>
            <tr>
              <td>Condition</td>
            </tr>
          </table>
        </li>
        <li>
          <div class="mainland">
            <img src="../assets/books.jpg" width="930px" height="500px">
          </div>
        </li>

      </ul>





    </div>
  </div>
</template>

<script>

  export default {
    name: 'home',
    data () {
      return {

      }
    },
    components: {}
  }
</script>

<style>
li{
display: inline;
}

table{
  width: "10px";
  table-layout: fixed;
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
  padding: 8px;
  text-align: left;
  vertical-align:middle;
  font-weight: 300;
  font-size: 12px;
  color: #fff;
  border-bottom: solid 1px rgba(255,255,255,0.1);
}


/* demo styles */

@import url(https://fonts.googleapis.com/css?family=Roboto:400,500,300,700);
body{
  background: -webkit-linear-gradient(left, #25c481, #25b7c4);
  background: linear-gradient(to right, #25c481, #25b7c4);
  font-family: 'Roboto', sans-serif;
}
section{
  margin: 50px;
}


/* follow me template */
.made-with-love {
  margin-top: 40px;
  padding: 10px;
  clear: left;
  text-align: center;
  font-size: 10px;
  font-family: arial;
  color: #fff;
}
.made-with-love i {
  font-style: normal;
  color: #F50057;
  font-size: 14px;
  position: relative;
  top: 2px;
}
.made-with-love a {
  color: #fff;
  text-decoration: none;
}
.made-with-love a:hover {
  text-decoration: underline;
}


/* for custom scrollbar for webkit browser*/

::-webkit-scrollbar {
  width: 6px;
}
::-webkit-scrollbar-track {
  -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
}
::-webkit-scrollbar-thumb {
  -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
}

</style>
