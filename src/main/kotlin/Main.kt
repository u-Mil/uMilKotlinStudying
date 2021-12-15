import backpack.*
import java.lang.Math.random
import java.lang.NumberFormatException

const val mil = "uMil"

fun plus(x:Int, y:Int):Int{
    println("plus...")
    return x+y
}

object Obj2{
    var minus:(Int, Int) -> Int = {
            x, y -> println("minus...")
        x-y
    }
}

class ClassMultiple{
    fun multiple(x:Int, y:Int):Int{
        return x*y
    }
}

fun main(args: Array<String>) {
    // random() : equal to 0.0 and less than 1.0.
    var total = (random() * 10).toInt()
    println(stringTemp("random.total", total))
    total = total % 10 + 1
    println(stringTemp("total", total))
    var i = (total % 3) + 1
    println(stringTemp("i", i))
    // when
    when(i){
        1 -> println("hello")
        2 -> println("hello2")
        else -> println("else")
    }

    println("------------------------------------------------------")
    println("------------------------------------------------------")

    var circle = Circle(4)
    println(stringTemp("Circle", circle.getCircleArea()))
    circle.radius = 6.0
    println(stringTemp("Circle", circle.getCircleArea()))

    println("------------------------------------------------------")
    println("------------------------------------------------------")

    // constructor
    var rectangle = Rectangle(4,5.0)
    println(stringTemp("Rectangle_Height", rectangle.height));
    println(stringTemp("Rectangle_Width", rectangle.width));
    println(stringTemp("Rectangle_Area", rectangle.getRectangleArea()))
    println()
    rectangle.width = 4.5
    rectangle.height = 4.5
    println(stringTemp("Rectangle_Height", rectangle.height));
    println(stringTemp("Rectangle_Width", rectangle.width));
    println(stringTemp("Rectangle_Area", rectangle.getRectangleArea()))

    println("------------------------------------------------------")
    println("------------------------------------------------------")

    // getter, setter
    var fruits = Fruits("Orange", "Orange")
    println(stringTemp(fruits[0], fruits[1]))
    fruits[0] = "Apple"
    fruits[1] = "Red/Green"
    println(stringTemp(fruits[0], fruits[1]))
    fruits()
    println("------------------------------------------------------")
    println("------------------------------------------------------")

    // invoke
    var hello = Hello("Mil")
    hello()
    println("------------------------------------------------------")
    println("------------------------------------------------------")

    // infix
    var point = Point(1, 2) from Point(5, -4)
    println("Pos : " + point.getX() + "," + point.getY())
    println("------------------------------------------------------")
    println("------------------------------------------------------")

    // override
    var student = Student("aaa","bbb", 31)
    var student2:Person = student
    println(student.getName())
    println(student2.getName())
    // object 표현식
    // 클래스 없이 객체를 만들 때 사용
    // Student 클래스를 상속받는 object 객체 생성
    // getGender()메소드 오버라이딩
    var custom:Student = object : Student("ccc","ddd",51){
        override fun getGender():String{
            return "....."
        }
    }
    println(custom.getGender())
    println("------------------------------------------------------")
    println("------------------------------------------------------")

    var strForException = "hello"
    try{
        strForException.toInt()
    }catch(e:NumberFormatException){
        println("Exception : This is String!")
    }finally {
        println("String!")
    }
    var classForException = TestException()
    try {
        classForException.throwException()
    }catch(e:Exception){
        println(e.message)
    }finally {

    }
    println("------------------------------------------------------")
    println("------------------------------------------------------")

    // Extension Companion
    var extString = "abcde"
    println(extString.compareLength(3, 5))
    println("------------------------------------------------------")
    println("------------------------------------------------------")

    // Companion
    println(CompanionTest.cObject)
    CompanionTest.sayHello()
    println(Obj.obj_string)
    Obj.objFunction()
    println("------------------------------------------------------")
    println("------------------------------------------------------")

    // inline
    printInlineThreeTimes()
    println("------------------------------------------------------")
    println("------------------------------------------------------")

    // const
    println(mil)
    println("------------------------------------------------------")
    println("------------------------------------------------------")

    // lateinit
    var rect2:Rectangle2 = Rectangle2()
    rect2.pt1 = Point(1, 2)
    rect2.pt2 = Point(2,3)
    println(rect2.getArea())
    println("------------------------------------------------------")
    println("------------------------------------------------------")

    // Nullable Receiver
    var extString2 = null
    println(extString2.compareLength(3, 5))
    println("------------------------------------------------------")
    println("------------------------------------------------------")

    // Extension Companion
    fun CompanionTest.Companion.sayCompanion(){
        println("companion")
    }
    fun CompanionTest.Companion.create() = CompanionTest(5)
    CompanionTest.sayCompanion()
    var companion = CompanionTest()
    println(companion.getComArg0())
    companion = CompanionTest.create()
    println(companion.getComArg0())
    println("------------------------------------------------------")
    println("------------------------------------------------------")

    fun Person.hello() = println("Hello Person")
    fun Student.hello() = println("Hello Student")
    var student3:Person = Student("Mil", "MALE", 10)
    // Receiver
    student3.hello()
    // Override Method
    student3.talk()
    println("------------------------------------------------------")
    println("------------------------------------------------------")

    var inter = Inter()
    inter.helloInterface()
    inter.interfaceValue = 1
    println("------------------------------------------------------")
    println("------------------------------------------------------")

    var instanceOuter = Outer(100)
    var instanceInner:Outer.Inner = instanceOuter.Inner(40)
    instanceInner.hello()
    println("------------------------------------------------------")
    println("------------------------------------------------------")

    // 익명함수...
    var anonyFunc: (Int) -> Int = fun(number:Int):Int{
        println("$number")
        return number
    }
    var anonyval = anonyFunc(33)
    println(anonyval)
    // it
    var instantFunc:(Int) -> Int = {
        println("instantFunc $it")
        it + 10
    }

    var ifuncres = instantFunc(10)
    println(ifuncres)
    println("------------------------------------------------------")
    println("------------------------------------------------------")
    var fplus:(Int,Int)->Int
    //function to variable
    fplus = ::plus
    println(fplus(1,2))
    println(Obj2.minus(2,5))
    var fmultiple = ClassMultiple()::multiple
    println(fmultiple(3,5))
    println("------------------------------------------------------")
    println("------------------------------------------------------")
    func_test_2(::func_test)
    var lamb_test:(String) -> Unit = {
        str ->
        println("this is lambda")
        func_test(str)
    }
    func_test_2(lamb_test)
    var func_test_3 = {str:String -> func_test(str)}
    func_test_3("test3")
    println("------------------------------------------------------")
    println("------------------------------------------------------")
    var compare:Int.(left:Int, right:Int) -> Int = {
        left, right ->
        if(this < left) left
        else if(this > right) right
        else this
    }
    println(25.compare(0, 30))
    println(compare(20, 0, 50))

    var compareLength:String.(left:Int, right:Int) -> Boolean = {
        left, right ->
        this.length in left..right
    }
    // this -> 첫번째 매개변수로 활용될 수 있다..
    println("Hello".compareLength(0,10))
    println(compareLength("Hello", 0, 10))
    println("------------------------------------------------------")
    println("------------------------------------------------------")
    /*
    var printStar:() -> Unit ={
        for(i:Int in 0..5){
            for(j:Int in 4 downTo 0){
                if(j >= i) print(" ")
            }
            for(k:Int in 0..5){
                print("*")
                if(k == i) break
            }
            println()
        }
    }
    printStar()
    */

    // Generic
    fun <T> printSomething (arg:T){
        println(arg)
    }
    printSomething("aaaa")
    printSomething(1234)
    var testgeneric = TestGeneric("String")
    testgeneric.printArg()
    var testgeneric2 = TestGeneric(2, 1234)
    testgeneric2.printArg()

    println("------------------------------------------------------")
    println("------------------------------------------------------")

    var intarr:Array<Int> = arrayOf(1, 5, 9 , 0)
    for(i in intarr)
        print("$i ")
    println()
}

fun stringTemp(msg : String, value : Any, result : String = "RESULT") : String {
    return "[$result] : $msg : $value"
}

fun String?.compareLength(low:Int, high:Int):Boolean{
    return this?.length in low..high
}

object Obj {
    var obj_string = "obj_string"
    fun objFunction (){
        println("objFunction")
    }
}

inline fun printInlineThreeTimes(){
    for(i:Int in 0..2){
        println("Inline")
    }
}

fun func_test(string:String){
    println("test : $string")
}
fun func_test_2(func: (String) -> Unit){
    func("func_test_2")
}


//https://readystory.tistory.com/114?category=822867

//269 Closure