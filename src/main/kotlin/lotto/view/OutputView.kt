package lotto.view

import lotto.model.Lotto
import lotto.model.Purchase

class OutputView {
    fun printPurchaseCount(purchaseCount: Int) {
        println()
        println("${purchaseCount}개를 구매했습니다.")
    }

    fun printLottos(lottos: List<Lotto>) {
        lottos.forEach { lotto -> println(lotto) }
    }
}