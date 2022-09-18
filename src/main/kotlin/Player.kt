class Player(val namePlayer: String, val gameCard: LottoCard) {

    fun game(randomKeg: Int): GameState {
        for (column in 0..2) {
            for (row in 0..4) {
                if (gameCard.card[column][row] == randomKeg)
                    gameCard.card[column][row] = 0
            }
            if (gameCard.card[column].sumOf { it } == 0)
                return GameState.Win(this)
        }
        return GameState.Progress
    }
}