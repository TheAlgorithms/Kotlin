package dynamicProgramming

import java.util.Comparator
import java.util.Collections
import kotlin.math.max

/* This algorithm is Weighted Job Scheduling

 * @param jobs - list of jobs with start time, end time and profit
 * @return Maximum profit that can be obtained
 */

class Job(var start: Int, var finish: Int, var profit: Int)

fun findLastNonConflictingJob(jobs: List<Job>, n: Int): Int {
    for (i in n - 1 downTo 0) {
        if (jobs[i].finish <= jobs[n].start) {
            return i
        }
    }
    return -1
}

fun findMaxProfit(jobs: List<Job>): Int {
    Collections.sort(jobs, Comparator.comparingInt { x: Job -> x.finish })

    val n = jobs.size

    val maxProfit = IntArray(n)

    maxProfit[0] = jobs[0].profit

    for (i in 1 until n) {
        val index = findLastNonConflictingJob(jobs, i)

        var incl = jobs[i].profit
        if (index != -1) {
            incl += maxProfit[index]
        }

        maxProfit[i] = max(incl, maxProfit[i - 1])
    }
    return maxProfit[n - 1]
}