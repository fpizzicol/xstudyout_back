package br.com.hackatur.xtudyout.repository

import br.com.hackatur.xtudyout.domain.Idioma
import com.google.api.core.ApiFuture
import com.google.cloud.firestore.DocumentReference
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.QuerySnapshot
import com.google.cloud.firestore.SetOptions
import com.google.cloud.firestore.WriteResult
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

        ApiFuture<QuerySnapshot> apiFuture = firestore.collection(Idioma.child).get()
        try {
            return apiFuture.get().getDocuments().collect { new Idioma(it) }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace()
        }
        return []
    }

    Idioma findByDocument(String document) {
        new Idioma(firestore.collection(Idioma.child).document(document).get().get())
    }

    Idioma update(String document, Idioma idioma) {
        firestore.collection(Idioma.child).document(document).update(idioma.toMap()).get()
        findByDocument(document)
    }

    Idioma patchUpdate(String document, Map<String, Object> idiomaAtributos) {
        firestore.collection(Idioma.child).document(document).update(idiomaAtributos).get()
        findByDocument(document)
    }

    void delete(String document) {
        firestore.collection(Idioma.child).document(document).delete().get()
    }
}
