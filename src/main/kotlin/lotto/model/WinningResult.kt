package lotto.model

import lotto.utils.Constants.FIFTH_RANK
import lotto.utils.Constants.FIRST_RANK
import lotto.utils.Constants.FOURTH_RANK
import lotto.utils.Constants.SECOND_RANK
import lotto.utils.Constants.THIRD_RANK

class WinningResult(private val purchase: Purchase, private val winningLotto: WinningLotto) {
    private val winningStatistics = MutableList(6) { 0 }
    private var rateOfReturn = 0.0

    init {
        calculateWinningStatistics()
        calculateRateOfReturn()
    }

    private fun calculateWinningStatistics() {
        purchase.getLottos().forEach { lotto ->
            val rank = winningLotto.getWinningRank(lotto.getNumbers())
            winningStatistics[rank] += 1
        }
    }

    private fun calculateRateOfReturn() {
        rateOfReturn = (calculateTotalReward() * 100.0) / purchase.getAmount()
    }

    private fun calculateTotalReward(): Int {
        return winningStatistics[FIRST_RANK] * WinningRank.FIRST_RANK.getReward() +
                winningStatistics[SECOND_RANK] * WinningRank.SECOND_RANK.getReward() +
                winningStatistics[THIRD_RANK] * WinningRank.THIRD_RANK.getReward() +
                winningStatistics[FOURTH_RANK] * WinningRank.FOURTH_RANK.getReward() +
                winningStatistics[FIFTH_RANK] * WinningRank.FIFTH_RANK.getReward()
    }

    fun getWinningStatistics() = winningStatistics
    fun getRateOfReturn() = rateOfReturn
}