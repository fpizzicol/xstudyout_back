package br.com.hackatur.xtudyout.service;

import br.com.hackatur.xtudyout.domain.Orcamento;
import br.com.hackatur.xtudyout.repository.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrcamentoService {

    @Autowired
    private OrcamentoRepository orcamentoRepository;

    public List<Orcamento> getAll() {
        return orcamentoRepository.findAll();
    }

    public Orcamento create(Orcamento orcamento) {
        return orcamentoRepository.save(orcamento);
    }

    public Orcamento getByDocument(String document) {
        return orcamentoRepository.findByDocument(document);
    }

    public Orcamento update(String document, Orcamento orcamento) {
        return orcamentoRepository.update(document, orcamento);
    }

    public Orcamento patch(String document, Map<String, Object> orcamentoAtributos) {
        return orcamentoRepository.patchUpdate(document, orcamentoAtributos);
    }

    public void delete(String document) {
        orcamentoRepository.delete(document);
    }
}
