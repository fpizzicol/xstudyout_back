package br.com.hackatur.xtudyout.repository

import br.com.hackatur.xtudyout.domain.Avaliacao
import br.com.hackatur.xtudyout.domain.Pergunta
import com.google.api.core.ApiFuture
import com.google.cloud.firestore.DocumentReference
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.QuerySnapshot
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

import java.util.concurrent.ExecutionException

@Repository
class AvaliacaoRepository {

    @Autowired
    Firestore firestore;

    Avaliacao save(Avaliacao avaliacao) {
        ApiFuture<DocumentReference> apiFuture = firestore.collection(Avaliacao.child).add(avaliacao.toMap())
        try {
            return new Avaliacao(apiFuture.get().get().get())
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace()
        }
        return null
    }

    List<Avaliacao> findAll() {

        ApiFuture<QuerySnapshot> apiFuture = firestore.collection(Avaliacao.child).get()
        List<Avaliacao> resp = new ArrayList<>()
        try {
            return apiFuture.get().getDocuments().collect { new Avaliacao(it) }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace()
        }

        return resp
    }

    Avaliacao findByDocument(String document) {
        new Avaliacao(firestore.collection(Avaliacao.child).document(document).get().get())
    }

    Avaliacao update(String document, Avaliacao avaliacao) {
        firestore.collection(Avaliacao.child).document(document).update(avaliacao.toMap()).get()
        findByDocument(document)
    }

    Avaliacao patchUpdate(String document, Map<String, Object> avaliacaoAtributos) {
        firestore.collection(Avaliacao.child).document(document).update(avaliacaoAtributos).get()
        findByDocument(document)
    }

    void delete(String document) {
        firestore.collection(Avaliacao.child).document(document).delete().get()
    }

}
