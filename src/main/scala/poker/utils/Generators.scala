package poker.utils

import org.scalacheck.Gen
import poker.core._

object Generators {

  /**
    * Simple card generator
    */
  val cardGen: Gen[SimpleCard] =
    for {
      number <- Gen.oneOf(CRange.values.toList)
      suit <- Gen.oneOf(Suit.values)
    } yield SimpleCard(number, suit)

}
