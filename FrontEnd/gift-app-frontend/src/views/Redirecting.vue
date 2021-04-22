<template>
    <p>Successfully. Redirecting to homepage...</p>
</template>

<script>
export default {
    created() {
        setTimeout(() => {
            this.$router.push('/')
        }, 2000)
    },
}
</script>

<style scoped>
p {
    margin-top: 2rem;
}
</style>
