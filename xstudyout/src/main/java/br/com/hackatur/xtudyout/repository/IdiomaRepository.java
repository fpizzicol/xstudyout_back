package br.com.hackatur.xtudyout.repository;

import br.com.hackatur.xtudyout.domain.Idioma;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class IdiomaRepository {

    public Idioma save(Idioma idioma) {
        return new Idioma();
    }

    public List<Idioma> findAll() {
        return Arrays.asList(
                new Idioma("Inglês", "https://upload.wikimedia.org/wikipedia/en/a/a4/Flag_of_the_United_States.svg"),
                new Idioma("Francês", "https://upload.wikimedia.org/wikipedia/commons/6/62/Flag_of_France.png")
        );
    }
}
