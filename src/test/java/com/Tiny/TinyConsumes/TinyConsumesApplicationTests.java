package com.Tiny.TinyConsumes;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootTest
class TinyConsumesApplicationTests {

	@Test
	void consumerApiTest() {
		RestTemplate template = new RestTemplate();

		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("api.tiny.com.br")
				.path("api2/produtos.pesquisa.php")
				.queryParam("token","{token}")
				.queryParam("formato","json")
				.build();

		ResponseEntity <String> produtosResponseEntity = template.getForEntity(uri.toString(), String.class);
		System.out.println(produtosResponseEntity.getBody());
	}

}
