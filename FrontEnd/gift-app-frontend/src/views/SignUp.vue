<template>
    <div class="container">
        <base-form>
            <label for="username">Username</label>
            <input type="text" id="username" v-model="inputtedUsername" />
            <label for="password">Password</label>
            <input type="password" id="password" v-model="inputtedPassword" />
            <label for="retype-password">Type Password Again</label>
            <input
                type="password"
                id="retype-password"
                v-model="retypedPassword"
            />
            <p v-if="errMessage">{{ errMessage }}</p>
            <base-button mode="outlined" @click="signUp">Sign Up</base-button>
        </base-form>
    </div>
</template>

<script>
import BaseForm from '@/UI/BaseForm'
import BaseButton from '@/UI/BaseButton'
import axios from 'axios'
export default {
    data() {
        return {
            inputtedUsername: '',
            inputtedPassword: '',
            retypedPassword: '',
            errMessage: '',
        }
    },
    watch: {
        inputtedUsername() {
            this.errMessage = ''
        },
        inputtedPassword() {
            this.errMessage = ''
        },
        retypedPassword() {
            this.errMessage = ''
        },
    },
    methods: {
        signUp() {
            if (
                !this.inputtedUsername ||
                !this.inputtedPassword ||
                !this.retypedPassword
            ) {
                this.errMessage = 'Please fill all fields!'
            } else if (this.inputtedPassword !== this.retypedPassword) {
                this.errMessage = `Password doesn't match!`
            } else {
                axios
                    .post(
                        'http://tonydomain.ddns.net:8080/giftapp/api/accounts/signup',
                        {
                            username: this.inputtedUsername,
                            password: this.inputtedPassword,
                        }
                    )
                    .then((res) => {
                        if (res.status === 201) {
                            this.$router.push('redirecting')
                        }
                    })
                    .catch(
                        () => (this.errMessage = 'Username is already taken!')
                    )
            }
        },
    },
    components: { BaseForm, BaseButton },
}
</script>

<style scoped lang="scss">
.container {
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
}

label {
    margin-top: 1rem;
    font-size: 0.8rem;
    color: var(--primary);
}

input {
    margin-top: 0.3rem;
    width: 15rem;
    padding: 0.25rem 0.6rem;
    color: #212121;
    border: none;
    outline: none;
    border-bottom: 2px solid #212121;
}

button {
    margin-top: 2.2rem;
}

p {
    font-size: 0.7rem;
    color: #44a;
    margin-top: 1rem;
}
</style>
