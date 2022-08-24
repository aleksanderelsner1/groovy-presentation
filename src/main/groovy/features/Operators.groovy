package features

class Operators {
    static void main(String[] args) {
        println "In groovy you can overload the operators"
        println "by creating a method with certain name in your class"
        println "the matrix of methods and operators should be in the presentation"

        def pair1 = new Pair(1, 2)
        def pair2 = new Pair(1, 2)

        def joinedPair = pair1 + pair2
        println "pair1 + pair2 = ${joinedPair} "

        assert joinedPair.number1 == 2
        assert joinedPair.number2 == 4

        println "There are also many useful operators in groovy\r\n"

        println "Safe navigation operator - ?."
        println "Prevents the NullPointerException when calling methods"
        println "on a null object\r\n"

        Pair pair3 = null

        try {
            pair3.getNumbers()
        } catch (NullPointerException e) {
            println "This call results in null pointer exception\r\n"
        }

        println "but call with '?.' operator is null safe"
        println "thus no exception is thrown\r\n"

        pair3?.getNumbers()

        println "Elvis operator - ?:"
        println "used to return default value if expression resolves to false"

        def correctPair = pair3 ?: pair1

        println correctPair

        println "It can be also used to populate variable that might "
        println "have been not instantiated\r\n"

        pair3 ?= new Pair(10, 10)
        pair2 ?= new Pair(100, 100)

        println "pair3 = ${pair3}"
        println "pair2 = ${pair2}\r\n"

        println "Spread operator *."
        println "Used to invoke an action on all elements of"
        println "aggregate object"
        println "it is equivalent to calling the action on each "
        println "item and collecting the result into a list:"

        def list = [pair1, pair2, pair3]
        println "${list*.getNumber1()}\r\n"

        println "Range operator .."
        println "for creating ranges:"

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

    def getNumbers() {
        number1 + number2
    }

    def getNumber1() {
        number1
    }

    @Override
    String toString() {
        "Pair($number1, $number2)"
    }
}