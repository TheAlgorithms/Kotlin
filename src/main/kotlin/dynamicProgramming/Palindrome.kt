package dynamicProgramming

fun isPalindrome(input: String): Boolean {
    return if (input.length <= 1) {
        true
    } else {
        val lastIndex = input.length - 1
        val firstChar = input[0]
        val lastChar = input[lastIndex]
        val subInput = input.substring(1, lastIndex)
        (firstChar == lastChar) && isPalindrome(subInput)
    }
}
