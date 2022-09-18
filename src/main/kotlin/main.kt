import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() {
    val card1 = LottoCard()
    val card2 = LottoCard()

    val player1 = Player("Alexandr", card1)
    val player2 = Player("Andrey", card2)

    card1.createCard()
    card2.createCard()

    var gameState: GameState = GameState.Progress
    val players = mutableListOf(player1, player2)

    runBlocking {
        launch {
            println("Start game...")
            GeneratorKeg.getKeg().takeWhile { gameState is GameState.Progress }.collect {
                println("Barrel number - $it")
                for (player in players) {
                    gameState = player.game(it)
                    if (gameState is GameState.Win)
                        break
                }
            }
            println(gameState)
        }
    }
    for (player in players)
        player.gameCard.printCard()
}

object GeneratorKeg {
    fun getKeg() = (1..90)
        .shuffled()
        .asFlow()
}