package game.rules

import game.domain._

trait Step
case object SingleStep extends Step
case object MultiStep extends Step

trait Move {
  def movementToDirections: List[Position => Position]
}
case object Horizontal extends Move {
  override def movementToDirections: List[Position => Position] = List(East.transform,West.transform)
}
case object Vertical extends Move {
  override def movementToDirections: List[Position => Position] = List(North.transform,South.transform)
}
case object Diagonal extends Move {
  override def movementToDirections: List[Position => Position] =
    List(NorthEast.transform,NorthWest.transform,SouthEast.transform,SouthWest.transform)
}
case object TwoAndHalf extends Move {
  override def movementToDirections: List[Position => Position] = List(EastEastNorth.transform,EastEastSouth.transform,
    WestWestNorth.transform,WestWestSouth.transform, NorthNorthEast.transform, NorthNorthWest.transform,SouthSouthEast.transform, SouthSouthWest.transform)
}
case object ThreeAndHalf extends Move {
  override def movementToDirections: List[Position => Position] = List(EastEastNorth.transform andThen(North.transform))
}