<template>
  <form @submit.prevent="onSubmit">
    <!-- @submit.prevent 는 html에서 제공하는 기본 submit 기능을 막고, 
    개발자가 직접 입력한 커스텀 메서드인 onSubmit을 사용하기 위해 쓴다. ($emit때문에?) -->
    <table>
        <tr>
            <td>상품명</td>
            <td>
                <input type="text" v-model="productName"/>
            </td>
        </tr>
        <tr>
            <td>작성자</td>
            <td>
                <input type="text" v-model="writer"/>
            </td>
        </tr>
        <tr>
            <td>본문</td>
            <td>
                <textarea cols="50" rows="20" v-model="content"/>
            </td>
        </tr>
        <tr>
            <td>상품 사진</td>
            <td>
                <input type="file" id="files" ref="files"
                    multiple @change="handleFileUpload"/>
            </td>
        </tr>
        <tr>
            <td>가격</td>
            <td>
                <input type="number" v-model="price"/>
            </td>
        </tr>
    </table>
    <div>
        <button type="submit">등록</button>
        <router-link :to="{ name: 'ProductListPage' }">
            취소
        </router-link>
    </div>
  </form>
</template>

<script>

export default {
    name: "ProductRegisterForm",
    data () {
        return {
            productName: '상품명',
            writer: '작성자',
            content: '내용을 입력하세요.',
            price: 0,
            files: '',
        }
    },
    methods: {
        onSubmit () {
            let formData = new FormData()
            // 사진
            for (let idx = 0; idx < this.files.length; idx++) {
                formData.append('imageFileList', this.files[idx])
            }
            const { productName, writer, content, price } = this
            let productInfo = {
                productName: productName,
                writer: writer,
                content: content,
                price: price,
            }
            console.log('productInfo: ' + JSON.stringify(productInfo))
            // 글자
            formData.append(
                "productInfo",
                new Blob([JSON.stringify(productInfo)], { type: "application/json" })
            )
            console.log('formData: ' + JSON.stringify(formData))
            this.$emit('submit', formData)
        },
        handleFileUpload () {
            this.files = this.$refs.files.files
        },
    }
}
</script>

<style scoped>

</style>