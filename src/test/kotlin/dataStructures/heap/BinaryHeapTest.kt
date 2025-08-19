package dataStructures.heap

import org.junit.Assert.assertThat
import org.junit.Test
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.nullValue

class BinaryHeapTest{
    @Test
    fun `empty Heap`(){
        val minHeap = BinaryHeap<Int>()

        assertThat(minHeap.size, `is`(0))
        assertThat(minHeap.peek(), `is`(nullValue()))
        assertThat(minHeap.pop(), `is`(nullValue()))
    }

    @Test
    fun `push and pop single item`(){
        val minHeap = BinaryHeap<Int>()

        minHeap.push(5)

        assertThat(minHeap.size, `is`(1))
        assertThat(minHeap.peek(), `is`(5))

        val min = minHeap.pop()

        assertThat(min, `is`(5))
        assertThat(minHeap.size, `is`(0))
    }

    @Test
    fun `push several items`() {
        val minHeap = BinaryHeap<Int>()

        minHeap.push(4)
        assertThat(minHeap.peek(), `is`(4))

        minHeap.push(2)
        assertThat(minHeap.peek(), `is`(2))

        minHeap.push(3)
        assertThat(minHeap.peek(), `is`(2))

        minHeap.push(1)
        assertThat(minHeap.peek(), `is`(1))
    }

    @Test
    fun `heapify new list`() {
        val minHeap = BinaryHeap(listOf(4,3,2,1))

        assertThat(minHeap.pop(), `is`(1))
        assertThat(minHeap.pop(), `is`(2))
        assertThat(minHeap.pop(), `is`(3))
        assertThat(minHeap.pop(), `is`(4))
    }

    @Test
    fun maxHeap() {
        val maxHeap = BinaryHeap(listOf(1,2,3,4), Comparator.reverseOrder())

        assertThat(maxHeap.pop(), `is`(4))
        assertThat(maxHeap.pop(), `is`(3))
        assertThat(maxHeap.pop(), `is`(2))
        assertThat(maxHeap.pop(), `is`(1))
    }
}