package br.com.hackatur.xtudyout.service;

import br.com.hackatur.xtudyout.domain.Pais;
import br.com.hackatur.xtudyout.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    public List<Pais> getAll() {
        return paisRepository.findAll();
    }

    public Pais create(Pais pais) {
        return paisRepository.save(pais);
    }

    public Pais getByDocument(String document) {
        return paisRepository.findByDocument(document);
    }

    public Pais update(String document, Pais pais) {
        return paisRepository.update(document, pais);
    }

    public Pais patch(String document, Map<String, Object> paisAtributos) {
        return paisRepository.patchUpdate(document, paisAtributos);
    }

    public void delete(String document) {
        paisRepository.delete(document);
    }
}
