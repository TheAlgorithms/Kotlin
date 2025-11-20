package binaryTree

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class PreorderTraverseTest {

    @Test
    fun `base_case`() {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3)

        val expected = listOf(1, 2, 3)
        val res = preorderTraverse(root)

        assertArrayEquals(expected.toIntArray(), res.toIntArray())
    }


    @Test
    fun `empty_tree`() {
        val root: TreeNode? = null

        val expected = emptyList<Int>()
        val res = preorderTraverse(root)

        assertArrayEquals(expected.toIntArray(), res.toIntArray())
    }
}