package graphs

import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class DijkstraTest {

    var graph = UndirectedGraph()

    var node0 = GraphNode("0")
    var node1 = GraphNode("1")
    var node2 = GraphNode("2")
    var node3 = GraphNode("3")
    var node4 = GraphNode("4")
    var node5 = GraphNode("5")
    var node6 = GraphNode("6")
    var node7 = GraphNode("7")
    var node8 = GraphNode("8")

    @Before
    fun setup() {
        graph.addNode(node0)  
        graph.addNode(node1)  
        graph.addNode(node2)  
        graph.addNode(node3)  
        graph.addNode(node4)    
        graph.addNode(node5)  
        graph.addNode(node6)  
        graph.addNode(node7)
        graph.addNode(node8)

        graph.addEdge(node0, node1, 4)
        graph.addEdge(node0, node7, 8)
        graph.addEdge(node1, node2, 8)
        graph.addEdge(node1, node7, 11)
        graph.addEdge(node2, node3, 7)
        graph.addEdge(node2, node8, 2)
        graph.addEdge(node2, node5, 4)
        graph.addEdge(node3, node4, 9)
        graph.addEdge(node3, node5, 14)
        graph.addEdge(node4, node5, 10)
        graph.addEdge(node5, node6, 2)
        graph.addEdge(node6, node7, 1)
        graph.addEdge(node6, node8, 6)
        graph.addEdge(node7, node8, 7)
    }

    @Test
    fun testDijkstra1() {
        graph.dijkstra(node0)

        assertEquals(node4.leastCost, 21)
    }

    @Test
    fun testDijkstra2() {
        graph.dijkstra(node1)

        assertEquals(node6.leastCost, 12)
    }

    @Test
    fun testDijkstra3() {
        graph.dijkstra(node2)

        assertEquals(node0.leastCost, 12)
    }

    @Test
    fun testDijkstra4() {
        graph.dijkstra(node3)

        assertEquals(node0.leastCost, 19)
    }

    @Test
    fun testDijkstra5() {
        graph.dijkstra(node6)

        assertEquals(node7.leastCost, 1)
    }
}