package lotto.model

import lotto.util.Constants.LOTTO_NUMBER_COUNT

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT)
        require(numbers.toSet().size == LOTTO_NUMBER_COUNT)
    }
}
