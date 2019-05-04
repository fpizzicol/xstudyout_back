package br.com.hackatur.xtudyout.domain;

import com.google.cloud.firestore.DocumentSnapshot;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Pais {

    public static String child = "pais";

    private String documento;
    @NonNull private String nome;
    @NonNull private String continente;
    @NonNull private String clima;
    @NonNull private String moeda;
    @NonNull private String descricao;
    @NonNull private List<String> tags;

    public Pais(DocumentSnapshot doc) {
        this.documento = doc.getId();
        this.nome = doc.getString("nome");
        this.continente = doc.getString("continente");
        this.clima = doc.getString("clima");
        this.moeda = doc.getString("moeda");
        this.descricao = doc.getString("descricao");
        this.tags = (List<String>) doc.get("tags");
    }

    public Pais(Map map) {
        this.nome = (String) map.get("nome");
        this.continente = (String) map.get("continente");
        this.clima = (String) map.get("clima");
        this.moeda = (String) map.get("moeda");
        this.descricao = (String) map.get("descricao");
        this.tags = (List<String>) map.get("tags");
    }

    public Map<String, Object> toMap() {
        Map<String, Object> resp = new HashMap<>();
        resp.put("continente", getContinente());
        resp.put("nome", getNome());
        resp.put("clima", getClima());
        resp.put("moeda", getMoeda());
        resp.put("descricao", getDescricao());
        resp.put("tags", getTags());

        if (StringUtils.isNotBlank(getDocumento())) {
            resp.put("documento", getDocumento());
        }

        return resp;
    }


}
