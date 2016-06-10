/**
  * Created by Ivansebastian on 09/06/2016.
  */
package expressions

object Expressions {
  def and(x: Boolean, y: Boolean) = if(x) y else false

  def or(x: Boolean, y: Boolean) = if(x) true else y
}


