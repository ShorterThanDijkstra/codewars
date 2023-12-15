object Multiplication:

    def mulDigits(n: Int): Int = 
        if n < 10 then n
        else (n % 10) * mulDigits(n / 10)

    def persistence(n: Int): Int = 
        if n < 10 then 0
        else {val res = mulDigits(n); println(res); 1 + persistence(res)}

// @main
// def main()=
//     val res = Multiplication.persistence(999)
    // println(res)
        