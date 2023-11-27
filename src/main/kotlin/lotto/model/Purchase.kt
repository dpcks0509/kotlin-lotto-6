package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.Constants
import lotto.util.Constants.LOTTO_UNIT

class Purchase(private val amount: Int) {
    private var count = 0
    private var lottos = listOf<Lotto>()

    init {
        count = calculatePurchaseCount()
        lottos = purchaseLottos()
    }

    private fun calculatePurchaseCount(): Int {
        return amount / LOTTO_UNIT
    }

    private fun generateLottoNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(
            Constants.LOTTO_NUMBER_START,
            Constants.LOTTO_NUMBER_END,
            Constants.LOTTO_NUMBER_COUNT
        )
    }

    private fun purchaseLottos(): List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        for (i in 0 until count) {
            val lotto = Lotto(generateLottoNumbers())
            lottos.add(lotto)
        }
        return lottos
    }

    fun getAmount() = amount
    fun getCount() = count
    fun getLottos() = lottos
}