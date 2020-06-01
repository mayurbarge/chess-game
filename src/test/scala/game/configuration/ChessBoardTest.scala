package game.configuration

import game.domain.Position
import org.scalatest.{FunSpec, Matchers}

class ChessBoardTest extends FunSpec with Matchers {
  describe("ChessBoafd") {
    it("should return false when X position is less than 1") {
      ChessBoard.isValidPosition(Position(0, 5)) shouldBe false
    }
    it("should return false when X position is greater than 8") {
      ChessBoard.isValidPosition(Position(2, 9)) shouldBe false
    }
    it("should return false when Y position is less than 1") {
      ChessBoard.isValidPosition(Position(2, 0)) shouldBe false
    }
    it("should return false when Y position is greater than 8") {
      ChessBoard.isValidPosition(Position(2, 9)) shouldBe false
    }
    it("should return true when X, Y position lies within chessboard boundries") {
      ChessBoard.isValidPosition(Position(8, 8)) shouldBe true
      ChessBoard.isValidPosition(Position(1, 1)) shouldBe true
    }
  }
}
