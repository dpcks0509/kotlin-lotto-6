package lotto.controller

import lotto.model.Purchase
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        val purchaseAmount = inputView.readPurchaseAmount()
        val purchase = Purchase(purchaseAmount)
        outputView.printPurchaseCount(purchase.getCount())
    }
}