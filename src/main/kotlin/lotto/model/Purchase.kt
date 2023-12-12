package lotto.model

import lotto.utils.Constants.LOTTO_AMOUNT

class Purchase(private val amount: Int) {
    private val count = calculateCount()
    private var lottos = listOf<Lotto>()

    private fun calculateCount(): Int {
        return amount / LOTTO_AMOUNT
    }

    fun setLottos(lottos: List<Lotto>) {
        this.lottos = lottos
    }

    fun getLottos() = lottos

    fun getCount() = count
}