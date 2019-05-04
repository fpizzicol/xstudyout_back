package br.com.hackatur.xtudyout.controller;

import br.com.hackatur.xtudyout.domain.Avaliacao;
import br.com.hackatur.xtudyout.domain.Pergunta;
import br.com.hackatur.xtudyout.service.AvaliacaoService;
import br.com.hackatur.xtudyout.service.PerguntasService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(Endpoints.AVALIACAO_ENDPOINT)
public class AvaliacaoController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AvaliacaoService avaliacaoService;

    @ResponseStatus(OK)
    @GetMapping
    List<Avaliacao> getAll() {
        return avaliacaoService.getAll();
    }

    @ResponseStatus(CREATED)
    @PostMapping
    Avaliacao create(@Valid @RequestBody Avaliacao avaliacao) {
        log.info("creating avaliacao=" + avaliacao);
        return avaliacaoService.create(avaliacao);
    }

    @GetMapping("{document}")
    Avaliacao getByDocument(@PathVariable String document) {
        return avaliacaoService.getByDocument(document);
    }

    @PutMapping("{document}")
    Avaliacao update(
            @PathVariable String document,
            @RequestBody Avaliacao avaliacao) {
        return avaliacaoService.update(document, avaliacao);
    }

    @PatchMapping("{document}")
    Avaliacao patch(
            @PathVariable String document,
            @RequestBody Map<String, Object> avaliacaoAtributos) {
        return avaliacaoService.patch(document, avaliacaoAtributos);
    }

    @DeleteMapping("{document}")
    void delete(@PathVariable String document) {
        avaliacaoService.delete(document);
    }
}
