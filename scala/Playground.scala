// trait Speaker:
//   def speak(): String // has no body, so it’s abstract

// trait TailWagger:
//   def startTail(): Unit = println("tail is wagging")
//   def stopTail(): Unit = println("tail is stopped")

// trait Runner:
//   def startRunning(): Unit = println("I'm running")
//   def stopRunning(): Unit = println("Stopped running")

// class Dog(val name: String) extends Speaker, TailWagger, Runner:
//   def speak(): String = s"Woof!, $name"
// end Dog
// open class Person(name: String)

// @main
// def main() =
//   val p = new Dog("hi")
//   println(p.name)
// object Main:
//   @main
//   def main(args: String*): Unit =
//     for arg <- args do println(arg)
// def tail(n: Int): Unit =
//   if n == Int.MaxValue then ()
//   else tail(n + 1)

class C:
  def f1 = 1
  def f2() = 2
  def f3 = println(3)
  def f4() = println(4)

// @main
// def main() = 
//   val c = C()
//   c.f1
//   c.f2()
//   c.f3
//   c.f4()
