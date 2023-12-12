package lotto.utils

import lotto.utils.Constants.LOTTO_AMOUNT
import lotto.utils.Constants.LOTTO_COUNT
import lotto.utils.Constants.LOTTO_END_NUMBER
import lotto.utils.Constants.LOTTO_START_NUMBER

object Validator {
    fun validatePurchaseAmount(purchaseAmount: String): Int {
        val validPurchaseAmount = purchaseAmount.toIntOrNull() ?: 0
        validatePurchaseAmountRange(validPurchaseAmount)
        validatePurchaseAmountUnit(validPurchaseAmount)
        return validPurchaseAmount
    }

    private fun validatePurchaseAmountRange(purchaseAmount: Int) {
        require(purchaseAmount >= LOTTO_AMOUNT) { Exception.INVALID_PURCHASE_AMOUNT_RANGE.getMessage() }
    }

    private fun validatePurchaseAmountUnit(purchaseAmount: Int) {
        require(purchaseAmount % LOTTO_AMOUNT == 0) { Exception.INVALID_PURCHASE_AMOUNT_UNIT.getMessage() }
    }

    fun validateWinningNumbers(winningNumbers: String): List<Int> {
        val validWinningNumbers = winningNumbers.split(",").map { winningNumber ->
            validateWinningNumber(winningNumber)
        }
        validateWinningNumbersSize(validWinningNumbers)
        validateWinningNumbersDuplicate(validWinningNumbers)
        return validWinningNumbers
    }

    private fun validateWinningNumber(winningNumber: String): Int {
        val validWinningNumber = winningNumber.toIntOrNull() ?: 0
        validateWinningNumberRange(validWinningNumber)
        return validWinningNumber
    }

    private fun validateWinningNumberRange(winningNumber: Int) {
        require(winningNumber in LOTTO_START_NUMBER..LOTTO_END_NUMBER) { Exception.INVALID_WINNING_NUMBER_RANGE.getMessage() }
    }

    private fun validateWinningNumbersSize(winningNumbers: List<Int>) {
        require(winningNumbers.size == LOTTO_COUNT) { Exception.INVALID_WINNING_NUMBERS_SIZE.getMessage() }
    }

    private fun validateWinningNumbersDuplicate(winningNumbers: List<Int>) {
        require(winningNumbers.toSet().size == LOTTO_COUNT) { Exception.INVALID_WINNING_NUMBERS_DUPLICATE.getMessage() }
    }
}