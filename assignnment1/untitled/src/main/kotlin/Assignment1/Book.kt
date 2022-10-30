package Assignment1

open class Book (
    val title:String,
    val author: String,
    val price: Float
){
    open fun read(){
        println("Reading Paper book")
    }
}
