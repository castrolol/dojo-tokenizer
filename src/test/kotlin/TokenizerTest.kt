import org.amshove.kluent.`should equal`
import org.amshove.kluent.`should equal`
import org.junit.Test

import org.junit.Assert.*

class TokenizerTest {

    @Test
    fun `deve retornar token com tipos number`() {

        val tokenizer = Tokenizer()

        val retorno = tokenizer.tokenize("55")

        retorno.size `should equal` 1
        retorno[0].tipo `should equal` "number"
        retorno[0].valor `should equal` "55"
    }


    @Test
    fun `deve ser possivel contemplar expressoes inteiras`() {

        val tokenizer = Tokenizer()

        val code = """
            var nome = "Nome de alguem"
            var valor = 5 + 3 + (3 * 4)
            var ok = true
            if(ok){
                nome += " sobrenome"
            }
        """;

        val tokensEsperados = arrayOf(
                Token("whitespace", "\n            "),

                Token("keyword", "var"),
                Token("whitespace", " "),
                Token("identifier", "nome"),
                Token("whitespace", " "),
                Token("operator", "="),
                Token("whitespace", " "),
                Token("string", "\"Nome de alguem\""),
                Token("whitespace", "\n            "),

                Token("keyword", "var"),
                Token("whitespace", " "),
                Token("identifier", "valor"),
                Token("whitespace", " "),
                Token("operator", "="),
                Token("whitespace", " "),
                Token("number", "5"),
                Token("whitespace", " "),
                Token("operator", "+"),
                Token("whitespace", " "),
                Token("number", "3"),
                Token("whitespace", " "),
                Token("operator", "+"),
                Token("whitespace", " "),
                Token("operator", "("),
                Token("number", "3"),
                Token("whitespace", " "),
                Token("operator", "*"),
                Token("whitespace", " "),
                Token("number", "4"),
                Token("operator", ")"),
                Token("whitespace", "\n            "),

                Token("keyword", "var"),
                Token("whitespace", " "),
                Token("identifier", "ok"),
                Token("whitespace", " "),
                Token("operator", "="),
                Token("whitespace", " "),
                Token("boolean", "true"),
                Token("whitespace", "\n            "),


                Token("keyword", "if"),
                Token("operator", "("),
                Token("identifier", "ok"),
                Token("operator", "){"),
                Token("whitespace", "\n                "),
                Token("identifier", "nome"),
                Token("whitespace", " "),
                Token("operator", "+="),
                Token("whitespace", " "),
                Token("string", "\" sobrenome\""),
                Token("whitespace", "\n            "),
                Token("operator", "}"),
                Token("whitespace", "\n        ")

        )

        val retorno = tokenizer.tokenize(code)


        tokensEsperados `should equal` retorno

    }

    @Test
    fun `deve retornar um token com number, sendo real`() {
        val tokenizer = Tokenizer()

        val retorno = tokenizer.tokenize("5.5")

        retorno.size `should equal` 1
        retorno[0].tipo `should equal` "number"
        retorno[0].valor `should equal` "5.5"
    }

    @Test
    fun `deve retornar um token string`() {
        val tokenizer = Tokenizer()

        val retorno = tokenizer.tokenize("'Coisa linda'")


        retorno[0].tipo `should equal` "string"
        retorno[0].valor `should equal` "'Coisa linda'"
    }

    @Test
    fun `deve retornar um token com bool`() {

        val tokenizer = Tokenizer()

        val retorno = tokenizer.tokenize("true")

        retorno[0].tipo `should equal` "boolean"
        retorno[0].valor `should equal` "true"


    }

}