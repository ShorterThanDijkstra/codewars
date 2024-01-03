import scala.collection.mutable.Set
object SumSquaredDivisors {
  val cache = Set[Long]()

  def isSquare(n: Long): Boolean =
    if (cache.exists(_ == n)) then true
    else {
      val sqrt = math.sqrt(n.toDouble).toLong
      if sqrt * sqrt == n
      then {
        cache.add(n)
        true
      } else false
    }

  def sumSquare(n: Long): Long =
    def go(i: Long): Long =
      if i > n then 0
      else if n % i == 0 then i * i + go(i + 1)
      else go(i + 1)
    go(1)

  def listSquares(m: Long, n: Long): List[(Long, Long)] =
    if m > n then Nil
    else {
      val sums = sumSquare(m);
      if isSquare(sums) then (m, sums) :: listSquares(m + 1, n)
      else listSquares(m + 1, n)
    }

  def listSquared(m: Long, n: Long): String =
    listSquares(m, n).toString()
}

@main def main() =
  println(SumSquaredDivisors.listSquared(1, 250))
