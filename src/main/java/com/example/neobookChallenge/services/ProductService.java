package com.example.neobookChallenge.services;

import com.example.neobookChallenge.exceptions.NotFoundException;
import com.example.neobookChallenge.models.Category;
import com.example.neobookChallenge.models.Product;
import com.example.neobookChallenge.repositories.CategoryRepository;
import com.example.neobookChallenge.repositories.ProductRepository;
import com.example.neobookChallenge.requests.ProductRequest;
import com.example.neobookChallenge.responses.ProductGetAllResponse;
import com.example.neobookChallenge.responses.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final CategoryService categoryService;

    private final S3Service s3Service;

    @Value("${cloud.aws.bucket.path}")
    private String path;

    public Response save(Long categoryId, ProductRequest productRequest) {

        Product product = Product.builder()
                .title(productRequest.title())
                .price(productRequest.price())
                .description(productRequest.description())
                .image(productRequest.image().substring(path.length()))
                .category(categoryService.findByIdCategory(categoryId))
                .build();


        productRepository.save(product);

        return new Response("Product successfully was saved");
    }


    public List<ProductGetAllResponse> findAll() {

        return productRepository.findAllProducts(path);
    }

    public ProductGetAllResponse findByIdProduct(Long productId) {

       return productRepository.findByIdProduct(path, productId);
    }


    @Transactional
    public Response update(Long productId, ProductRequest productRequest) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product is not found"));

        String oldImageLink = product.getImage();

        product.setTitle(productRequest.title());
        product.setDescription(productRequest.description());
        product.setPrice(productRequest.price());

        String newImageLink = productRequest.image();

        if (newImageLink != null && !newImageLink.isEmpty() && !newImageLink.equals(oldImageLink)) {

            s3Service.deletePath(oldImageLink);}

            product.setImage(newImageLink);

        return new Response("updated");
    }

    public Response deleteByProductId(Long productId) {

        productRepository.deleteById(productId);

        return new Response("Product was Successfully removed");
    }

}
