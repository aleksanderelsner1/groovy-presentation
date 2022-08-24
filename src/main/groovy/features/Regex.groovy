package features

class Regex {
    static void main(String[] args) {
        println "~ used in front of a String creates a pattern\r\n"
        def pattern = ~"([Gg])roovy"

        println "==~ exact match operator"
        println "evaluates to true if string on left matches pattern on right"

        print '"Groovy" ==~ "([Gg])roovy": '
        println "Groovy" ==~ pattern
        print '"Java" ==~ "([Gg])roovy": '
        println "Java" ==~ pattern

        println "\r\nyou can use '/' to denote a string"
        println "with string denoted like that you do not need to"
        println "escape '\\' character\r\n"

        pattern = ~/\d/

        println "=~ find operator"
        println "returns an object of java.util.regex.Matcher"
        println "on which you can apply standard Matcher methods"
        println "to extract results\r\n"

        def text = "0 one 2 three 4 five 6"
        def matcher = text =~ pattern

        print "digits in text: ${text} are: "
        println matcher.findAll()
    }
}
