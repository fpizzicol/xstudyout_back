package br.com.hackatur.xtudyout.service;

import br.com.hackatur.xtudyout.domain.Acomodacao;
import br.com.hackatur.xtudyout.repository.AcomodacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AcomodacaoService {

    @Autowired
    private AcomodacaoRepository acomodacaoRepository;

    public List<Acomodacao> getAll() {
        return acomodacaoRepository.findAll();
    }

    public Acomodacao create(Acomodacao acomodacao) {
        return acomodacaoRepository.save(acomodacao);
    }

    public Acomodacao getByDocument(String document) {
        return acomodacaoRepository.findByDocument(document);
    }

    public Acomodacao update(String document, Acomodacao acomodacao) {
        return acomodacaoRepository.update(document, acomodacao);
    }

    public Acomodacao patch(String document, Map<String, Object> acomodacaoAtributos) {
        return acomodacaoRepository.patchUpdate(document, acomodacaoAtributos);
    }

    public void delete(String document) {
        acomodacaoRepository.delete(document);
    }
}
