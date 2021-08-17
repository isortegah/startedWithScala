//http://www.dccia.ua.es/dccia/inf/asignaturas/LPP/teoria/Tema06-ProgramacionFuncionalScala.html

def max(x: Int, y: Int): Int = if (x > y) x else y

max(2,7)
max(9,4)

//Tuplas
val t: (Int, String, Double) = (21, "Veintiuno", 21.0)
t._1

//Colecciones
val miListaInt: List[Int] = List(1,2,3)
val miListaString: List[String] = List("Hola","que","tal")

//Any
val s: String = "Hola"
val cualquierTipo: Any = s
val listaCualquiera: List[Any] = List("Hola",1,"Adios",2)
listaCualquiera.foreach( x=> println(x))

val cualquierTipo: Any = "Hola"
cualquierTipo.isInstanceOf[String]
cualquierTipo.asInstanceOf[String]

val p: Any = "Hola "
p match {
  case s: String => s+s
  case s: Int => "Int"
  case _ => "Otro tipo"
}

// Definición de funciones de forma declarativa
def max3(x: Int, y: Int, z: Int): Int = max(max(x,y),z)

max3(3,8,6)

def max3(x: Int, y: Int, z: Int): Int = {
  val maxPrimeros = max(x,y)
  max(maxPrimeros,z)
}

max3(9,8,6)


//Valores inmutables
val numbers = Array(1, 2, 3, 4)
val num = numbers(3)
numbers(3) = 100
val numCambiado = numbers(3)

//Listas
val lista: List[Int] = List(1, 2, 3, 4)
val primero = lista.head
val resto = lista.tail
val dobleLista = primero :: resto ::: lista

/* Nil: lista vacía
head: devuelve el primer elemento de la lista
tail: devuelve el resto
isEmpty: comprueba si la lista es vacía
::  : devuelve una nueva lista añadiendo un elemento a su cabeza (similar a cons)
::: : devuelve una nueva lista concatenando dos listas (similar a append)*/

def numElems(lista:List[Int]):Int =
  if (lista.isEmpty) 0 else
    1 + numElems(lista.tail)

numElems(List(1,2,3,4,5,6,8))


def insert(x: Int, lista: List[Int]) : List[Int] =
  if (lista == Nil) x :: Nil else
    if (x < lista.head) x :: lista else
      lista.head :: insert(x, lista.tail)
insert(10, List(-10, -2, 0, 30, 54))

def sort(lista: List[Int]): List[Int] =
  if (lista.isEmpty) Nil else
    insert(lista.head, sort(lista.tail))

sort(List(20,-1,3,34,-10))

def reverse(lista: List[Int]) : List[Int] =
  if (lista.isEmpty) Nil else
    reverse(lista.tail) ::: List(lista.head)

reverse(List(2,5,10,12))

//El tipo función
def sumaDosInts(x: Int, y: Int): Int = {
  x + y
}
def multiplicaDosInts(x: Int, y: Int): Int = {
  x*y
}

var funcionMatematica: (Int, Int) => Int = sumaDosInts
funcionMatematica(3,10)

funcionMatematica = multiplicaDosInts
funcionMatematica(3,10)

val otraFuncionMatematica = sumaDosInts _

def sumaTresInt(x: Int, y: Int, z: Int): Int = {
  x + y + z
}

funcionMatematica = sumaTresInt(10, _: Int , _: Int)
funcionMatematica(2,3)


def prueba(x: Int, f: (Int, Int) => Int) = {
  x + f(x,x)
}
prueba(5, multiplicaDosInts)


def sumatorio(a: Int, b:Int, f:(Int) => Int): Int = {
  if (a > b) 0
  else f(a) + sumatorio(a + 1, b, f)
}

def cuadrado(x: Int) = x * x
def cubo(x: Int) = x * x * x
def suma3(x: Int) = x + 3

sumatorio(1, 10, cuadrado)
sumatorio(1, 10, cubo)
sumatorio(1, 10, suma3)

//Funciones anónimas
(x: Int, y: Int) => {x + y}
val fun: (Int, Int) => Int = (x: Int, y: Int) => {x + y}
fun(2,3)
((x: Int, y: Int) => {x + y})(2,3)
sumatorio(1, 10, (x:Int) => {x+10})

sumatorio(1, 10, (x) => {x+10})
sumatorio(1, 10, x => x+10)
sumatorio(1, 10, _+10)

//Funciones en listas
def suma3(a: Int, b: Int, c: Int) = a + b + c
def mult3(a: Int, b: Int, c: Int) = a * b * c
val listaFuncs: List[(Int,Int,Int)=>Int] = List(suma3 _, mult3 _, (x:Int,y:Int,z:Int)=>x+y*z)
val f = listaFuncs.head
f(1,2,3)

def aplicaLista (lista: List[(Int) => Int], x: Int): Int = {
  if (lista.length == 1) lista.head(x)
  else lista.head(aplicaLista(lista.tail,x))
}
def mas5(x: Int) = x+5
def por8(x: Int) = x*8

val l = List(mas5 _, por8 _, suma3(1, _: Int, 10))
aplicaLista(l, 10)

//Funciones como valores devueltos
def makeSumador(k: Int) : (Int) => Int = {
  (x: Int) => {x + k}
}

