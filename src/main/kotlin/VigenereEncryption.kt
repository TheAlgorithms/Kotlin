fun vigenere(text: String, key: String, encrypt: Boolean = true): String {
    val t = if (encrypt) text.toUpperCase() else text
    val sb = StringBuilder()
    var ki = 0
    for (c in t) {
        if (c !in 'A'..'Z') continue
        val ci = if (encrypt)
            (c.toInt() + key[ki].toInt() - 130) % 26
        else
            (c.toInt() - key[ki].toInt() +  26) % 26
        sb.append((ci + 65).toChar())
        ki = (ki + 1) % key.length
    }
    return sb.toString()
}

fun main(args: Array<String>) {
    val key = "LEMON"
    val text = "ATTACKATDAWN"
    val encoded = vigenere(text, key)
    println(encoded)
    val decoded = vigenere(encoded, key, false)
    println(decoded)
}