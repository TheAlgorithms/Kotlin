package sort


// Shell Sort Implemebtation
/*
*Time Complexity
* * Best : O(nlog n)
* * Average : O(nlog n)
* * Worst  : O(n^2)
* Space Complexity : o(n)
* Not Stable
* */



fun <T: Comparable<T>> shellSort(array: Array<T>){

    val length = array.size - 1;

    var gap = length /2;

    while( gap > 0){
        gap /= 2 ;

        for (i in gap..length){
            val temp = array[i];
            var j = i ;


            while(j >= gap && array[j - gap] > temp){
                array[j] = array[j - gap]
                j -= gap;

            }

            array[j] = temp;
        }

    }

}

