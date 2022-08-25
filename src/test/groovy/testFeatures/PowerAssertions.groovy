package testFeatures

import spock.lang.Specification

class PowerAssertions extends Specification {

    def "Power assertion failed"() {
        expect:
        2 + 2 == 7 + 3
    }

    def "Power assertion failed chained methods"() {
        expect:
        new Integer(-5).abs().power(2).minus(17).plus(22) == 50
    }

    def "Power assertion failed chained methods 2"() {
        expect:
        [-2, -1, 0, 1, 2, 3, 4, 5, 6].findAll { it % 2 == 0 }.findAll { it < 3 }.collect { it**3 } == 0
    }
}
