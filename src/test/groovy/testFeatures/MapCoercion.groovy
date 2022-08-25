package testFeatures

import spock.lang.Specification

class MapCoercion extends Specification {

    def "Map coercion"() {
        when:
        def myAccount = [myDebt: { -100 }] as BankAccount

        then:
        myAccount.myDebt() == -100
        myAccount.myName() == "name"
    }

    def "Adding additional methods through map coercion"() {
        when:
        def myAccount = [extraMethod: { "test" }] as BankAccount

        then:
        myAccount.extraMethod() == "test"
    }
}

class BankAccount {
    def debt = -10000

    def myDebt() {
        debt
    }

    def myName() {
        "name"
    }
}
