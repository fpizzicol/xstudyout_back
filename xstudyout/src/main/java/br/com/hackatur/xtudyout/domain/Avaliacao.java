package br.com.hackatur.xtudyout.domain;

import com.google.cloud.firestore.DocumentSnapshot;
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
public class Avaliacao {

    public static String child = "avaliacoes";

    private String documento;
    private String autor;
    private Double nota;
    private String comentario;

    public Avaliacao(String autor, Double nota, String comentario) {
        this.autor = autor;
        this.nota = nota;
        this.comentario = comentario;
    }

    public Avaliacao(DocumentSnapshot doc) {
        this.documento = doc.getId();
        this.autor = doc.getString("autor");
        this.nota = doc.getDouble("nota");
        this.comentario = doc.getString("comentario");
    }

    public Map<String, Object> toMap(){
        Map<String, Object> resp = new HashMap<>();
        resp.put("autor", autor);
        resp.put("nota", nota);
        resp.put("comentario", comentario);

        if(StringUtils.isNotBlank(getDocumento())){
            resp.put("documento", documento);
        }

        return resp;
    }



}
