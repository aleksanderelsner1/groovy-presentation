package features

class DynamicTyping {

    static void main(String[] args) {
        println """
        ***
        * 1. Dynamic Typing.
        *   • Type of a variable does not have to be explicitly given to compiler
        *   • Same variable can hold objects of different types
        ***\r\n""".stripIndent()

        def variable = 3

        println "'variable' initialised, and is equal to ${variable}, and is a type of ${variable.class}\r\n"

        assert variable instanceof Integer

        variable = "ABCD"

        println "'variable' reassigned, and is equal to ${variable}, and is a type of ${variable.class}\r\n"

        assert variable instanceof String

        variable = 3f

        println "'variable' reassigned, and is equal to ${variable} and is a type of ${variable.class}\r\n"

        assert variable instanceof Float

        println """
        ***
        * 2. Duck Typing.
        * "If it walks like a duck and it quacks like a duck, then it must be a duck"
        *   • static method quack() in this example at compile time has no idea,
        *     what type of object will be supplied to it, and still allows
        *     us to call methods on it with out information if this
        *     object contains this method
        ***\r\n""".stripIndent()
        def duck = new Duck()
        def dog = new Dog()

        println "If we supply an object that does not contain given method,"
        try {
            println quack(dog)
        } catch (MissingMethodException e) {
            println "missing method exception will be thrown.\r\n"
        }
        println "And if we supply an object that has it the result will be: " + quack(duck)

    }

    static def quack(def object) {
        object.quack()
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
