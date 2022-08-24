package features

class Traits {

    trait MyTrait {
        //can have abstract methods like interface
        //but also default implemted methods

        //abstract method
        abstract static int add(int a, int b)

        static int multiply(int a, int b) {
            a * b
        }

    }

    static class Calculator implements MyTrait {

        static int add(int a, int b) {
            a + b
        }
    }

    static void main(String[] args) {
        assert Calculator.add(1, 2) == 3
        assert Calculator.multiply(3, 3) == 9
    }
}
