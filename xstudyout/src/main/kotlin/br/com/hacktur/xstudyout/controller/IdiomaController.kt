import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/idiomas")
class IdiomaController {

    @GetMapping
    fun list(): List<Idioma> {
        return listOf(Idioma("Inglês", "EUA"),
                Idioma("Francês", "França"))
    }

}