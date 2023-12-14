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
object Main:
  @main
  def main(args: String*): Unit =
    for arg <- args do println(arg)
