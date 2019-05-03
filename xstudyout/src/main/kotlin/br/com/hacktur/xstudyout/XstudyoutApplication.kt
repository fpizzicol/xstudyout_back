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

@SpringBootApplication
class XstudyoutApplication {

val firebaseDatabseUrl = "https://exchange-c9b48.firebaseio.com/"


//Spring will automatically call this function and inject the return value into other places where it's needed
//We don't need the return value, so we are just using the @Bean annotation to automatically populate the database
//Spring will determine where it needs to find the person repository and the databaseReference
@Bean
fun init(fb: DatabaseReference) = CommandLineRunner {
	FirebaseDatabase.getInstance().reference.child("idioma").setValueAsync(Idioma("Hendi", "Santika"))

}

//Spring will automatically call this function and inject the return value into other places where it's needed
@Bean
fun initFirebase(): DatabaseReference {
	val google: GoogleCredentials = GoogleCredentials.fromStream(FileHelper().getFireBaseCredentialStream().byteInputStream())

	val options = FirebaseOptions.Builder()
			.setCredentials(google)
			.setDatabaseUrl(firebaseDatabseUrl)
			.build()


	FirebaseApp.initializeApp(options)
	return FirebaseDatabase.getInstance().reference.child("idioma")
}
}



fun main(args: Array<String>) {
	runApplication<XstudyoutApplication>(*args)
}



data class Idioma(
		val nome: String,
		val bandeira: String, //Spring will use the nullable information to infer that this field is not required when making a POST request
		@Id @GeneratedValue(strategy = GenerationType.AUTO)
		val id: Long = 0 //A default value for this is set so we don't have to supply an id when initializing the repository in the init function
)

//Spring will generate an implementation for this interface and make it available for injection at other locations.
//The JpaSpecificationExecutor interface is needed so we can use the jpa specification dsl to define custom methods.
class FileHelper {

	fun getFireBaseCredentialStream() =
			this::class.java.classLoader.getResource("exchange-firebase.json").readText()
}