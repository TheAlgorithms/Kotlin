package DataStructures.Trees


/**
 * This entire class is used to build a Binary Tree data structure.
 * There is the Node Class and the Tree Class, both explained below.
 * The functions are mostly recursively implemented.
 */


/**
 * A binary tree is a data structure in which an element
 * has two successors(children). The left child is usually
 * smaller than the parent, and the right child is usually
 * bigger.
 *
 * A new Binary Tree can initialized with his root
 */
class BinaryTree(rootValue: Int) {

    var root: Node

    init {
        this.root = Node(rootValue, null)
    }

    /**
     * This class implements the nodes that will go on the Binary Tree.
     * They consist of the data in them, the node to the left, the node
     * to the right, and the parent from which they came from.
     */
    class Node(var value: Int, var parent: Node?) {
        var left: Node? = null
        var right: Node? = null

        /**
         * Method to check if a node has a left child
         *
         * @return True if node has a left child, false if not
         */
        fun hasLeft(): Boolean {
            return left != null
        }

        /**
         * Method to check if a node has a right child
         *
         * @return True if node has a right child, false if not
         */
        fun hasRight(): Boolean {
            return right != null
        }

        /**
         * Method to replace a node with a given different node
         *
         * @param replacement Node which will replace original node
         */
        fun replaceWith(replacement: Node?) {
            if (this.parent!!.left === this) {
                this.parent!!.left = replacement
            } else {
                this.parent!!.right = replacement
            }
            if (replacement != null) replacement.parent = this.parent
        }

    }

    /**
     * Method to check if a value is present
     *
     * @param value Value being looked for
     * @return True if tree contains the value, false if not
     */
    fun search(value: Int): Boolean {
        return searchNode(this.root, value) != null
    }

    /**
     * Method to find a Node with a certain value
     *
     * @param value Value being looked for
     * @return The node if it finds it, otherwise returns null
     */
    fun searchNode(currentNode: Node?, value: Int): Node? {
        //If there is no node with the searched value
        if (currentNode == null) return null

        //Return the node with the searched value
        if (currentNode.value == value) return currentNode

        //Continue searching for the right node
        return if (value < currentNode.value) searchNode(currentNode.left, value) else searchNode(currentNode.right, value)
    }

    /**
     * Deletes a given value from the Binary Tree
     *
     * @param value Value to be deleted
     * @return If the value was deleted
     */
    fun delete(value: Int): Boolean {
        return deleteNode(this.root, value)
    }

    fun deleteNode(current: Node, value: Int): Boolean {

        //If the value doesn't exist
        var removeNode: Node = searchNode(root, value) ?: return false

        //If node has two children
        if (removeNode.hasLeft() && removeNode.hasRight()) {
            val minNode = findMin(current.right!!)
            removeNode.value = minNode.value
            removeNode = minNode
        }

        //If node has one Children or less
        if (removeNode.hasLeft()) removeNode.replaceWith(removeNode.left) else removeNode.replaceWith(removeNode.right)

        //If delete was succesfull
        return true
    }

    /**
     * Finds the minimum from one Binary Tree branch
     *
     * @param currentNode Starting node
     * @return Node with minimum value
     */
    fun findMin(currentNode: Node): Node {
        return if (!currentNode.hasLeft()) currentNode else findMin(currentNode.left!!)
    }

    /**
     * Inserts certain value into the Binary Tree
     *
     * @param value Value to be inserted
     */
    fun insert(value: Int): Boolean {
        return insertNode(root, value)
    }

    fun insertNode(node: Node?, value: Int): Boolean {
        //Go to the left branch if the value to insert is smaller than the current node value
        if (value < node!!.value) {
            if (node.hasLeft()) {
                insertNode(node.left, value)
            } else {
                node.left = Node(value, node)
                return true
            }
        //Go to the left branch if the value to insert is bigger than the current node value
        } else if (value > node.value) {
            if (node.hasRight()) {
                insertNode(node.right, value)
            } else {
                node.right = Node(value, node)
                return true
            }
        }
        return false
    }

    /**
     * Prints leftChild - root - rightChild
     *
     * @param node The local root of the binary tree
     */
    fun traverseInOrder(node: Node?) {
        if (node != null) {
            traverseInOrder(node.left)
            print(" " + node.value)
            traverseInOrder(node.right)
        }
    }

    /**
     * Prints rightChild - leftChild - root
     *
     * @param node The local root of the binary tree
     */
    fun traversePostOrder(node: Node?) {
        if (node != null) {
            traversePostOrder(node.left)
            traversePostOrder(node.right)
            print(" " + node.value)
        }
    }

    /**
     * Prints root - leftChild - rightChild
     *
     * @param node The local root of the binary tree
     */
    fun traversePreOrder(node: Node?) {
        if (node != null) {
            print(" " + node.value)
            traversePreOrder(node.left)
            traversePreOrder(node.right)
        }
    }

}
