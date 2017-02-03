package poker.core

object card extends card

trait card {

  /**
    * Different suit values
    */
  sealed trait Suit
  object Suit {
    lazy val values = List(Spades, Diamonds, Hearts, Clubs)
  }
  case object Spades extends Suit
  case object Diamonds extends Suit
  case object Hearts extends Suit
  case object Clubs extends Suit

  /**
    * Range enumeration that represent the different card values.
    */
  object CRange extends Enumeration {
    type CRange = Range
    val _2 = Value("2")
    val _3 = Value("3")
    val _4 = Value("4")
    val _5 = Value("5")
    val _6 = Value("6")
    val _7 = Value("7")
    val _8 = Value("8")
    val _9 = Value("9")
    val _10 = Value("10")
    val J = Value("J")
    val Q = Value("Q")
    val K = Value("K")
    val A = Value("A")
  }

  type Number = CRange.Value

  /**
    * A [[Card]] is just (a piece of paper?) some playing item.
    */
  sealed trait Card

  /**
    * A [[SimpleCard]] is represented by...
    * @param number ...a ranked [[Number]]
    * @param suit ...and some [[Suit]]
    */
  case class SimpleCard(number: Number, suit: Suit) extends Card

  /**
    * A special card that
    */
  case object Joker extends Card

  //  Nice constructors ...

  object Card{
    def apply(_number: Number, _suit: Suit): Card =
      SimpleCard(_number, _suit)
    def apply(_number: Int, _suit: Suit): Card = {
      require(_number >=2 && _number <= 10, "Not a valid card number")
      SimpleCard(CRange.withName(_number.toString), _suit)
    }
  }

}
