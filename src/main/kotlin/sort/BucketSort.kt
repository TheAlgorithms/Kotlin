fun insertionsort(A: ArrayList<Double>) {
    var x = A.size
    var k: Int
    for (j in 1 until x) {
        var keys = A[j]
        k = j - 1
        while (k >= 0 && A[k] > keys) {
            A[k + 1] = A[k]
            i--
        }
        A[k + 1] = keys
    }
}

fun bucketsort(A:Array<Double>){
    var x=A.size
    var bucket = Array<ArrayList<Double>>(x,{i-> ArrayList() })  
    for(i in 0..A.size-1){
        bucket[Math.floor(x*A[i]).toInt()].add(A[i])             
    }
    for(i in 0..A.size-1){
        insertionsort(bucket[i])                               
    }
    for (i in 1..A.size-1){
        bucket[0].addAll(bucket[i])                              
    }
    for (i in bucket[0])
    {
        print("$i ")                                            
    }
}
fun main(arg: Array<String>) {
    print("Enter no. of elements :")
    var n = readLine()!!.toInt()
    println("Enter elements : ")
    var A = Array(n, { 0.0 })
    for (i in 0 until n)
        A[i] = readLine()!!.toDouble()
    bucketsort(A)

}
