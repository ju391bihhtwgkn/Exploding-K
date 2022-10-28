package view


object playboard {

  val eol: String = sys.props("line.separator")

  def row(wigth: Int, anz: Int): String = (("+" + "-" * wigth + "+") * anz) + eol

  def colum(wigth: Int, len: Int, anz: Int): String = (("|" + " " * wigth + "|") * anz + eol) * len

  def field(wigth: Int, len: Int, anz: Int = 1): String = row(wigth, anz) + colum(wigth, len, anz) + row(wigth, anz)

  def headline(title:String, wigth:Int ):String = "|" + title + " " * (wigth - title.length) + "|"

  def playboard(title: List[String], wigth: Int, len: Int):String = {
    val newt = title.map(i => headline(i, wigth))
    val result = newt.addString(new StringBuilder())
    result + eol + field(wigth, len, title.length)

  }
}