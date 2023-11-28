package lotto.model

class WinningLotto(private val numbers: List<Int>, private val bonusNumber: Int) {
    fun getWinningNumbers() = numbers
    fun getBonusNumber() = bonusNumber
}