package com.hcl.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.client.dto.ProductResponseDto;
import com.hcl.client.dto.ProductsDto;
import com.hcl.client.model.Product;
import com.hcl.client.repository.ClientRepositorys;

@Service
public class ClientServiceImpl implements ClientServices {

	@Autowired
	private ClientRepositorys clientRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	private RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Override
	public Product createProduct(Product product) {

		String url1 = "http://localhost:7118/createProduct";
		HttpEntity<Product> entity = new HttpEntity<Product>(product);

		Product p = getRestTemplate().postForObject(url1, entity, Product.class);
		return clientRepository.save(p);
	}

	@Override
	public ProductResponseDto findProduct(Long productId) { // TODO Auto-generated

		String url1 = "http://localhost:7118/select/1";

		ProductResponseDto p = this.restTemplate.getForObject(url1, ProductResponseDto.class);

		return p;
	}

	@Override
	public List<ProductResponseDto> getAllProduct() {
		String url1 = "http://localhost:8080/getAllProduct";

		ResponseEntity<Object> p = this.restTemplate.getForEntity("http://localhost:7118/getAllProduct", Object.class);

		ObjectMapper mapper = new ObjectMapper();
		ProductsDto date = mapper.convertValue(p.getBody(), ProductsDto.class);

		return date.getProducts();
	}

	@Override
	public String deleteProduct(Long productId) { // TODO
		return null;
	}

}
