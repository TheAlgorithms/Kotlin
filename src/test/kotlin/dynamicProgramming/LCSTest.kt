package dynamicProgramming

import org.junit.Test

class LCSTest {

    @Test
    fun testForBasicCases() {
        assert(lcs("apple", "orange") == 2)
    }

    @Test
    fun testForNoCommonSubsequence() {
        assert(lcs("bird", "fly") == 0)
    }

    @Test
    fun testForSameString() {
        assert(lcs("success", "success") == 7)
    }

    @Test
    fun testForSubstringOfAString() {
        assert(lcs("application", "app") == 3)
    }

    @Test
    fun testForTwoLcs() {
        assert(lcs("abcxyz", "xyzabc") == 3)
    }
}