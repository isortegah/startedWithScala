package me.isortegah

import scala.collection.mutable

object ProductDefects {
  var setSeries: mutable.Map[String, Array[Array[Point]]] = collection.mutable.Map()

  def getSize(sample: Array[Array[Int]]): Unit ={
    printArray(sample)

    println("")
    var pointStar = new Point(0,0)
    var pointEnd  = new Point(0,0)

    var previousIsDefective = false

    for (i <- 0 to sample.length-1){
      previousIsDefective = false
      pointEnd.setPoint(0,0)
      for(j <- 0 to sample.length-1){
        if (sample(i)(j) == 1) {
          if (previousIsDefective){
            pointEnd.setPoint(i,j)
          } else {
            pointStar.setPoint(i,j)
            pointEnd.setPoint(i,j)
          }
          previousIsDefective = true
        } else {
          if((j-1) < 0)
            pointEnd.setPoint(i,0)
          else
            pointEnd.setPoint(i,j-1 )
          if(previousIsDefective)
            saveSerie(i.toString,pointStar,pointEnd)
          previousIsDefective = false
        }
      }
      if(previousIsDefective)
        saveSerie(i.toString,pointStar,pointEnd)
      println("")
    }
    for ( (key, value) <- setSeries){
      println(key )
      println(key + " " + value.toArray.foreach(item => item.toArray.foreach(i => println(i))))
    }
  }

  def printArray(sample: Array[Array[Int]]): Unit ={
    for (i <- 0 to sample.length-1){
      for(j <- 0 to sample.length-1){
        print(sample(i)(j))
      }
      println("")
    }
  }

  def saveSerie(i: String, pointStar: Point, pointEnd: Point){
    var savePointStar = new Point(pointStar.getPointX(),pointStar.getPointY())
    var savePointEnd  = new Point(pointEnd.getPointX(),pointEnd.getPointY())
    val size = setSeries.size
    var key = i + "_" + size.toString

    if(setSeries.contains(i)) {
      key = i+"_"+ (size+1).toString
    }
    setSeries.put(key,Array(Array(savePointStar, savePointEnd)))
    println("SaveSerie -> Row: "+ i + " Star -> " + savePointStar + " End -> " + savePointEnd)
  }



}

class Point(xc: Int, yc: Int) {
  var x: Int = xc
  var y: Int = yc

  def move(dx: Int, dy: Int) {
    x = x + dx
    y = y + dy
  }

  def setPoint(xc: Int, yc: Int){
    x = xc
    y = yc
  }

  def getPointY(): Int ={
    y
  }

  def getPointX(): Int ={
    x
  }

  override def toString(): String = "(" + x + ", " + y + ")";
}