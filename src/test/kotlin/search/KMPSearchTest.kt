package search

import org.junit.Test

class KMPSearchTest{
    @Test
    fun kmpSearchFound(){
        assert(kmpSearch("I love Kotlin", "Kotlin") == 7)
    }

    @Test
    fun kmpSearchNotFound(){
        assert(kmpSearch("I love Kotlin", "C++") == -1)
    }
}