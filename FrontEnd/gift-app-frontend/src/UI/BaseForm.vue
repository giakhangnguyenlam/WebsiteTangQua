<template>
    <form @submit.prevent=""><slot></slot></form>
</template>

<script>
export default {}
</script>

<style scoped lang="scss">
form {
    display: flex;
    flex-direction: column;
    padding: 1rem 3.5rem;
    background: #fff;
    border-radius: 4px;
}
</style>
