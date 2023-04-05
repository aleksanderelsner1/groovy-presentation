package features

class MetaProgramming {
    static void main(String[] args) {

        println """
        ***
        * Each class in groovy has metaClass property which is instance of groovy.lang.ExpandoMetaClass
        * with it you can transform existing classes and object instance at runtime
        ***\r\n""".stripIndent()
        def human1 = new Human(age: 11, name: "John")

        try {
            human1.getAddress()
        } catch (MissingMethodException) {
            println "Human class does not have the getAddress() method,"
        }

        println "but we can add the method at run time to the instance of the class using metaClass\r\n"

        human1.metaClass.getAddress << { -> "address1" }

        print " - 'getAddress()' method of human1 returns: "
        println human1.getAddress()
        println()

        println "Additionally by creating a getter method the object instance automatically gained an address field\r\n"

        print " - 'address' field of human1 returns: "
        println human1.address

        println "\r\nThis way, only the object referenced by human1 contains the method and field"
        println "and it does not contain the address field we can change it by modifying the Human class directly\r\n"

        Human.class.metaClass.address = ""

        def human2 = new Human(age: 12, name: "Bob", address: "Prosta 20")

        println " - 'getAddress()' method of human1 returns: " + human2.getAddress()

        println "\r\nUse of metaClass property is not only limited to our own classes, "
        println "we can also modify existing classes, for example, we can add our own"
        println "static method to String class\r\n"

        String.class.metaClass.static.myOwnMethod << { -> "This is my method" }

        println " - Value returned by our new String method is: " + String.myOwnMethod()
    }
}

class Human {
    int age
    String name
}