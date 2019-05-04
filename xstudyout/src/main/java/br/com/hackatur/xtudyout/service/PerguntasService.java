package br.com.hackatur.xtudyout.service;

import br.com.hackatur.xtudyout.domain.Idioma;
import br.com.hackatur.xtudyout.domain.Pergunta;
import br.com.hackatur.xtudyout.repository.PerguntasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PerguntasService {

    private PerguntasRepository repository;

    PerguntasService(PerguntasRepository repository) {
        this.repository = repository;
    }

    public List<Pergunta> getAll() {
        return repository.findAll();
    }

    public Pergunta create(Pergunta pergunta) {
        return repository.save(pergunta);
    }

    public Pergunta getByDocument(String document) {
        return repository.findByDocument(document);
    }

    public Pergunta update(String document, Pergunta pergunta) {
        return repository.update(document, pergunta);
    }

    public Pergunta patch(String document, Map<String, Object> perguntaAtributos) {
        return repository.patchUpdate(document, perguntaAtributos);
    }

    public void delete(String document) {
        repository.delete(document);
    }

}
