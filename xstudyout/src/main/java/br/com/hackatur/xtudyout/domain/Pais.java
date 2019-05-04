package br.com.hackatur.xtudyout.domain;

import com.google.cloud.firestore.DocumentSnapshot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pais {

    public static String child = "pais";

    private String documento;
    private String continente;
    private String clima;
    private String moeda;
    private String descricao;
    private List<String> tags;


    public Pais(String continente, String clima, String moeda, String descricao, List<String> tags) {
        this.continente = continente;
        this.clima = clima;
        this.moeda = moeda;
        this.descricao = descricao;
        this.tags = tags;
    }

    public Pais(DocumentSnapshot doc) {
        this.documento = doc.getId();
        this.continente = doc.getString("continente");
        this.clima = doc.getString("clima");
        this.moeda = doc.getString("moeda");
        this.descricao = doc.getString("descricao");
        this.tags = (List<String>) doc.get("tags");
    }

    public Map<String, Object> toMap() {
        Map<String, Object> resp = new HashMap<>();
        resp.put("continente", getContinente());
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
