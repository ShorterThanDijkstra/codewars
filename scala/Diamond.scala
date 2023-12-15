def build(n: Int): String =
  def buildLine(i: Int): String =
    if i< n / 2 then {val star = (n - 1) / 2; val space
def diamond(n: Int): Option[String] =
  if n < 0 || n % 2 == 0
  then None
  else Some(build(n))
