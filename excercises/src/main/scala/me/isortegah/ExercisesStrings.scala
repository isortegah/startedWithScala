package me.isortegah

import scala.collection.mutable.HashMap

object ExercisesStrings {

  def groupAndCount(word: String):String={
    val arrWord = word.split("")
    val map: HashMap[String, Int] = HashMap.empty[String, Int]
    arrWord.foreach( w => map(w)= if (map.contains(w)) map.get(w).get+1 else 1)
    var joins:String=""
    map.foreach(x => {
      joins += x._2.toString + x._1
    })
    joins
  }
}
