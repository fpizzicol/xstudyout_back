package br.com.hackatur.xtudyout.domain;

import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Idioma {

    public static String child = "idioma";

    private String nome;
    private String bandeira;
    private String documento;

    public Idioma(String nome, String bandeira) {
        this.nome = nome;
        this.bandeira = bandeira;
    }

    public Idioma(DocumentSnapshot doc) {
        this.documento = doc.getId();
        this.bandeira = doc.getString("bandeira");
        this.nome = doc.getString("nome");
    }

    public Map<String, Object> toMap(){
        Map<String, Object> resp = new HashMap<>();
        resp.put("nome", getNome());
        resp.put("bandeira", getBandeira());

        if(StringUtils.isNotBlank(getDocumento())){
            resp.put("documento", getDocumento());
        }

        return resp;
    }



}
