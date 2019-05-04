package br.com.hackatur.xtudyout.domain;

import com.google.cloud.firestore.DocumentSnapshot;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Endereco {

    public static String child = "escola";

    private String documento;
    @NonNull private Pais pais;
    @NonNull private String cidade;
    @NonNull private String endereco;


    public Endereco(DocumentSnapshot doc) {
        this.documento = doc.getId();
        this.pais = (Pais) doc.get("pais");
        this.cidade = doc.getString("cidade");
        this.endereco = doc.getString("endereco");
    }

    public Map<String, Object> toMap() {
        Map<String, Object> resp = new HashMap<>();
        resp.put("pais", getPais().toMap());
        resp.put("cidade", getCidade());
        resp.put("endereco", getEndereco());

        if (StringUtils.isNotBlank(getDocumento())) {
            resp.put("documento", getDocumento());
        }

        return resp;
    }


}
