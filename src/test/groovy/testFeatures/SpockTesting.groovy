package testFeatures

import spock.lang.Specification

class SpockTesting extends Specification {
    //in spock you can name your test method with a string
    def "Simple addition test"() {
        given:
        def x = 1
        def y = 1

        when:
        def result = x + y

        then:
        result == 2
    }

    def "Data table test - multiplication test"() {
        given:
        def x = number1
        def y = number2

        when:
        def result = x * y

        then:
        result == expectedResult

        where:
        number1 | number2 || expectedResult
        1       | 2       || 2
        3       | 3       || 9
        17      | 0       || 0
    }

    def "Data table test - failed test"() {
        given:
        def x = number1
        def y = number2

        when:
        def result = x * y

        then:
        result == expectedResult

        where:
        number1 | number2 || expectedResult
        1       | 2       || 37
        3       | 3       || 90
        17      | 0       || 20
    }

    def "Mocking a class without stubbing method call"() {
        given:
        def simpleClass = Mock(SimpleClass)

        expect:
        simpleClass.someMethod("value") == "return value is value"

        //because our method was mocked
        //default response was returned
        //without a real instance being invoked
    }

    def "Mocking a class with stubbing method call"() {
        given:
        def simpleClass = Mock(SimpleClass)
        // underscore used as argument wild card
        // anything can be supplied as argument
        // and the stub will work
        simpleClass.someMethod(_) >> "stubbed"

        expect:
        simpleClass.someMethod("value") == "stubbed"
    }

    def "Method call verifications"() {
        given:
        def simpleClass = Mock(SimpleClass)
        // in spock you can also verify how many times
        // given method was calles using its cardinality

        when:
        simpleClass.someMethod("value")

        then:
        1 * simpleClass.someMethod(_)
        // we expect that someMethod was called one time
    }
}

class SimpleClass {
    def someMethod(def someArgument) {
        "return value is ${someArgument}"
    }
}

