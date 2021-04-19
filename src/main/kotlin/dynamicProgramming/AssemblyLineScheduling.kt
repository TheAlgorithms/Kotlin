package dynamicProgramming

import kotlin.math.min


/*
 * This is a dynamic programming implementation of assembly line scheduling.
 * @Params n- number of stations, a- service time at each station, t- line switch time from each station, e- entry time, x- exit time
 * @Return minimum time to cross n stations
 * */
fun AssemblyLineScheduling(n:Int,a:Array<IntArray>,t:Array<IntArray>,e:IntArray,x:IntArray):Int {

    var L1:IntArray =  IntArray(n);
    var L2:IntArray = IntArray(n) ;
    var i=0;

    L1[0] = e[0] + a[0][0];

    L2[0] = e[1] + a[1][0];

    for(i in 1..n-1)
    {
        L1[i] = min(L1[i - 1] + a[0][i],
                L2[i - 1] + t[1][i] + a[0][i]);
        L2[i] = min(L2[i - 1] + a[1][i],
                L1[i - 1] + t[0][i] + a[1][i]);
    }

    return min(L1[n-1] + x[0],
            L2[n-1] + x[1]);


}