val f: (Int) => Int = makeSumador(10)
f(4)

val g: (Int) => Int = makeSumador(100)
g(4)
makeSumador(10)(100)

def makeContador(valorInicial: Int): () => Int = {
  var contador = valorInicial
  () => {
    contador += 1
    contador
  }
}
val c1 = makeContador(10)
val c2 = makeContador(100)
c1()
c1()
c2()
c2()

val lista = List(1,2,3,4,5,6,7,8,9,10,11,12)
lista.count((x:Int) => {x % 2 == 0})
lista.count((x) => {x % 2 == 0})
lista.count(x => x % 2 == 0)
lista.count(_ % 2 == 0)

def par(x:Int): Boolean = {x % 2 == 0}
lista.count(par)

lista.filter(par)

def cuadrado(x:Int) = x*x
lista.map(cuadrado)
List("No","es","elegante","escribir","con","mayusculas").map(s => s.toUpperCase)

lista.filter(par).map(cuadrado)

def miCount(lista:List[Int], p:(Int)=>Boolean): Int = {
  if (lista == Nil) 0
  else if (p(lista.head)) 1+miCount(lista.tail,p)
  else miCount(lista.tail,p)
}

def miMap(lista:List[Int], f:(Int)=>Int): List[Int] = {
  if (lista == Nil) Nil
  else f(lista.head) :: miMap(lista.tail,f)
}

//Funciones genéricas
def miFilter[A](lista: List[A], pred: (A)=>Boolean): List[A] = {
  if (lista.isEmpty) Nil
  else if (pred (lista.head)) lista.head :: miFilter(lista.tail, pred)
  else miFilter(lista.tail, pred)
}

def par(x: Int) = x % 2 == 0

miFilter(List(1,2,3,4), par)
miFilter(List("hola","amigo","adios"),(s: String) => { s.head == 'a'})


def numElems[A](lista:List[A]):Int = {
  if (lista.isEmpty) 0
  else 1 + numElems(lista.tail)
}

def reverse[A](lista: List[A]) : List[A] = {
  if (lista.isEmpty) Nil
  else reverse(lista.tail) ::: List(lista.head)
}

def insert[A](x: A, lista: List[A], menor: (A,A) => Boolean) : List[A] = {
  if (lista == Nil) x :: Nil
  else if (menor(x,lista.head)) x :: lista
  else lista.head :: insert(x, lista.tail, menor)
}

def sort[A](lista: List[A], menor: (A,A) => Boolean): List[A] = {
  if (lista.isEmpty) Nil
  else insert(lista.head, sort(lista.tail, menor), menor)
}

numElems(List(1,2,3,4,5))
numElems(List("Hola" , "Juan", "Saludos"))

reverse(List(1,2,3,4,5))
reverse(List("Hola" , "Juan", "Saludos"))

def menorTuplas(t1: (Int,Int), t2: (Int,Int)) = t1._1+t1._2 < t2._1+t2._2
sort(List((1,2),(3,1),(-1,-2)), menorTuplas)

def emparejar[A,B](lista1: List[A], lista2: List[B]): List[(A,B)] = {
  if (lista1.isEmpty) Nil
  else (lista1.head, lista2.head) :: emparejar(lista1.tail, lista2.tail)
}

emparejar(List(1,2,3,4),List("hola","como","estas","colega"))

//Métodos foldRight y foldLeft

val lista1 = List("hola", "que" , "tal")
lista1.foldLeft("-")((c1: String, c2: String) => {c1 + c2})
lista1.foldRight("-")((c1: String, c2: String) => {c1 + c2})
lista1.foldRight("-")(_+_)

lista1.foldRight(0) ((cad,n) => {cad.length+n})

//Ámbitos
def f(x: Int, y: Int): Int = {
  val z = 5
  x+y+z
}
def g(z: Int): Int = {
  val x = 10
  z+x
}
f(g(3),g(5))

val x = 10
val y = 20

def g(y: Int): Int = {
  x+y
}

def prueba(z: Int): Int = {
  val x = 0
  g(x+y+z)
}

prueba(3)

//Clausuras en Scala
val x = 10
val y = 20
def prueba(y: Int): (Int)=>Int = {
  val x = 0
  (z:Int) => {x+y+z}
}

val f: (Int) => Int = prueba(10)
f(30)

def makeSumador(k: Int): (Int)=>Int = (x: Int) => x + k
val f = makeSumador(10)
val g = makeSumador(100)
f(4)
g(4)

val x = 100

def func1(): () => Int = {
  val x=1
  () => {x+1}
}

def func2(): Int= {
  val x=10
  val f=func1()
  f()
}

func2()

//Definición por comprensión de colecciones
for (x <- (1 to 5)) yield x*x

for (i <- List.range(1, 30) if i % 2 != 0) yield i*i

for (i <- List.range(1, 101) if (i % 2 != 0 && i % 3 == 0)) yield i*i

for(x <- (1 to 3 ); y <- (1 to x)) yield (x,y)

def mulUnoCadaVez(x: Int) = (y: Int) => x * y
mulUnoCadaVez(6)(7)

def mulUnoCadaVez(x: Int)(y: Int) = x * y;
val f = mulUnoCadaVez(20) _
f(2)

sumatorio(1,2,f)