data class Idioma(val nome: String, val bandeira: String) {

    fun toMapFirebase(): Map<String, Any> = hashMapOf("nome" to nome, "bandeira" to bandeira)
}