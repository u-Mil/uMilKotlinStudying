package backpack

class TestGeneric<T>(private var arg0:Int, private var arg1:T){
    constructor(arg1:T):this(arg0 = 1, arg1)
    fun printArg(){
        println("$arg0 , $arg1")
    }
    fun setArg0(_arg0:Int){
        this.arg0 = _arg0
    }
    fun setArg1(_arg1:T){
        this.arg1 = _arg1
    }
}