import sample.SampleClassGroovy

class Main {
    static void main(String[] args) {
        def obj = new SampleClassGroovy(name: "name", age: 22, salary: 100.50)
        def obj2 = new SampleClassGroovy(name: "other", age: 13, salary: 0)

        //test getters
        assert obj.getAge() == 22
        assert obj.getName() == "name"
        assert obj.getSalary() == 100.50

        //test setters
        obj.setAge(100)
        assert obj.getAge() == 100

        //test equals
        assert !obj.equals(obj2)
    }
}