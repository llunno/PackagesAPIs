package br.edu.infnet.packagedetiny.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class StringToJson {

    public static String toJson(String chave, String valor) {
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, String> map = new HashMap<>();
        map.put(chave, valor);
        try {
            return   mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
