package view

object Exploding {
  def main(Args: Array[String]): Unit = {

    //println(field("Ablage Stapel", 15, 10))
    val titles: List[String] = List("Aufnehm Stapel", "Ablage Stapel")

    val eol = sys.props("line.separator")

    def row(wigth: Int, anz: Int): String = ("+" + "-" * wigth + "+") * anz + eol

    def colum(wigth: Int, len: Int, anz: Int): String = (("|" + " " * wigth + "|") * anz + eol) * len

    def field(wigth: Int, len: Int, anz: Int = 1): String = row(wigth, anz) + colum(wigth, len, anz) + row(wigth, anz)

    nfields(titles, 20, 10)

    def nfields(title: List[String], wigth: Int, len: Int): Unit = {
      val anz = title.length
      for (t <- title) {
        print(" " + t + " " * (wigth + 1 - t.length))
        //if (t.length>wigth) wigth = t.length
      }
      print(eol + field(wigth, len, anz))
    }
  }
}