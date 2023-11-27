package lotto.controller

import lotto.model.Purchase
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()
    fun run() {
        val purchase = Purchase(inputView.readPurchaseAmount())
    }
}