package poker.core

object figures extends figures

trait figures {

  //  Order relation

  implicit object PokerOrdering extends Ordering[Card] {
    def compare(c1: Card, c2: Card): Int = (c1, c2) match {
      case (Joker, c2: SimpleCard) => if (c2.number == CRange.A) 0 else 1
      case (c1: SimpleCard, Joker) => if (c1.number == CRange.A) 0 else -1
      case (Joker, Joker) => 0
      case (c1: SimpleCard, c2: SimpleCard) => c1.number.compare(c2.number)
    }
  }

  implicit class PokerOrdered(c: Card) extends Ordered[Card]{
    override def compare(that: Card): Int = PokerOrdering.compare(c, that)
  }

  //  Poker figures

  // TODO Implement poker figures

}
