package features

class Operators {
    static void main(String[] args) {
        //operator overloading
        def pair1 = new Pair(1, 2)
        def pair2 = new Pair(1, 2)

        def joinedPair = pair1 + pair2

        assert joinedPair.number1 == 2
        assert joinedPair.number2 == 4

        def counter = new Counter(0)

        println counter

        counter++

        println counter

        //useful new operators in groovy
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
}

class Counter {
    private int count

    Counter(int count) {
        this.count = count
    }

    def next() {
        count += 1
    }

    def getCount() {
        count
    }
}