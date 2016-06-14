val x = 0
def f(y: Int) = y + 1
val result  = {
  val x = f(3)
  x * x
}


val result2  = {
  val x = f(3)
  x * x
}+x

def abs(x: Double) = if (x < 0) -x else x

def sqrt(x: Double) = {


  def sqrtIter(guess: Double): Double =
    if (isGoodEnoug(guess)) guess
    else sqrtIter(improve(guess))

  def isGoodEnoug(guess: Double) =
    abs(guess * guess - x)/x < 0.001

  def improve(guess: Double) = (guess + x / guess) / 2

  sqrtIter(1.0)
}
sqrt(9)