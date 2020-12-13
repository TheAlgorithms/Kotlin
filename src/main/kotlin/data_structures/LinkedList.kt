package data_structures

/**
 * A linked list has the concept of a head and tail, which refers to the first and last nodes of the list respectively
 * You’ll also keep track of the size of the linked list in the size property.
 *
 */
class LinkedList<T>{
    private lateinit var tail: Node<T>
    private lateinit var head: Node<T>
    var size = 0
        private set

    /**
     * @return the list list is not empty
     * return if the LinkedList is not Empty
    */
    fun isEmpty() = size == 0

    /**
     * @return the string value of elements
     */
    // override toString() method
    override fun toString(): String =
        if(isEmpty())
            "The linked list is empty"
        else
            head.toString()

    /**
     *  head first insertion
     * push: Adds a value at the front of the list
     *
     * Worst-case performance	O(n)
     * Best-case performance	O(1)
     * Average performance	    O(n)
     *
     */

    /**
     * @param value is an element which insert in list
     */
    fun push(value: T){
        // create new node
        head = Node(value = value , next = if(this::head.isInitialized) head else null)
        // inset the new node if tail was not initialized
        if(this::tail.isInitialized)
            tail = head

     size++
    }
}