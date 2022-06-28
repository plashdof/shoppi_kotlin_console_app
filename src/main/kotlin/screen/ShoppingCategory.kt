package screen

import extensions.getNotEmptyInt
import extensions.getNotEmptyString

class ShoppingCategory : Screen() {

    fun showCategories() {
        ScreenStack.push(this)
        val categories = arrayOf("패션", "전자기기", "반려동물용품")

        for (category in categories) {
            println(category)
        }

        println("=> 장바구니로 이동하시려면 #을 입력해주세요")

        var selectedCategory = readLine().getNotEmptyString()

//        while (selectedCategory.isNullOrBlank()) {        // getNotEmptyString() 함수 사용했으므로, while문 안써도 됨
//            println("값을 입력해주세요")
//            selectedCategory = readLine()
//        }

        if (selectedCategory == "#") {

            val shoppingCart = ShoppingCart()
            shoppingCart.showCartItems()
        } else {

            if(categories.contains(selectedCategory)){
                val shoppingProductList = ShoppingProduct()
                shoppingProductList.showProducts(selectedCategory)
            } else{

                showErrorMessage(selectedCategory)
            }

        }
    }

    private fun showErrorMessage(selectedCategory: String?) {
        println("[$selectedCategory] : 존재하지 않는 카테고리입니다. 다시 입력하세요")
        showCategories()
    }
}