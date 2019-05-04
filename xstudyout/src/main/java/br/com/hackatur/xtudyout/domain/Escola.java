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
public class Escola {

    public static String child = "escola";

    private String documento;
    @NonNull private Endereco endereco;
    @NonNull private String logo;
    @NonNull private String descricao;
    @NonNull private Boolean moradia;
    @NonNull private List<Avaliacao> avaliacoes;
    @NonNull private List<String> tags;
    @NonNull private String curso;
    @NonNull private String periodo;
    @NonNull private String nivel;
    @NonNull private String duracao;
    @NonNull private Orcamento orcamento;

    public Escola(DocumentSnapshot doc) {
        this.documento = doc.getId();
        this.endereco = (Endereco) doc.get("endereco");
        this.orcamento = (Orcamento) doc.get("orcamento");
        this.logo = doc.getString("logo");
        this.descricao = doc.getString("descricao");
        this.curso = doc.getString("curso");
        this.periodo = doc.getString("periodo");
        this.nivel = doc.getString("nivel");
        this.duracao = doc.getString("duracao");
        this.moradia = doc.getBoolean("moradia");
        this.avaliacoes = (List<Avaliacao>) doc.get("avaliacoes");
        this.tags = (List<String>) doc.get("tags");
    }

    public Map<String, Object> toMap() {
        Map<String, Object> resp = new HashMap<>();
        resp.put("endereco", getEndereco().toMap());
        resp.put("orcamento", getOrcamento().toMap());
        resp.put("logo", getLogo());
        resp.put("descricao", getDescricao());
        resp.put("curso", getCurso());
        resp.put("periodo", getPeriodo());
        resp.put("nivel", getNivel());
        resp.put("duracao", getDuracao());
        resp.put("moradia", getMoradia());
        resp.put("avaliacoes", getAvaliacoes().stream().map(Avaliacao::toMap).collect(Collectors.toList()));
        resp.put("tags", getTags());

        if (StringUtils.isNotBlank(getDocumento())) {
            resp.put("documento", getDocumento());
        }

        return resp;
    }


}
