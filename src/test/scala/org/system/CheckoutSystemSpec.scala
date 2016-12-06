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

    result should be("£2.05")
  }
}