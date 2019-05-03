class FileHelper {

    fun getFireBaseCredentialStream() =
            this::class.java.classLoader.getResource("exchange-firebase.json").readText()
}