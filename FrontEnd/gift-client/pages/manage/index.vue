<template>
  <div>
    <h1 class="text-2xl font-semibold">
      Welcome to admin panel.
      <span class="text-xl font-normal"
        >You can manage items and giftpacks here!</span
      >
    </h1>
    <div class="mt-3">
      <div class="flex justify-between">
        <h2 class="text-lg font-semibold">All Items:</h2>
        <button
          class="text-blue-600 hover:underline"
          @click="isAddItemModalShowed = true"
        >
          New Item +
        </button>
      </div>
      <div class="grid grid-cols-4 gap-4 mt-2">
        <m-gift-card
          v-for="item in items"
          :key="item.cid"
          :item="item"
          @reloadItems="reloadItems"
        />
      </div>
    </div>

    <!-- Addon -->

    <div class="mt-3">
      <div class="flex justify-between">
        <h2 class="text-lg font-semibold">All Addons:</h2>
        <button
          class="text-blue-600 hover:underline"
          @click="isAddAddonModalShowed = true"
        >
          New Addon +
        </button>
      </div>
      <div class="grid grid-cols-4 gap-4 mt-2">
        <m-addon-card
          v-for="addon in addons"
          :key="addon.cid"
          :addon="addon"
          @reloadAddons="reloadAddons"
        />
      </div>
    </div>

    <!-- Add Item Modal -->

    <div
      v-if="isAddItemModalShowed"
      class="fixed top-0 bottom-0 left-0 right-0 flex items-center justify-center bg-gray-500  bg-opacity-70"
    >
      <div class="px-6 py-4 bg-white rounded-md">
        <h3 class="text-lg font-semibold">Add an item</h3>
        <div class="mt-3 space-y-2">
          <label class="flex flex-col space-y-1">
            <span>Name:</span>
            <input
              type="text"
              class="px-3 py-2 border border-blue-500 rounded-md focus:ring-1"
              v-model="newItem.itemName"
            /> </label
          ><label class="flex flex-col space-y-1">
            <span>Description:</span>
            <input
              type="text"
              class="px-3 py-2 border border-blue-500 rounded-md focus:ring-1"
              v-model="newItem.itemDescription"
            /> </label
          ><label class="flex flex-col space-y-1">
            <span>Price:</span>
            <input
              type="text"
              class="px-3 py-2 border border-blue-500 rounded-md focus:ring-1"
              v-model="newItem.price"
            /> </label
          ><label class="flex flex-col space-y-1">
            <span>Thumbnail URL:</span>
            <input
              type="text"
              class="px-3 py-2 border border-blue-500 rounded-md focus:ring-1"
              v-model="newItem.thumbnailimg"
            />
          </label>
        </div>
        <div class="flex justify-end mt-3 space-x-3">
          <button
            class="
              text-sm
              font-semibold
              bg-gray-500
              hover:bg-gray-400
              px-2.5
              py-1
              rounded-full
              text-white
            "
            @click="isAddItemModalShowed = false"
          >
            CANCEL
          </button>
          <button
            class="
              text-sm
              font-semibold
              hover:bg-yellow-400
              px-2.5
              py-1
              rounded-full
              text-white
            "
            :class="{
              'bg-yellow-500': !isAddDone,
              'bg-green-500': isAddDone,
            }"
            @click="handleAddItem"
          >
            {{ !isAddDone ? 'ADD' : 'DONE!' }}
          </button>
        </div>
      </div>
    </div>

    <!-- Add Addon Modal-->

    <div
      v-if="isAddAddonModalShowed"
      class="fixed top-0 bottom-0 left-0 right-0 flex items-center justify-center bg-gray-500  bg-opacity-70"
    >
      <div class="px-6 py-4 bg-white rounded-md">
        <h3 class="text-lg font-semibold">Add an addon</h3>
        <div class="mt-3 space-y-2">
          <label class="flex flex-col space-y-1">
            <span>Name:</span>
            <input
              type="text"
              class="px-3 py-2 border border-blue-500 rounded-md focus:ring-1"
              v-model="newAddon.aname"
            /> </label
          ><label class="flex flex-col space-y-1">
            <span>Description:</span>
            <input
              type="text"
              class="px-3 py-2 border border-blue-500 rounded-md focus:ring-1"
              v-model="newAddon.adescription"
            /> </label
          ><label class="flex flex-col space-y-1">
            <span>Price:</span>
            <input
              type="text"
              class="px-3 py-2 border border-blue-500 rounded-md focus:ring-1"
              v-model="newAddon.price"
            />
          </label>
        </div>
        <div class="flex justify-end mt-3 space-x-3">
          <button
            class="
              text-sm
              font-semibold
              bg-gray-500
              hover:bg-gray-400
              px-2.5
              py-1
              rounded-full
              text-white
            "
            @click="isAddAddonModalShowed = false"
          >
            CANCEL
          </button>
          <button
            class="
              text-sm
              font-semibold
              hover:bg-yellow-400
              px-2.5
              py-1
              rounded-full
              text-white
            "
            :class="{
              'bg-yellow-500': !isAddAddonDone,
              'bg-green-500': isAddAddonDone,
            }"
            @click="handleAddAddon"
          >
            {{ !isAddAddonDone ? 'ADD' : 'DONE!' }}
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import services from '@/services'
import MGiftCard from '@/components/MGiftCard.vue'
import MAddonCard from '@/components/MAddonCard.vue'
export default {
  data() {
    return {
      items: [],
      addons: [],
      isAddDone: false,
      isAddAddonDone: false,
      isAddItemModalShowed: false,
      isAddAddonModalShowed: false,
      newItem: {
        itemName: '',
        itemDescription: '',
        thumbnailimg: '',
        price: '',
        activeState: 1,
      },
      newAddon: {
        aname: '',
        adescription: '',
        price: '',
      },
    }
  },
  components: {
    MGiftCard,
    MAddonCard,
  },
  created() {
    services
      .getItems()
      .then((res) => (this.items = [...res.data]))
      .catch((err) => console.log(err))
    this.$axios
      .get('http://tonydomain.ddns.net:8080/giftapp/api/addons')
      .then((res) => {
        this.addons = [...res.data]
      })
      .catch((err) => console.log(err))
  },
  methods: {
    handleAddItem() {
      const item = {
        itemName: this.newItem.itemName,
        itemDescription: this.newItem.itemDescription,
        thumbnailimg: this.newItem.thumbnailimg,
        price: this.newItem.price,
        activeState: 1,
      }
      this.$axios
        .post('http://tonydomain.ddns.net:8080/giftapp/api/items', item)
        .then((res) => {
          if (res.status === 201) {
            services
              .getItems()
              .then((res) => {
                this.isAddDone = true
                this.items = [...res.data]
                setTimeout(() => {
                  this.isAddItemModalShowed = false
                  this.isAddDone = false
                }, 300)
              })
              .catch((err) => console.log(err))
          }
        })
        .catch((err) => console.log(err))
    },
    reloadItems() {
      services
        .getItems()
        .then((res) => (this.items = [...res.data]))
        .catch((err) => console.log(err))
    },
    reloadAddons() {
      this.$axios
        .get('http://tonydomain.ddns.net:8080/giftapp/api/addons')
        .then((res) => {
          this.addons = [...res.data]
        })
        .catch((err) => console.log(err))
    },
    handleAddAddon() {
      const addon = {
        aname: this.newAddon.aname,
        adescription: this.newAddon.adescription,
        price: this.newAddon.price,
      }
      this.$axios
        .post('http://tonydomain.ddns.net:8080/giftapp/api/addons', addon)
        .then((res) => {
          if (res.status === 201) {
            this.$axios
              .get('http://tonydomain.ddns.net:8080/giftapp/api/addons')
              .then((res) => {
                this.isAddAddonDone = true
                this.addons = [...res.data]
                setTimeout(() => {
                  this.isAddAddonModalShowed = false
                  this.isAddAddonDone = false
                }, 300)
              })
              .catch((err) => console.log(err))
          }
        })
        .catch((err) => console.log(err))
    },
  },
}
</script>
