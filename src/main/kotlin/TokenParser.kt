import java.util.regex.Pattern

class TokenParser {

    companion object {
        val NUMBER_CHARS = "0123456789."
        val OPERATOR_CHARS = "+-/*=!><{}()[]"
        val WHITESPACE_CHARS = " \n\t\r"
        val STRING_DELIMITERS = "'\""
        val BOOLEAN_CHARS = "truefals"
        val KEYWORD_CHARS = "ifelsorwhdwtcabkunv"

        val NUMBER_TYPE = "number"
        val OPERATOR_TYPE = "operator"
        val STRING_TYPE = "string"
        val IDENTIFIER_TYPE = "identifier"
        val WHITESPACE_TYPE = "whitespace"
        val BOOLEAN_TYPE = "boolean"
        val KEYWORD_TYPE = "keyword"


        val BOOLEAN_VALUES = arrayOf("true", "false")
        val KEYWORD_VALUES = arrayOf("if", "else", "for", "while", "switch", "case", "break", "return", "var")
    }


    var tokens = mutableListOf<Token>()

    var currentToken: Token? = null

    var currentType = ""

    fun consume(char: Char) {

        val token = currentToken

        if (token == null) {
            currentToken = Token(checkType(char), char.toString())
            tokens.add(currentToken!!)
            return
        }

        val type = token.tipo

        if (!canBeConcatedInType(type, char)) {
            if (type == IDENTIFIER_TYPE) {
                token.convertType(convertIdentifierIfNeeded(token.valor))
            }
            currentToken = null
            return consume(char)
        }

        token.concat(char)

        if (type == STRING_TYPE && STRING_DELIMITERS.contains(char)) {
            currentToken = null
            return
        }


    }

    public fun end() {

        val token = currentToken ?: return

        val type = token.tipo

        if (type == IDENTIFIER_TYPE) {
            token.convertType(convertIdentifierIfNeeded(token.valor))
        }


    }

    private fun convertIdentifierIfNeeded(valor: String): String {

        if (BOOLEAN_VALUES.contains(valor)) {
            return BOOLEAN_TYPE
        }

        if (KEYWORD_VALUES.contains(valor)) {
            return KEYWORD_TYPE
        }


        return IDENTIFIER_TYPE

    }

    private fun canBeConcatedInType(type: String, char: Char): Boolean {

        return when (type) {
            NUMBER_TYPE -> NUMBER_CHARS.contains(char)
            WHITESPACE_TYPE -> WHITESPACE_CHARS.contains(char)
            OPERATOR_TYPE -> OPERATOR_CHARS.contains(char)
            STRING_TYPE -> true
            IDENTIFIER_TYPE -> Regex("[0-9A-Za-z_]").matches(char.toString())
            BOOLEAN_TYPE -> BOOLEAN_CHARS.contains(char.toString())
            KEYWORD_TYPE -> KEYWORD_CHARS.contains(char.toString())
            else -> false
        }


    }

    fun checkType(char: Char): String {

        if (NUMBER_CHARS.contains(char)) return NUMBER_TYPE
        if (STRING_DELIMITERS.contains(char)) return STRING_TYPE
        if (OPERATOR_CHARS.contains(char)) return OPERATOR_TYPE
        if (WHITESPACE_CHARS.contains(char)) return WHITESPACE_TYPE

        val regex = Regex("[a-zA-Z_]");

        if (regex.matches(char.toString())) return IDENTIFIER_TYPE

        throw Exception("invalid token")
    }


}