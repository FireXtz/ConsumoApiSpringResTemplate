package com.Tiny.TinyConsumes.Service;

import com.Tiny.TinyConsumes.Entity.Produto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;

import static com.Tiny.TinyConsumes.Environment.Environment.*;

@Service
public class ProductsServiceClient {

    public JsonNode findAllProducts() throws JsonProcessingException {
        RestTemplate template = new RestTemplate();
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme(SCHEME)
                .host(HOST)
                .path("api2/produtos.pesquisa.php")
                .queryParam("token", TOKEN)
                .queryParam("formato", FORMAT)
                .build();
        ResponseEntity <String> responseEntity = template.getForEntity(uri.toUri(),String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(responseEntity.getBody());
        return root;

    }
    public String findProducts(Long id) {
        RestTemplate template = new RestTemplate();
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme(SCHEME)
                .host(HOST)
                .path("api2/produto.obter.php")
                .queryParam("token", TOKEN)
                .queryParam("id", id)
                .queryParam("formato", FORMAT)
                .build();
        String produtosResponseEntity = template.getForEntity(uri.toString(), String.class).getBody();
        System.out.println(produtosResponseEntity);
        return produtosResponseEntity;
    }

    public String findStockProducts(Long id) {
        RestTemplate template = new RestTemplate();
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme(SCHEME)
                .host(HOST)
                .path("api2/produto.obter.estoque.php")
                .queryParam("token", TOKEN)
                .queryParam("id", id)
                .queryParam("formato", FORMAT)
                .build();
        String produtosResponseEntity = template.getForEntity(uri.toString(), String.class).getBody();
        return produtosResponseEntity;
    }
    public String findStructProducts(Long id) {
        RestTemplate template = new RestTemplate();
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme(SCHEME)
                .host(HOST)
                .path("api2/produto.obter.estrutura.php")
                .queryParam("token", TOKEN)
                .queryParam("id", id)
                .queryParam("formato", FORMAT)
                .build();
        String produtosResponseEntity = template.getForEntity(uri.toString(), String.class).getBody();
        return produtosResponseEntity;
    }
    public String findTagsProducts(Long id) {
        RestTemplate template = new RestTemplate();
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme(SCHEME)
                .host(HOST)
                .path("api2/produto.obter.tags")
                .queryParam("token", TOKEN)
                .queryParam("id", id)
                .queryParam("formato", FORMAT)
                .build();
        String produtosResponseEntity = template.getForEntity(uri.toString(), String.class).getBody();
        return produtosResponseEntity;
    }


}