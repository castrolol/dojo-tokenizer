class Token(
        tipo: String,
        valor: String

) {

    var tipo: String = tipo
        private set
    var valor: String = valor
        private set

    fun concat(char: Char) {
        valor += char
    }

    fun convertType(realType: String) {
        tipo = realType
    }

    override fun equals(other: Any?): Boolean {
        if(other is Token){
            return other.tipo == tipo && other.valor == valor
        }

        return super.equals(other)
    }
}
