/*
    Kotlin implementation of Dijkstra's algorithm
    to calculate the shortest paths in a weighted,
    undirected graph.

    This source file includes the following classes:
        - MinHeap (Minimum Heap)
        - MinPQ (Minimum Priority Queue)
        - UndirectedGraph
        - GraphNode
        - GraphEdge

    Check main() for an example of how to use.
 */

package graphs

/*
    Native Kotlin implementation of a minimum heap.

    A minimum heap is where the root of the heap
    is the minimum of the collection of elements.
    The rest of the heap is not guaranteed to be in
    sorted order.

    This is a binary heap so an element can have at
    most 2 children and 1 parent

    Elements must be Comparable

    This data structure is used as a helper to
    implement the MinPQ class
 */
class MinHeap<T : Comparable<T>>() {

    // index 0: not used!!
    // index 1: root of heap
    var heap = ArrayList<T>()

    /*
        @param keys List of comparable keys to
                    init heap with
    */
    constructor(keys: ArrayList<T>) : this() {
        for(key in keys) {
            add(key)
            swim(size())
        }
    }

    /*
        add element to end of heap

        @param key Element to be added
     */
    fun add(key: T) {

        /*
         Filling in index 0 just to fill it
         with something and get to next index.

         It will never be used.
         */
        if(size() == 0) {
            heap.add(key)
        }

        heap.add(size(), key)
    }

    /*
        Wrapper function to return size of heap
     */
    fun size(): Int {
        return heap.size
    }

    /*
        Wrapper function to get element from heap.
        Element will not be removed.

        @param i Index of element to get

        @return T Element at index i
     */
    fun get(i: Int): T {
        return heap.get(i)
    }

    /*
        Wrapper function to remove element from heap.

        @param i Index of element to remove
     */
    fun remove(i: Int) {
        heap.removeAt(i)
    }

    /*
        Make element "swim up" the heap.

        Element will be compared to parent and
        will be swapped with parent if element
        is less than parent. This will continue
        until the element is greater than the
        parent or the element reaches the root
        of the heap.

        @param kParam Index of element to swim
     */
    fun swim(kParam: Int) {
        var k = kParam

        while(k > 1 && less(k, k/2)) {
            swap(k/2, k)
            k = k/2
        }
    }

    /*
        Make element "sink down" the heap.

        Element will be compared to greater of
        two children and then swapped if parent
        is greater. This will continue until
        element is less than both children or
        element reaches bottom of heap.

        @param kParam Index of element to sink
     */
    fun sink(kParam: Int) {
        var k = kParam
        var j: Int
        
        while(2 * k <= size() - 1) {
            j = 2 * k

            if(j < size() - 1 && less(j+1, j)) {
                j++
            }
            
            if(!less(j,k)) {
                break
            }

            swap(k, j)
            k = j
        }
    }

    /*
        Helper function to swap 2 elements

        @param i Index of first element
        @param j Index of second element
     */
    fun swap(i: Int, j: Int) {
        var tmp = heap.get(i)
        heap.set(i, heap.get(j))
        heap.set(j, tmp)
    }

    /*
        Helper function to compare 2 elements

        @param i Index of first element
        @param j Index of second element

        @return true if(i < j)
        @return false if(i >= j)
     */
    fun less(i: Int, j: Int): Boolean {
        return heap.get(i).compareTo(heap.get(j)) < 0
    }

    /*
        Helper function to return index of element

        @param ele Element to find index of in heap

        @return Int Index of element
     */
    fun find(ele: T): Int {
        return heap.indexOf(ele)
    }
}

/*
    Native Kotlin implementation of a Minimum Priority Queue

    A minimum priority queue is a weighted queue where the first
    element is guaranteed to be the least of all elements and is
    internally represented by a minimum heap.

    Elements must be Comparable
 */
class MinPQ<T : Comparable<T>>() {
    var heap = MinHeap<T>()

    /*
        @param keys List of comparable keys to
                    init MinPQ with
    */
    constructor (keys: ArrayList<T>): this() {
        for(key in keys) {
            insert(key)
        }
    }

    /*
        Insert element into MinPQ.

        Element will be added to end of MinPQ and
        will then "swim" upwards.

        @param key Element to insert into MinPQ
     */
    fun insert(key: T) {
        heap.add(key)
        heap.swim(heap.size() - 1)
    }

    /*
        This function is called if an element's
        priority was just updated to a lower
        priority and might need to "swim".

        @param ele Element that was updated
     */
    fun reheapify(ele: T) {
        heap.swim(heap.find(ele))
    }

