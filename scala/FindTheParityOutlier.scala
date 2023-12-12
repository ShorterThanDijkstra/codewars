object Parity {

  def findOutlier(integers: List[Int]): Int =
    val even = integers.filter(_ % 2 == 0)
    val odd = integers.filter(_ % 2 != 0)
    if even.size == 1 then even(0) else odd(0)
}
