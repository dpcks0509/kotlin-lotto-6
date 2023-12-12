package lotto.model

enum class WinningRank(private val reward: Int) {
    FIRST_RANK(2_000_000_000),
    SECOND_RANK(30_000_000),
    THIRD_RANK(1_500_000),
    FOURTH_RANK(50_000),
    FIFTH_RANK(5_000);

    fun getReward() = reward
}