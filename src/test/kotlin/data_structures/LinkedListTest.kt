package data_structures

import org.junit.Test

class LinkedListTest {

    @Test
    fun  testPush1(){
        val list = LinkedList<Int>()
        list.push(1)
        assert(!list.isEmpty())
    }

    @Test
    fun testPush2(){
        val list = LinkedList<Int>()
        list.push(1)
        assert(list.size == 1)
    }

    @Test
    fun testPush3(){
        val list = LinkedList<Int>()
        list.push(1)
        list.push(2)
        list.push(3)
        list.push(4)
        list.push(5)
        assert(list.size == 5)
    }
}
