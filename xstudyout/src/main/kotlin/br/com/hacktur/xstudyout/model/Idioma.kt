import com.google.cloud.firestore.DocumentSnapshot

class Idioma {
    var nome: String = ""
    var bandeira: String = ""
    var document: String = ""

    constructor(nome: String, bandeira: String) {
        this.nome = nome
        this.bandeira = bandeira
    }

    constructor(dataDoc: DocumentSnapshot) {
        this.document = dataDoc.id
        this.nome = dataDoc.getString("nome") ?: ""
        this.bandeira = dataDoc.getString("bandeira") ?: ""
    }

    fun toMapFirebase(): HashMap<String, String> {
        val map = hashMapOf("nome" to nome,
                "bandeira" to bandeira)

        if (document.isNotBlank()) {
            map["document"] = document
        }

        return map
    }
}