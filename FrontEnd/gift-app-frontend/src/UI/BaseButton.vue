<template>
    <button :class="mode">
        <slot></slot>
    </button>
</template>

<script>
export default {
    props: ['mode'],
}
</script>

<style lang="scss" scoped>
button {
    color: var(--primary);
    border: none;
    background: none;
    text-transform: uppercase;
    transition: all 0.2s ease;
    cursor: pointer;
    &:hover {
        transform: translateY(-2px);
        color: #fff;
    }
    &.outlined {
        padding: 0.5rem 1rem;
        color: #212121;
        background: var(--primary);
        &:hover {
            color: #fff;
        }
    }
}
</style>
