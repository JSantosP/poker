package poker.core

import org.scalatest.{FlatSpec, Matchers}

class CardUT extends FlatSpec with Matchers {

  behavior of "Card"

  it should "constraint the values that may hold" in {
    a[IllegalArgumentException] shouldBe thrownBy{
      Card(11, Spades)
    }
    a[IllegalArgumentException] shouldBe thrownBy{
      Card(1, Spades)
    }
    (2 to 10).map(Card(_, Clubs))
  }

  it should "allow being a Joker or a simple card" in {
    val card: Card = Joker
    val cards: List[Card] = Card(4, Hearts) :: Joker :: Nil
  }

}
