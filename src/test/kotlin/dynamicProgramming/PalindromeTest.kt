package dynamicProgramming

import org.junit.Test

internal class PalindromeTest {

    @Test
    fun testPalindrome1() {
        assert(isPalindrome(""))
    }

    @Test
    fun testPalindrome2() {
        assert(isPalindrome("a"))
    }

    @Test
    fun testPalindrome3() {
        assert(isPalindrome("abba"))
    }

    @Test
    fun testPalindrome4() {
        assert(!isPalindrome("dsa"))
    }
}
