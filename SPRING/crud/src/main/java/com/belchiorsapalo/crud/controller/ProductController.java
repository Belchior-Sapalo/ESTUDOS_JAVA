package com.belchiorsapalo.crud.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.belchiorsapalo.crud.domain.Product;
import com.belchiorsapalo.crud.domain.ProductDTO;
import com.belchiorsapalo.crud.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService pService;

    public ProductController(ProductService pService){
        this.pService = pService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> products = pService.getProducts();
        for (Product product : products) {
            Link linkToProduct = linkTo(methodOn(ProductController.class).getProduct(product.getId())).withSelfRel();
            product.add(linkToProduct);
        }
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category){
        List<Product> products = pService.geProductsByCategory(category);
        for (Product product : products) {
            Link linkToProduct = linkTo(methodOn(ProductController.class).getProduct(product.getId())).withSelfRel();
            product.add(linkToProduct);
        }
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable UUID id){
        Product product = pService.getProduct(id);
        Link linkToProductList = linkTo(methodOn(ProductController.class).getProducts()).withRel("produtos");
        product.add(linkToProductList);
        return ResponseEntity.ok().body(product);
    }

    @PostMapping("/create")
    public ResponseEntity<Product> register(@RequestBody ProductDTO pDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(pService.register(pDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> update(@PathVariable UUID id, @RequestBody ProductDTO pDto){
        return ResponseEntity.ok().body(pService.update(pDto, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id){
        pService.delete(id);
        return ResponseEntity.ok().build();
    }
}
