fun HashMap<String, Int>.add(key: String, num: Int) {
    val oldVal = this.getOrDefault(key, 0)
    this[key] = num + oldVal
}

fun HashMap<String, Int>.multAndAdd(other: HashMap<String, Int>, num: Int) {
    for (key in other.keys) {
        val otherValue = other.getOrDefault(key, 0)
        val thisValue = this.getOrDefault(key, 0)
        this[key] = thisValue + otherValue * num

    }
}

fun Char.isOpenBracket(): Boolean {
    return this == '{'
            || this == '['
            || this == '('
}

fun Char.isCloseBracket(open: Char): Boolean {
    return this == '}' && open == '{'
            || this == ']' && open == '['
            || this == ')' && open == '('
}

fun Char.toDigit(): Int {
    return this - '0'
}

fun parseBracket(formula: String, i: Int, result: HashMap<String, Int>): Int {
    var i = i
    val open = formula[i]
    i += 1
    val inner = HashMap<String, Int>()
    while (i < formula.length && !formula[i].isCloseBracket(open)) {
        i = parseAtoms(formula, i, inner)
    }
    if (!(i < formula.length && formula[i].isCloseBracket(open))) {
        throw IllegalArgumentException()
    }
    i += 1
    var num = 0
    while (i < formula.length && formula[i].isDigit()) {
        num = num * 10 + formula[i].toDigit()
        i += 1
    }
    if (num == 0) {
        num = 1
    }
    result.multAndAdd(inner, num)
    return i
}

fun parseAtoms(formula: String, i: Int, result: HashMap<String, Int>): Int {
    var i = i
    val len = formula.length
    val c = formula[i]
    if (c.isUpperCase() && i < len - 1 && formula[i + 1].isLowerCase()) {
        val atom = formula.substring(i, i + 2)
        i += 2
        var num = 0
        while (i < len && formula[i].isDigit()) {
            num = num * 10 + formula[i].toDigit()
            i += 1
        }
        if (num == 0) {
            num = 1
        }
        result.add(atom, num)
        return i
    }
    if (c.isUpperCase()) {
        val atom = formula.substring(i, i + 1)
        i += 1
        var num = 0
        while (i < len && formula[i].isDigit()) {
            num = num * 10 + formula[i].toDigit()
            i += 1
        }
        if (num == 0) {
            num = 1
        }
        result.add(atom, num)
        return i
    }
    if (!c.isOpenBracket()) {
        throw IllegalArgumentException()
    }
    return parseBracket(formula, i, result)
}

fun getAtoms(formula: String): Map<String, Int> {
    val result = HashMap<String, Int>()
    var i = 0
    val len = formula.length
    while (i < len) {
        i = parseAtoms(formula, i, result)
    }
    return result
}

fun main() {
    val atoms = getAtoms("Au5(C2H5[OH)3Li]3")
    println(atoms)
}