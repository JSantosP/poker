package poker.core

object deck extends deck

trait deck {

  /**
    * A [[Deck]] represents a bunch of cards that
    * might be shuffled.
    *
    * @param cards Sequence of cards
    */
  case class Deck(cards: List[Card]){

    /**
      * Shuffle the deck.
      * @return A brand new [[Deck]] with the same cards
      *         but in a different order.
      */
    def shuffle: Deck =
      Deck(scala.util.Random.shuffle(cards))

  }
  object Deck {

    /**
      * Create a new deck that might have
      * a concrete number of [[Joker]] cards
      *
      * @param jokerAmount Amount of joker cards
      * @return A brand new [[Deck]]
      */
    def apply(jokerAmount: Int = 0): Deck = {
      val jokers = (0 until jokerAmount).map(_ => Joker).toList
      val cards =
        for {
          suit <- Suit.values
          number <- CRange.values.toList
        } yield Card(number, suit)
      new Deck(cards ++ jokers)
    }

  }

}
