package br.com.hackatur.xtudyout.repository

import br.com.hackatur.xtudyout.domain.Idioma
import com.google.api.core.ApiFuture
import com.google.cloud.firestore.DocumentReference
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.QuerySnapshot
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

import java.util.concurrent.ExecutionException

@Repository
class IdiomaRepository {

    @Autowired
    Firestore firestore;

    Idioma save(Idioma idioma) {
        ApiFuture<DocumentReference> apiFuture = firestore.collection(Idioma.child).add(idioma.toMap())
        try {
            return new Idioma(apiFuture.get().get().get())
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace()
        }
        return null
    }

    List<Idioma> findAll() {
        save(new Idioma("Inglês", "https://upload.wikimedia.org/wikipedia/en/a/a4/Flag_of_the_United_States.svg"))
        save(new Idioma("Francês", "https://upload.wikimedia.org/wikipedia/commons/6/62/Flag_of_France.png"))

        ApiFuture<QuerySnapshot> apiFuture = firestore.collection(Idioma.child).get()
        List<Idioma> resp = new ArrayList<>()
        try {
            resp = apiFuture.get().getDocuments().collect { new Idioma(it) }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace()
        }

        return resp
    }
}
