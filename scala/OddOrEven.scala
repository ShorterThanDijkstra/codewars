def oddOrEven(xs: Seq[Int]): String = 
    if xs.foldLeft(0)(_ + _)  % 2 == 0
    then "even"
    else "odd"
