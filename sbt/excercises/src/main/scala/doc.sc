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