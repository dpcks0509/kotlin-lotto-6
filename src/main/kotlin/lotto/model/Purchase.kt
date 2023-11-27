package lotto.model

import lotto.util.Constants.LOTTO_UNIT

class Purchase(private val amount: Int) {
    private var count = 0
    
    init {
        count = calculatePurchaseCount()
    }

    private fun calculatePurchaseCount(): Int {
        return amount / LOTTO_UNIT
    }

    fun getAmount() = amount
    fun getCount() = count
}