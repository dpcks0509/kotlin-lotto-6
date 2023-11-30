package lotto.model

class Bonus(private val number: Int) {
    fun judgeBonusMatching(purchaseNumbers: List<Int>): Boolean {
        return purchaseNumbers.contains(number)
    }

    fun getBonusNumber() = number
}