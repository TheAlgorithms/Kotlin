package math

fun closestIntegerOf(x: Float) : Int {
    return if (x >= 0.0f) {
        (x + 0.5f).toInt()
    } else {
        (x - 0.5f).toInt()
    }
}