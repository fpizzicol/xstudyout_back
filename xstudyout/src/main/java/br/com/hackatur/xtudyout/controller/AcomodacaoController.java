package br.com.hackatur.xtudyout.controller;

import br.com.hackatur.xtudyout.domain.Acomodacao;
import br.com.hackatur.xtudyout.service.AcomodacaoService;
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
@RequestMapping(Endpoints.ACOMODACAO_ENDPOINT)
public class AcomodacaoController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AcomodacaoService acomodacaoService;

    @ResponseStatus(OK)
    @GetMapping
    List<Acomodacao> getAll() {
        return acomodacaoService.getAll();
    }

    @ResponseStatus(CREATED)
    @PostMapping
    Acomodacao create(@Valid @RequestBody Acomodacao acomodacao) {
        log.info("creating acomodacao=" + acomodacao);
        return acomodacaoService.create(acomodacao);
    }

    @GetMapping("{document}")
    Acomodacao getByDocument(@PathVariable String document) {
        return acomodacaoService.getByDocument(document);
    }

    @PutMapping("{document}")
    Acomodacao update(
            @PathVariable String document,
            @RequestBody Acomodacao acomodacao) {
        return acomodacaoService.update(document, acomodacao);
    }

    @PatchMapping("{document}")
    Acomodacao patch(
            @PathVariable String document,
            @RequestBody Map<String, Object> acomodacaoAtributos) {
        return acomodacaoService.patch(document, acomodacaoAtributos);
    }

    @DeleteMapping("{document}")
    void delete(@PathVariable String document) {
        acomodacaoService.delete(document);
    }
}
