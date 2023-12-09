package lotto.util

import lotto.util.Constants.LOTTO_NUMBER_COUNT
import lotto.util.Constants.LOTTO_NUMBER_END
import lotto.util.Constants.LOTTO_NUMBER_START
import lotto.util.Constants.LOTTO_UNIT

object Validator {
    fun validatePurchaseAmount(purchaseAmount: String): Int {
        validatePurchaseAmountRange(purchaseAmount)
        validatePurchaseAmountUnit(purchaseAmount)
        return purchaseAmount.toInt()
    }

    private fun validatePurchaseAmountRange(purchaseAmount: String) {
        require((purchaseAmount.toIntOrNull() ?: 0) >= 1000) { Exception.INVALID_PURCHASE_AMOUNT_RANGE.getMessage() }
    }

    private fun validatePurchaseAmountUnit(purchaseAmount: String) {
        require(purchaseAmount.toInt() % LOTTO_UNIT == 0) { Exception.INVALID_PURCHASE_AMOUNT_UNIT.getMessage() }
    }

    fun validateWinningNumbers(winningNumbers: String): List<Int> {
        val validWinningNumbers = winningNumbers.split(",").map { winningNumber ->
            validateWinningNumberFormat(winningNumber)
            validateWinningNumberRange(winningNumber)
            winningNumber.toInt()
        }
        validateWinningNumbersCount(validWinningNumbers)
        validateWinningNumbersNoDuplicate(validWinningNumbers)
        return validWinningNumbers
    }

    private fun validateWinningNumberFormat(winningNumber: String) {
        requireNotNull(winningNumber.toIntOrNull()) { Exception.INVALID_WINNING_NUMBER_FORMAT.getMessage() }
    }

    private fun validateWinningNumberRange(winningNumber: String) {
        require(winningNumber.toInt() in LOTTO_NUMBER_START..LOTTO_NUMBER_END) { Exception.INVALID_WINNING_NUMBER_RANGE.getMessage() }
    }

    private fun validateWinningNumbersCount(winningNumbers: List<Int>) {
        require(winningNumbers.size == LOTTO_NUMBER_COUNT) { Exception.INVALID_WINNING_NUMBERS_COUNT.getMessage() }
    }

    private fun validateWinningNumbersNoDuplicate(winningNumbers: List<Int>) {
        require(winningNumbers.toSet().size == LOTTO_NUMBER_COUNT) { Exception.INVALID_WINNING_NUMBERS_NO_DUPLICATE.getMessage() }
    }

    fun validateBonusNumber(bonusNumber: String, winningNumbers: List<Int>): Int {
        validateBonusNumberFormat(bonusNumber)
        validateBonusNumberRange(bonusNumber)
        validateBonusNumberNoDuplicate(bonusNumber, winningNumbers)
        return bonusNumber.toInt()
    }

    private fun validateBonusNumberFormat(bonusNumber: String) {
        requireNotNull(bonusNumber.toIntOrNull()) { Exception.INVALID_BONUS_NUMBER_FORMAT.getMessage() }
    }

    private fun validateBonusNumberRange(bonusNumber: String) {
        require(bonusNumber.toInt() in LOTTO_NUMBER_START..LOTTO_NUMBER_END) { Exception.INVALID_BONUS_NUMBER_RANGE.getMessage() }
    }

    private fun validateBonusNumberNoDuplicate(bonusNumber: String, winningNumbers: List<Int>) {
        require(!winningNumbers.contains(bonusNumber.toInt())) { Exception.INVALID_BONUS_NUMBER_NO_DUPLICATE.getMessage() }
    }
}