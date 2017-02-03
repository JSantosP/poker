package poker.core

import org.scalatest.{FlatSpec, Matchers}

class FiguresUT extends FlatSpec with Matchers {

  import CRange._

  behavior of "Figures"

  it should "not care about the suit for ordering" in {
    Card(2, Hearts) < Card(2, Spades) shouldEqual false
    Card(2, Hearts) > Card(2, Spades) shouldEqual false
    Card(2, Hearts) <= Card(2, Spades) shouldEqual true
    Card(2, Hearts) >= Card(2, Spades) shouldEqual true
  }

  it should "provide a natural card ordering for poker" in {
    Card(2, Hearts) <= Card(2, Spades) shouldEqual true
    Card(2, Hearts) < Card(2, Spades) shouldEqual false
    Card(3, Clubs) < Card(2, Diamonds) shouldEqual false
    Card(A, Diamonds) > Card(K, Hearts) shouldEqual true
  }

}
