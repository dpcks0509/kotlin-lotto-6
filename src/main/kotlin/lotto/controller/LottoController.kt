package lotto.controller

import lotto.model.*
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()
    fun run() {
        val purchase = purchaseLottos()
        getPurchaseInfo(purchase)

        val winningLotto = getWinningLottoInfo()
        getWinningResult(purchase, winningLotto)
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
        val lotto = Lotto(getInputUntilValid { inputView.readWinningNumbers() })
        val bonus = Bonus(getInputUntilValid { inputView.readBonusNumber(lotto.getNumbers()) })
        return WinningLotto(lotto, bonus)
    }

    private fun getWinningResult(purchase: Purchase, winningLotto: WinningLotto) {
        val winningResult = WinningResult(purchase, winningLotto)
        outputView.printWinningResult(winningResult)
        getRateOfReturn(purchase, winningResult)
    }

    private fun getRateOfReturn(purchase: Purchase, winningResult: WinningResult) {
        purchase.calculateRateOfReturn(winningResult.getTotalReward())
        outputView.printRateOfReturn(purchase.getRateOfReturn())
    }
}