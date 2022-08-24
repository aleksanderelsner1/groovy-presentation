package features

class DynamicTyping {

    static void main(String[] args) {
        println "In groovy you do not have to explicitly define a type"
        println "of a variable\r\n"

        def variable = 3

        println "variable is equal to ${variable} and is a type of ${variable.class}\r\n"

        assert variable instanceof Integer

        variable = "ABCD"

        println "variable is equal to ${variable} and is a type of ${variable.class}\r\n"

        assert variable instanceof String

        variable = 3f

        println "variable is equal to ${variable} and is a type of ${variable.class}\r\n"

        assert variable instanceof Float

        println "Duck typing\r\n.............\r\n"
        println "Static method quack in our DynamicTyping class"
        println "does not know at compile time what object will be suplied"
        println "or if the object contains given method, but it allows us"
        println "to call this method\r\n"
        def duck = new Duck()

        println "result of Duck quacking is ${quack(duck)}\r\n"

        println "but if we supply an object that does not contain given method"
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
