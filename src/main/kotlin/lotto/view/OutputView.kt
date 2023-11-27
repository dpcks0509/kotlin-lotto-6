package lotto.view

import lotto.model.Lotto

class OutputView {
    fun printPurchaseCount(purchaseCount: Int) {
        println()
        println("${purchaseCount}개를 구매했습니다.")
    }

    fun printLottos(lottos: List<Lotto>) {
        lottos.forEach { lotto -> println(lotto) }
    }

    fun printErrorMessage(errorMessage: String) {
        println(errorMessage)
    }
}