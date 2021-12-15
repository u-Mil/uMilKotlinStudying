package backpack

open class CompanionTest {
    private var comarg:Int
    constructor(){
        comarg = 0
    }
    constructor(arg0:Int):this(){
        this.comarg = arg0
    }
    fun getComArg0():Int{
        return this.comarg
    }
    companion object {
        var cObject = "cObject"
        fun sayHello(){
            println("Hello")
        }
    }
}