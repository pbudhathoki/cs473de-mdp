package Assignment1

class EBook(
    eTitle:String,
    eAuthor:String,
    ePrice:Float,
    val fileType:String
): Book(eTitle, eAuthor, ePrice){
    override fun read(){
        println("Read from Electronic Device")
    }
}