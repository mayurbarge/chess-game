package game.domain

import game.rules.{MultiStep, SingleStep}
import org.scalatest.{FunSpec, Matchers}

class PieceTest extends FunSpec with Matchers {
  describe("Piece") {
    describe("King") {
      it("should take single step") {
        King(Position(1,1), None).step shouldBe SingleStep
      }
      it("should be able to move in East, West, North, South, NorthEast, NorthWest, SouthEast and SouthSouthWest directions") {
        King(Position(1,1), None).possibleDirections should contain theSameElementsAs List(East,West,North,South,NorthEast,NorthWest,SouthEast,SouthWest)
      }
    }
    describe("Queen") {
      it("should take multiple steps") {
        Queen(Position(1,1), None).step shouldBe MultiStep
      }
      it("should be able to move in East, West, North, South, NorthEast, NorthWest, SouthEast and SouthSouthWest directions") {
        Queen(Position(1,1), None).possibleDirections should contain theSameElementsAs List(East,West,North,South,NorthEast,NorthWest,SouthEast,SouthWest)
      }
    }
    describe("Bishop") {
      it("should take multiple steps") {
        Bishop(Position(1,1), None).step shouldBe MultiStep
      }
      it("should be able to move in East, West, North, South, NorthEast, NorthWest, SouthEast and SouthSouthWest directions") {
        Bishop(Position(1,1), None).possibleDirections should contain theSameElementsAs List(NorthEast,NorthWest,SouthEast,SouthWest)
      }
    }
    describe("Horse") {
      it("should take single step") {
        Horse(Position(1,1), None).step shouldBe SingleStep
      }
      it("should be able to move in directions EastEastNorth, EastEastSouth, WestWestNorth, WestWestSouth, NorthNorthEast, NorthNorthWest, SouthSouthEast andSouthSouthWest") {
        Horse(Position(1,1), None).possibleDirections should contain theSameElementsAs
          List(EastEastNorth,EastEastSouth,WestWestNorth,WestWestSouth,
            NorthNorthEast,NorthNorthWest,SouthSouthEast,SouthSouthWest)
      }
    }
    describe("Rook") {
      it("should take single step") {
        Rook(Position(1,1), None).step shouldBe MultiStep
      }
      it("should be able to move in directions East, West, North and South") {
        Rook(Position(1,1), None).possibleDirections should contain theSameElementsAs List(East, West, North, South)
      }
    }
    describe("Pawn") {
      it("should take single step") {
        Pawn(Position(1,1), None).step shouldBe SingleStep
      }
      it("should be able to move in directions North, South, NorthEast, NorthWest, SouthEast and SouthWest") {
        Pawn(Position(1,1), None).possibleDirections should contain theSameElementsAs List(North, South, NorthEast, NorthWest, SouthEast, SouthWest)
      }
    }
  }
}
