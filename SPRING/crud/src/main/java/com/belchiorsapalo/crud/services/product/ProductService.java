package com.belchiorsapalo.crud.services.product;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.belchiorsapalo.crud.domain.product.Product;
import com.belchiorsapalo.crud.domain.product.ProductDTO;
import com.belchiorsapalo.crud.exception.EntityNotFoundException;
import com.belchiorsapalo.crud.exception.InvalidDataException;
import com.belchiorsapalo.crud.repository.product.ProductRepo;

@Service
public class ProductService {
    
    private final ProductRepo pRepo;

    public ProductService(ProductRepo pRepo){
        this.pRepo = pRepo;
    }

    public Product register(ProductDTO pDto){
        validateProductDTO(pDto);
        return pRepo.save(new Product(pDto));
    }


    public Product getProduct(UUID id){
        if (!pRepo.existsById(id))
            throw new EntityNotFoundException("O produto requerido não foi encontrado");
        return pRepo.findById(id).get();
    }

    public List<Product> geProductsByCategory(String category){
        if (!pRepo.existsByCategory(category))
            throw new EntityNotFoundException("Não existem produtos nessa categoria");
        return pRepo.findAllByCategory(category);
    }

    public List<Product> getProducts(){
        return pRepo.findAll();
    }

    public Product update(ProductDTO pDto, UUID id){
        Product product = pRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("O produto requerido não foi encontrado"));
        validateProductDTO(pDto);       
        product.setPrice(pDto.price());
        if (pDto.name() != null && !pDto.name().equals(product.getName()))
            product.setName(pDto.name());
        if (pDto.category() != null && !pDto.category().equals(product.getCategory()))
            product.setCategory(pDto.category());
        return pRepo.save(product);
    }

    private void validateProductDTO(ProductDTO pDto){
        if (pDto.price() < 0)
            throw new InvalidDataException("O preço deve maior ou igual a zero");
    }

    public void delete(UUID id){
        if (!pRepo.existsById(id))
            throw new EntityNotFoundException("O produto requerido não foi encontrado");
        pRepo.deleteById(id);
    }
}
