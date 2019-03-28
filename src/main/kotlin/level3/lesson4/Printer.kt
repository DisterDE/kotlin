class Printer(private val neededLetter: Letter) {
    companion object {
        private val LOCKER = Object()
        @Volatile
        private var currentLetter = Letter.A
        internal var count = 0
    }

    internal fun print() {
        for (i in 0 until count) {
            synchronized(LOCKER) {
                while (currentLetter != neededLetter) {
                    try {
                        LOCKER.wait()
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
                print(neededLetter)
                currentLetter = currentLetter.nextLetter
                LOCKER.notifyAll()
            }
        }
    }
}
