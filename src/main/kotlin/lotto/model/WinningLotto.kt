package lotto.model

import lotto.utils.Constants.FIFTH_RANK
import lotto.utils.Constants.FIRST_RANK
import lotto.utils.Constants.FOURTH_RANK
import lotto.utils.Constants.NO_RANK
import lotto.utils.Constants.SECOND_RANK
import lotto.utils.Constants.THIRD_RANK

class WinningLotto(private val winningNumbers: List<Int>, private val bonusNumber: Int) {
    private fun calculateNumberOfMatching(lottoNumbers: List<Int>): Int {
        return lottoNumbers.intersect(winningNumbers.toSet()).size
    }

    private fun judgeBonusMatching(lottoNumbers: List<Int>): Boolean {
        return lottoNumbers.contains(bonusNumber)
    }

    fun getWinningRank(lottoNumbers: List<Int>): Int {
        val numberOfMatching = calculateNumberOfMatching(lottoNumbers)
        val bonusMatching = judgeBonusMatching(lottoNumbers)

        return when (numberOfMatching) {
            6 -> FIRST_RANK
            5 -> SECOND_RANK.takeIf { bonusMatching } ?: THIRD_RANK
            4 -> FOURTH_RANK
            3 -> FIFTH_RANK
            else -> NO_RANK
        }
    }
}