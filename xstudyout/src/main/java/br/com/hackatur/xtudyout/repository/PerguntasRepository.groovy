package br.com.hackatur.xtudyout.repository

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
}
