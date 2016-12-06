package org.system

object CheckoutSystem {
  import Extensions._

  sealed trait Fruit extends Product with Serializable {
    val price: BigDecimal
  }

  case object Apple extends Fruit { val price = 60 }
  case object Orange extends Fruit { val price = 25 }

  case class Offer(fruit: Fruit, buySize: Int, paidSize: Int) {
    def totalPrice(size: Int): BigDecimal = {
      val count = size / buySize
      ((count * paidSize) + (size % buySize)) * fruit.price / 100
    }
  }

  /**
    * Returns price of fruits with discounts.
    * @param fruits
    * @return String total price
    */
  def checkout(fruits: Seq[Fruit]): String  = {
    val apples = fruits.filter(_ == Apple).size
    val oranges = fruits.size - apples
    val totalPrice =
      Offer(Apple, 2, 1).totalPrice(apples) + Offer(Orange, 3, 2).totalPrice(oranges)

    totalPrice.toPounds
  }
}

object Extensions {
  implicit class BigDecimalUtils(price: BigDecimal) {
    def toPounds: String = s"£$price"
  }
}