    /*
        Get the minimum element of MinPQ, stored
        at index 1.

        Element will not be removed.

        @return T Minimum element in MinPQ
     */
    fun min(): T {
        return heap.get(1)
    }

    /*
        Delete the minimum element of MinPQ.

        @return T Minimum element in MinPQ
     */
    fun delMin(): T {
        var min = heap.get(1)

        heap.swap(1, heap.size() - 1)
        heap.remove(heap.size() - 1)
        heap.sink(1)

        return min
    }

    /*
        Helper function to check if MinPQ is empty

        @return true if(MinPQ is empty)
        @return false if(MinPQ is not empty)
     */
    fun isEmpty(): Boolean {
        return heap.size() == 0
    }

    /*
        Helper function to return actual size of MinPQ.
        Index 0 is not used, so size is decremented.

        @return Int Number of elements in MinPQ
     */
    fun size(): Int {
        return heap.size() - 1
    }
}

/*
    Native Kotlin implementation of an undirected graph

    All edges are bidirectional.

    Weights can exist on edges (must be Comparable)
 */
class UndirectedGraph() {

    /*
        map of all nodes in this graph
        key:    name of node
        val:    node obj
    */
    var nodes = HashMap<String, GraphNode>()

    /*
        used to keep track of the last node that
        dijkstra alj was used on
    */
    var pathsToNode = ""

    /*
        @param nodeList HashMap of nodes
    */
    constructor(nodeList: HashMap<String, GraphNode>) : this() {
        nodes = nodeList
    }

    /*
        add new node to graph

        @param node New node to be added
    */
    fun addNode(node: GraphNode) {
        nodes.put(node.label, node)
    }

    /*
        create new bidirectional edge between 2 nodes 
        with cost to traverse

        @param src First edge in new bidirectional edge
        @param dst First edge in new bidirectional edge
        @param cost Comparable value for giving edges weights
    */
    fun addEdge(src: GraphNode, dst: GraphNode, cost: Int) {
        src.addEdge(dst, cost)
        dst.addEdge(src, cost)
    }

    /*
        find node object in list of nodes in graph

        @param target Name of node to find

        @return GraphNode Node object that was found
    */
    fun findNode(target: String): GraphNode? {
        return nodes.get(target)
    }

    /*
        compute the shortest paths to every node from the given node

        implementation of Dijkstra's alg

        @param src Node to be used as source in path calculation
    */ 
    fun dijkstra(src: GraphNode) {
        pathsToNode = src.label

        var visitedNodes = ArrayList<GraphNode>()

        // MinPQ where lowest path cost src is minimum
        var unvisitedNodes = MinPQ<GraphNode>() 

        visitedNodes.add(src)

        // init
        src.leastCost = 0;

        // find src's neighbors and make their least cost 
        // the edge cost between them
        for(node in nodes.values) {
            if(node != src) {
                if(node.neighbors.contains(src)) {
                    node.leastCost = src.edges.get(src.neighbors.indexOf(node)).cost
                    node.prev = src
                }

                // add every node besides src to unvisited nodes
                unvisitedNodes.insert(node)
            }
        }

        // loop thru all unvisited nodes to calculate 
        // least cost paths to src
        while(visitedNodes.size != nodes.size) {
            // w will be node with current least cost path to src
            var w = unvisitedNodes.delMin()

            visitedNodes.add(w)

            /*
                calculate least cost path to src from all of w's neighbors
                that haven't been visited already
            */
            for(node in w.neighbors) {
                if(!visitedNodes.contains(node)) {
                    if(w.leastCost < Int.MAX_VALUE) {
                        node.leastCost = minOf(node.leastCost, 
                                                    w.leastCost + w.edges.get(w.neighbors.indexOf(node)).cost)

                        // if leastCost was just updated, store and reorder heap
                        if(node.leastCost == w.leastCost + w.edges.get(w.neighbors.indexOf(node)).cost) {
                            node.prev = w

                            unvisitedNodes.reheapify(node)
                        }
                    }
                }
            }
        }
    }

    /*
        print all of the shortest paths from the src node 
        to all other nodes
    */
    fun printShortestPaths() {
        println("SHORTEST PATHS FROM NODE: $pathsToNode")

        for(node in nodes.values) {
            print("Node ${node.label} has distance:\t")

            if(node.leastCost == Int.MAX_VALUE) {
                println("unreachable")
            }
            else {
                println(node.leastCost)
            }
        }
    }

