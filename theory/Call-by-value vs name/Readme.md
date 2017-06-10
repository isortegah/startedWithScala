Aqui un ejemplo de Martin Odersky:

def test (x:Int, y: Int)= x*x
Se examina las estrategias de evaluacion por nombre o valor:

test (2,3)
call by value: test(2,3) -> 2*2 -> 4
call by name: test(2,3) -> 2*2 -> 4
Aqui el resultado se obtiene con el mismo numero de pasos.

test (3+4,8)
call by value: test (7,8) -> 7*7 -> 49
call by name: (3+4) (3+4) -> 7(3+4)-> 7*7 ->49
Aqui la evaluacion por valor es mas rapido.

test (7,2*4)
call by value: test(7,8) -> 7*7 -> 49
call by name: 7 * 7 -> 49
La evaluacion por nombre es mas rapida.

test (3+4, 2*4) 
call by value: test(7,2*4) -> test(7, 8) -> 7*7 -> 49
call by name: (3+4)(3+4) -> 7(3+4) -> 7*7 -> 49
En este ejemplo se toma el mismo numero de pasos.