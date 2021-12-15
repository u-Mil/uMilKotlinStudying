package backpack

class Point (private var pnt_x:Int,private var pnt_y:Int){
    infix fun from(pnt:Point):Point{
        return Point(this.getX() - pnt.getX(), this.getY() - pnt.getY())
    }
    fun getX():Int{
        return this.pnt_x
    }
    fun getY():Int{
        return this.pnt_y
    }
}