package lotto.model

import lotto.util.Constants.FIFTH_RANK
import lotto.util.Constants.FIRST_RANK
import lotto.util.Constants.FOURTH_RANK
import lotto.util.Constants.NO_RANK
import lotto.util.Constants.SECOND_RANK
import lotto.util.Constants.THIRD_RANK

class WinningLotto(private val lotto: Lotto, private val bonus: Bonus) {
    fun judgeRank(numbers: List<Int>): Int {
        val numberOfMatching = lotto.judgeNumberOfMatching(numbers)
        val isBonusMatching = bonus.judgeBonusMatching(numbers)

        return when {
            numberOfMatching == 6 -> FIRST_RANK
            numberOfMatching == 5 && isBonusMatching -> SECOND_RANK
            numberOfMatching == 5 -> THIRD_RANK
            numberOfMatching == 4 -> FOURTH_RANK
            numberOfMatching == 3 -> FIFTH_RANK
            else -> NO_RANK
        }
    }
}