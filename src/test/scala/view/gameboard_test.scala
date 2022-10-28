package  view
//import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should._


class gameboard_test() extends AnyWordSpec with Matchers{
  val eol = sys.props("line.separator")
  val titles: List[String] = List("T1", "Ti2")

    "have a scalable row" in {
      playboard.row(1, 1) should be("+-+" + eol)
      playboard.row(1, 2) should be("+-++-+" + eol)
      playboard.row(2, 1) should be("+--+" + eol)
    }
    "have a scalable colum" in {
      playboard.colum(1,1,1) should be("| |" + eol)
      playboard.colum(1,1,2) should be("| || |" + eol)
      playboard.colum(1,2,1) should be("| |" + eol + "| |" + eol)
      playboard.colum(2,1,1) should be("|  |" + eol)
    }
    "have a scalable field" in {
      playboard.field(1,1,1) should be("+-+" + eol + "| |" + eol + "+-+" + eol)
      playboard.field(1,1,2) should be("+-++-+" + eol + "| || |" + eol + "+-++-+" + eol)
    }

    "have a scalable thing" in {
      playboard.playboard(titles, 6,1) should be("|T1    ||Ti2   |" + eol + "+------++------+" + eol +
        "|      ||      |" + eol + "+------++------+" + eol)
    }
}
