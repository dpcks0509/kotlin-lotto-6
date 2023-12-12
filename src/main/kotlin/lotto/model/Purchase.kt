package lotto.model

import lotto.utils.Constants.LOTTO_AMOUNT

class Purchase(private val amount: Int) {
    private var count = 0
    private var lottos = listOf<Lotto>()

    init {
        calculateCount()
    }

    private fun calculateCount() {
        count = amount / LOTTO_AMOUNT
    }

    fun setLottos(lottos: List<Lotto>) {
        this.lottos = lottos
    }

    fun getLottos() = lottos
    fun getCount() = count
    fun getAmount() = amount

}