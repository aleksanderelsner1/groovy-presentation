package features

//anonymous block of code
class Closure {

    static void main(String[] args) {

        def helloWorld = {
            "Hello World!"
        }


        println "Testing simple closure:"
        println helloWorld()
        println()

        //closure with parameter, you can explicitly define the parameters
        //or use the 'it' keyword to create unary closure

        def greet = { name ->
            name + ", Hi!"
        }

        def unaryGreet = {
            it + ", Hello!"
        }

        println "Testing closure with parameter:"
        println greet("xyz")
        println()

        println "Testing unary closure:"
        println unaryGreet("abc")
        println()

        //you can pass multiple explicitly defined parameters to a closure

        def add = { x, y ->
            x + y
        }

        println "Testing multiple parameters in closure:"
        println add(2, 2)
        println()

        //types for the parameters can also be defined

        //as closure return value is not typed it can
        //return multiple types

        def area = { float a, float h, String shape ->
            {
                switch (shape) {
                    case "triangle": return a * h / 2 as float
                    case "square":
                    case "rectangle": return a * h as float
                    default: "shape not implemented yet"
                }
            }
        }

        println "Testing closure with typed parameters"
        println "the return value is float:"
        println area(4, 5, "triangle")
        println()

        println "But if we call the same closure with shape"
        println "that was not defined in out closure"
        println "it will return a String:"
        println area(2, 7, "trapezoid")
        println()

        //with() is a method that accepts a closure
        //and every method call or property access is
        //appliedon the object the method was called on
        def list = [0, 1, 2, 3, 4]

        list.with {
            println "Calling from with in 'with' method:"
            println it
            it[0] = 10
        }

        println "List was modified in the method:"
        println list


    }

}
