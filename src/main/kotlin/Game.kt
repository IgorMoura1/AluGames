import com.google.gson.annotations.SerializedName

class Game(@SerializedName("title") val title:String,
           @SerializedName("thumb") val cover:String) {
    // diferença entre val e var
    // var é uma variável mutável
    // val é uma variável imutável
    val description = ""
    override fun toString(): String {
        return "Meu Jogo: \n" +
                "Título: $title \n" +
                "Capa: $cover \n" +
                "Descricao: $description"
    }
}