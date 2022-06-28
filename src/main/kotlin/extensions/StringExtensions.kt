package extensions


// 입력에 대한 예외처리를 해주는 함수 두가지 작성

fun String?.getNotEmptyString(): String{   // nullable string type 기능의 extension
    var input = this
    while(input.isNullOrBlank()){   
        println("값을 입력해주세요")    // input 값이 null 이나 blank 이면, 다시입력하라는 안내문 띄움
        input = readLine()          // 재입력 받음
    }

    return input.trim()         // 입력된값 앞뒤 공백 제거
}

fun String?.getNotEmptyInt(): Int{      // nullable string type 기능의 extention
    var input = this?.trim()
    while(input.isNullOrEmpty() || input.toIntOrNull() == null){    // input 값이 int로 변환할수 있는지 확인하는 역할
        println("값을 입력해주세요")
        input = readLine()
    }
    return input.toInt()
}