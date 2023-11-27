package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Validator.validatePurchaseAmount

class InputView {
    fun readPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val purchaseAmount = Console.readLine()
        return validatePurchaseAmount(purchaseAmount)
    }
}