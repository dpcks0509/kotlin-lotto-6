package lotto.view

import lotto.model.Lotto
import lotto.model.WinningResult
import lotto.util.Constants.FIFTH_RANK
import lotto.util.Constants.FIRST_RANK
import lotto.util.Constants.FOURTH_RANK
import lotto.util.Constants.SECOND_RANK
import lotto.util.Constants.THIRD_RANK
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
        printNumberOfPrize(winningResult)
    }

    fun printNumberOfPrize(winningResult: WinningResult) {
        println("3개 일치 (5,000원) - ${winningResult.getNumberOfRank(FIFTH_RANK)}개")
        println("4개 일치 (50,000원) - ${winningResult.getNumberOfRank(FOURTH_RANK)}개")
        println("5개 일치 (1,500,000원) - ${winningResult.getNumberOfRank(THIRD_RANK)}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${winningResult.getNumberOfRank(SECOND_RANK)}개")
        println("6개 일치 (2,000,000,000원) - ${winningResult.getNumberOfRank(FIRST_RANK)}개")
    }

    fun printRateOfReturn(rateOfReturn: Double) {
        println("총 수익률은 ${decimalFormat.format(rateOfReturn)}%입니다.")
    }

    companion object {
        private val decimalFormat = DecimalFormat("#,###.#")
    }
}