
class Tipo { }
fun doIt() {}

class ComoFazer {


    fun euSOuUmMetodo(souUmParam: Tipo) : Tipo{


        return Tipo()
    }


    fun comoFazer(){

        if(true){

        }else{


        }


        val rolou : Any? = null


        if(rolou is String){

        }

        //lista
        val items = listOf(1,2,3,4,5)

        //ternario
        val ba = if(true) 5 else 1


        //simpla
        while(false){

        }


        //for
        for(item in items){

        }


        for(i in 0 until items.size) {} //itera de 0 a 4

        for(i in 0..items.size) {} //itera de 0 a 5


        //switch
        val a = 0;

        when(a) {

            5 -> doIt()
            0 -> doIt()
            else -> doIt()
        }


        when(a){
            in 0..5 -> doIt()
            else -> doIt()
        }







    }

}

