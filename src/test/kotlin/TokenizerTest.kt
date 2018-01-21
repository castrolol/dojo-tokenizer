import org.amshove.kluent.`should be`
import org.amshove.kluent.`should equal`
import org.junit.Test

import org.junit.Assert.*

class TokenizerTest {

    @Test
    fun `deve retornar token com tipos number`() {

        val tokenizer = Tokenizer()

        val retorno = tokenizer.tokenize("55")

        retorno.size `should be` 1
        retorno[0].tipo `should be` "number"
        retorno[0].valor `should be` "55"
     }

    @Test
    fun `deve retornar um token com number, sendo real`(){
        val tokenizer = Tokenizer()

        val retorno = tokenizer.tokenize("5.5")

        retorno.size `should be` 1
        retorno[0].tipo `should be` "number"
        retorno[0].valor `should be` "5.5"
    }

    @Test
    fun `deve retornar um token string`(){
        val tokenizer = Tokenizer()

        val retorno = tokenizer.tokenize("'Coisa linda'")


        retorno[0].tipo `should be` "string"
        retorno[0].valor `should be` "'Coisa linda'"
    }

    @Test
    fun `deve retornar um token com bool`(){

        val tokenizer = Tokenizer()

        val retorno = tokenizer.tokenize("true")

        retorno[0].tipo `should be` "boolean"
        retorno[0].valor `should be` "true"



    }

}