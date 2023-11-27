package lotto.model

class Winning(private val numbers: List<Int>, private val bonusNumber: Int) {
    fun getWinningNumbers() = numbers
    fun getBonusNumber() = bonusNumber
}