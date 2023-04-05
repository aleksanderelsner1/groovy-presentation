package features

class Regex {
    static void main(String[] args) {
        println """
        ***
        * Groovy regular expressions.
        ***\r\n""".stripIndent()

        println "*** Pattern operator -> ~ ****"
        println "   Used in front of string creates a pattern\r\n"
        def pattern = ~"([Gg])roovy"

        println "*** Exact match operator -> ==~ ***"
        println "   Evaluates to true if string on left matches pattern on right\r\n"

        print '"Groovy" ==~ "([Gg])roovy": '
        println "Groovy" ==~ pattern
        print '"Java" ==~ "([Gg])roovy": '
        println "Java" ==~ pattern

        println "\r\n*** You can use '/' to denote a String ***"
        println "   With string denoted like that you do not need to escape '\\' character\r\n"

        pattern = ~/\d/

        println "*** Find operator -> =~ ***"
        println "   Returns an object of java.util.regex.Matcher on which you can apply standard Matcher methods"
        println "   to extract results\r\n"

        def text = "0 one 2 three 4 five 6"
        def matcher = text =~ pattern

        print "Digits in '${text}' are: "
        println matcher.findAll()
    }
}
