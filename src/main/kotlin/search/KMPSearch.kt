package search

private const val NOT_FOUND = -1

/**
 * Knuth–Morris–Pratt string-searching algorithm searches for occurrences of a "word" W within a main "text string" S
 *
 * Worst-case performance	O(n*m)
 * Best-case performance	O(n)
 * Worst-case space complexity	O(m)
 * */


/**
 * @param s the string in which the search will be carried out
 * @param w search string
 * @return index of the substring found (-1 if not found)
 */

fun kmpSearch(s: String, w: String): Int {
    var i = 0
    var j = 0
    val t = table(w)
    while (j + i < s.length) {
        if (w[i] == s[j + i]) {
            if (i == w.length - 1) {
                return j
            }
            i++
        } else {
            j = j + i - t[i]
            i = t[i].takeIf { t[i] > NOT_FOUND } ?: 0
        }
    }
    return NOT_FOUND
}

/**
 * The goal of the table is to allow the algorithm not to match any character of S more than once.
 * @param s search string
 * @return partial match table
 * */
private fun table(s: String): IntArray {
    val t = IntArray(s.length)
    var pos = 2
    var cnd = 0
    t[0] = -1
    t[1] = 0
    while (pos < s.length) {
        if (s[pos - 1] == s[cnd]) {
            cnd++
            t[pos] = cnd
            pos++
        } else if (cnd > 0) {
            cnd = t[cnd]
        } else {
            t[pos] = 0
            pos++
        }
    }
    return t
}
