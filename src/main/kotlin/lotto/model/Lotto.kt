package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.toSet().size == 6)
    }

    override fun toString(): String {
        return numbers.sorted().joinToString(", ", "[", "]")
    }
}
