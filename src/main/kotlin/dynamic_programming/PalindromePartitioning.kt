package dynamic_programming

/**
 * Palindrome Partitioning Algorithm
 *
 * You are given a string as input, and task is to find the minimum number of partitions to be made,
 * in the string sot that the resulting strings are all palindrome
 * eg. s = "nitik"
 * string s can be partitioned as n | iti | k into 3 palindromes, thus the number of partions are 2
 * Time Complexity = O(n^2)
 *
 * */


/**
 * @param String is the string to be checked
 * @param Int is the starting index of the string in consideration
 * @param Int is the ending index of the string in consideration
 * @return whether string is a palindrome or not
 **/
fun isPalindrome(string: String, i: Int, j: Int): Boolean {
    for (l in 0..(j - i) / 2) {
        if (string[l + i] != string[j - l]) {
            return false
        }
    }
    return true
}


/**
 * @param String is the string to be checked
 * @param Int is the starting index of the string in consideration
 * @param Int is the ending index of the string in consideration
 * @return minimum number of partitions required
 **/
fun palindromePartition(string: String, i: Int, j: Int): Int {
    if (i >= j) {
        return 0
    }
    if (isPalindrome(string, i, j)) {
        return 0
    }
    if (dp[i][j] != -1) {
        return dp[i][j]
    }
    var mn = Int.MAX_VALUE
    for (k in i until j) {
        val temp: Int = palindromePartition(string, i, k) + palindromePartition(string, k + 1, j) + 1
        if (temp < mn) {
            mn = temp
        }
    }
    dp[i][j] = mn
    return dp[i][j]
}


/**
 * memoization table
 **/
lateinit var dp: Array<Array<Int>>


/**
 * @param String the string on which algorithm is to be operated
 */
fun initialize(string: String): Int {
    dp = Array(string.length) { Array(string.length) { -1 } }
    return palindromePartition(string, 0, string.length - 1)
}
