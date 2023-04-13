package testFeatures

import groovy.mock.interceptor.MockFor
import groovy.mock.interceptor.StubFor
import spock.lang.Specification

class MockingStubbing extends Specification {

    def "Mocking"(){
        given:
        def mock = new MockFor(Person)

        when:
        // demand - object used for registering method calls
        mock.demand.getFirst { "mock_first" }
        mock.demand.getLast { "mock_last" }

        // ignore - object used for filtering methods that shouldn't be mocked
        mock.ignore('getAge')

        then:
        mock.use {
            def mary = new Person(first:'Mary', last:'Smith', age:33)
            def f = new Family(mother:mary)
            assert f.nameOfMother() == 'mock_first mock_last'
            assert mary.getAge() == 33
        }

        mock.expect.verify()
    }

    def "Stubbing"() {
        given:
        def stub = new StubFor(Person)

        when:
        stub.demand.with {
            getFirst{ 'stub_first' }
            getLast{ 'stub_last' }
        }

        stub.ignore("getAge")

        then:
        stub.use {
            def john = new Person(first:'John', last:'Smith')
            def f = new Family(father:john)
            assert f.nameOfFather() == 'stub_first stub_last'
            assert john.age == 0
        }
        stub.expect.verify()
    }
}

class Person {
    String first, last
    int age
}

class Family {
    Person father, mother
    def nameOfMother() { "$mother.first $mother.last" }
    def nameOfFather() { "$father.first $father.last" }
}
