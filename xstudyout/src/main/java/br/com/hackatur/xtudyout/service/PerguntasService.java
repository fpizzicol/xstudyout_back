package br.com.hackatur.xtudyout.service;

import br.com.hackatur.xtudyout.domain.Pergunta;
import br.com.hackatur.xtudyout.repository.PerguntasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerguntasService {

    private PerguntasRepository repository;

    PerguntasService(PerguntasRepository repository) {
        this.repository = repository;
    }

    public Pergunta create(Pergunta pergunta) {
        return repository.save(pergunta);
    }

    public List<Pergunta> getAll() {
        return repository.findAll();
    }
}
