package string

import org.junit.Test


class AnagramTest {

    @Test
    fun `test isAnagramOf empty string returns true`() {
        val string1 = ""
        val string2 = ""

        assert(string1.isAnagramOf(string2))
    }

    @Test
    fun `test isAnagramOf single letter string returns true`() {
        val string1 = "a"
        val string2 = "a"

        assert(string1.isAnagramOf(string2))
    }

    @Test
    fun `test isAnagramOf returns true`() {
        val string1 = "testIsAnagramOfReturnsTrue1"
        val string2 = "test isAnagramOf returns true 1"

        assert(string1.isAnagramOf(string2))
    }

    @Test
    fun `test isAnagramOf ignoreWhitespace true ignoreCase True returns True`() {
        val string1 = "Wolfgang Amadeus Mozart"
        val string2 = "A famous german waltz god"

        assert(string1.isAnagramOf(string2, ignoreWhitespace = true, ignoreCase = true))
    }

    @Test
    fun `test isAnagramOf ignoreWhitespace False ignoreCase True returns True`() {
        val string1 = "Eleven plus Two"
        val string2 = "Twelve plus One"

        assert(string1.isAnagramOf(string2, ignoreWhitespace = false, ignoreCase = true))
    }

    @Test
    fun `test isAnagramOf ignoreWhitespace True ignoreCase False returns True`() {
        val string1 = "wolfgang amadeus mozart"
        val string2 = "a famous german waltz god"

        assert(string1.isAnagramOf(string2, ignoreWhitespace = true, ignoreCase = false))
    }

    @Test
    fun `test isAnagramOf ignoreWhitespace False ignoreCase False returns True`() {
        val string1 = "wolfgangamadeusmozart"
        val string2 = "afamousgermanwaltzgod"

        assert(string1.isAnagramOf(string2, ignoreWhitespace = false, ignoreCase = false))
    }

    @Test
    fun `test isAnagramOf ignoreWhitespace true ignoreCase True returns False`() {
        val string1 = "testIsAnagramOfReturnsTrue1"
        val string2 = "test isAnagramOf returns true 2"

        assert(string1.isAnagramOf(string2, ignoreWhitespace = true, ignoreCase = true).not())
    }

    @Test
    fun `test isAnagramOf ignoreWhitespace False ignoreCase True returns False`() {
        val string1 = "testIsAnagramOfReturnsTrue1"
        val string2 = "test IsAnagramOf Returns True 1"

        assert(string1.isAnagramOf(string2, ignoreWhitespace = false, ignoreCase = true).not())
    }

    @Test
    fun `test isAnagramOf ignoreWhitespace True ignoreCase False returns False`() {
        val string1 = "testIsAnagramOfReturnsTrue1"
        val string2 = "testisAnagramOfreturnstrue1"

        assert(string1.isAnagramOf(string2, ignoreWhitespace = true, ignoreCase = false).not())
    }

    @Test
    fun `test isAnagramOf ignoreWhitespace False ignoreCase False returns False`() {
        val string1 = "testisanagramofreturnstrue"
        val string2 = "testisanagramofreturnstrup"

        assert(string1.isAnagramOf(string2, ignoreWhitespace = false, ignoreCase = false).not())
    }
}