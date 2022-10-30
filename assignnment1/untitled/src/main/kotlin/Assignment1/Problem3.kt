package Assignment1

import java.util.Scanner

fun main(){
    //println("Solution of problem 3a is "+ FirstAndLastNumber());
    val inputArray = arrayOf(1,2,3,4,5,6);
    //println("Solution of problem 3b is "+SumOddSquare(inputArray));
    println("The solution of problem 3c(the weight in this planet) is "+CalcWeightPlanet());
}

//solution to problem 3a
fun FirstAndLastNumber():Int{
    var sc = Scanner(System.`in`);
    println("please input the desired number");
    var inNum = sc.nextInt();
    var num = inNum/10;
    var last = inNum%10;
    while(num>9){
        num=num/10;
    }
    val first = num;
    return first*10+last;
}

//problem 3 b)

fun SumOddSquare(inputArray: Array<Int>):Int{
    var sumOdd=0;
    inputArray.forEach { inValue: Int->
        if(inValue%2!=0){
            sumOdd+=inValue*inValue;
        }
    }
    return sumOdd
}

//problem 3 c)
fun CalcWeightPlanet():Float{

    var g: Float=0.0f;
    val inputVal= Scanner(System.`in`);
    println("your choice between 1-6")
    val choiceVal=inputVal.nextInt()
    println("Enter weight in pound")


    val input=inputVal.nextInt()
    //val input= Integer.valueOf(readLine())
    when (choiceVal){
        1->g=0.78f
        2->g=0.39f
        3->g=2.65f
        4->g=1.17f
        5->g=1.05f
        6->g=1.23f
        else->println("your choice between 1-6")
    }
    return g*input
}