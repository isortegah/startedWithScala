object session{
  def sqrt(x: Double) = {
    def abs(x: Double) = if (x < 0) -x else x

    def sqrtIter(guess: Double, x: Double): Double =
      if (isGoodEnoug(guess, x)) guess
      else sqrtIter(improve(guess, x), x)

    def isGoodEnoug(guess: Double, x: Double) = abs(guess * guess - x)/x < 0.001

    def improve(guess: Double, x: Double) = (guess + x / guess) / 2

    sqrtIter(1.0, x)
  }
  sqrt(9)



  sqrt(2)
}
