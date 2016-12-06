package org.system

import org.scalatest._

import org.system.CheckoutSystem.{Apple, Fruit, Orange}

class CheckoutSystemSpec extends FlatSpec with Matchers {

  "CheckoutSystem" should "return zero pounds if the shopping cart is empty" in {
    val fruits = Seq.empty[Fruit]
    val result = CheckoutSystem.checkout(fruits)

    result should be("£0")
  }

  it should "return an orange's price" in {
    val result = CheckoutSystem.checkout(Seq(Orange))

    result should be("£0.25")
  }

  it should "return an apple's price" in {
    val result = CheckoutSystem.checkout(Seq(Apple))

    result should be("£0.6")
  }

  it should "return price for 3 apples and an orange" in {
    val fruits = Seq(Apple, Apple, Orange, Apple)
    val result = CheckoutSystem.checkout(fruits)

    result should be("£1.45")
  }

  it should "return price of one apple for two apples" in {
    val apples = Seq(Apple, Apple)
    val result = CheckoutSystem.checkout(apples)

    result should be("£0.6")
  }

  it should "return price of two oranges for three oranges" in {
    val oranges = Seq(Orange, Orange, Orange)
    val result = CheckoutSystem.checkout(oranges)

    result should be("£0.5")
  }

  it should "return the price of 9 apples" in {
    val apples = (1 to 9).map(_ => Apple)
    val result = CheckoutSystem.checkout(apples)

    result should be("£3")
  }

  it should "return the price of 10 oranges" in {
    val oranges = (1 to 10).map(_ => Orange)
    val result = CheckoutSystem.checkout(oranges)

    result should be("£1.75")
  }

  it should "return price for 9 apples and 10 oranges" in {
    val apples = (1 to 9).map(_ => Apple)
    val oranges = (1 to 10).map(_ => Orange)
    val fruits = apples ++ oranges
    val result = CheckoutSystem.checkout(fruits)

    result should be("£4.75")
  }
}