package dynamicProgramming

fun Int.isPrime() = this > 1 && (2..(this / 2)).all { this % it != 0 }