/**
 * This is the testing part of binomial.kt file
 */

package io.uuddlrlrba.ktalgs.math

import org.junit.Assert
import org.junit.Test

class BinomialfuncTest {
    @Test
    fun test1() {
        Assert.assertEquals(0, binomialfunc(0, 1))
        Assert.assertEquals(1, binomialfunc(1, 1))
        Assert.assertEquals(2, binomialfunc(2, 1))
        Assert.assertEquals(3, binomialfunc(3, 1))
        Assert.assertEquals(3, binomialfunc(3, 2))
        Assert.assertEquals(4, binomialfunc(4, 1))
        
        Assert.assertEquals(1, binomialfunc(6, 0))
        Assert.assertEquals(6, binomialfunc(6, 1))
        Assert.assertEquals(15, binomialfunc(6, 2))
        Assert.assertEquals(20, binomialfunc(6, 3))
        Assert.assertEquals(15, binomialfunc(6, 4))
        Assert.assertEquals(6, binomialfunc(6, 5))
        Assert.assertEquals(1, binomialfunc(6, 6))

        Assert.assertEquals(1, binomialfunc(5, 0))
        Assert.assertEquals(5, binomialfunc(5, 1))
        Assert.assertEquals(10, binomialfunc(5, 2))
        Assert.assertEquals(10, binomialfunc(5, 3))
        Assert.assertEquals(5, binomialfunc(5, 4))
        Assert.assertEquals(1, binomialfunc(5, 5))

      
    }
}
