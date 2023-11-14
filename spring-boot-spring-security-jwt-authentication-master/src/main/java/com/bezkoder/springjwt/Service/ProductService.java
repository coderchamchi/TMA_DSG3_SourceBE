package com.bezkoder.springjwt.Service;

import com.bezkoder.springjwt.payload.response.ProductRespone;
import com.bezkoder.springjwt.payload.request.ProductRequest;
import com.bezkoder.springjwt.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductService {
    //Get all Product
    List<Product> GetAllProduct();

    //Get Product by id
    Optional<ProductRespone> getProductbyid(long id);

    //get Product by name
    ArrayList<Product> getProductbyName(String query);

    //get product by truong/brand ="DUE"
    ArrayList<Product> getProdcuctbyBrand(String query);

    //Create new Product
    boolean saveProduct(ProductRequest productDTO);

    //update Product by id
    boolean updateProductbyid(Long id, ProductRequest productRequest);


    //delete Product by id
    boolean deleteProductbyid(long id);

    //delete all Product
    boolean deleteallProduct();

    //get product by category id
    ArrayList<Product> getproductbycategory(Long id);

    ArrayList<Product> getproductbycategoryname(String query);

    //update by patch
    Product updatebypatch(long id, Map<String, Object> fields);

    List<Product> sortbyproductname(String direction);

    List<Product> sortbyproductprice(String direction);

    List<Product> sortbyproductnameandprice(String directionname, String directionprice);

    List<Product> sortbyproductname_price_discount(String directionname, String directionprice, String directiondiscount);

    Page<Product> getPagging(Pageable pageable);

}
