package features

//anonymous block of code
class Closure {

    static void main(String[] args) {

        def helloWorld = {
            "Hello World!\r\n"
        }


        println "Testing simple closure:"
        println helloWorld()

        println "closure with parameter, you can explicitly define the parameters"
        println "or use the 'it' keyword to create unary closure\r\n"

        def greet = { name ->
            name + ", Hi!\r\n"
        }

        def unaryGreet = {
            it + ", Hello!\r\n"
        }

        println "Testing closure with parameter:"
        println greet("xyz")

        println "Testing unary closure:"
        println unaryGreet("abc")

        println "you can pass multiple explicitly defined parameters to a closure\r\n"

        def add = { x, y ->
            x + y
        }

        println "Testing multiple parameters in closure: "
        println add(2, 2) + '\r\n'

        println "Types for the parameters can also be defined\r\n"

        println "As closure return value is not typed it can"
        println "return multiple types\r\n"

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
        println "the return value is float: "
        print "area(4, 5, \"triangle\") => "
        println area(4, 5, "triangle") + '\r\n'

        println "But if we call the same closure with shape"
        println "that was not defined in out closure"
        println "it will return a String: "
        print "area(2, 7, \"trapezoid\") => "
        println area(2, 7, "trapezoid") + '\r\n'

        println "with() is a method that accepts a closure"
        println "and every method call or property access is"
        println "applied on the object the method was called on\r\n"
        def list = [0, 1, 2, 3, 4]

        list.with {
            print "Calling from within 'with' method: "
            println it
            println()
            it[0] = 10
        }

        print "List was modified in the closure: "
        println list + '\r\n'


        println "Closures can be curried"
        println "which means you can set one or more of the parameters\r\n"
        println "left currying - left hand side parameter set"

        def power = { int x, int y -> x**y }
        def powerOfTwo = power.curry(2)
        println "2.pow(3) = " + powerOfTwo(3) + '\r\n'

        println "right currying - right hand side parameter set"

        def toThePowerOfTwo = power.rcurry(2)

        println "3.pow(2) = " + toThePowerOfTwo(3)


    }
}
