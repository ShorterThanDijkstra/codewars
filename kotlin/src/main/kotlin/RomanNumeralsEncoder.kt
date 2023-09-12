class RomanNumeralsEncoder {
    fun encode(num: Int): String {
        if (num < 0) {
            throw IllegalArgumentException()
        }
        if (num == 0) {
            return ""
        }
        val builder = StringBuilder()
        var num = num
        while (num > 0) {
            val current: Char
            val next1: Char
            val next2: Char
            val place: Int
            when {
                num / 1000 > 0 -> {
                    current = 'M'
                    next1 = '-'
                    next2 = '-'
                    place = 1000
                }
                num / 100 > 0 -> {
                    current = 'C'
                    next1 = 'D'
                    next2 = 'M'
                    place = 100
                }
                num / 10 > 0 -> {
                    current = 'X'
                    next1 = 'L'
                    next2 = 'C'
                    place = 10
                }
                else -> {
                    current = 'I'
                    next1 = 'V'
                    next2 = 'X'
                    place = 1
                }
            }
            num = process(num, builder, current, next1, next2, place)
        }
        return builder.toString()
    }

    private fun process(num: Int, builder: StringBuilder, current: Char, next1: Char, next2: Char, place:Int): Int {
        val digit = num / place
        return when {
            digit == 9 -> {
                builder.append(current)
                builder.append(next2)
                num % place
            }
            digit == 4 -> {
                builder.append(current)
                builder.append(next1)
                num % place
            }
            digit >= 5 -> {
                builder.append(next1)
                num - (5*place)
            }
            else -> {
                builder.append(current)
                num - place
            }
        }
    }

}