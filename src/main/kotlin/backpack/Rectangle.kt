package backpack

class Rectangle {
    var width:Double
    var height:Double
    constructor(){
        this.width = 1.0
        this.height = 1.0
    }
    constructor(_width:Double, _height:Double){
        this.width = _width
        this.height = _height
    }
    constructor(_width:Int, _height: Int):this(_width.toDouble(),_height.toDouble()){

    }
    constructor(_width:Int, _height: Double):this(_width.toDouble(),_height){

    }
    constructor(_width:Double, _height: Int):this(_width,_height.toDouble()){

    }
    fun getRectangleArea():Double{
        return (this.width * this.height)
    }
}