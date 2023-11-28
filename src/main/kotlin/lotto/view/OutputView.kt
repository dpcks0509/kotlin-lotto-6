package lotto.view

import lotto.model.Lotto
import lotto.model.WinningResult
import java.text.DecimalFormat

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

    fun printWinningResult(winningResult: WinningResult) {
        println()
        println("당첨 통계")
        println("---")
        println("3개 일치 (5,000원) - ${winningResult.getNumberOfFifthPrize()}개")
        println("4개 일치 (50,000원) - ${winningResult.getNumberOfFourthPrize()}개")
        println("5개 일치 (1,500,000원) - ${winningResult.getNumberOfThirdPrize()}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${winningResult.getNumberOfSecondPrize()}개")
        println("6개 일치 (2,000,000,000원) - ${winningResult.getNumberOfFirstPrize()}개")
        printRateOfReturn(winningResult.getRateOfReturn())
    }

    fun printRateOfReturn(rateOfReturn: Double) {
        println("총 수익률은 ${decimalFormat.format(rateOfReturn)}%입니다.")
    }

    companion object {
        private val decimalFormat = DecimalFormat("#,###.#")
    }
}