import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FirebaseConfig {

    @Bean
    fun initFirebase(): Firestore {
        val firebaseDatabseUrl = "https://exchange-c9b48.firebaseio.com/"
        val google: GoogleCredentials = GoogleCredentials.fromStream(FileHelper().getFireBaseCredentialStream().byteInputStream())

        val options = FirebaseOptions.Builder()
                .setCredentials(google)
                .setDatabaseUrl(firebaseDatabseUrl)
                .setDatabaseAuthVariableOverride(null)
                .build()


        FirebaseApp.initializeApp(options)

        return FirestoreClient.getFirestore()
    }
}