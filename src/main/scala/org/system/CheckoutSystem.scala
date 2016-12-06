package org.system

object CheckoutSystem {
  import Extensions._

  sealed trait Fruit extends Product with Serializable {
    val price: BigDecimal
  }

  case object Apple extends Fruit { val price = 60 }
  case object Orange extends Fruit { val price = 25 }

  /**
    * Returns price of fruits without any discount.
    * @param fruits
    * @return String total price
    */
  def checkout(fruits: Seq[Fruit]): String = totalPrice(fruits).toPounds

  private def totalPrice(fruits: Seq[Fruit]): BigDecimal = (fruits.map(_.price).sum) / 100

}

object Extensions {
  implicit class BigDecimalUtils(price: BigDecimal) {
    def toPounds: String = s"£$price"
  }
}