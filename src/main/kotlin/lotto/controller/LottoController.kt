package lotto.controller

import lotto.model.Purchase
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()
    fun run() {
        val purchase = purchaseLottos()
        getPurchaseInfo(purchase)
    }

    private fun purchaseLottos(): Purchase {
        val purchaseAmount = inputView.readPurchaseAmount()
        return Purchase(purchaseAmount)
    }

    private fun getPurchaseInfo(purchase: Purchase) {
        outputView.printPurchaseCount(purchase.getCount())
        outputView.printLottos(purchase.getLottos())
    }
}