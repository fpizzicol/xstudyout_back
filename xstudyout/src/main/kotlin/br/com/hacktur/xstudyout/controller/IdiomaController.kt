import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/idiomas")
class IdiomaController {

    @GetMapping
    fun list(): List<Idioma> {
        return listOf(
                Idioma("Inglês", "https://upload.wikimedia.org/wikipedia/en/a/a4/Flag_of_the_United_States.svg"),
                Idioma("Francês", "https://upload.wikimedia.org/wikipedia/commons/6/62/Flag_of_France.png"))
    }

}