package dynamicProgramming

import org.junit.Test

internal class isPrimeTest {

    @Test
    fun testPrime1(){
        assert(2.isPrime()==true)
    }

    @Test
    fun testPrime2(){
        assert(53.isPrime()==true)
    }

    @Test
    fun testPrime3(){
        assert(4.isPrime()==false)
    }
}