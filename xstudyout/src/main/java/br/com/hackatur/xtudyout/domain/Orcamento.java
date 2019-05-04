package br.com.hackatur.xtudyout.domain;

import com.google.cloud.firestore.DocumentSnapshot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
public class Orcamento {

    public static String child = "orcamento";

    private String documento;
    private Double valorTotal;
    private Double taxas;
    private String curso;
    private Double valorMatricula;
    private Integer periodo;
    private Double valorMoradia;
    private Date dataOrcamento;


    public Orcamento(
                      Double valorTotal,
                      Double taxas,
                      String curso,
                      Double valorMatricula,
                      Integer periodo,
                      Double valorMoradia,
                      Date dataOrcamento) {

        this.valorTotal = valorTotal;
        this.taxas = taxas;
        this.curso = curso;
        this.valorMatricula = valorMatricula;
        this.periodo = periodo;
        this.valorMoradia = valorMoradia;
        this.dataOrcamento = dataOrcamento;

    }

    public Orcamento(DocumentSnapshot doc) {
        this.documento = doc.getId();
        this.valorTotal = doc.getDouble("valorTotal");
        this.taxas = doc.getDouble("taxas");
        this.curso = doc.getString("curso");
        this.valorMatricula = doc.getDouble("valorMatricula");
        this.periodo = doc.getDouble("periodo").intValue();
        this.valorMoradia = doc.getDouble("valorMoradia");
        this.dataOrcamento = doc.getDate("dataOrcamento");
    }

    public Map<String, Object> toMap() {
        Map<String, Object> resp = new HashMap<>();
        resp.put("valorTotal" , getValorTotal());
        resp.put("taxas" , getTaxas());
        resp.put("curso" , getCurso());
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
