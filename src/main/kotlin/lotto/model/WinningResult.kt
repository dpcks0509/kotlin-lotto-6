package lotto.model

class WinningResult(private val purchase: Purchase, private val winningLotto: WinningLotto) {
    private var numberOfFirstPrize = 0
    private var numberOfSecondPrize = 0
    private var numberOfThirdPrize = 0
    private var numberOfFourthPrize = 0
    private var numberOfFifthPrize = 0

    private var rateOfReturn = 0.0

    init {
        calculateNumberOfPrize()
        rateOfReturn = calculateRateOfReturn()
    }

    private fun calculateNumberOfPrize() {
        purchase.getLottos().forEach { lotto ->
            judgePrize(lotto.getNumbers())
        }
    }

    private fun judgePrize(numbers: List<Int>) {
        val numberOfMatching = judgeNumberOfMatching(numbers)
        val isBonusMatching = judgeBonusMatching(numbers)

        when {
            numberOfMatching == 6 -> numberOfFirstPrize += 1
            numberOfMatching == 5 && isBonusMatching -> numberOfSecondPrize += 1
            numberOfMatching == 5 -> numberOfThirdPrize += 1
            numberOfMatching == 4 -> numberOfFourthPrize += 1
            numberOfMatching == 3 -> numberOfFifthPrize += 1
        }
    }

    private fun judgeNumberOfMatching(numbers: List<Int>): Int {
        return numbers.intersect(winningLotto.getWinningNumbers()).size
    }

    private fun judgeBonusMatching(numbers: List<Int>): Boolean {
        return numbers.contains(winningLotto.getBonusNumber())
    }

    private fun calculateRateOfReturn(): Double {
        val purchaseAmount = purchase.getAmount()
        val totalReward = calculateTotalReward()
        return (totalReward * 100.0) / purchaseAmount
    }

    private fun calculateTotalReward(): Int {
        return (numberOfFirstPrize * WinningPrize.FIRST_PRIZE.getReward()
                + numberOfSecondPrize * WinningPrize.SECOND_PRIZE.getReward()
                + numberOfThirdPrize * WinningPrize.THIRD_PRIZE.getReward()
                + numberOfFourthPrize * WinningPrize.FOURTH_PRIZE.getReward()
                + numberOfFifthPrize * WinningPrize.FIFTH_PRIZE.getReward())
    }

    fun getNumberOfFirstPrize() = numberOfFirstPrize
    fun getNumberOfSecondPrize() = numberOfSecondPrize
    fun getNumberOfThirdPrize() = numberOfThirdPrize
    fun getNumberOfFourthPrize() = numberOfFourthPrize
    fun getNumberOfFifthPrize() = numberOfFifthPrize

    fun getRateOfReturn() = rateOfReturn
}