val numbers = Array(1, 2, 3, 4, 5)
val sum = numbers.reduceLeft[Int](_+_)