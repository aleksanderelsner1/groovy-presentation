package features

class DynamicTyping {

    static void main(String[] args) {
        def variable = 3

        assert variable instanceof Integer

        variable = "ABCD"

        assert variable instanceof String

        variable = 3f

        assert variable instanceof Float

        //Duck typing
        //Static method quack in our DynamicTyping class
        //does not know at compile time what object will be suplied
        //nor does the object contain given method, but it allows us
        //to call this method
        def duck = new Duck()
        println quack(duck)

        //if we supply an object that does not contain given method
        try {
            def dog = new Dog()
            println quack(dog)
        } catch (MissingMethodException e) {
            println "Missing method exception will be thrown"
        }

    }

    static def quack(def animal) {
        animal.quack()
    }
}

class Duck {
    def quack() {
        "quack"
    }
}

class Dog {
    def bark() {
        "bark"
    }
}
