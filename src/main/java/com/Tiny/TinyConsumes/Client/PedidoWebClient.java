package com.Tiny.TinyConsumes.Client;

import com.Tiny.TinyConsumes.Service.PedidoServiceClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoWebClient {

    @Autowired
    private PedidoServiceClient serviceClient;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonNode listarTodos() throws JsonProcessingException {
        return serviceClient.listarPedidos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>listarPorId(@PathVariable Long id){
        return serviceClient.listarPorId(id);
    }
}
