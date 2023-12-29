import scala.collection.mutable.ListBuffer
object Kata {
  def partsSums(l: List[Int]): List[Int] =
    if l.isEmpty then List(0)
    else {
      var sum = l.sum
      val res = ListBuffer[Int]()
      res.addOne(sum)
      for e <- l do
        sum -= e
        res.addOne(sum)
      res.toList
    }
}
@main
def main() =
  println(Kata.partsSums(List(0, 1, 3, 6, 10)))
