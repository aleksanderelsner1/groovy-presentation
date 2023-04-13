package sample

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includeFields = true)
class SampleClassGroovy {
    String name
    int age
    float salary
}
