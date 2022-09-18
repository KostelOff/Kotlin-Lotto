class LottoCard {

    var card: MutableList<MutableList<Int>> = MutableList(3) { MutableList(5) { 0 } }

    fun createCard(): MutableList<MutableList<Int>> {
        val tempCard = (1..90).shuffled()
        var count = 0
        for (column in 0..2) {
            for (row in 0..4) {
                card[column][row] = tempCard[count++]
            }
            card[column].sort()
        }
        return card
    }

    fun printCard() {
        for (column in 0..2) {
            for (row in 0..4) {
                print("${card[column][row]} ")
            }
            println()
        }
        println()
    }
}