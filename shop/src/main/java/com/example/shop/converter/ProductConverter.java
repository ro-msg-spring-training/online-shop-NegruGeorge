package com.example.shop.converter;

import com.example.shop.Entity.Product;
import com.example.shop.Entity.ProductCategory;
import com.example.shop.Entity.Supplier;
import com.example.shop.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter implements InConverter<Product, ProductDTO>{
    @Override
    public ProductDTO entityToDto(Product entity) {


        ProductDTO p =  ProductDTO.builder()
                .description(entity.getDescription())
                .IdProduct(entity.getId())
                .idCategory(entity.getProductCategory().getId())
                .ProductCategoryDescription(entity.getProductCategory().getDescription())
                .ProductCategoryName(entity.getProductCategory().getName())
                .IdSupplier(entity.getSupplier().getId())
                .SupplierName(entity.getSupplier().getNamee())
                .name(entity.getNamee())
                .price(entity.getPrice())
                .weight(entity.getWeight())
                .imageUrl(entity.getImageURL())
                .build();

        System.out.println(p);
        return p;
    }

    @Override
    public Product DTOToEntity(ProductDTO productDTO) {

        ProductCategory pcat = ProductCategory.builder()

                .Name(productDTO.getProductCategoryName())
                .Description(productDTO.getProductCategoryDescription())
                .build();
        pcat.setId(productDTO.getIdCategory());

        Supplier sup = Supplier.builder()
                .Namee(productDTO.getSupplierName())
                .build();
        sup.setId(productDTO.getIdSupplier());

        Product product =  Product.builder()
                .Description(productDTO.getDescription())

                .productCategory(pcat)

                .supplier(sup)

                .Namee(productDTO.getName())
                .Price(productDTO.getPrice())
                .Weight(productDTO.getWeight())
                .ImageURL(productDTO.getImageUrl())
                .build();
        product.setId(productDTO.getIdProduct());
        return product;
    }
}
