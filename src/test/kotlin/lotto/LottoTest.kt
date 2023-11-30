package lotto

import lotto.model.Bonus
import lotto.model.Lotto
import lotto.model.Purchase
import lotto.model.WinningLotto
import lotto.util.Constants.LOTTO_NUMBER_COUNT
import lotto.util.Constants.LOTTO_NUMBER_END
import lotto.util.Constants.LOTTO_NUMBER_START
import lotto.util.Validator.validateBonusNumber
import lotto.util.Validator.validatePurchaseAmount
import lotto.util.Validator.validateWinningNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1000", "5000", "8000"])
    fun `올바른 구입 금액 입력`(purchaseAmount: String) {
        assertDoesNotThrow { validatePurchaseAmount(purchaseAmount) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["oneThousand", " 1000", "1000 "])
    fun `구입 금액 입력 예외 처리 (구입 금액은 문자나 공백 입력이 허용되지 않는다)`(purchaseAmount: String) {
        assertThrows<IllegalArgumentException> { validatePurchaseAmount(purchaseAmount) }
    }

    @Test
    fun `발행한 로또 수량 계산`() {
        val purchase = Purchase(8000)
        val expectPurchaseCount = 8

        val actualPurchaseCount = purchase.getCount()

        assertThat(actualPurchaseCount).isEqualTo(expectPurchaseCount)
    }

    @Test
    fun `발행한 로또 번호 생성`() {
        val purchase = Purchase(8000)

        purchase.getLottos().forEach { lotto ->
            lotto.getNumbers().forEach { number ->
                assertThat(number).isBetween(LOTTO_NUMBER_START, LOTTO_NUMBER_END)
            }
            assertThat(lotto.getNumbers().toSet().size).isEqualTo(LOTTO_NUMBER_COUNT)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,6", "7,8,9,10,11,12"])
    fun `올바른 당첨 번호 입력`(winningNumbers: String) {
        assertDoesNotThrow { validateWinningNumbers(winningNumbers) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["one,2,3,4,5,6", " 7,8,9,10,11,12", "13,14,15,16,17,18 "])
    fun `당첨 번호 입력 예외 처리 (당첨 번호는 문자나 공백 입력이 허용되지 않는다)`(winningNumbers: String) {
        assertThrows<IllegalArgumentException> { validateWinningNumbers(winningNumbers) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0,1,2,3,4,5", "-1,2,3,4,5,6", "1,2,3,4,5,46"])
    fun `당첨 번호 입력 예외 처리 (당첨 번호의 숫자 범위는 1~45까지이다)`(winningNumbers: String) {
        assertThrows<IllegalArgumentException> { validateWinningNumbers(winningNumbers) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,6,7", "7,8,9,10,11,12,13"])
    fun `당첨 번호 입력 예외 처리 (당첨 번호의 개수는 6개 이다)`(winningNumbers: String) {
        assertThrows<IllegalArgumentException> { validateWinningNumbers(winningNumbers) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,1,2,3,4,5", "7,8,9,10,11,11"])
    fun `당첨 번호 입력 예외 처리 (당첨 번호는 중복되지 않는다)`(winningNumbers: String) {
        assertThrows<IllegalArgumentException> { validateWinningNumbers(winningNumbers) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["7", "8", "9"])
    fun `올바른 보너스 번호 입력`(bonusNumber: String) {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        assertDoesNotThrow { validateBonusNumber(bonusNumber, winningNumbers) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["one", " 8", "9 "])
    fun `보너스 번호 입력 예외 처리 (보너스 번호는 문자나 공백 입력이 허용되지 않는다)`(bonusNumber: String) {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        assertThrows<IllegalArgumentException> { validateBonusNumber(bonusNumber, winningNumbers) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "0", "46"])
    fun `보너스 번호 입력 예외 처리 (보너스 번호의 숫자 범위는 1~45까지이다)`(bonusNumber: String) {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        assertThrows<IllegalArgumentException> { validateBonusNumber(bonusNumber, winningNumbers) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3"])
    fun `보너스 번호 입력 예외 처리 (보너스 번호는 당첨 번호와 중복되지 않는다)`(bonusNumber: String) {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        assertThrows<IllegalArgumentException> { validateBonusNumber(bonusNumber, winningNumbers) }
    }

    @Test
    fun `1등 당첨 확인`() {
        val winningLotto = WinningLotto(Lotto(listOf(1,2,3,4,5,6)), Bonus(7))
        val purchaseLotto = listOf(1,2,3,4,5,6)
        val expectRank = 1

        val actualRank = winningLotto.judgeRank(purchaseLotto)

        assertThat(actualRank).isEqualTo(expectRank)
    }

    @Test
    fun `2등 당첨 확인`() {
        val winningLotto = WinningLotto(Lotto(listOf(1,2,3,4,5,6)), Bonus(7))
        val purchaseLotto = listOf(1,2,3,4,5,7)
        val expectRank = 2

        val actualRank = winningLotto.judgeRank(purchaseLotto)

        assertThat(actualRank).isEqualTo(expectRank)
    }

    @Test
    fun `3등 당첨 확인`() {
        val winningLotto = WinningLotto(Lotto(listOf(1,2,3,4,5,6)), Bonus(7))
        val purchaseLotto = listOf(1,2,3,4,5,8)
        val expectRank = 3

        val actualRank = winningLotto.judgeRank(purchaseLotto)

        assertThat(actualRank).isEqualTo(expectRank)
    }

    @Test
    fun `4등 당첨 확인`() {
        val winningLotto = WinningLotto(Lotto(listOf(1,2,3,4,5,6)), Bonus(7))
        val purchaseLotto = listOf(1,2,3,4,8,9)
        val expectRank = 4

        val actualRank = winningLotto.judgeRank(purchaseLotto)

        assertThat(actualRank).isEqualTo(expectRank)
    }

    @Test
    fun `5등 당첨 확인`() {
        val winningLotto = WinningLotto(Lotto(listOf(1,2,3,4,5,6)), Bonus(7))
        val purchaseLotto = listOf(1,2,3,8,9,10)
        val expectRank = 5

        val actualRank = winningLotto.judgeRank(purchaseLotto)

        assertThat(actualRank).isEqualTo(expectRank)
    }

    @Test
    fun `미당첨 확인`() {
        val winningLotto = WinningLotto(Lotto(listOf(1,2,3,4,5,6)), Bonus(7))
        val purchaseLotto = listOf(8,9,10,11,12,13)
        val expectRank = 0

        val actualRank = winningLotto.judgeRank(purchaseLotto)

        assertThat(actualRank).isEqualTo(expectRank)
    }
}