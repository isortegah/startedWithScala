/**
  * Created by Ivansebastian on 08/06/2016.
  */
package lists

object Lists {
  /**
    * .tail -> Devuelve la lista sin el primer elemento.
    * .head -> Devuelve el primer elemento de la lista.
    *
    * @param xs
    * @return
    */
  def sum(xs: List[Int]): Int = {
    if(xs.isEmpty) 0
    else {
      println("Head " + xs.head)
      println("Tail " + xs.tail)
      xs.head + sum(xs.tail)}
  }

  /**
    *
    * @param xs
    * @return
    */
  def max(xs: List[Int]): Int = {

    if (xs.isEmpty) throw new NoSuchElementException
    else {
      def inner(max: Int, list: List[Int]): Int = {

        def compare(x: Int, y: Int): Int = {
          println("Numeros a comparar " + x + " y " + y)
          if (x > y) x
          else y
        }
        if (list.isEmpty) max
        else inner(compare(max, list.head), list.tail)
      }
      println("List antes de inner " + xs)
      inner(xs.head, xs.tail)
    }
  }
}
