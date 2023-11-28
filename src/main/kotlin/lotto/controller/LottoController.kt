package lotto.controller

import lotto.model.Purchase
import lotto.model.WinningLotto
import lotto.model.WinningResult
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()
    fun run() {
        val purchase = purchaseLottos()
        getPurchaseInfo(purchase)

        val winningLotto = getWinningLottoInfo()
        val winningResult = getWinningResult(purchase, winningLotto)
    }

    private fun <T> getInputUntilValid(inputFunction: () -> T): T {
        return try {
            inputFunction()
        } catch (illegalArgumentException: IllegalArgumentException) {
            outputView.printErrorMessage(illegalArgumentException.message.toString())
            getInputUntilValid(inputFunction)
        }
    }

    private fun purchaseLottos(): Purchase {
        val purchaseAmount = getInputUntilValid { inputView.readPurchaseAmount() }
        return Purchase(purchaseAmount)
    }

    private fun getPurchaseInfo(purchase: Purchase) {
        outputView.printPurchaseCount(purchase.getCount())
        outputView.printLottos(purchase.getLottos())
    }

    private fun getWinningLottoInfo(): WinningLotto {
        val winningNumbers = getInputUntilValid { inputView.readWinningNumbers() }
        val bonusNumber = getInputUntilValid { inputView.readBonusNumber(winningNumbers) }
        return WinningLotto(winningNumbers, bonusNumber)
    }

    private fun getWinningResult(purchase: Purchase, winningLotto: WinningLotto): WinningResult {
        val winningResult = WinningResult(purchase, winningLotto)
        outputView.printWinningResult(winningResult)
        return winningResult
    }
}