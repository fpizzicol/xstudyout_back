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
public class Resposta {

    private String resposta;
    private String tag;

    public Map<String, Object> toMap(){
        Map<String, Object> resp = new HashMap<>();
        resp.put("resposta", getResposta());
        resp.put("tag", getTag());

        return resp;
    }



}
