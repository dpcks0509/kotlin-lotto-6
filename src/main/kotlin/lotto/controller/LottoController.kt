package lotto.controller

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto
import lotto.model.Purchase
import lotto.util.Constants.LOTTO_NUMBER_COUNT
import lotto.util.Constants.LOTTO_NUMBER_END
import lotto.util.Constants.LOTTO_NUMBER_START
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private val inputView = InputView()
    private val outputView = OutputView()
    fun run() {
        val purchase = Purchase(inputView.readPurchaseAmount())
        outputView.printPurchase(purchase)

        val lottos = makeLottos(purchase.getCount())
    }

    private fun generateRandomNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_START, LOTTO_NUMBER_END, LOTTO_NUMBER_COUNT)
    }

    private fun makeLottos(purchaseCount: Int): List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        for (i in 0 until purchaseCount) {
            val lotto = Lotto(generateRandomNumbers())
            lottos.add(lotto)
        }
        return lottos
    }
}