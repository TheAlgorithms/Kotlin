package array

fun <T>ArrayList<T>.removeAll(): ArrayList<T> {
    if (this.removeAll(this)){
        return this
    }
    return this
}