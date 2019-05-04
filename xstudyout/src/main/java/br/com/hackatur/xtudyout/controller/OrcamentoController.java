package br.com.hackatur.xtudyout.controller;

import br.com.hackatur.xtudyout.domain.Orcamento;
import br.com.hackatur.xtudyout.service.OrcamentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(Endpoints.ORCAMENTO_ENDPOINT)
public class OrcamentoController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private OrcamentoService orcamentoService;

    OrcamentoController(OrcamentoService orcamentoService) {
        this.orcamentoService = orcamentoService;
    }

    @ResponseStatus(OK)
    @GetMapping
    List<Orcamento> getAll() {
        return orcamentoService.getAll();
    }

    @ResponseStatus(CREATED)
    @PostMapping
    Orcamento create(@Valid @RequestBody Orcamento orcamento) {
        log.info("creating orcamento=" + orcamento);
        return orcamentoService.create(orcamento);
    }

    @GetMapping("{document}")
    Orcamento getByDocument(@PathVariable String document) {
        return orcamentoService.getByDocument(document);
    }

    @PutMapping("{document}")
    Orcamento update(
            @PathVariable String document,
            @RequestBody Orcamento orcamento) {
        return orcamentoService.update(document, orcamento);
    }

    @PatchMapping("{document}")
    Orcamento patch(
            @PathVariable String document,
            @RequestBody Map<String, Object> orcamentoAtributos) {
        return orcamentoService.patch(document, orcamentoAtributos);
    }

    @DeleteMapping("{document}")
    void delete(@PathVariable String document) {
        orcamentoService.delete(document);
    }
}
