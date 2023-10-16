package strings

import org.junit.Assert.assertEquals
import org.junit.Test

class ReverseStringTest {

    @Test
    fun testReverseStringWithEmptyString() {
        val input = ""
        val expected = ""
        assertEquals(expected, reverseString(input))
    }

    @Test
    fun testReverseStringWithSingleCharacter() {
        val input = "a"
        val expected = "a"
        assertEquals(expected, reverseString(input))
    }

    @Test
    fun testReverseStringWithEvenLengthString() {
        val input = "abcdef"
        val expected = "fedcba"
        assertEquals(expected, reverseString(input))
    }

    @Test
    fun testReverseStringWithOddLengthString() {
        val input = "hello"
        val expected = "olleh"
        assertEquals(expected, reverseString(input))
    }
}
