package br.com.hackatur.xtudyout.repository

import br.com.hackatur.xtudyout.domain.Escola
import com.google.api.core.ApiFuture
import com.google.cloud.firestore.DocumentReference
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.QuerySnapshot
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

import java.util.concurrent.ExecutionException

@Repository
class EscolaRepository {

    @Autowired
    Firestore firestore;

    Escola save(Escola escola) {
        ApiFuture<DocumentReference> apiFuture = firestore.collection(Escola.child).add(escola.toMap())
        try {
            return new Escola(apiFuture.get().get().get())
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace()
        }
        return null
    }

    List<Escola> findAll() {

        ApiFuture<QuerySnapshot> apiFuture = firestore.collection(Escola.child).get()
        try {
            return apiFuture.get().getDocuments().collect { new Escola(it) }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace()
        }
        return []
    }

    Escola findByDocument(String document) {
        new Escola(firestore.collection(Escola.child).document(document).get().get())
    }

    Escola update(String document, Escola escola) {
        firestore.collection(Escola.child).document(document).update(escola.toMap()).get()
        findByDocument(document)
    }

    Escola patchUpdate(String document, Map<String, Object> escolaAtributos) {
        escolaAtributos[]
        firestore.collection(Escola.child).document(document).update(escolaAtributos).get()
        findByDocument(document)
    }

    void delete(String document) {
        firestore.collection(Escola.child).document(document).delete().get()
    }
}
