package com.example.neobookChallenge.repositories;

import com.example.neobookChallenge.models.Product;
import com.example.neobookChallenge.responses.ProductGetAllResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("""
            select new com.example.neobookChallenge.responses.ProductGetAllResponse(
            p.id,
            p.title,
            p.price,
            concat(:path, p.image)
            ) from Product p
            """)
    List<ProductGetAllResponse> findAllProducts(String path);


    @Query("""
            select new com.example.neobookChallenge.responses.ProductGetAllResponse(
            p.id,
            p.title,
            p.price,
            concat(:path, p.image)
            ) from Product p where p.id = :productId
""")
    ProductGetAllResponse findByIdProduct(String path, Long productId);

    @Query("""
            select new com.example.neobookChallenge.responses.ProductGetAllResponse(
            p.id,
            p.title,
            p.price,
            concat(:path, p.image))
            from Product p where ((:search is null)
            or (upper(p.title) like upper(concat('%', :searchName, '%'))))
          """)
    List<ProductGetAllResponse> findAllProductsSearch(String path, String searchName, Pageable pageable);
}
