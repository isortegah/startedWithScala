type Set = Int => Boolean

def singletonSet(elem: Int): Set = (x: Int) => x == elem
def contains(s: Set, elem: Int): Boolean = s(elem)

println(contains(singletonSet(1),1))



type Set1 = Int => Boolean

val isEven: Set1 = _ % 2 == 0
println(isEven(4))


val incrementor = (x: Int) => x + 1
incrementor(1)

def strToInt(x: String) = x.toInt
"123"
val y: Int = strToInt("123")
math.max(strToInt("123"), 134)

List(1,2,3,4).min
List(1,2,3,4).min(new Ordering[Int] { def compare(a: Int, b: Int) = b compare a })
  