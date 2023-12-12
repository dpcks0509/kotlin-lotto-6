package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoMachine
import lotto.model.Purchase
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val inputView: InputView, private val outputView: OutputView) {

    fun run() {
        val purchaseAmount = inputView.readPurchaseAmount()
        val purchase = Purchase(purchaseAmount)
        val purchaseCount = purchase.getCount()
        outputView.printPurchaseCount(purchaseCount)
        val lottos = issueLottos(purchaseCount)
        printLottos(lottos)
        val winningNumbers = inputView.readWinningNumbers()
        val bonusNumber = inputView.readBonusNumber(winningNumbers)
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
}