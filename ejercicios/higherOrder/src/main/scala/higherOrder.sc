def sumInts(a: Int, b: Int): Int = {
  if(a > b ) 0 else a + sumInts(a+1, b) }

sumInts(1,10)

def cube(x: Int): Int = x * x * x

cube(3)

def sumCubes(a: Int , b: Int): Int = {
  if (a > b) 0 else cube(a) + sumCubes(a + 1, b)
}

sumCubes(1 , 3)


(x: Int)=> x * x * x


//Higher order function

def sum(f: Int => Int ,a: Int, b: Int):Int ={
  def loop(a: Int, acc: Int):Int ={
    if(a > b) acc
    else
      loop(a+1,f(a)+acc)
  }
  loop(a,0)
}

sum(x => x * x, 3, 5)



  def sum1(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, acc + f(a))
    }
    loop(a, 0)
  }                                               //> sum: (f: Int => Int)(a: Int, b: Int)Int

  1+2+3+4+5+6                                     //> res0: Int = 21
  sum1(x => x)(1, 6)                               //> res1: Int = 21

  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)          //> product: (f: Int => Int)(a: Int, b: Int)Int

  product(x => x * x)(3, 4)                       //> res2: Int = 144

  def fact(n: Int) = product(x => x)(1, n)        //> fact: (n: Int)Int

  fact(4)                                         //> res3: Int = 24
  fact(5)                                         //> res4: Int = 120
  fact(6)                                         //> res5: Int = 720

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
  //|  Int)Int

  def product2(f: Int => Int)(a: Int, b: Int): Int =
    mapReduce(f, (x, y) => x * y, 1)(a, b)    //> product2: (f: Int => Int)(a: Int, b: Int)Int

  product2(x => x * x)(3, 4)                      //> res6: Int = 144


// factorial is in a file by itself

def sumInts1(a: Int, b: Int): Int =
  if (a > b) 0 else a + sumInts1(a + 1, b)


def square(x: Int): Int = x * x
def sumSquares(a: Int, b: Int): Int =
  if (a > b) 0 else square(a) + sumSquares(a + 1, b)


def powerOfTwo(x: Int): Int = if (x == 0) 1 else 2 * powerOfTwo(x - 1)
def sumPowersOfTwo(a: Int, b: Int): Int =
  if (a > b) 0 else powerOfTwo(a) + sumPowersOfTwo(a + 1, b)


//======================================================================
//
// first simplification

def sum3(f: Int => Int, a: Int, b: Int): Int =
  if (a > b) 0 else f(a) + sum3(f, a + 1, b)

def id(x: Int): Int = x


def sumInts2(a: Int, b: Int): Int = sum(id, a, b)
def sumSquares2(a: Int, b: Int): Int = sum(square, a, b)
def sumPowersOfTwo2(a: Int, b: Int): Int = sum(powerOfTwo, a, b)


//======================================================================
//
// using anonymous functions

def sumInts3(a: Int, b: Int): Int = sum((x: Int) => x, a, b)
def sumSquares3(a: Int, b: Int): Int = sum((x: Int) => x * x, a, b)