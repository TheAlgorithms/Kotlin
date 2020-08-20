package dynamic_programming

import org.junit.Test

class PalindromePartitioningTest {

    @Test
    fun palindromePartitioningTest1() {
        val string = "nitik"
        val res = 2
        assert(initialize(string) == res)
    }

    @Test
    fun palindromePartitioningTest2() {
        val string = "ababbbabbaababa"
        val res = 3
        assert(initialize(string) == res)
    }

    @Test
    fun palindromePartitioningTest3() {
        val string = "abcddefgk"
        val res = 7
        assert(initialize(string) == res)
    }
}
