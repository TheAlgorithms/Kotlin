package math

import org.junit.Assert.assertEquals
import org.junit.Test
import java.math.BigInteger

class ShallowBinaryExponentiationTest {
    companion object {
        const val VERY_LARGE_RESULT_OF_EXPONENTIATION =
            "22745166391733635518864036952592070133430143938205371357914689788524029686058206121982289842297958648295318631512712290346668320656359121380034172922949409836427358375009684698518997958656"
    }

    @Test
    fun testBinaryExponentiationOfBigIntegers() {
        assertEquals(125L.toBigInteger(), 5.toBigInteger() bpow 3.toBigInteger())
        assertEquals(
            BigInteger("16832483071748016388427036991744"),
            BigInteger("4102740921840912").bpow(2.toBigInteger())
        )
        assertEquals(
            BigInteger(VERY_LARGE_RESULT_OF_EXPONENTIATION),
            BigInteger("4102740921840912").bpow(BigInteger("12"))
        )
    }

    @Test
    fun testBinaryExponentiationOfInts() {
        assertEquals(125, 5 bpow 3)
        assertEquals(1073741824, 32768 bpow 2)
    }

    @Test(expected = StackOverflowError::class)
    fun testStackOverflowForVeryLargeIndex() {
        BigInteger.ONE.bpow(
            2.toBigInteger().bpow(5000.toBigInteger())
        )
    }

    @Test
    fun testBinaryExponentiationOfLongs() {
        assertEquals(125L, 5L bpow 3L)
        assertEquals(1073741824L, 32768L bpow 2L)
        assertEquals(1152921504606846976L, 1024L bpow 6L)
    }
}