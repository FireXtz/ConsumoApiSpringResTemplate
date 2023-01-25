package com.Tiny.TinyConsumes.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static com.Tiny.TinyConsumes.Environment.Environment.*;
import static com.Tiny.TinyConsumes.Environment.Environment.FORMAT;

@Service
public class PedidoServiceClient {
    public JsonNode listarPedidos() throws JsonProcessingException {
        RestTemplate template = new RestTemplate();
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme(SCHEME)
                .host(HOST)
                .path("api2/pedidos.pesquisa.php")
                .queryParam("token", TOKEN)
                .queryParam("formato", FORMAT)
                .build();
        ResponseEntity <String> responseEntity = template.getForEntity(uri.toUri(),String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(responseEntity.getBody());
        return root;

    }
    
    public ResponseEntity <?>listarPorId(Long id){
        RestTemplate template = new RestTemplate();
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme(SCHEME)
                .host(HOST)
                .path("api2/pedido.obter.php")
                .queryParam("token",TOKEN)
                .queryParam("formato",FORMAT)
                .queryParam("id",id)
                .build();
        Object pedidoPorIdResponse = template.getForEntity(uri.toUri(), String.class).getBody();
        return ResponseEntity.ok(pedidoPorIdResponse);
    }

}
