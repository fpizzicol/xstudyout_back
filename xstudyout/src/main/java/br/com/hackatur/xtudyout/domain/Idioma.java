package br.com.hackatur.xtudyout.domain;

import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Idioma {

    public static String child = "idioma";

    @NonNull private String nome;
    @NonNull private String bandeira;
    private String documento;

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
