import sample.SampleClassGroovy

class Main {
    static void main(String[] args) {
        def obj = new SampleClassGroovy(name: "name", age: 22, salary: 100.50)

        //test getters
        assert obj.getAge() == 22
        assert obj.getName() == "name"
        assert obj.getSalary() == 100.50

        //test setters
        obj.setAge(100)
        assert obj.getAge() == 100

        //test equals
        def obj2 = new SampleClassGroovy(name: "name1", age: 23, salary: 101.00)
        assert !obj.equals(obj2)
    }
}