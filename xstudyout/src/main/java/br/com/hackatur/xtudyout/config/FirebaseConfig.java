package br.com.hackatur.xtudyout.config;

import br.com.hackatur.xtudyout.utils.FileHelper;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class FirebaseConfig {

    @Bean
    public Firestore initFirebase() throws IOException {

        GoogleCredentials google = GoogleCredentials.fromStream(FileHelper.getFireBaseCredentialStream());

        FirestoreOptions firestoreOptions =
                FirestoreOptions.getDefaultInstance().toBuilder()
                        .setCredentials(google)
                        .build();

        return firestoreOptions.getService();

    }


}
