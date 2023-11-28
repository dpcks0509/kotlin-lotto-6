package lotto

import lotto.model.Lotto
import lotto.util.Validator.validatePurchaseAmount
import org.junit.jupiter.api.Test
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
    @ValueSource(strings = ["1000", "5000", "8000 "])
    fun `올바른 구입 금액 입력`(purchaseAmount: String) {
        assertThrows<IllegalArgumentException> { validatePurchaseAmount(purchaseAmount) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["oneThousand", " 1000", "1000 "])
    fun `구입 금액 입력 예외 처리 (구입 금액은 문자나 공백 입력이 허용되지 않는다)`(purchaseAmount: String) {
        assertThrows<IllegalArgumentException> { validatePurchaseAmount(purchaseAmount) }
    }
}
