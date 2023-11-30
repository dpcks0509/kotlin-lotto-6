package lotto.model

import lotto.util.Constants.FIFTH_RANK
import lotto.util.Constants.FIRST_RANK
import lotto.util.Constants.FOURTH_RANK
import lotto.util.Constants.SECOND_RANK
import lotto.util.Constants.THIRD_RANK

class WinningResult(private val purchase: Purchase, private val winningLotto: WinningLotto) {
    private val numberOfRanks = MutableList(6) { 0 }
    private var rateOfReturn = 0.0

    init {
        calculateNumberOfRanks()
        calculateRateOfReturn()
    }

    private fun calculateNumberOfRanks() {
        purchase.getLottos().forEach { lotto ->
            val rank = winningLotto.judgeRank(lotto.getNumbers())
            numberOfRanks[rank] += 1
        }
    }

    private fun calculateRateOfReturn() {
        val purchaseAmount = purchase.getAmount()
        val totalReward = calculateTotalReward()
        rateOfReturn = (totalReward * 100.0) / purchaseAmount
    }

    private fun calculateTotalReward(): Int {
        return (numberOfRanks[FIRST_RANK] * WinningPrize.FIRST_PRIZE.getReward()
                + numberOfRanks[SECOND_RANK] * WinningPrize.SECOND_PRIZE.getReward()
                + numberOfRanks[THIRD_RANK] * WinningPrize.THIRD_PRIZE.getReward()
                + numberOfRanks[FOURTH_RANK] * WinningPrize.FOURTH_PRIZE.getReward()
                + numberOfRanks[FIFTH_RANK] * WinningPrize.FIFTH_PRIZE.getReward())
    }

    fun getNumberOfRank(rank: Int) = numberOfRanks[rank]

    fun getRateOfReturn() = rateOfReturn
}