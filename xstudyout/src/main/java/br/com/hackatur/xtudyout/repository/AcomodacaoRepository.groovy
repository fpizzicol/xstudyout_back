package br.com.hackatur.xtudyout.repository

import br.com.hackatur.xtudyout.domain.Acomodacao
import com.google.api.core.ApiFuture
import com.google.cloud.firestore.DocumentReference
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.QuerySnapshot
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

import java.util.concurrent.ExecutionException

@Repository
class AcomodacaoRepository {

    @Autowired
    Firestore firestore;

    Acomodacao save(Acomodacao acomodacao) {
        ApiFuture<DocumentReference> apiFuture = firestore.collection(Acomodacao.child).add(acomodacao.toMap())
        try {
            return new Acomodacao(apiFuture.get().get().get())
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace()
        }
        return null
    }

    List<Acomodacao> findAll() {

        ApiFuture<QuerySnapshot> apiFuture = firestore.collection(Acomodacao.child).get()
        try {
            return apiFuture.get().getDocuments().collect { new Acomodacao(it) }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace()
        }
        return []
    }

    Acomodacao findByDocument(String document) {
        new Acomodacao(firestore.collection(Acomodacao.child).document(document).get().get())
    }

    Acomodacao update(String document, Acomodacao acomodacao) {
        firestore.collection(Acomodacao.child).document(document).update(acomodacao.toMap()).get()
        findByDocument(document)
    }

    Acomodacao patchUpdate(String document, Map<String, Object> acomodacaoAtributos) {
        firestore.collection(Acomodacao.child).document(document).update(acomodacaoAtributos).get()
        findByDocument(document)
    }

    void delete(String document) {
        firestore.collection(Acomodacao.child).document(document).delete().get()
    }
}
