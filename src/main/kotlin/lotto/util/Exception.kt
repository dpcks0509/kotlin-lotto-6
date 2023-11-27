package lotto.util

enum class Exception(private val message: String) {
    INVALID_PURCHASE_AMOUNT_FORMAT("구입 금액은 문자나 공백 입력이 허용되지 않는다."),
    INVALID_PURCHASE_AMOUNT_UNIT("구입 금액은 1,000원 단위로 입력 받는다."),
    INVALID_WINNING_NUMBER_FORMAT("당첨 번호는 문자나 공백 입력이 허용되지 않는다."),
    INVALID_WINNING_NUMBER_RANGE("당첨 번호의 숫자 범위는 1~45까지이다."),
    INVALID_WINNING_NUMBERS_COUNT("당첨 번호의 개수는 6개 이다."),
    INVALID_WINNING_NUMBERS_NO_DUPLICATE("당첨 번호는 중복되지 않는다."),
    INVALID_BONUS_NUMBER_FORMAT("보너스 번호는 문자나 공백 입력이 허용되지 않는다."),
    INVALID_BONUS_NUMBER_RANGE("보너스 번호의 숫자 범위는 1~45까지이다."),
    INVALID_BONUS_NUMBER_NO_DUPLICATE("보너스 번호는 당첨 번호와 중복되지 않는다.");

    fun getMessage() = "[ERROR] $message"
}