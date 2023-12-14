object BouncingBall:
  def bouncing(h: Double, bounce: Double, window: Double): Int =
    val next = h * bounce
    if next <= window then 1
    else 2 + bouncing(next, bounce, window)

  def bouncingBall(h: Double, bounce: Double, window: Double): Int = 
    if !(h > 0 && bounce > 0 & bounce < 1 && window < h) then -1
    else bouncing(h, bounce, window)
  