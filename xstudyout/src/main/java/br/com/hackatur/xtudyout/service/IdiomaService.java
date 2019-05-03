package br.com.hackatur.xtudyout.service;

import br.com.hackatur.xtudyout.domain.Idioma;
import br.com.hackatur.xtudyout.repository.IdiomaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdiomaService {

    private IdiomaRepository idiomaRepository;

    IdiomaService(IdiomaRepository idiomaRepository) {
        this.idiomaRepository = idiomaRepository;
    }

    public Idioma create(Idioma idioma) {
        return idiomaRepository.save(idioma);
    }

    public List<Idioma> getAll() {
        return idiomaRepository.findAll();
    }
}
