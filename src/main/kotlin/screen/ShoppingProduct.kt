package screen

import data.Cartitems
import data.Product

class ShoppingProduct {

    private val products = arrayOf(
        Product("패션", "겨울 패딩"),
        Product("패션", "겨울 바지"),
        Product("전자기기", "핸드폰"),
        Product("전자기기", "블루투스 이어폰"),
        Product("반려동물용품", "건식사료"),
        Product("반려동물용품", "습식사료"),
        Product("반려동물용품", "치약"),
        Product("반려동물용품", "간식")
    )

    private val categories: Map<String, List<Product>> = products.groupBy{
        product -> product.categoryLabel
    }

    fun showProducts(selectedCategory: String){
        val categoryProducts = categories[selectedCategory]
        if(!categoryProducts.isNullOrEmpty()){
            println("""
                ***==================================***
                선택하신 [$selectedCategory] 카테고리 상품입니다.
            """.trimIndent())

            /*
            val productSize = categoryProducts.size
            for(index in 0 until productSize){
                print("${index}, ${categoryProducts[index].name} ")
            }
            */
            // 위의 for문을, 고차함수 형태로 변환!!
            categoryProducts.forEachIndexed{ index, product ->
                println("${index}, ${product.name}")
            }
            showCartOption(categoryProducts, selectedCategory)
        } else{
            showEmptyProductMessage(selectedCategory)
        }
    }

    private fun showCartOption(categoryProducts : List<Product>, selectedCategory : String){
        println(
            """
                ***==============================*** 
                장바구니에 담을 상품 번흐를 선택하세요
            """.trimIndent()
        )

        val selectedIndex = readLine()?.toIntOrNull()!!     // Int로 변환, 변환못하면 Null로 변환
        categoryProducts.getOrNull(selectedIndex)?.let{ product ->      // getOrNull  :  지정된 인덱스의 value를 반환하거나, 없으면 Null 반환
            Cartitems.addProduct(product)
            println("=> 장바구니로 이동하시려면 #를, 계속 쇼핑하시려면 *를 입력해주세요")
            val answer = readLine()
            if(answer == "#"){
                val shoppingCart = ShoppingCart()
                shoppingCart.showCartItems()
            } else if(answer == "*"){
                showProducts(selectedCategory)
            } else{
                // TODO 그 외 값을 입력한 경우에 대한 처리
            }
        }
    }

    private fun showEmptyProductMessage(selectedCategory: String){
        println("[$selectedCategory] 카테고리 상품이 등록되기 전입니다.")
    }
}