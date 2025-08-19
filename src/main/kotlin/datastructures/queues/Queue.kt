package datastructures

const val DEFAULT_CAPACITY = 10

/**
 * This is an implementation of a Queue
 * that uses an array as primary structure
 *
 * A queue data structure functions the same as a real world queue. The elements
 * that are added first are the first to be removed. New elements are added to
 * the back/rear of the queue.
 */
class Queue (size: Int?) {

    private val maxCapacity = size ?: DEFAULT_CAPACITY

    private var itemsCount = 0

    private val queue = IntArray(maxCapacity)

    private var last = -1

    private var first = 0

    /**
     * @param value is an integer that will be inserted into the queue
     * @returns false if the queue is full and true if the item was inserted
     */
    fun enqueue(value: Int): Boolean {
        if (isFull()) return false

        itemsCount++

        last = (last + 1) % maxCapacity
        queue[last] = value

        return true
    }

    /**
     * @returns the first item inserted into the queue, and null if it's empty
     */
    fun dequeue(): Int? {
        if (isEmpty()) {
            return null
        }

        val itemToReturn = queue[first]
        first = (first + 1) % maxCapacity

        itemsCount--

        return itemToReturn
    }

    /**
     * @returns the first item inserted into the queue as string
     */
    fun peekFirst(): String = queue[first].toString()

    /**
     * @returns the last item inserted into the queue as string
     */
    fun peekLast(): String = queue[last].toString()

    /**
     * @returns the amount of itens inside the queue
     */
    fun getSize(): Int = itemsCount

    private fun isFull(): Boolean = itemsCount == maxCapacity

    private fun isEmpty(): Boolean = itemsCount == 0
}