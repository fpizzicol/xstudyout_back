package br.com.hackatur.xtudyout.controller;

import br.com.hackatur.xtudyout.domain.Idioma;
import br.com.hackatur.xtudyout.service.IdiomaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

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

    @ResponseStatus(CREATED)
    @PostMapping
    Idioma create(@Valid @RequestBody Idioma idioma) {
        log.info("creating idioma=" + idioma);
        return idiomaService.create(idioma);
    }

    @ResponseStatus(OK)
    @GetMapping
    List<Idioma> getAll() {
        return idiomaService.getAll();
    }

}
