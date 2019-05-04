package br.com.hackatur.xtudyout.service;

import br.com.hackatur.xtudyout.domain.Idioma;
import br.com.hackatur.xtudyout.repository.IdiomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class IdiomaService {

    @Autowired
    private IdiomaRepository idiomaRepository;

    public List<Idioma> getAll() {
        return idiomaRepository.findAll();
    }

    public Idioma create(Idioma idioma) {
        return idiomaRepository.save(idioma);
    }

    public Idioma getByDocument(String document) {
        return idiomaRepository.findByDocument(document);
    }

    public Idioma update(String document, Idioma idioma) {
        return idiomaRepository.update(document, idioma);
    }

    public Idioma patch(String document, Map<String, Object> idiomaAtributos) {
        return idiomaRepository.patchUpdate(document, idiomaAtributos);
    }

    public void delete(String document) {
        idiomaRepository.delete(document);
    }
}
