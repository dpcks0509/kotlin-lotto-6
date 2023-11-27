package lotto.view

import lotto.model.Lotto
import lotto.model.Purchase

class OutputView {
    fun printPurchase(purchase: Purchase) {
        println()
        println(purchase)
    }

    fun printLottos(lottos: List<Lotto>) {
        lottos.forEach { lotto -> println(lotto) }
    }
}