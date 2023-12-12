package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.utils.Validator.validatePurchaseAmount
import lotto.utils.Validator.validateWinningNumbers

class InputView {
    fun readPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val purchaseAmount = Console.readLine()
        return try {
            validatePurchaseAmount(purchaseAmount)
        } catch (exception: IllegalArgumentException) {
            println(exception.message)
            readPurchaseAmount()
        }
    }

    fun readWinningNumbers(): List<Int> {
        println()
        println("당첨 번호를 입력해 주세요.")
        val winningNumbers = Console.readLine()
        return try {
            validateWinningNumbers(winningNumbers)
        } catch (exception: IllegalArgumentException) {
            println(exception.message)
            readWinningNumbers()
        }
    }
}