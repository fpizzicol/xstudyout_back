package br.com.hackatur.xtudyout.domain;

import com.google.cloud.firestore.DocumentSnapshot;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Pergunta {

    public static String child = "pergunta";

    private String documento;
    @NonNull private Long ordem;
    @NonNull private String questao;
    @NonNull private List<Resposta> respostas;

    public Pergunta(DocumentSnapshot doc) {
        this.documento = doc.getId();
        this.ordem = doc.getLong("ordem");
        this.questao = doc.getString("questao");
        this.respostas = (List<Resposta>) doc.get("respostas");
    }

    public Map<String, Object> toMap() {
        Map<String, Object> resp = new HashMap<>();
        resp.put("ordem", ordem);
        resp.put("questao", questao);
        List<Map<String, Object>> respostasMap = getRespostas().stream().map(Resposta::toMap).collect(Collectors.toList());
        resp.put("respostas", respostasMap);

        if (StringUtils.isNotBlank(documento)) {
            resp.put("documento", documento);
        }

        return resp;
    }


}
