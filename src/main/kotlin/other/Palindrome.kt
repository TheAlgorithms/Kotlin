package other

import java.text.Normalizer
import java.util.regex.Pattern

/**
 * A palindrome is a word, number, phrase, or other sequence
 * of characters which reads the same backward as forward,
 * such as madam, racecar. There are also numeric palindromes,
 * particularly date/time stamps using short digits 11/11/11 11:11
 * and long digits 02/02/2020
 *
 * This function
 * @param text The text to be checked if it is a palindrome
 * @return return true if the text is a Palindrome
 */
fun isPalindrome(text: String): Boolean {

    val normalizedText = text.normalize()
    for(i in normalizedText.indices)
        if(normalizedText[i] != normalizedText[normalizedText.length - (i + 1)])
            return false
    return true;
}


fun String.normalize(): String {
    val nfdNormalizedString = Normalizer.normalize(this, Normalizer.Form.NFD)
    return Pattern
        .compile("\\p{InCombiningDiacriticalMarks}+")
        .matcher(nfdNormalizedString)
        .replaceAll("")
        .toLowerCase()
        .replace(" ", "")

}