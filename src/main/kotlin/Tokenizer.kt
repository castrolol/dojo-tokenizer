class Tokenizer {

    fun tokenize(entrada: String): Array<Token> {


        val parser = TokenParser()


        for (char in entrada) parser.consume(char)

        parser.end()

        return parser.tokens.toTypedArray()
    }

}