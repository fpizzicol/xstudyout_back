package br.com.hacktur.xstudyout

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.annotation.Id
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import com.google.cloud.firestore.Firestore
import com.google.firebase.cloud.FirestoreClient


@SpringBootApplication
class XstudyoutApplication {

    val firebaseDatabseUrl = "https://exchange-c9b48.firebaseio.com/"


    //Spring will automatically call this function and inject the return value into other places where it's needed
    @Bean
    fun initFirebase(): Firestore {
        val google: GoogleCredentials = GoogleCredentials.fromStream(FileHelper().getFireBaseCredentialStream().byteInputStream())

        val options = FirebaseOptions.Builder()
                .setCredentials(google)
                .setDatabaseUrl(firebaseDatabseUrl)
                .setDatabaseAuthVariableOverride(null)
                .build()


        FirebaseApp.initializeApp(options)

        return FirestoreClient.getFirestore()
    }

    //Spring will automatically call this function and inject the return value into other places where it's needed
//We don't need the return value, so we are just using the @Bean annotation to automatically populate the database
//Spring will determine where it needs to find the person repository and the databaseReference
    @Bean
    fun init(fs: Firestore) = CommandLineRunner {
        val idioma = Idioma("Nome", "Bandeira")


        fs.collection("idioma").add(idioma.toMapFirebase())

    }
}


fun main(args: Array<String>) {
    runApplication<XstudyoutApplication>(*args)
}


data class Idioma(
        val nome: String,
        val bandeira: String
//		@Id @GeneratedValue(strategy = GenerationType.AUTO)
//		val id: Long = 0 //A default value for this is set so we don't have to supply an id when initializing the repository in the init function
) {
    fun toMapFirebase(): Map<String, Any> = hashMapOf(
//			"id" to id,
            "nome" to nome,
            "bandeira" to bandeira)
}

//Spring will generate an implementation for this interface and make it available for injection at other locations.
//The JpaSpecificationExecutor interface is needed so we can use the jpa specification dsl to define custom methods.
class FileHelper {

    fun getFireBaseCredentialStream() =
            this::class.java.classLoader.getResource("exchange-firebase.json").readText()
}