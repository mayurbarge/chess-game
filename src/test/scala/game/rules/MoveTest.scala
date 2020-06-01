package game.rules
import game.domain.{East, EastEastNorth, EastEastSouth, North, NorthEast, NorthNorthEast, NorthNorthWest, NorthWest, South, SouthEast, SouthSouthEast, SouthSouthWest, SouthWest, West, WestWestNorth, WestWestSouth}
import org.scalatest.{FunSpec, Matchers}

class MoveTest extends FunSpec with Matchers {
  describe("Move") {
    it("should return East and West movement when Horizontal") {
      Horizontal.movementToDirection should contain theSameElementsAs  List(East, West)
    }
    it("should return North and South movement when Vertical") {
      Vertical.movementToDirection should contain theSameElementsAs  List(North, South)
    }
    it("should return NorthEast, NorthWest, SouthEast and SouthWest movement when Diagonal") {
      Diagonal.movementToDirection should contain theSameElementsAs  List(NorthEast, NorthWest, SouthEast, SouthWest)
    }
    it("should return NorthEast, NorthWest, SouthEast, SouthWest, EastEastNorth movement when TwoAndHalf") {
      TwoAndHalf.movementToDirection should contain theSameElementsAs  List(EastEastNorth,EastEastSouth,WestWestNorth,WestWestSouth, NorthNorthEast, NorthNorthWest, SouthSouthEast, SouthSouthWest)
    }
  }
}
