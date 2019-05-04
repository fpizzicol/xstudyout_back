package br.com.hackatur.xtudyout.service;

import br.com.hackatur.xtudyout.domain.Avaliacao;
import br.com.hackatur.xtudyout.domain.Pergunta;
import br.com.hackatur.xtudyout.repository.AvaliacaoRepository;
import br.com.hackatur.xtudyout.repository.PerguntasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository repository;

    public List<Avaliacao> getAll() {
        return repository.findAll();
    }

    public Avaliacao create(Avaliacao avaliacao) {
        return repository.save(avaliacao);
    }

    public Avaliacao getByDocument(String document) {
        return repository.findByDocument(document);
    }

    public Avaliacao update(String document, Avaliacao avaliacao) {
        return repository.update(document, avaliacao);
    }

    public Avaliacao patch(String document, Map<String, Object> avaliacaoAtributos) {
        return repository.patchUpdate(document, avaliacaoAtributos);
    }

    public void delete(String document) {
        repository.delete(document);
    }

}
