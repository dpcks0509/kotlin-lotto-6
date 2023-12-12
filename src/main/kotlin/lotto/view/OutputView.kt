package lotto.view

import lotto.model.Lotto
import lotto.utils.Constants.FIFTH_RANK
import lotto.utils.Constants.FIRST_RANK
import lotto.utils.Constants.FOURTH_RANK
import lotto.utils.Constants.SECOND_RANK
import lotto.utils.Constants.THIRD_RANK
import java.text.DecimalFormat

class OutputView {
    fun printPurchaseCount(purchaseCount: Int) {
        println()
        println("${purchaseCount}개를 구매했습니다.")
    }

    fun printLotto(lotto: Lotto) {
        println(lotto)
    }

    fun printWinningStatistics(winningStatistics: List<Int>) {
        println()
        println("당첨 통계")
        println("---")
        println("3개 일치 (5,000원) - ${winningStatistics[FIFTH_RANK]}개")
        println("4개 일치 (50,000원) - ${winningStatistics[FOURTH_RANK]}개")
        println("5개 일치 (1,500,000원) - ${winningStatistics[THIRD_RANK]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${winningStatistics[SECOND_RANK]}개")
        println("6개 일치 (2,000,000,000원) - ${winningStatistics[FIRST_RANK]}개")
    }

    fun printRateOfReturn(rateOfReturn: Double) {
        println("총 수익률은 ${decimalFormat.format(rateOfReturn)}%입니다.")
    }

    companion object {

        private val decimalFormat = DecimalFormat("#.#")

    }
}