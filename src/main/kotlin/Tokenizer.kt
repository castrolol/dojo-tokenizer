class Tokenizer{

    fun tokenize(entrada: String) : Array<Token>{

        return  arrayOf(Token(avaliaTipo(entrada), entrada))


    }

    fun avaliaTipo(valor: String) : String {


        val novoValor = valor.toDoubleOrNull()


        return if(novoValor==null) "string" else "number"




    }
}