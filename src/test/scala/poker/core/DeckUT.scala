package poker.core

import org.scalatest.{FlatSpec, Matchers}

class DeckUT extends FlatSpec with Matchers {

  behavior of "Deck"

  it should "allow creating a new deck mixing both simple cards and jokers" in {
    val cards = List(Card(2,Spades), Card(3, Hearts), Card(4, Diamonds))
    val deck = Deck(cards)
    deck.cards shouldEqual cards

    Deck(cards ++ List(Joker, Joker))

    val deck2 = Deck(jokerAmount = 3)
    deck2.cards.size shouldEqual (52 + 3)
    deck2.cards.count(_ == Joker) shouldEqual 3

  }

  it should "create a new deck once shuffled" in {
    val cards = List(Card(2,Spades), Card(3, Hearts), Card(4, Diamonds))
    val deck = Deck(cards)
    val newDeck = deck.shuffle
    deck.cards == newDeck.cards shouldEqual false
    deck.cards.sorted == newDeck.cards.sorted shouldEqual true
  }

  it should "generate a different sorted list of cards each time it's shuffled" in {
    val cards = List(Card(2,Spades), Card(3, Hearts), Card(4, Diamonds))
    val deck = Deck(cards)
    val deck2 = deck.shuffle
    val deck3 = deck2.shuffle
    deck.cards == deck2.cards shouldEqual false
    deck2.cards == deck3.cards shouldEqual false
    deck.cards.sorted == deck3.cards.sorted shouldEqual true
  }

}
