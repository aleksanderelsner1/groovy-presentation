package sample;

import java.util.Objects;

public class SampleClassJava {
    private String name;
    private int age;
    private float salary;

    public SampleClassJava(String name, int age, float salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public float getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SampleClassJava that = (SampleClassJava) o;
        return age == that.age && Float.compare(that.salary, salary) == 0 && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary);
    }
}
