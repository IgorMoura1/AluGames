import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.*


fun main() {
    val reader = Scanner(System.`in`)
    println("Digite um código do jogo para buscar:")

    val search = reader.nextLine()

    val endereco = "https://www.cheapshark.com/api/1.0/games?id=$search"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(endereco))
        .build()
    val response = client
        .send(request, HttpResponse.BodyHandlers.ofString())

    val json = response.body()

    val gson = Gson()
    val myInfoGame = gson.fromJson(json, InfoGame::class.java)

    var myGame:Game? = null

    val result = runCatching {
        myGame = Game(
            myInfoGame.info.title,
            myInfoGame.info.thumb)
    }

    result.onFailure{
        println("That game do not exists. Try other number.")
    }
    result.onSuccess {
        println("Want to insert a customized description? S/N")
        val opcao = reader.nextLine()
        if (opcao.equals("s", true)) {
            println("Insert your custom description:")
            val description = reader.nextLine()
            myGame?.description = description
        } else {
            myGame?.description = myGame?.title
        }
        println(myGame)
    }

    result.onSuccess {
        println("Search ended with success.")
    }
}