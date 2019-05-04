package br.com.hackatur.xtudyout.repository;

import br.com.hackatur.xtudyout.domain.Idioma;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
class IdiomaRepository {

    Idioma save(Idioma idioma) {
        new Idioma()
    }

    List<Idioma> findAll() {
        [
            new Idioma("Inglês", "https://upload.wikimedia.org/wikipedia/en/a/a4/Flag_of_the_United_States.svg"),
            new Idioma("Francês", "https://upload.wikimedia.org/wikipedia/commons/6/62/Flag_of_France.png")
        ]
    }
}
