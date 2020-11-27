package math

import java.util.Arrays.sort

fun median(values: IntArray): Double {
    sort(values)
    return when {
        values.size % 2 == 0 -> getHalfwayBetweenMiddleValues(values)
        else -> getMiddleValue(values)
    }
}

fun getHalfwayBetweenMiddleValues(values: IntArray): Double {
    val arraySize = values.size
    val sumOfMiddleValues = (values[arraySize / 2] + values[(arraySize / 2) - 1 ])
    return sumOfMiddleValues / 2.0
}

fun getMiddleValue(values: IntArray): Double {
    return values[values.size / 2].toDouble()
}
