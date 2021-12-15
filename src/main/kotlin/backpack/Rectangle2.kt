package backpack

class Rectangle2() {
    lateinit var pt1:Point
    lateinit var pt2:Point
    private var width:Double get() = pt1.getX().toDouble() - pt2.getX().toDouble()
    private var height:Double get() = pt1.getY().toDouble() - pt2.getY().toDouble()
    fun getArea():Double{
        return this.width * this.height
    }
    init {
        width = 0.0
        height = 0.0
    }
}