    /*
        print shortest path from dst to last src used in    
        dijkstra()

        @param dst Destination node to print path from
    */
    fun printShortestPathFromDestination(dst: GraphNode) {
        println("Shortest path from $pathsToNode to ${dst.label}")

        var copy = dst

        var nodeList = ArrayList<String>()
    
        nodeList.add(copy.label)

        while(copy.prev != null) {
            nodeList.add(copy.prev!!.label)

            copy = copy.prev!!
        }

        for (i in nodeList.size - 1 downTo 1) {
            print("${nodeList.get(i)} -> ")
        }

        println(nodeList.get(0))

        println("Total cost of path: ${dst.leastCost}")
    }

    /*
        print list representation of graph
    */
    fun printGraph() {
        for(node in nodes.values) {
            print(node.label)

            for(edge in node.edges) {
                print(" -> ${edge.destination.label}(${edge.cost})")
            }

            println()
        }
    }
}

/*
    Node class used for graphs

    Nodes are represented by a string

    @param label Text representation of node
*/
class GraphNode(var label: String): Comparable<GraphNode> {
    var neighbors = ArrayList<GraphNode>()
    var edges = ArrayList<GraphEdge>()

    // previous node along the shortest path
    var prev: GraphNode? = null               

    // cost along shortest path to this node  
    var leastCost: Int = Int.MAX_VALUE      
 
    /*
        add edge to node

        @param newNeighbor Node used to create edge to from this node
        @param cost Weight used for edge to newNeighbor
    */
    fun addEdge(newNeighbor: GraphNode, cost: Int) {
        edges.add(GraphEdge(newNeighbor, cost))
        neighbors.add(newNeighbor)
    }

    /*
        least cost to last src used in Graph.dijkstra() 
        is used to compare

        @return 1 if(this.leastCost > other.leastCost)
        @return 0 if(this.leastCost == other.leastCost)
        @return -1 if(this.leastCost < other.leastCost)
    */
    override fun compareTo(other: GraphNode): Int {
        return this.leastCost.compareTo(other.leastCost)
    }
}

/*
    Edge class used for graphs

    Edges have sources, destinations, and weights (costs)
    Edges are stored by source so source is known already

    @param destination Node at end of edge
    @param cost Weight used for edge
*/
class GraphEdge(var destination: GraphNode, var cost: Int) {
    
}

fun main(args: Array<String>) {

    // create empty graph
    var graph = UndirectedGraph()

    // create nodes to be used in graph
    var node0 = GraphNode("0")
    var node1 = GraphNode("1")
    var node2 = GraphNode("2")
    var node3 = GraphNode("3")
    var node4 = GraphNode("4")
    var node5 = GraphNode("5")
    var node6 = GraphNode("6")
    var node7 = GraphNode("7")
    var node8 = GraphNode("8")

    // insert nodes into graph
    graph.addNode(node0)  
    graph.addNode(node1)  
    graph.addNode(node2)  
    graph.addNode(node3)  
    graph.addNode(node4)    
    graph.addNode(node5)  
    graph.addNode(node6)  
    graph.addNode(node7)
    graph.addNode(node8)

    // create edges between nodes
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

    graph.printGraph()

    // calculate shortest paths from node0
    graph.dijkstra(node0)

    graph.printShortestPaths()
    graph.printShortestPathFromDestination(node4)


    /*  -- OUTPUT -- 
        0 -> 1(4) -> 7(8)
        1 -> 0(4) -> 2(8) -> 7(11)
        2 -> 1(8) -> 3(7) -> 8(2) -> 5(4)
        3 -> 2(7) -> 4(9) -> 5(14)
        4 -> 3(9) -> 5(10)
        5 -> 2(4) -> 3(14) -> 4(10) -> 6(2)
        6 -> 5(2) -> 7(1) -> 8(6)
        7 -> 0(8) -> 1(11) -> 6(1) -> 8(7)
        8 -> 2(2) -> 6(6) -> 7(7)
        SHORTEST PATHS FROM NODE: 0
        Node 0 has distance:    0
        Node 1 has distance:    4
        Node 2 has distance:    12
        Node 3 has distance:    19
        Node 4 has distance:    21
        Node 5 has distance:    11
        Node 6 has distance:    9
        Node 7 has distance:    8
        Node 8 has distance:    14
        Shortest path from 0 to 4
        0 -> 7 -> 6 -> 5 -> 4
        Total cost of path: 21
     */
}