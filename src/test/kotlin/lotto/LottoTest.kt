package lotto

import lotto.model.Lotto
import lotto.model.WinningNumbers
import lotto.utils.Validator.validatePurchaseAmount
import lotto.utils.Validator.validateWinningNumbers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["8000", "1000", "15000"])
    fun `올바른 구입금액 입력`(purchaseAmount: String) {
        assertDoesNotThrow { validatePurchaseAmount(purchaseAmount) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1000", "0", "999", " 1000", "1000 ", " ", "", "oneThousand"])
    fun `구입금액 입력 예외 처리 (구입 금액이 1,000원 이상의 숫자가 아닌 경우)`(purchaseAmount: String) {
        assertThrows<IllegalArgumentException> { validatePurchaseAmount(purchaseAmount) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1100", "1010", "1001"])
    fun `구입금액 입력 예외 처리 (구입 금액이 1,000원으로 나누어 떨어지지 않는 경우)`(purchaseAmount: String) {
        assertThrows<IllegalArgumentException> { validatePurchaseAmount(purchaseAmount) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,6", "23,17,42,31,29,5"])
    fun `올바른 당첨 번호 입력`(winningNumbers: String) {
        assertDoesNotThrow { validateWinningNumbers(winningNumbers) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5", "1,2,3,4,5,6,7"])
    fun `당첨 번호 입력 예외 처리 (당첨 번호의 개수가 6개가 아닌 경우)`(winningNumbers: String) {
        assertThrows<IllegalArgumentException> { validateWinningNumbers(winningNumbers) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0,1,2,3,4,5", "-1,2,3,4,5,6", "1,2,3,4,5,46", " 1,2,3,4,5,6", "1,2,3,4,5,6 ", " ,2,3,4,5,6", "one,2,3,4,5,6"])
    fun `당첨 번호 입력 예외 처리 (당첨 번호가 1~45사이의 숫자가 아닌 경우)`(winningNumbers: String) {
        assertThrows<IllegalArgumentException> { validateWinningNumbers(winningNumbers) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,5", "1,1,3,4,5,6"])
    fun `당첨 번호 입력 예외 처리 (당첨 숫자가 중복되는 경우)`(winningNumbers: String) {
        assertThrows<IllegalArgumentException> { validateWinningNumbers(winningNumbers) }
    }
}
