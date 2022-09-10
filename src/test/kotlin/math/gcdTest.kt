package math

import org.junit.Test

class gcdTest{
    @Test
    fun testGcd1(){
        val a=20
        val b=2
        val res=2
        assert(gcd(a,b)==res)
    }
    @Test
    fun testGcd2(){
        val x=34
        val y=13
        val res=1
        assert(gcd(x,y)==res)
    }
    @Test
    fun testGcd3(){
        val m=24590
        val n=345
        val res=5
        assert(gcd(m,n)==res)
    }
}