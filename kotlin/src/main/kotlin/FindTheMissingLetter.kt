class FindTheMissingLetter {
    fun findMissingLetter(array: CharArray): Char {
        var should = array[0]
        for (c in array.copyOfRange(1, array.size)) {
            should += 1
            if (c != should) {
                return should
            }
        }
        return should
    }
}