import org.amshove.kluent.*
import org.amshove.kluent.`should equal`
import org.junit.Test


class TokenParserTest {


    @Test
    fun `deve agrupar os numerais antes do espaco`(){

        val parser = TokenParser()

        val code = "55 "

        for(char in code){
            parser.consume(char)
        }

        val tokens = parser.tokens

        tokens.size `should equal` 2
        tokens[0].tipo `should equal` "number"
        tokens[0].valor `should equal` "55"


    }
    @Test
    fun `deve retornar o tipo number`(){
        val char = '5'

        val parser = TokenParser()

        val tipo = parser.checkType(char)


        tipo `should equal` "number"

    }


    @Test
    fun `deve retornar o tipo string`(){
        val char ='"'

        val parser = TokenParser()

        val tipo = parser.checkType(char)


        tipo `should equal` "string"
    }


    @Test
    fun `deve retornar o tipo operador`(){
        val char = '<'

        val parser = TokenParser()

        val tipo = parser.checkType(char)


        tipo `should equal` "operator"
    }

    @Test
    fun `deve retornar o tipo whiteSpace`(){
        val char = ' '

        val parser = TokenParser()

        val tipo = parser.checkType(char)


        tipo `should equal` "whiteSpace"
    }

    @Test
    fun `deve retornar o tipo identificator`() {
        val char = '_'

        val parser = TokenParser()

        val tipo = parser.checkType(char)


        tipo `should equal` "identifier"
    }

    @Test
    fun `deve estourar o compilador`(){

        val char = '#'

        val parser = TokenParser()

        val act: ()->Unit = {parser.checkType(char)}

        act shouldThrow Exception::class
    }



}