package math


/**
 * Find the Absolute Value of a Number
 *
 * @param num Number
 * @return Absolute value of Number
 */
fun abs_val(num: Int) =
   /**
    * Find the absolute value of a number.
    * >>> abs_val(-5.1)
    * 5.1
    * >>> abs_val(-5) == abs_val(5)
    * True
    * >>> abs_val(0)
    * 0
    */
    when {
        num < 0 -> -num
        else -> num
    }

fun test() {
    println(abs_val(-90)) // Prints +90
    println(abs_val(+90)) // Prints +90
}