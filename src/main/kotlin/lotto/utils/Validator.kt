package lotto.utils

import lotto.utils.Constants.LOTTO_AMOUNT

object Validator {
    fun validatePurchaseAmount(input: String): Int {
        val purchaseAmount = input.toIntOrNull() ?: 0
        validatePurchaseAmountRange(purchaseAmount)
        validatePurchaseAmountUnit(purchaseAmount)
        return purchaseAmount
    }

    private fun validatePurchaseAmountRange(purchaseAmount: Int) {
        require(purchaseAmount >= LOTTO_AMOUNT) { Exception.INVALID_PURCHASE_AMOUNT_RANGE.getMessage() }
    }

    private fun validatePurchaseAmountUnit(purchaseAmount: Int) {
        require(purchaseAmount % LOTTO_AMOUNT == 0) { Exception.INVALID_PURCHASE_AMOUNT_UNIT.getMessage() }
    }
}