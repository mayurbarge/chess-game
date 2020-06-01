package game.domain

import game.rules.{Diagonal, Horizontal, MultiStep, SingleStep, Step, TwoAndHalf, Vertical}

trait Piece { self =>
  def position: Position
  def step: Step
  def movingDirection: Option[Direction]
  def possibleDirections: List[Direction]
}

case class King(override val position: Position, override val movingDirection: Option[Direction]) extends Piece {
  def step: Step = SingleStep
  def possibleDirections: List[Direction] = Horizontal.movementToDirections ++ Vertical.movementToDirections ++ Diagonal.movementToDirections
}
case class Queen(override val position: Position, override val movingDirection: Option[Direction]) extends Piece {
  def step: Step = MultiStep
  def possibleDirections: List[Direction] = Horizontal.movementToDirections ++ Vertical.movementToDirections ++ Diagonal.movementToDirections
}
case class Bishop(override val position: Position, override val movingDirection: Option[Direction]) extends Piece {
  def step: Step = MultiStep
  def possibleDirections: List[Direction] = Diagonal.movementToDirections
}
case class Horse(override val position: Position, override val movingDirection: Option[Direction]) extends Piece {
  def step: Step = SingleStep
  def possibleDirections: List[Direction] = TwoAndHalf.movementToDirections
}
case class Rook(override val position: Position, override val movingDirection: Option[Direction]) extends Piece {
  def step: Step = MultiStep
  def possibleDirections: List[Direction] = Horizontal.movementToDirections ++ Vertical.movementToDirections
}
case class Pawn(override val position: Position, override val movingDirection: Option[Direction]) extends Piece {
  def step: Step = SingleStep
  def possibleDirections: List[Direction] = Diagonal.movementToDirections ++ Vertical.movementToDirections
}
