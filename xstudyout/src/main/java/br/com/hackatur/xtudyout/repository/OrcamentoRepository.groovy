package br.com.hackatur.xtudyout.repository

import br.com.hackatur.xtudyout.domain.Orcamento
import com.google.api.core.ApiFuture
import com.google.cloud.firestore.DocumentReference
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.QuerySnapshot
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

import java.util.concurrent.ExecutionException

@Repository
class OrcamentoRepository {

    @Autowired
    Firestore firestore;

    Orcamento save(Orcamento orcamento) {
        ApiFuture<DocumentReference> apiFuture = firestore.collection(Orcamento.child).add(orcamento.toMap())
        try {
            return new Orcamento(apiFuture.get().get().get())
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace()
        }
        return null
    }

    List<Orcamento> findAll() {

        ApiFuture<QuerySnapshot> apiFuture = firestore.collection(Orcamento.child).get()
        try {
            return apiFuture.get().getDocuments().collect { new Orcamento(it) }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace()
        }
        return []
    }

    Orcamento findByDocument(String document) {
        new Orcamento(firestore.collection(Orcamento.child).document(document).get().get())
    }

    Orcamento update(String document, Orcamento orcamento) {
        firestore.collection(Orcamento.child).document(document).update(orcamento.toMap()).get()
        findByDocument(document)
    }

    Orcamento patchUpdate(String document, Map<String, Object> orcamentoAtributos) {
        firestore.collection(Orcamento.child).document(document).update(orcamentoAtributos).get()
        findByDocument(document)
    }

    void delete(String document) {
        firestore.collection(Orcamento.child).document(document).delete().get()
    }
}
