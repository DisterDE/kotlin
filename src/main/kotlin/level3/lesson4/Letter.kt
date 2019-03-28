internal val Letter.nextLetter
    get() = when (this) {
        Letter.A -> Letter.B
        Letter.B -> Letter.C
        Letter.C -> Letter.A
    }

enum class Letter {
    A, B, C;
}
