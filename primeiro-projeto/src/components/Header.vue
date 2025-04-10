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

        name: "Header"

    }

</script>

<style scoped>
header{
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 10px 0;
    background-color: black;
}

.header-content{
    display: flex;
    gap: 24px;
}


.buttons-header {
  padding: 12px 24px; 
  background-color: #8A9A5B;
  color: white;
  border: none;
  border-radius: 4px;
  font-weight: 500;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.buttons-header:hover {
  background-color: #76804F; 
}
</style>