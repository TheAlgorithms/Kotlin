package io.uuddlrlrba.ktalgs.sorts

@ComparisonSort
@StableSort
class ShellSort : AbstractSortStrategy() {
    public override fun<T : Comparable<T>> perform(arr: Array<T>) {
        var h = 1
        while (h < arr.size / 3) {
            h = h * 3 + 1
        }

        while (h >= 1) {
            for (i in h until arr.size) {
                for (j in i downTo h step h) {
                    if (arr[j - h] < arr[j]) break
                    arr.exch(j, j - h)
                }
            }
            h /= 3
        }
    }
}
