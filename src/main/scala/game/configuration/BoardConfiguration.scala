package game.configuration

import game.domain.{Direction, Piece, Position}
import game.rules.{MultiStep, SingleStep}

trait BoardConfiguration {
  val validPositions: List[Position] = {
    //val rows = List("A","B","C","D","E","F","G","H")
    val rows = List("1","2","3","4","5","6","7","8")
    val cols = List("1","2","3","4","5","6","7","8")
    for {
      r <- rows
      c <- cols
    } yield {
      Position(r.toInt, c.toInt)
    }
  }
}

object ChessBoard extends BoardConfiguration {
  def isValidPosition(position: Position) =
    validPositions.exists(validPosition => validPosition.row == position.row && validPosition.col == position.col)

  def possibleMoves(piece: Piece) = piece.step match {
    case SingleStep => piece.possibleDirections.flatMap(direction => piece.moves(direction).take(1).toList)
    case MultiStep => piece.possibleDirections.flatMap(direction => piece.moves(direction).takeWhile(isValidPosition).toList)
  }
}