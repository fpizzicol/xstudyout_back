package br.com.hackatur.xtudyout.repository

import br.com.hackatur.xtudyout.domain.Idioma
import br.com.hackatur.xtudyout.domain.Pergunta
import com.google.api.core.ApiFuture
import com.google.cloud.firestore.DocumentReference
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.QuerySnapshot
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

import java.util.concurrent.ExecutionException

@Repository
class PerguntasRepository {

    @Autowired
    Firestore firestore;

    Pergunta save(Pergunta pergunta) {
        ApiFuture<DocumentReference> apiFuture = firestore.collection(Pergunta.child).add(pergunta.toMap())
        try {
            return new Pergunta(apiFuture.get().get().get())
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace()
        }
        return null
    }

    List<Pergunta> findAll() {

        ApiFuture<QuerySnapshot> apiFuture = firestore.collection(Pergunta.child).get()
        List<Pergunta> resp = new ArrayList<>()
        try {
            resp = apiFuture.get().getDocuments().collect { new Pergunta(it) }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace()
        }

        return resp
    }

    Pergunta findByDocument(String document) {
        new Pergunta(firestore.collection(Pergunta.child).document(document).get().get())
    }

    Pergunta update(String document, Pergunta pergunta) {
        firestore.collection(Pergunta.child).document(document).update(pergunta.toMap()).get()
        findByDocument(document)
    }

    Pergunta patchUpdate(String document, Map<String, Object> perguntaAtributos) {
        firestore.collection(Pergunta.child).document(document).update(perguntaAtributos).get()
        findByDocument(document)
    }

    void delete(String document) {
        firestore.collection(Pergunta.child).document(document).delete().get()
    }

}
