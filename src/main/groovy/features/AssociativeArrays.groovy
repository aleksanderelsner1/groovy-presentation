package features

class AssociativeArrays {

    static void main(String[] args) {
        def array = [0, 1, 2, 3]

        println array[2]

        def associativeArray =
            ["green": "#33FF42",
             "red"  : "#FF3C33",
             "blue" : "#33B2FF"]

        println associativeArray["green"]

        println associativeArray.blue
    }
}
