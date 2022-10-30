package Assignment1

class TestClass {
    val book= Book("BookTitle", "BookAuthor",50.99f)
    val ebook= EBook("EbookTitle", "EbbokAuthor",99.99f,"Pdf")

    fun testFunc(){
        book.read()
        println("Title of the book is: "+book.title + " Author of the book is: "+book.author +" Price of the book is: "+book.price);
        ebook.read()
        println("Title of the Ebook is: "+ebook.title + " Author of the Ebook is: "+ebook.author +" Price of the Ebook is: "+ebook.price+" Filetype of the Ebook is: "+ebook.price);
    }
}

fun main(){
    val testCls=TestClass();
    testCls.testFunc()
}

