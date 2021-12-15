package backpack

class Hello(private val _value:String) {
    operator fun invoke(){
        println("Hello");
        println(_value);
    }
}