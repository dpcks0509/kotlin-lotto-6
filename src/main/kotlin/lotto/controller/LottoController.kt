package lotto.controller

import lotto.model.*
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val inputView: InputView, private val outputView: OutputView) {
    private lateinit var purchase: Purchase
    private lateinit var winningLotto: WinningLotto
    private lateinit var winningResult: WinningResult

    fun run() {
        purchaseLottos()
        drawWinningLotto()
        provideWinningResult()
    }

    private fun purchaseLottos() {
        val purchaseAmount = inputView.readPurchaseAmount()
        purchase = Purchase(purchaseAmount)
        val purchaseCount = purchase.getCount()
        outputView.printPurchaseCount(purchaseCount)
        val lottos = issueLottos(purchaseCount)
        purchase.setLottos(lottos)
        printLottos(lottos)
    }

    private fun issueLottos(purchaseCount: Int): List<Lotto> {
        val lottoMachine = LottoMachine()
        val lottos = mutableListOf<Lotto>()
        repeat(purchaseCount) {
            lottos.add(lottoMachine.execute())
        }
        return lottos
    }

    private fun printLottos(lottos: List<Lotto>) {
        lottos.forEach { lotto ->
            outputView.printLotto(lotto)
        }
    }

    private fun drawWinningLotto() {
        val winningNumbers = inputView.readWinningNumbers()
        val bonusNumber = inputView.readBonusNumber(winningNumbers)
        winningLotto = WinningLotto(winningNumbers, bonusNumber)
    }

    private fun provideWinningResult() {
        winningResult = WinningResult(purchase, winningLotto)
        outputView.printWinningStatistics(winningResult.getWinningStatistics())
        outputView.printRateOfReturn(winningResult.getRateOfReturn())
    }
}