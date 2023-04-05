package features

class Closure {
    static void main(String[] args) {

        println """
        ***
        * 1. Simplest Closure.
        *   • return statement is not mandatory
        *     closure will return value of the
        *     last statement
        ***\r\n""".stripIndent()

        def helloWorld = {
            "Hello World!"
        }
        println "*** Testing simple closure: ***"
        println helloWorld()



        println """\r\n
        ***
        * 2. Closure with parameter.
        *   • Can have one or more explicitly defined parameters,
        *   • Explicitly defined parameters can have default values,
        *   • Closures can use implicit parameter 'it' for unary closure.
        ***\r\n
        """.stripIndent()

        def greet = { name = "default" ->
           "Hi, " + name + "!\r\n"
        }

        def multiGreet = { name1, name2 ->
            "Hi " + name1 + " and " + name2 + "!\r\n"
        }

        def unaryGreet = {
            "Hello, " + it + "!\r\n"
        }

        println "*** Testing closure with one parameter: ***"
        println greet("xyz")

        println "*** Testing closure with one default parameter: ***"
        println greet()

        println "*** Testing closure with two parameters: ***"
        println multiGreet("xyz", "zyx")

        println "*** Testing unary closure: ***"
        println unaryGreet("abc")

        println """\r\n
        ***
        * 3. Typed parameters in closures
        *    • When defining a closure you can also define the types of parameters.
        *    • And because closures are not typed they can return different types.
        ***\r\n
        """.stripIndent()

        def typedClosure = { int a ->
            if (a == 2){
                return "2"
            } else {
                return a
            }
        }

        println "*** Testing closure with typed parameters and different return types: ***"
        println "In our closure for 2 the return value is string, and for all other numbers int\r\n"
        print "typedClosure(2) instanceof String ==> "
        println typedClosure(2) instanceof String
        print "typedClosure(1) instanceof Integer ==> "
        println typedClosure(1) instanceof Integer

        println """\r\n
        ***
        * 4. Object.with(Closure closure) method
        *    • with() method accepts an closure,
        *    • can be applied on any Object,
        *    • 'it' used to call the Object,
        *    • every method call or property access/change
        *      is reflected on the original Object.
        ***\r\n
        """.stripIndent()

        println "*** Test with() on a list = [0, 1, 2, 3, 4]: ***"

        def list = [0, 1, 2, 3, 4]

        list.with {
            print "Calling from within 'with' method:\r\n "
            println "   Object refered to by it:" + it
            println()
            it[0] = 10
        }

        print "List was modified in the closure to: "
        println list

        println """\r\n
        ***
        * 5. Currying closures
        *    • setting one or more of closure parameters,
        *    • curry() - lhs parameter set,
        *    • rcurry() - rhs parameter set.
        ***\r\n
        """.stripIndent()

        def power = { int x, int y -> x**y }
        def powerOfTwo = power.curry(2)
        def toThePowerOfTwo = power.rcurry(2)

        println "*** Test closure currying: ***"
        println "left currying - 2.pow(3) => " + powerOfTwo(3)
        println "right currying - 3.pow(2) => " + toThePowerOfTwo(3)
    }
}
