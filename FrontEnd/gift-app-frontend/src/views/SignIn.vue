<template>
    <div class="container">
        <base-form>
            <label for="username">Username</label>
            <input type="text" id="username" v-model="inputtedUsername" />
            <label for="password">Password</label>
            <input type="password" id="password" v-model="inputtedPassword" />
            <div class="role-select">
                <input
                    type="radio"
                    name="role"
                    v-model="role"
                    id="normal-user"
                    value="1"
                    checked
                />
                <label for="normal-user">User</label>
                <input
                    type="radio"
                    name="role"
                    v-model="role"
                    id="admin"
                    value="0"
                />
                <label for="admin">Admin</label>
            </div>
            <p v-if="errMessage">{{ errMessage }}</p>
            <base-button mode="outlined" @click="signIn">Sign In</base-button>
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
            role: '1',
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
    components: { BaseForm, BaseButton },
    methods: {
        signIn() {
            if (!this.inputtedUsername || !this.inputtedPassword) {
                this.errMessage = 'Please fill all fields!'
            } else {
                axios
                    .post(
                        'http://tonydomain.ddns.net:8080/giftapp/api/accounts/signin',
                        {
                            username: this.inputtedUsername,
                            password: this.inputtedPassword,
                            accountType: this.role,
                        }
                    )
                    .then((res) => {
                        if (res.status === 200) {
                            this.$router.push('redirecting')
                        }
                    })
                    .catch(
                        () =>
                            (this.errMessage =
                                'Username or password is incorrect!')
                    )
            }
        },
    },
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

.role-select {
    margin-top: 1rem;
    display: flex;
    align-items: center;
    input {
        margin-top: 0;
        max-width: 20px;
        max-height: 20px;
        &:last-of-type {
            margin-left: 1rem;
        }
    }
    label {
        margin-top: 0;
        margin-left: 0.25rem;
    }
}

p {
    font-size: 0.7rem;
    color: #44a;
    margin-top: 1rem;
}
</style>
