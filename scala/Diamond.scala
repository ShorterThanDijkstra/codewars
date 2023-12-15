def build(n: Int): String =
  def buildFirstLines(space: Int, star: Int): String =
    if star == n then "*" * n ++ "\n"
    else
      " " * space ++ "*" * star ++ "\n" ++ buildFirstLines(
        space - 1,
        star + 2
      )
  def buildSecondLines(space: Int, star: Int): String =
    if star == 1 then " " * space ++ "*" ++ "\n"
    else
      " " * space ++ "*" * star ++ "\n" ++ buildSecondLines(
        space + 1,
        star - 2
      )
  if n == 1 then "*\n"
  else buildFirstLines((n - 1) / 2, 1) ++ buildSecondLines(1, n - 2)

def diamond(n: Int): Option[String] =
  if n <= 0 || n % 2 == 0
  then None
  else Some(build(n))

@main
def main() = 
  println(diamond(1))