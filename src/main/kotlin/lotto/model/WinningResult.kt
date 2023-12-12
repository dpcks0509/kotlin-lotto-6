package lotto.model

class WinningResult(private val purchase: Purchase, private val winningLotto: WinningLotto) {
    private val winningStatistics = MutableList(6) { 0 }

    init {
        calculateWinningStatistics()
    }

    private fun calculateWinningStatistics() {
        purchase.getLottos().forEach { lotto ->
            val rank = winningLotto.getWinningRank(lotto.getNumbers())
            winningStatistics[rank] += 1
        }
    }

    fun getWinningStatistics() = winningStatistics
}