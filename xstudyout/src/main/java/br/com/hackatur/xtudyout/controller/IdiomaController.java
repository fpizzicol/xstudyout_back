package br.com.hackatur.xtudyout.controller;

import br.com.hackatur.xtudyout.domain.Idioma;
import br.com.hackatur.xtudyout.service.IdiomaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(Endpoints.IDIOMAS_ENDPOINT)
public class IdiomaController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private IdiomaService idiomaService;

    IdiomaController(IdiomaService idiomaService) {
        this.idiomaService = idiomaService;
    }

    @ResponseStatus(OK)
    @GetMapping
    List<Idioma> getAll() {
        return idiomaService.getAll();
    }

    @ResponseStatus(CREATED)
    @PostMapping
    Idioma create(@Valid @RequestBody Idioma idioma) {
        log.info("creating idioma=" + idioma);
        return idiomaService.create(idioma);
    }

    @GetMapping("{document}")
    Idioma getByDocument(@PathVariable String document) {
        return idiomaService.getByDocument(document);
    }

    @PutMapping("{document}")
    Idioma update(
            @PathVariable String document,
            @RequestBody Idioma idioma) {
        return idiomaService.update(document, idioma);
    }

    @PatchMapping("{document}")
    Idioma patch(
            @PathVariable String document,
            @RequestBody Map<String, Object> idiomaAtributos) {
        return idiomaService.patch(document, idiomaAtributos);
    }

    @DeleteMapping("{document}")
    void delete(@PathVariable String document) {
        idiomaService.delete(document);
    }
}
