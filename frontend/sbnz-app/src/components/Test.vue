<template>
  <div class="hello">
    <h1>Recite nam nesto vise o sebi...</h1>
    <table class="center">
      <tr>
        <td>Da li Vam smeta buka? </td>
        <td>
          <input type="radio" id="da" value="Da" v-model="picked">
          <label for="da">Da</label>
          <br>
        </td>
        <td>
          <input type="radio" id="ne" value="Ne" v-model="picked">
          <label for="ne">Ne</label>
          <br>
        </td>
      </tr>
      <!-- <tr>
        <td>Da li preferirate aktivan odmor? </td>
        <td>
          <input type="radio" id="da" value="Da" v-model="picked1">
          <label for="da">Da</label>
          <br>
        </td>
        <td>
          <input type="radio" id="ne" value="Ne" v-model="picked1">
          <label for="ne">Ne</label>
          <br>
        </td>
        <td><span>Picked: {{ picked1 }}</span></td>
      </tr> -->

    </table>
    <button @click="getSomeData">Posalji</button><br><br>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'Test',
  data(){
    return{
      picked : null
    }
  },
  //  mounted() {
  //   this.getSomeData()
  // },
  methods : {
    getSomeData() {
       const odgovor = {
                'mir': false
            }
      //  console.log(this.picked)
      //   console.log(odgovor)
       if(this.picked=="Da"){
         odgovor.mir=true
       }else{
         odgovor.mir=false
       }
       console.log(odgovor)
       axios.post('http://localhost:8080/odgovor/nesto', odgovor).then(response => {
                    if (response.status == 200){
                        console.log("PROSAOOOOO")
                    } 
                })
        
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    .center{
      margin-left:auto;
      margin-right:auto;
    }
</style>
