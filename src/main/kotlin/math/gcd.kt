package math


/**
 * Euclidean Algorithm to find gcd of 2 numbers:
 * If we subtract a smaller number from a larger one (we reduce a larger number), GCD doesn’t change.
 * So if we keep subtracting repeatedly the larger of two, we end up with GCD.
 * Now instead of subtraction, if we divide the smaller number, the algorithm stops when we find the remainder 0.

 * Time Complexity: O(Log min(a, b))
 * Auxiliary Space: O(Log (min(a,b))

 *@param a Long number
 *@param b Long number
 * @return gcd of a and b
 */

fun gcd(a:Long,b:Long):Long{
    if(a==0)return b;
    if(b==0)return a;
    return gcd(b%a,a)
}
