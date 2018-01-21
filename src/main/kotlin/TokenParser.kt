import java.util.regex.Pattern

class TokenParser {

    var tokens = mutableListOf<Token>()

    var currentToken: Token? = null

    var currentType = ""

    fun consume(char: Char){

        if (currentToken == null){
            tokens.add(Token(checkType(char), char.toString()))
            return
        }

        val token = currentToken
        if (token != null) {
            currentType = checkType(char)

            if(currentType == token.tipo) {
                token.valor += char
            }
        }

        if(char != ' '){
            currentToken += char;
        }else{
            tokens.add(Token("number", token));
            tokens.add(Token("white space", " "))
        }


    }

    fun checkType(char: Char) : String {

        if("0123456789.".contains(char)) return "number"
        if("'\"".contains(char)) return "string"
        if("+-/*=!><{}()[]".contains(char)) return "operator"
        if(" \n\t\r".contains(char)) return "whiteSpace"

        val regex = Regex("[a-zA-Z_]");

        if(regex.matches(char.toString())) return "identifier"

        throw Exception("invalid token")
    }


}