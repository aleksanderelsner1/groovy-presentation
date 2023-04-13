package testFeatures

import spock.lang.Specification

class GroovyTruth extends Specification {
    def "truths"() {
        expect:
        assert true
        //empty list is equivalent to false
        assert ![]
        assert [1, 2, 3]

        //matcher has at least one match
        assert 'a' =~ /a/
        assert !('a' =~ /b/)

        //empty map is equivalent to false
        assert ["a": "a"]
        assert ![:]

        //empty strings are equivalent to false
        assert !""
        assert "text"

        //non zero numbers are equivalent to true
        assert !0
        assert 1
        assert 1.34

        //null objects are equivalent to false
        assert !null
        assert new Object()

        //you can customize the truth for your clases by implementing asBoolean method
        assert new Animal("DOG")
        assert !new Animal("CAT")
    }
}

class Animal {
    def type

    Animal(def type) {
        this.type = type
    }

    boolean asBoolean() {
        type == 'DOG'
    }
}
