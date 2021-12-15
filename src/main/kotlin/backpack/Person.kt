package backpack

open class Person(private var name: String, private var gender: String) {
    open fun getName():String{
        return name
    }
    open fun getGender():String{
        return gender
    }
    open fun talk(){
        println("Person Class")
    }
}