package dynamicProgramming

import org.junit.Test

internal class IsPrimeTest {

    @Test
    fun testPrime1(){
        assert(2.isPrime())
    }

    @Test
    fun testPrime2(){
        assert(53.isPrime())
    }

    @Test
    fun testPrime3(){
        assert(!4.isPrime())
    }
}