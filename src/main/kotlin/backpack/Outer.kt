package backpack

class Outer(private var value:Int) {
    fun hello(){
        println("this is outer...$value")
    }
    inner class Inner(private var innervalue:Int){
        fun hello(){
            this@Outer.hello()
            println("this is inner..." + this.innervalue)
            println("outer value is...." + this@Outer.value)
        }
    }
}