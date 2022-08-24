package features

class Regex {
    static void main(String[] args) {
        // ~ => pattern operator
        def pattern = ~"([Gg])roovy"

        print '"Groovy" ==~ pattern: '
        println "Groovy" ==~ pattern

        //slashy string, in which you do not need to escape '\' chararacter
        //with another backlash
        pattern =  ~/\d/

        def text = "0 one 2 three 4 five 6"
        def matcher = text =~ pattern

        print "digits in text: ${text} are: "
        println matcher.findAll()
    }
}
