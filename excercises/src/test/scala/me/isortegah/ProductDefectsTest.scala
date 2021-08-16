package me.isortegah

import org.scalatest.{Matchers, WordSpec}

class ProductDefectsTest extends WordSpec with Matchers{

  "A Product Defects" when {
    "Receives a 3x3 dimensional array" should {
      "" in {
        val sample = Array(Array(1,1,1),
                      Array(1,1,0),
                      Array(1,0,1))
        ProductDefects.getSize(sample)
      }

      /*"Cero" in {
        val sample = Array(Array(0,0,0),
          Array(0,0,0),
          Array(0,0,0))
        ProductDefects.getSize(sample)
      }

      "Cero" in {
        val sample = Array(Array(0,1,0),
          Array(0,0,0),
          Array(0,0,0))
        ProductDefects.getSize(sample)
      }*/
    }
  }
}
