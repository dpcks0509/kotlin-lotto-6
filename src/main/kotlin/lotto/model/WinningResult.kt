package lotto.model

class WinningResult(private val purchase: Purchase, private val winningLotto: WinningLotto) {
    private var numberOfFirstPrize = 0
    private var numberOfSecondPrize = 0
    private var numberOfThirdPrize = 0
    private var numberOfFourthPrize = 0
    private var numberOfFifthPrize = 0

    init {
        calculateNumberOfPrize()
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


    fun getNumberOfFirstPrize() = numberOfFirstPrize
    fun getNumberOfSecondPrize() = numberOfSecondPrize
    fun getNumberOfThirdPrize() = numberOfThirdPrize
    fun getNumberOfFourthPrize() = numberOfFourthPrize
    fun getNumberOfFifthPrize() = numberOfFifthPrize
}