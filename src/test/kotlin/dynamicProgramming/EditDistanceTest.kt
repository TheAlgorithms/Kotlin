package dynamicProgramming

import org.junit.Test

class EditDistanceTest {
    @Test
    fun testForInsertion() {
        assert(editDistance("time", "timetable") == 5)
    }

    @Test
    fun testForReplacement() {
        assert(editDistance("rice", "race") == 1)
    }

    @Test
    fun testForInsertionReplacementAndDeletion() {
        assert(editDistance("saturday", "friday") == 5)
    }
}