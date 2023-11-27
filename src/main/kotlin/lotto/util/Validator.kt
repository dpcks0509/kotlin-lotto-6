package lotto.util

import lotto.util.Constants.LOTTO_UNIT

object Validator {
    fun validatePurchaseAmount(purchaseAmount: String): Int {
        validatePurchaseAmountFormat(purchaseAmount)
        validatePurchaseAmountUnit(purchaseAmount)
        return purchaseAmount.toInt()
    }

    private fun validatePurchaseAmountFormat(purchaseAmount: String) {
        requireNotNull(purchaseAmount.toIntOrNull()) { Exception.INVALID_PURCHASE_AMOUNT_FORMAT.getMessage() }
    }

    private fun validatePurchaseAmountUnit(purchaseAmount: String) {
        require(purchaseAmount.toInt() % LOTTO_UNIT == 0) { Exception.INVALID_PURCHASE_AMOUNT_UNIT.getMessage() }
    }
}