package array

import org.junit.Assert
import org.junit.Test

class RemoveArrayTest {

    @Test
    fun testRemoveAllElementsOfArray(){
        val list = arrayListOf("a","b","c","e","f")
        val expected = arrayListOf<String>()
        val actual = list.removeAll()
        Assert.assertEquals(expected,actual)
    }

}