import com.google.gson.annotations.SerializedName

class Game(val title:String,
           val cover:String) {
    // diferença entre val e var
    // var é uma variável mutável
    // val é uma variável imutável
    var description:String? = null
    override fun toString(): String {
        return "Meu Jogo: \n" +
                "Título: $title \n" +
                "Capa: $cover \n" +
                "Descricao: $description"
    }
}