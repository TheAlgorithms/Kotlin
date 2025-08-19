package DataStructures.Trees

import org.junit.Test

class BinaryTreeTest {

    fun createTree(root : Int, args: Array<Int>) : BinaryTree {
        val tree: BinaryTree = BinaryTree(root)
        args.forEach { tree.insert(it) }
        return tree
    }

    @Test
    fun testBinaryTree1() {
        val array = arrayOf(1, 65, 0, 8, 16)
        val tree : BinaryTree = createTree(10, array)
        assert(tree.traverse("pre") == "10 1 0 8 65 16")
    }

    @Test
    fun testBinaryTree2a() {
        val array = arrayOf(1, 65, 0, 8, 16)
        val tree : BinaryTree = createTree(10, array)
        assert(tree.search(8) == true)
    }

    @Test
    fun testBinaryTree2b() {
        val array = arrayOf(1, 65, 0, 8, 16)
        val tree : BinaryTree = createTree(10, array)
        tree.delete(8)
        assert(tree.search(8) == false)
    }

    @Test
    fun testBinaryTree3a() {
        val array = arrayOf(1, 65, 0, 8, 42, 123, 4, 654, 32, 86)
        val tree : BinaryTree = createTree(10, array)
        tree.delete(42)
        assert(tree.traverse("in") == "0 1 4 8 10 32 65 86 123 654")
    }

    @Test
    fun testBinaryTree3b() {
        val array = arrayOf(1, 65, 0, 8, 42, -123, 4, 654, 32, 86, 1, -12)
        val tree : BinaryTree = createTree(10, array)
        tree.delete(8)
        assert(tree.traverse("in") == "-123 -12 0 1 4 10 32 42 65 86 654")
    }

    @Test
    fun testBinaryTree4() {
        val array = arrayOf(1, 65, 0, 8, 16, 42, -123, 4, 654, 32, 86, 1, -12)
        val tree : BinaryTree = createTree(10, array)
        assert(tree.findMin(tree.root).value == -123)
    }

    @Test
    fun testBinaryTree5() {
        val array = arrayOf(1, 1, 33, 1, 2, 89, 142, 1, 4)
        val tree : BinaryTree = createTree(10, array)
        tree.delete(1)
        assert(tree.traverse("post") == "4 2 142 89 33 10")
    }

}
