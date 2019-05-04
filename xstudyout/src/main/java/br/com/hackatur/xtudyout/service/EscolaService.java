package br.com.hackatur.xtudyout.service;

import br.com.hackatur.xtudyout.domain.Escola;
import br.com.hackatur.xtudyout.repository.EscolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EscolaService {

    @Autowired
    private EscolaRepository escolaRepository;

    public List<Escola> getAll() {
        return escolaRepository.findAll();
    }

    public Escola create(Escola escola) {
        return escolaRepository.save(escola);
    }

    public Escola getByDocument(String document) {
        return escolaRepository.findByDocument(document);
    }

    public Escola update(String document, Escola escola) {
        return escolaRepository.update(document, escola);
    }

    public Escola patch(String document, Map<String, Object> escolaAtributos) {
        return escolaRepository.patchUpdate(document, escolaAtributos);
    }

    public void delete(String document) {
        escolaRepository.delete(document);
    }
}
