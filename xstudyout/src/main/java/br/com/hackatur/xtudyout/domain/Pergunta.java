package br.com.hackatur.xtudyout.domain;

import com.google.cloud.firestore.DocumentSnapshot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
public class Pergunta {

    public static String child = "pergunta";

    private String documento;
    private String questao;
    private List<Resposta> respostas;

    public Pergunta(String questao, List<Resposta> respostas) {
        this.questao = questao;
        this.respostas = respostas;
    }

    public Pergunta(DocumentSnapshot doc) {
        this.documento = doc.getId();
        this.questao = doc.getString("bandeira");
        this.respostas = (List<Resposta>) doc.get("respostas");
    }

    public Map<String, Object> toMap() {
        Map<String, Object> resp = new HashMap<>();
        resp.put("questao", getQuestao());
        List<Map<String, Object>> respostasMap = getRespostas().stream().map(Resposta::toMap).collect(Collectors.toList());
        resp.put("respostas", respostasMap);

        if (StringUtils.isNotBlank(getDocumento())) {
            resp.put("documento", getDocumento());
        }

        return resp;
    }


}
