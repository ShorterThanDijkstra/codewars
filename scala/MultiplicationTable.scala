object Kata {
  def multiplicationTable(size: Int): List[List[Int]] =
    def go(i: Int, first: List[Int]): List[List[Int]] =
      if i == size then Nil
      else first.map(_ * (i + 1)) :: go(i + 1, first)
    val first = Range(1, size + 1).toList
    go(0, first)
}

@main
def main() =
  println(Kata.multiplicationTable(0))
