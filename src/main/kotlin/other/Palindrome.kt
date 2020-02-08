package other

import java.text.Normalizer
import java.util.regex.Pattern


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