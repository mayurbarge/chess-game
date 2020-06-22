package game.domain

import game.rules.{Diagonal, Horizontal, MultiStep, SingleStep, Step, TwoAndHalf, Vertical}

trait Piece { self =>
  def position: Position
  def step: Step
  def movingDirection: Option[Position => Position]
  def possibleDirections(): List[Position => Position]

  def moves(transformation: Position => Position): Stream[Position] = {
    def go(current: Position): Stream[Position] = {
      val newPosition = transformation(current)
      Stream.cons(newPosition, go(newPosition))
    }
    go(position)
  }

  def allMoves():List[Position] = possibleDirections().flatMap(trasformation => moves(trasformation).toList)
}

case class King(override val position: Position, override val movingDirection: Option[Position => Position]) extends Piece {
  def step: Step = SingleStep
  def possibleDirections(): List[Position => Position] = Horizontal.movementToDirections ++ Vertical.movementToDirections ++ Diagonal.movementToDirections
}
case class Queen(override val position: Position, override val movingDirection: Option[Position => Position]) extends Piece {
  def step: Step = MultiStep
  def possibleDirections(): List[Position => Position] = Horizontal.movementToDirections ++ Vertical.movementToDirections ++ Diagonal.movementToDirections
}
case class Bishop(override val position: Position, override val movingDirection: Option[Position => Position]) extends Piece {
  def step: Step = MultiStep
  def possibleDirections(): List[Position => Position] = Diagonal.movementToDirections
}
case class Horse(override val position: Position, override val movingDirection: Option[Position => Position]) extends Piece {
  def step: Step = SingleStep
  def possibleDirections(): List[Position => Position] = TwoAndHalf.movementToDirections
}
case class Rook(override val position: Position, override val movingDirection: Option[Position => Position]) extends Piece {
  def step: Step = MultiStep
  def possibleDirections(): List[Position => Position] = Horizontal.movementToDirections ++ Vertical.movementToDirections
}
case class Pawn(override val position: Position, override val movingDirection: Option[Position => Position]) extends Piece {
  def step: Step = SingleStep
  def possibleDirections(): List[Position => Position] = Vertical.movementToDirections
}

object Piece {
  def apply(name: String, position: Position): Option[Piece] = name match {
    case "King" => Some(King(position, None))
    case "Queen" => Some(Queen(position, None))
    case "Bishop" => Some(Bishop(position, None))
    case "Horse" => Some(Horse(position, None))
    case "Rook" => Some(Rook(position, None))
    case "Pawn" => Some(Pawn(position, None))
    case _=> None
  }
}
