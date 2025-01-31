package com.belchiorsapalo.crud.domain.product;

import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product extends RepresentationModel<Product>{
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NonNull
    private String name;
    @NonNull
    private String category;
    @NonNull
    private double price;

    public Product(ProductDTO pDto){
        this.name = pDto.name();
        this.price = pDto.price();
        this.category = pDto.category();
    }
}
