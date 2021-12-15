package backpack

class Fruits(private var name:String, private var color:String) {
    operator fun get(pos : Int):String{
        return when(pos){
            0-> name
            1-> color
            else -> "..."
        }
    }
    operator fun set(pos : Int,value : String){
        when(pos){
            0-> name = value
            1-> color = value
            else -> return
        }
    }
    operator fun invoke(){
        println("Fruits")
    }
}