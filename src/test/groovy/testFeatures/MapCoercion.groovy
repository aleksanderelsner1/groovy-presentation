package testFeatures

import spock.lang.Specification

class MapCoercion extends Specification {

    def "Map coercion - method"() {
        when:
        def myAccount = [getBalance: { -100 }] as BankAccount

        then:
        myAccount.balance == -100
        myAccount.name == "name"
    }

    def "Map coercion = field"(){
        when:
        def myAccount = [name: "coerced"] as BankAccount

        then:
        myAccount.balance == -10000
        myAccount.name == "coerced"
    }

    def "Map coercion - additional methods"() {
        when:
        def myAccount = [extraMethod: { "test" }] as BankAccount

        then:
        myAccount.extraMethod() == "test"
        myAccount.balance == -10000
        myAccount.name == "name"
    }

    def "List coercion"() {
        when:
        def human = ["John", "Paul", "Developer"] as Human

        then:
        human.fname == "John"
        human.lname == "Paul"
        human.occupation == "Developer"
    }
}

class BankAccount {
    int balance = -10000
    String name = "name"
}

class Human {
    String fname, lname, occupation;
}
