package testFeatures

import spock.lang.Specification

class MapCoercion extends Specification {

    def "Map coercion - method"() {
        when:
        def myAccount = [getBalance: { -100 }] as BankAccount

        then:
        myAccount.getBalance() == -100
        myAccount.getName() == "name"
    }

    def "Map coercion = field"(){
        when:
        def myAccount = [name: "coerced"] as BankAccount

        then:
        myAccount.getBalance() == -10000
        myAccount.getName() == "coerced"
    }

    def "Map coercion - additional methods"() {
        when:
        def myAccount = [extraMethod: { "test" }] as BankAccount

        then:
        myAccount.extraMethod() == "test"
        myAccount.getBalance() == -10000
        myAccount.getName() == "name"
    }
}

class BankAccount {
    def balance = -10000
    def name = "name"

    def getBalance() {
        balance
    }

    def getName() {
        name
    }
}
