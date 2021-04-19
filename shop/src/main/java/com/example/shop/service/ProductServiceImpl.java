package com.example.shop.service;

import com.example.shop.Entity.Product;
import com.example.shop.Entity.ProductCategory;
import com.example.shop.Repository.InProductCategoryRepo;
import com.example.shop.Repository.InProductRepo;
import com.example.shop.Repository.InSupplierRepo;
import com.example.shop.converter.ProductConverter;
import com.example.shop.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductServiceImpl implements InService<ProductDTO,Product>{

    private final InProductRepo productRepo;
    private final  ProductConverter productConverter;
    private final InProductCategoryRepo productCategoryRepo;
    private final InSupplierRepo supplierRepo;

    @Autowired
    public ProductServiceImpl(InProductRepo r, ProductConverter p, InProductCategoryRepo productCategoryRepo, InSupplierRepo supplierRepo)
    {
        this.productRepo = r;
        this.productConverter = p;
        this.productCategoryRepo = productCategoryRepo;
        this.supplierRepo = supplierRepo;
    }


    @Override
    public List<ProductDTO> getALL() {

    List<Product> prod_list  =  productRepo.findAll();
    List<ProductDTO> dto_list = new ArrayList<>();
    for(Product p:prod_list){

        dto_list.add(productConverter.entityToDto(p));
    }

        return dto_list;
    }

    @Override
    public void addProduct(ProductDTO productDTO) {
        Product product = productConverter.DTOToEntity(productDTO);
        productRepo.save(product);

    }


    @Override
    public void delete(Integer id) {
        Product product = productRepo.findById(id).orElse(null);

        if(product !=null)
            productRepo.delete(product);
    }

    // problema cu id ul
    // cred ca se face autoincrement trebuie vazut
    @Override
    public void update(ProductDTO newproductDTO, Integer id) {
            Product product  = productRepo.findById(id).orElse(null);
        System.out.println("aici");
            if(product !=null)
            {



                Product newProduct = productConverter.DTOToEntity(newproductDTO);

                newProduct.setId(id);
                productRepo.save(newProduct);
//                productRepo.delete(product);
//                // poate merge asa inca nu am rulat
//                newProduct.setId(id);
//                System.out.println("////");
//                System.out.println(newproductDTO);
//                System.out.println(newProduct);

            }

    }

    @Override
    public ProductDTO findOne(Integer id) {
        Product product = productRepo.findById(id).orElse(null);

        if(product !=null)
        {
            return productConverter.entityToDto(product);
        }
        return null;
    }

    @Override
    public ProductDTO ENTtoDTO(Product p) {
        return productConverter.entityToDto(p);
    }

    @Override
    public Product DTOtoENT(ProductDTO p) {
        return productConverter.DTOToEntity(p);
    }


}
