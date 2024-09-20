package mg.tife.obgrafana.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import mg.tife.obgrafana.entity.Product;
import mg.tife.obgrafana.model.Post;
import mg.tife.obgrafana.repository.ProductRepository;

@RestController
public class ProductController {
	private ProductRepository productRepo;
	
	private RestClient restClient;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public ProductController(ProductRepository prodRep,RestClient.Builder restClientBuilder) {
		this.productRepo = prodRep;
		this.restClient = restClientBuilder
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
	}
	
	@GetMapping("/products")
	public List<Product> getAllProduct(){
		logger.info("------------dans products -------------");
		return productRepo.findAll();
	}
	
	@GetMapping("/posts")
	public List<Post> getAllpost(){
		logger.info("------------dans posts -------------");
		return restClient.get()
						.uri("/posts")
						.retrieve()
						.body(new ParameterizedTypeReference<List<Post>>() {
						});
	}
}
