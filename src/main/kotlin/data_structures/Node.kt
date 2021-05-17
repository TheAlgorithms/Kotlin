package data_structures

/**
 * linked list is a chain of nodes. Nodes have two responsibilities:
 * 1) Hold a value
 * 2) Hold a reference to the next node. The absence of a reference to the next node, null, marks the end of the list.
 *
 */
data class Node<T>(var value: T , var next: Node<T>? = null){
    // override the toString() method
    override fun toString(): String =
        if (next != null)
            "$value -> ${next.toString()}"  // if the next node exist
        else
            "$value"    // id the next node does not exit

}