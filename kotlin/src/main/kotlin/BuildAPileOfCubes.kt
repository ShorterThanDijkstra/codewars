class BuildAPileOfCubes {
    fun findNb(m: Long): Long = findNb(m, 1)

    private fun findNb(m: Long, k: Long): Long {
        if (m < 0) {
            return -1
        }
        if (m == 0L) {
            return k - 1
        }
        return findNb(m - k * k * k, k + 1)
    }
}