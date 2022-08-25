package sample

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class SampleClassGroovy {
    String name
    int age
    float salary
}

class Main {
    static void main(String[] args) {
        def obj = new SampleClassGroovy(name: "name", age: 22, salary: 100.50)
        assert obj.getAge() == 22
        assert obj.getName() == "name"
        assert obj.getSalary() == 100.50

        obj.setAge(100)
        assert obj.getAge() == 100
        def obj2 = new SampleClassGroovy(name: "other", age: 13, salary: 0)

        assert !obj.equals(obj2)
    }
}
