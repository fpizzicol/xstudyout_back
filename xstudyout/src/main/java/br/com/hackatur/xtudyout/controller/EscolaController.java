package br.com.hackatur.xtudyout.controller;

import br.com.hackatur.xtudyout.domain.Escola;
import br.com.hackatur.xtudyout.service.EscolaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(Endpoints.ESCOLAS_ENDPOINT)
public class EscolaController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private EscolaService escolaService;

    EscolaController(EscolaService escolaService) {
        this.escolaService = escolaService;
    }

    @ResponseStatus(OK)
    @GetMapping
    List<Escola> getAll() {
        return escolaService.getAll();
    }

    @ResponseStatus(CREATED)
    @PostMapping
    Escola create(@Valid @RequestBody Escola escola) {
        log.info("creating escola=" + escola);
        return escolaService.create(escola);
    }

    @GetMapping("{document}")
    Escola getByDocument(@PathVariable String document) {
        return escolaService.getByDocument(document);
    }

    @PutMapping("{document}")
    Escola update(
            @PathVariable String document,
            @RequestBody Escola escola) {
        return escolaService.update(document, escola);
    }

    @PatchMapping("{document}")
    Escola patch(
            @PathVariable String document,
            @RequestBody Map<String, Object> escolaAtributos) {
        return escolaService.patch(document, escolaAtributos);
    }

    @DeleteMapping("{document}")
    void delete(@PathVariable String document) {
        escolaService.delete(document);
    }
}
