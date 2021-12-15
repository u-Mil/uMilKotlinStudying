package backpack

class Circle{
    var radius:Double
    constructor(){
        this.radius=0.0
    }
    constructor(_rad:Int){
        this.radius=_rad.toDouble()
    }
    constructor(_rad:Double){
        this.radius=_rad
    }
    /*
    fun setCircleRadius(rad : Double){
        this.radius = rad
    }
    fun setCircleRadius(rad : Int){
        this.radius = rad.toDouble()
    }
    fun getCircleRadius():Double{
        return this.radius
    }
    */
    fun getCircleArea():Double{
        return this.radius*this.radius
    }
}