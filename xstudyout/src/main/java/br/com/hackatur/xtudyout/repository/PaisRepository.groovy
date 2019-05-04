package br.com.hackatur.xtudyout.repository

import br.com.hackatur.xtudyout.domain.Pais
import com.google.api.core.ApiFuture
import com.google.cloud.firestore.DocumentReference
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.QuerySnapshot
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

import java.util.concurrent.ExecutionException

@Repository
class PaisRepository {

    @Autowired
    Firestore firestore;

    Pais save(Pais pais) {
        ApiFuture<DocumentReference> apiFuture = firestore.collection(Pais.child).add(pais.toMap())
        try {
            return new Pais(apiFuture.get().get().get())
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace()
        }
        return null
    }

    List<Pais> findAll() {

        ApiFuture<QuerySnapshot> apiFuture = firestore.collection(Pais.child).get()
        try {
            return apiFuture.get().getDocuments().collect { new Pais(it) }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace()
        }
        return []
    }

    Pais findByDocument(String document) {
        new Pais(firestore.collection(Pais.child).document(document).get().get())
    }

    Pais update(String document, Pais pais) {
        firestore.collection(Pais.child).document(document).update(pais.toMap()).get()
        findByDocument(document)
    }

    Pais patchUpdate(String document, Map<String, Object> paisAtributos) {
        firestore.collection(Pais.child).document(document).update(paisAtributos).get()
        findByDocument(document)
    }

    void delete(String document) {
        firestore.collection(Pais.child).document(document).delete().get()
    }
}
