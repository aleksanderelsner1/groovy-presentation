package testFeatures

import spock.lang.Specification

class CombinationMethods extends Specification {

    def "simple combinations"() {
        given:
        def list = [[1, 2], [4, 5, 6]]

        when:
        def combinations = list.combinations()

        then:
        combinations == [[1, 4], [2, 4], [1, 5], [2, 5], [1, 6], [2, 6]]
    }

    def "each combination"() {
        given:
        def list = [[1, 2, 3], [5, 6, 7, 8]]

        when:
        def eachCombination = []
        list.eachCombination { if (it.contains(3)) eachCombination << it }

        then:
        eachCombination == [[3, 5], [3, 6], [3, 7], [3, 8]]
    }
}
