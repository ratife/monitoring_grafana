package mg.tife.obgrafana.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mg.tife.obgrafana.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
