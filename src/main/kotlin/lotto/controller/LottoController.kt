package lotto.controller

import lotto.model.Purchase
import lotto.model.Winning
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()
    fun run() {
        val purchase = purchaseLottos()
        getPurchaseInfo(purchase)

        val winning = getWinningInfo()
    }

    private fun purchaseLottos(): Purchase {
        val purchaseAmount = inputView.readPurchaseAmount()
        return Purchase(purchaseAmount)
    }

    private fun getPurchaseInfo(purchase: Purchase) {
        outputView.printPurchaseCount(purchase.getCount())
        outputView.printLottos(purchase.getLottos())
    }

    private fun getWinningInfo(): Winning {
        val winningNumbers = inputView.readWinningNumbers()
        val bonusNumber = inputView.readBonusNumber(winningNumbers)
        return Winning(winningNumbers, bonusNumber)
    }
}