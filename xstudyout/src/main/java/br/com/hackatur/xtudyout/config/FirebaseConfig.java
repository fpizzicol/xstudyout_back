package br.com.hackatur.xtudyout.config;

import br.com.hackatur.xtudyout.utils.FileHelper;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class FirebaseConfig {

    @Bean
    public Firestore initFirebase() throws IOException {
        String firebaseDatabseUrl = "https://exchange-c9b48.firebaseio.com/";

        GoogleCredentials google = GoogleCredentials.fromStream(FileHelper.getFireBaseCredentialStream());

                FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(google)
                .setDatabaseUrl(firebaseDatabseUrl)
                .setDatabaseAuthVariableOverride(null)
                .build();


        FirebaseApp.initializeApp(options);

        return FirestoreClient.getFirestore();
    }


}
