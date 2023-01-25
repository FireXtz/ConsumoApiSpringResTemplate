package com.Tiny.TinyConsumes.Client;

import com.Tiny.TinyConsumes.Service.ProductsServiceClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductsWebClient {

    @Autowired
    private ProductsServiceClient productsServiceClient;

    @GetMapping
    @CrossOrigin
    public JsonNode searchProducts() throws JsonProcessingException {
        return productsServiceClient.findAllProducts();
    }

    @GetMapping("/{id}")
    public String getProducts(@PathVariable Long id){
        return productsServiceClient.findProducts(id);
    }

    @GetMapping("stock/{id}")
    public String getStock(@PathVariable Long id){
        return productsServiceClient.findStockProducts(id);
    }

    @GetMapping("structure/{id}")
    public String getStructureProduct(@PathVariable Long id){
        return productsServiceClient.findStructProducts(id);
    }

    @GetMapping("tags/{id}")
    public String getTagsProducts(@PathVariable Long id){
        return productsServiceClient.findTagsProducts(id);
    }







}
