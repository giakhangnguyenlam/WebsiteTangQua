<template>
    <header>
        <div class="logo">
            <img src="@/assets/logo.svg" alt="logo" />
            <span>GiftApp</span>
        </div>
        <nav>
            <router-link tag="base-button" to="/sign-in">
                <base-button>Sign In</base-button>
            </router-link>
            <router-link tag="base-button" to="/sign-up">
                <base-button mode="outlined">Sign Up</base-button>
            </router-link>
        </nav>
    </header>
</template>

<script>
import BaseButton from '@/UI/BaseButton'
export default {
    components: { BaseButton },
}
</script>

<style lang="scss" scoped>
@import url('https://fonts.googleapis.com/css2?family=Orelega+One&display=swap');
header {
    margin-top: 1rem;
    display: flex;
    justify-content: space-between;
    align-items: center;
}
nav {
    button:last-child {
        margin-left: 1rem;
    }
}

.logo {
    display: flex;
    align-items: center;
    img {
        width: 2.7rem;
    }
    span {
        font-family: 'Orelega One', cursive;
        font-size: 1.5rem;
        color: var(--primary);
        margin-left: 0.5rem;
    }
}
</style>
