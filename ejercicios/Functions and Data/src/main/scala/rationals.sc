  val x = new Rational(1 , 3)
  val y = new Rational(5 , 7)
  val z = new Rational(3 , 2)
  x.numer
  x.denom

  x.add(y)
  x.sub(y).sub(z)
  y.add(y)
  x.less(y)
  x.max(y)
  /*val strange = new Rational(1,0)
  strange.add(strange)*/
  new Rational(2)

  new Rational(1,2).numer

  new Rational(1,2).less(new Rational(2,3))


class Rational (x: Int , y: Int) {
  require(y !=0,"denominator must be nonzero")

  def this(x: Int) = this(x,1)

  private def gcd(a: Int, b: Int): Int = if (b==0) a else gcd(b, a % b)
  /*private val g = gcd(x ,y )
  def numer = x / g
  def denom = y / g*/

  def numer = x
  def denom = y

  def less(that: Rational) = numer * that.denom < that.numer * denom
  def max(that: Rational) = if (this.less(that)) that else this

  def add (that: Rational) =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom)

  def neg : Rational = new Rational(-numer, denom)

  def sub(that: Rational) = add(that.neg)

  override def toString = {
    val g = gcd(numer , denom)
    numer/g + "/" + denom/g
  }

}