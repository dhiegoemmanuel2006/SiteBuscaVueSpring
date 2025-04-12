<template>
    <header>
        <div class="header-content">
            <button @click="$router.push('/inicio')" class="buttons-header">Home</button>
            <button @click="$router.push('/busca')" class="buttons-header">Busca</button>
        </div>
    </header>

</template>

<script>

    export default{

        name: "HeaderComponent",

    }

</script>

<style scoped>
*{
  padding: 0;
  margin: 0;
}


header {
  width: 100%;
  margin: 0;
  padding: 20px 0;
  background-color: black;
  font-family: Helvetica, Arial, sans-serif;
  font-weight: bold;
  text-align: center;
}

header button {
  background-color: green;
  color: white;
  padding: 10px 20px;
  margin: 0 10px;
  border: none;
  border-radius: 5px;
  font-weight: bold;
  cursor: pointer;
  transition: background-color 0.3s;
}
header button:hover {
  background-color: #006400;
}
</style>
