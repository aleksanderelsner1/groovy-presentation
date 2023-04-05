package scripts

import groovy.transform.Field

println """
• Scripts are converted in to classes by groovy compiler
• Converted class extends the groovy.lang.Script class
• groovy.lang.Script requires a run method returning a value
• Script body goes into the run method
• Name of the generated class will be the script filename
• Main method is automatically generated and delegates the execution of the script on the run method\r\n"""

println "• Scripts can also define different variables: "
"   - with @Field annotation, and each of the fields in the script will end up as class fields in generated class\r\n"
"   - with no type, and each of those variables will be put in to scripts Binding which is visible from all methods and can be used to share data between" +
    " script and application that uses it"
"   - with type, local variable visible only in run() method of the script"

@Field
int x = 10

int y = 20

z = 30

println "• Scripts can define methods, and each of the methods in the script will end up as class methods in generated class\r\n"

int add(int one, int two) {
    one + two
}

int sub(int one, int two) {
    one - two
}

int mul(int one, int two) {
    one * two
}

def result = mul(add(x, x), sub(x, x))

println "result = $result"

return result



