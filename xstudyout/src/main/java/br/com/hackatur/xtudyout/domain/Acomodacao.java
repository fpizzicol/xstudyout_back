package br.com.hackatur.xtudyout.domain;

import com.google.cloud.firestore.DocumentSnapshot;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Acomodacao {

    public static String child = "acomodacoes";

    private String documento;
    @NonNull private String nome;
    @NonNull private String imagem;
    @NonNull private Date inicio;
    @NonNull private Date fim;
    @NonNull private Double valor;
    @NonNull private String cidade;
    @NonNull private Pais pais;

    public Acomodacao(DocumentSnapshot doc) {
        this.documento = doc.getId();
        this.nome = doc.getString("nome");
        this.imagem = doc.getString("imagem");
        this.inicio = doc.getDate("inicio");
        this.fim = doc.getDate("fim");
        this.valor = doc.getDouble("valor");
        this.cidade = doc.getString("cidade");
        this.pais = new Pais((Map) doc.get("pais"));
    }

    public Map<String, Object> toMap(){
        Map<String, Object> resp = new HashMap<>();
        resp.put("nome", getNome());
        resp.put("imagem", getImagem());
        resp.put("inicio", getInicio());
        resp.put("fim", getFim());
        resp.put("valor", getValor());
        resp.put("cidade", getCidade());
        resp.put("pais", getPais().toMap());

        if(StringUtils.isNotBlank(getDocumento())){
            resp.put("documento", documento);
        }

        return resp;
    }
}
