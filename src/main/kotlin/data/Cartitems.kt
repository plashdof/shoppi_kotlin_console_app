package data

object Cartitems {

// project 전역에서 사용하므로, 항상 같은값 유지되어야함. -> 싱글톤으로 생성
    private val mutableProducts = mutableMapOf<Product, Int>()      //  변화 가능 변수
    val products: Map<Product, Int> = mutableProducts       //  변화 불가 변수

    fun addProduct(product: Product){
        mutableProducts[product]?.let {     // 장바구니에 이미 들어있으면, 기존수량 + 1
            mutableProducts[product] = it + 1
        } ?: kotlin.run{                    // 장바구니에 없으면, 1 기입
            mutableProducts[product] = 1
        }
    }
}