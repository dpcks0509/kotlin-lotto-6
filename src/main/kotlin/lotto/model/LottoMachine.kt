package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.Constants.LOTTO_COUNT
import lotto.utils.Constants.LOTTO_END_NUMBER
import lotto.utils.Constants.LOTTO_START_NUMBER

class LottoMachine {
    fun execute(): Lotto {
        val numbers: List<Int> = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_COUNT)
        return Lotto(numbers)
    }
}
