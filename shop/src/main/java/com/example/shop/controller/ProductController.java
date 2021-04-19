package com.example.shop.controller;


import com.example.shop.Entity.*;
import com.example.shop.Repository.*;
import com.example.shop.dto.ProductDTO;
import com.example.shop.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    private ProductServiceImpl srv;
    private InProductRepo repoProduct;
    private InProductCategoryRepo repoCategory;
    private InSupplierRepo repoSupplier;
    private InStockRepo stockRepo;
    private InLocationRepo locationRepo;

    @Autowired
    public ProductController(ProductServiceImpl serv,InProductRepo repo,InProductCategoryRepo repoCategory, InSupplierRepo supplierRepo,InStockRepo stockRepo,InLocationRepo locationRepo)
    {
        this.srv = serv;
        this.repoProduct = repo;
        this.repoCategory = repoCategory;
        this.repoSupplier = supplierRepo;
        this.stockRepo = stockRepo;
        this.locationRepo = locationRepo;
    }

    @GetMapping("/products")
    public List<ProductDTO> getAll()
    {

        return srv.getALL();
    }

    @GetMapping("/products/{id}")
    public ProductDTO getProduct(@PathVariable Integer id)
    {
        ProductDTO product = srv.findOne(id);
        if(product == null)
            return null;

        return product;
    }

    // test page / add/dell data fast
    @GetMapping("/test")
    public void save()
    {
        System.out.println("sss");
        Product p = repoProduct.findById(1).orElse(null);
        Location loc = locationRepo.findById(1).orElse(null);
        for(Stock s:stockRepo.findByProductAndQuantityGreaterThanEqualAndLocation(p,33,loc))
            System.out.println(s);




        BigDecimal l = BigDecimal.valueOf(10);
//        ProductCategory pc = ProductCategory.builder().Description("r").Name("ss").build();
//        Supplier s = Supplier.builder().Namee("sup").build();
//        repoSupplier.save(s);

//        Product p = Product.builder()
//                .Description("ss")
//                .ImageURL("qw")
//                .Namee("ss")
//                .Weight(10d)
//                .Price(l)
//                .productCategory(repoCategory.findById(1).orElse(null))
//                .supplier(repoSupplier.findById(1).orElse(null))
//                .build();
//        System.out.println(p.getId());
//        repoProduct.save(p);


        // update/delete

//
//        Product p = repoProduct.findById(170).orElse(null);
//        p.setDescription("grr");
//        p.getProductCategory().setName("categoria");
//        p.getProductCategory().setDescription("CAT A");
//
//        p.getSupplier().setNamee("suppllaa");
////        repoProduct.delete(p);
//        System.out.println(p);
//        System.out.println(srv.ENTtoDTO(p));
//        srv.update(srv.ENTtoDTO(p),170);


        //findOne


    }



    @PostMapping(value = "/products", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addProduct(@RequestBody ProductDTO pDTO)
    {
//        System.out.println(repoProduct.findProductByProductCategoryIdDesc());
//        srv.addProduct(pDTO);

        return new ResponseEntity<>("Product created", HttpStatus.CREATED);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id)
    {
        srv.delete(id);
        return new ResponseEntity<>("Product deleted",HttpStatus.OK);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id,@RequestBody ProductDTO pDTO)
    {
        srv.update(pDTO,id);
        return new ResponseEntity<>("Product updated",HttpStatus.OK);
    }

}
