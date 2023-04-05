package features

class Operators {
    static void main(String[] args) {

        println """
        ***
        * 1. Operator overloading.
        *   • Classes can overload what operators do by defining methods with certain names,
        *   • Operator to method name will be shown in presentation.
        ***\r\n""".stripIndent()

        def pair1 = new Pair(1, 2)
        def pair2 = new Pair(1, 2)

        println "pair1 + pair2 => ${pair1 + pair2} "
        println "pair1 - pair2 => ${pair1 - pair2} "


        println """
        ***
        * 2. Useful groovy operators.
        ***\r\n""".stripIndent()

        println "*** Safe navigation operator -> ?. ***"
        println "    Prevents the NullPointerException when calling methods on a null object\r\n"

        Pair pair3 = null
        try {
            pair3.getNumbers()
        } catch (NullPointerException e) {
            println " - call to .getNumbers() on a null object will result in NPE"
        }
        pair3?.getNumbers()

        println " - call to ?.getNumbers() will not execute the method if object is null\r\n"

        println "*** Elvis operator -> ?: / ?= ***"
        println "    ?: - Returns a default value if expression resolves to groovy false\r\n"

        def correctPair = pair3 ?: pair1
        println "correctPair = ($correctPair)"

        println "\r\n    ?= - Used for initialising uninitialized variables \r\n"

        pair3 ?= new Pair(10, 10)
        pair2 ?= new Pair(100, 100)

        println "pair3 = (${pair3}) - initialized"
        println "pair2 = (${pair2}) - not reassgined\r\n"

        println "*** Spread operator -> *. ***"
        println "   Used to invoke an action on all elements of aggregate object,"
        println "   it is equivalent to calling the action on each item and collecting the result into a list:"

        def pairs = [pair1, pair2, pair3]
        println "${pairs*.getNumber1()}\r\n"

        println "*** Range operator -> .. ***"
        println "   Used for creating ranges:"

        for (def n in 1..5) {
            print n + ", "
        }

    }
}

class Pair {

    private int number1
    private int number2

    Pair(int number1, int number2) {
        this.number1 = number1
        this.number2 = number2
    }

    def plus(Pair other) {
        return new Pair(this.number1 + other.number1,
            this.number2 + other.number2)
    }

    def minus(Pair other) {
        return new Pair(this.number1 - other.number1,
            this.number2 - other.number2)
    }

    def getNumbers() {
        number1 + number2
    }

    def getNumber1() {
        number1
    }

    @Override
    String toString() {
        "Pair of $number1 and $number2"
    }
}