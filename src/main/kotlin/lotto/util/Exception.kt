package lotto.util

enum class Exception(private val message: String) {
    INVALID_PURCHASE_AMOUNT_FORMAT("구입 금액은 문자나 공백 입력이 허용되지 않는다."),
    INVALID_PURCHASE_AMOUNT_UNIT("구입 금액은 1,000원 단위로 입력 받는다.");

    fun getMessage() = "[ERROR] $message"
}