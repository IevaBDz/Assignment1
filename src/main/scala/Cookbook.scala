import java.io.{FileWriter, PrintWriter}
import scala.io.Source

object Cookbook extends App {
  def getLinesFromFile(srcPath: String) = {
    val bufferedSource = Source.fromFile(srcPath)
    val lines = bufferedSource.getLines.toArray
    bufferedSource.close
    lines
  }

    val relative_path = "src/resources/cookbook.txt"

    val relative_save_path = "src/resources/cookbook_result.txt"

  def openSource(fName:String) = {
    //actually get a real sequence of strings
    val filePointer = scala.io.Source.fromFile(relative_path)
    val myLines = filePointer.getLines.toSeq
    myLines
  }
  def processSeq(mySeq:Seq[String])= {
    val ingredients = mySeq.filter(line => line.startsWith("    "))
    ingredients
  }

  def saveSeq(destName:String, mySeq:Seq[String]) = {
    println(s"Saving my Sequence to file $relative_save_path")
    val fw = new FileWriter(relative_save_path)
    mySeq.map(_ + "\n").foreach(fw.write)
    fw.close()
  }

  val mySeq = openSource(relative_path)
  val filteredSeq = processSeq(mySeq)
  saveSeq(relative_save_path,filteredSeq)
}







