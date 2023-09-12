class TwoOldestAges {
    fun twoOldestAges(ages: List<Int>): List<Int> {
        var oldest: Int = ages[0]
        var second: Int = ages[1]
        if (ages[0] < ages[1]) {
            oldest = ages[1]
            second = ages[0]
        }
        for (age in ages.subList(2, ages.size)) {
            if (age < second) {
                continue
            }
            if (age >= oldest) {
                second = oldest
                oldest = age
                continue
            }
            second = age
        }

        return listOf(second, oldest)
    }
}