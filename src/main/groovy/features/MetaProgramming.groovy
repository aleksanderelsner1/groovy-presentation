package features

class MetaProgramming {
    static void main(String[] args) {

        //groovy provides a metaClass property in all of its classes
        //metaClass is instance of ExpandoMetaClass
        //it is a way of transforming existing classes and object instances at run time
        def human1 = new Human(age: 11, name: "John")

        try {
            human1.getAddress()
        } catch (MissingMethodException) {
            println "Human class does not have the getAddress method\r\n"
        }

        println "we can add the property and the method at run time to the instance of the class using metaClass"

        human1.metaClass.getAddress << { -> "address1" }

        print "Address of human1 is: "
        println human1.getAddress()
        println()

        println "additionaly by creating a getter method the object instance automatically"
        println "gained an address field\r\n"

        assert human1.address == "address1"

        println "but this way, only the human1 instance contains the method"
        println "and it does not contain the address field"
        println "we can change it by modifying the Human class directly\r\n"

        Human.class.metaClass.address = ""

        def human2 = new Human(age: 12, name: "Bob", address: "Prosta 20")

        println "Address of human2 is: " + human2.getAddress()

        println "the use of metaClass property is not only limited to our own classes"
        println "we can also modify existing classes, for example, we can add our own"
        println "static method to String class\r\n"

        String.class.metaClass.static.myOwnMethod << { -> "This is my method" }

        println "Value returned by my String method is: " + String.myOwnMethod()

    }
}

class Human {
    int age
    String name
}