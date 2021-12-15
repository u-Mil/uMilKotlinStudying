package backpack

open class Student(name:String, gender:String, private var old:Int):Person(name, gender){
    override fun getName(): String {
        return super.getName() + " : Student"
    }

    override fun getGender(): String {
        return super.getGender() + " : Student"
    }

    fun getOld(): Int{
        return this.old
    }
    override fun talk(){
        println("Student Class")
    }
}