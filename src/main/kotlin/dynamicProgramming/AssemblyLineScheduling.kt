package dynamicProgramming

import kotlin.math.min


/*
 * This is a dynamic programming implementation of assembly line scheduling.
 * @Params n- number of stations, a- service time at each station, t- line switch time from each station, e- entry time, x- exit time
 * @Return minimum time to cross n stations
 * */
fun assemblyLineScheduling(n:Int, a:Array<IntArray>, t:Array<IntArray>, e:IntArray, x:IntArray):Int {

    var line1 =  IntArray(n)
    var line2 = IntArray(n)

    line1[0] = e[0] + a[0][0]

    line2[0] = e[1] + a[1][0]

    for(i in 1..n-1)
    {
        line1[i] = min(line1[i - 1] + a[0][i],
                line2[i - 1] + t[1][i] + a[0][i])
        line2[i] = min(line2[i - 1] + a[1][i],
                line1[i - 1] + t[0][i] + a[1][i])
    }

    return min(line1[n-1] + x[0],
            line2[n-1] + x[1])


}