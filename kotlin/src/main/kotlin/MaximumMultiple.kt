class MaximumMultiple {
    fun maxMultiple(divisor: Int, bound: Int): Int {
        var n = 0
        while (n < bound) {
            n += divisor
        }
        if (n == bound) {
            return n
        }
        return n - divisor
    }
}

fun main() {
    val test = MaximumMultiple()
    println(test.maxMultiple(10, 50))
}