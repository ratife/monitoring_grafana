package mg.tife.obgrafana;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import mg.tife.obgrafana.entity.Product;
import mg.tife.obgrafana.repository.ProductRepository;

@SpringBootApplication
public class ObservableGrafanaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObservableGrafanaApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepo) {
		return args->{
			productRepo.save(Product.builder().name("PC").price(200).build());
			productRepo.save(Product.builder().name("Clavier").price(10).build());
			productRepo.save(Product.builder().name("Souris").price(50).build());
			productRepo.save(Product.builder().name("Serveur").price(5000).build());
			productRepo.findAll().forEach(System.out::println);
		};
	} 
}
