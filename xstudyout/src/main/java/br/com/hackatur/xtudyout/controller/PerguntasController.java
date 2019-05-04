package br.com.hackatur.xtudyout.controller;

import br.com.hackatur.xtudyout.domain.Idioma;
import br.com.hackatur.xtudyout.domain.Pergunta;
import br.com.hackatur.xtudyout.service.PerguntasService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(Endpoints.PERGUNTAS_ENDPOINT)
public class PerguntasController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private PerguntasService perguntasService;

    PerguntasController(PerguntasService perguntasService) {
        this.perguntasService = perguntasService;
    }

    @ResponseStatus(OK)
    @GetMapping
    List<Pergunta> getAll() {
        return perguntasService.getAll();
    }

    @ResponseStatus(CREATED)
    @PostMapping
    Pergunta create(@Valid @RequestBody Pergunta pergunta) {
        log.info("creating idioma=" + pergunta);
        return perguntasService.create(pergunta);
    }

    @GetMapping("{document}")
    Pergunta getByDocument(@PathVariable String document) {
        return perguntasService.getByDocument(document);
    }


    @PutMapping("{document}")
    Pergunta update(
            @PathVariable String document,
            @RequestBody Pergunta pergunta) {
        return perguntasService.update(document, pergunta);
    }

    @PatchMapping("{document}")
    Pergunta patch(
            @PathVariable String document,
            @RequestBody Map<String, Object> perguntaAtributos) {
        return perguntasService.patch(document, perguntaAtributos);
    }

    @DeleteMapping("{document}")
    void delete(@PathVariable String document) {
        perguntasService.delete(document);
    }
}
