package br.com.hackatur.xtudyout.domain;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.DocumentSnapshot;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Orcamento {

    public static String child = "orcamento";

    private String documento;
    @NonNull private Double valorTotal;
    @NonNull private Double valorCurso;
    @NonNull private Double taxas;
    @NonNull private Double valorServicos;
    @NonNull private Double valorMatricula;
    @NonNull private Integer periodo;
    @NonNull private Double valorMoradia;
    @NonNull private Date dataOrcamento;

    public Orcamento(DocumentSnapshot doc) {
        this.documento = doc.getId();
        this.valorTotal = doc.getDouble("valorTotal");
        this.valorCurso = doc.getDouble("valorCurso");
        this.taxas = doc.getDouble("taxas");
        this.valorMatricula = doc.getDouble("valorMatricula");
        this.periodo = doc.getDouble("periodo").intValue();
        this.valorMoradia = doc.getDouble("valorMoradia");
        this.dataOrcamento = doc.getDate("dataOrcamento");
        this.valorServicos = doc.getDouble("valorServicos");
    }

    public Orcamento(Map map) {
        this.valorTotal = (Double) map.get("valorTotal");
        this.valorCurso = (Double) map.get("valorCurso");
        this.taxas = (Double) map.get("taxas");
        this.valorMatricula = (Double) map.get("valorMatricula");
        this.periodo = ((Long) map.get("periodo")).intValue();
        this.valorMoradia = (Double) map.get("valorMoradia");
        this.dataOrcamento = ((Timestamp) map.get("dataOrcamento")).toDate();
        this.valorServicos = (Double) map.get("valorServicos");
    }

    public Map<String, Object> toMap() {
        Map<String, Object> resp = new HashMap<>();
        resp.put("valorTotal" , getValorTotal());
        resp.put("valorCurso" , getValorCurso());
        resp.put("valorServicos", getValorServicos());
        resp.put("taxas" , getTaxas());
        resp.put("valorMatricula" , getValorMatricula());
        resp.put("periodo" , getPeriodo());
        resp.put("valorMoradia" , getValorMoradia());
        resp.put("dataOrcamento" , getDataOrcamento());

        if (StringUtils.isNotBlank(getDocumento())) {
            resp.put("documento", getDocumento());
        }

        return resp;
    }


}
