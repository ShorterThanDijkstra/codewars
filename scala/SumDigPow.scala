// https://www.codewars.com/kata/5626b561280a42ecc50000d1/train/scala

import scala.annotation.tailrec
def toDigitsRev(l: Long): List[Long] =
  if l < 10 then List(l)
  else (l % 10) :: toDigitsRev(l / 10)

def hasProperty(l: Long): Boolean =
  def go(sum: Long, digits: List[Long], index: Long): Boolean =
    digits match
      case head :: next => {
        val pow = math.pow(head, index);
        go(sum + pow.toLong, next, index + 1)
      }
      case Nil => sum == l
  go(0, toDigitsRev(l).reverse, 1)

def sumDigPow(a: Long, b: Long): List[Long] =
  if a > b then Nil
  else if hasProperty(a) then a :: sumDigPow(a + 1, b)
  else sumDigPow(a + 1, b)

// @main
// def main() =
//   println(sumDigPow(1, 100))
