package lotto.model

import lotto.utils.Constants.LOTTO_AMOUNT

class Purchase(private val amount: Int) {
    private val count = calculateCount()

    private fun calculateCount(): Int {
        return amount / LOTTO_AMOUNT
    }

    fun getCount() = count
}