<template>
  <div class="book">
    <ul class="books">
      <li>
        <img src="../assets/baiyexing.png" width=250px>
      </li>
      <li class="detail">
        <h2>Under the Midnight Sun</h2>
        <h4>by Keigo Higashino</h4>
        <h6>Price: $16.23</h6>
        <div class="detail">
          <br>
          &nbsp&nbsp From the acclaimed international bestseller Keigo Higashino (The Devotion of Suspect X) comes a sweeping novel in the tradition of Les Miserables and Crime and Punishment. This is the compelling story of a brutal crime and the two teenagers―Ryo, the son of the murdered man, and Yukiho, the daughter of the main suspect―whose lives remain inextricably linked over the twenty-year search for the truth behind the crime.
          <br>
          &nbsp&nbsp In Osaka in 1973, the body of a murdered man is found in an abandoned building. Investigating the crime, Detective SasagakI is unable to find the killer. Over the next twenty years, through the lens of a succession of characters, Higashino tells the story of two teens, Ryo and Yukiho, whose lives are most affected by the crime, and the obsessed detective, Sasagaki, who continues to investigate the murder, looking for the elusive truth.
          <br>
          &nbsp&nbsp Under the Midnight Sun is a complex, psychological novel about crime and its after-effects by one the most read and most accomplished contemporary mystery author. A twisting, compelling work that will astonish and delight Higashino’s old fans and new reigars alike.
        </div>

      </li>


    </ul>



  </div>
</template>

<script>
  export default {
    name: '',
    data () {
      return {

      }
    },
    components: {}
  }
</script>

<style>
.books li{
  display: inline-block;
  padding-left: 30px;
}

li{
  display: inline;
}

  .detail{
    width: 600px;
    color: #ffffff;
  }


</style>
