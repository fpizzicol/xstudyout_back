package br.com.hackatur.xtudyout.controller;

import br.com.hackatur.xtudyout.domain.Pais;
import br.com.hackatur.xtudyout.service.PaisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(Endpoints.PAIS_ENDPOINT)
public class PaisController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private PaisService paisService;

    PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    @ResponseStatus(OK)
    @GetMapping
    List<Pais> getAll() {
        return paisService.getAll();
    }

    @ResponseStatus(CREATED)
    @PostMapping
    Pais create(@Valid @RequestBody Pais pais) {
        log.info("creating pais=" + pais);
        return paisService.create(pais);
    }

    @GetMapping("{document}")
    Pais getByDocument(@PathVariable String document) {
        return paisService.getByDocument(document);
    }

    @PutMapping("{document}")
    Pais update(
            @PathVariable String document,
            @RequestBody Pais pais) {
        return paisService.update(document, pais);
    }

    @PatchMapping("{document}")
    Pais patch(
            @PathVariable String document,
            @RequestBody Map<String, Object> paisAtributos) {
        return paisService.patch(document, paisAtributos);
    }

    @DeleteMapping("{document}")
    void delete(@PathVariable String document) {
        paisService.delete(document);
    }
}
