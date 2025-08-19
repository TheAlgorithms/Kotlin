/*This is an algorithm of sorting an array/list
 * the elements of the array will get rearranged in alphabetical order after 
 * the execution of the code*/
class OrderedArray<T:Comparable<T>>(list:MutableList<T>){

    var items: MutableList<T>  = this.quicksort(list) as MutableList<T>

    /**
     * Use quicksort algorithm to order elements in array
     */
    fun quicksort(its:List<T>):List<T>{
        if (its.count() < 1) return  its
        val pivot = its[its.count()/2]
        val equal = its.filter { it == pivot }
        val less = its.filter { it < pivot }
        val greater = its.filter { it > pivot }
        return quicksort(less) + equal + quicksort(greater)
    }

    fun insert(element:T){
        val position = findElementPosition(element)
        this.items.add(position, element)
    }

    /**
     * Use binarySearch algorithm to find the position for the new element in array
     */

    fun findElementPosition(element:T):Int{
        var rangeStart = 0
        var rangeEnd = this.items.count()
        while (rangeStart < rangeEnd) {
            val midIndex = rangeStart + (rangeEnd - rangeStart)/2
            if (this.items[midIndex] == element) {
                return midIndex
            } else if (this.items[midIndex] < element){
                rangeStart = midIndex + 1
            } else {
                rangeEnd = midIndex
            }
        }
        return rangeStart
    }

    override fun toString():String = this.items.toString()

}



fun main(args: Array<String>) {


    println("\nOriginal list:")
    val names = listOf<String>("Abhi", "Suman", "Misty", "Rhea", "Mukesh", "Ramesh", "Sunny") as MutableList<String>
    println(names)
    println("\nOrdered list:")
    val ordered =  OrderedArray<String>(names)
    println(ordered)

    val n1 = "Suresh"
    println("\nAdding ${n1} to the list:")
    ordered.insert(n1)
    println(ordered)

    val n2 = "Sachin"
    println("\nAdding ${n2} to the list:")
    ordered.insert(n2)
    println(ordered)

}
