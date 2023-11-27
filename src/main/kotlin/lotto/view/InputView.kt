package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Validator.validateBonusNumber
import lotto.util.Validator.validatePurchaseAmount
import lotto.util.Validator.validateWinningNumbers

class InputView {
    fun readPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val purchaseAmount = Console.readLine()
        return validatePurchaseAmount(purchaseAmount)
    }

    fun readWinningNumbers(): List<Int> {
        println()
        println("당첨 번호를 입력해 주세요.")
        val winningNumbers = Console.readLine()
        return validateWinningNumbers(winningNumbers)
    }

    fun readBonusNumber(winningNumber: List<Int>): Int {
        println()
        println("보너스 번호를 입력해 주세요.")
        val bonusNumber = Console.readLine()
        return validateBonusNumber(bonusNumber, winningNumber)
    }
}