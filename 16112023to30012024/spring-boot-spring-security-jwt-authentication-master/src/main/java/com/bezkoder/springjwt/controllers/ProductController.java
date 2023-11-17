//package com.bezkoder.springjwt.controllers;
//
//import com.bezkoder.springjwt.Service.CategoryService;
//import com.bezkoder.springjwt.dto.CategoryDTO;
//import com.bezkoder.springjwt.payload.response.ProductRespone;
//import com.bezkoder.springjwt.payload.request.ProductRequest;
//import com.bezkoder.springjwt.dto.ResponseJson;
//import com.bezkoder.springjwt.entities.Product;
//import com.bezkoder.springjwt.Service.ProductService;
//import org.apache.commons.lang3.ObjectUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.parameters.P;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//
//@CrossOrigin(origins = "*", maxAge = 3600)
//@RestController
//@RequestMapping("ProjectSJ/Product")
//public class ProductController {
//    @Autowired
//    private ProductService productService;
//
//    @Autowired
//    CategoryService categoryService;
//
//    @GetMapping("/all")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN', 'ROLE_USER')")
//    public ResponseEntity<List<Product>> findallProduct() {
//        List<Product> listProduct = productService.GetAllProduct();
//        return new ResponseEntity<List<Product>>(listProduct, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN', 'ROLE_USER')")
//    public ResponseEntity<ProductRespone> getProductbyid(@PathVariable("id") long id) {
//        Optional<ProductRespone> optionalProductDTO = productService.getProductbyid(id);
//
//        if (optionalProductDTO.isPresent()) {
//            ProductRespone productRespone = optionalProductDTO.get();
//            return new ResponseEntity<>(productRespone, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @GetMapping("/category/{id}")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN', 'ROLE_USER')")
//    public ResponseEntity<ArrayList<Product>> getproductsbycategory(@PathVariable("id") long id){
//        Optional<CategoryDTO> optional = categoryService.getCategorybyid(id);
//        if (ObjectUtils.isNotEmpty(optional)){
//            ArrayList<Product> listproduct = productService.getproductbycategory(id);
//            return new ResponseEntity<ArrayList<Product>>(listproduct, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @GetMapping("/categoryname")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN', 'ROLE_USER')")
//    public ResponseEntity<ArrayList<Product>> getproductsbycategoryname(@RequestParam("query") String query){
//        try {
//            ArrayList<Product> products = productService.getproductbycategoryname(query);
//            return new ResponseEntity<>(products, HttpStatus.OK);
//        }
//        catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//
//    @GetMapping("/searchbyname")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN', 'ROLE_USER')")
//    public ResponseEntity<ArrayList<Product>> getproductbyname(@RequestParam("query") String query){
//        try {
//            ArrayList<Product> product = productService.getProductbyName(query);
//            return new ResponseEntity<>(product, HttpStatus.OK);
//        }
//        catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @GetMapping("/searchbybrand")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN', 'ROLE_USER')")
//    public ResponseEntity<ArrayList<Product>> getproductbybrand(@RequestParam("query") String query){
//        try {
//            ArrayList<Product> product = productService.getProdcuctbyBrand(query);
//            return new ResponseEntity<>(product, HttpStatus.OK);
//        }
//        catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PostMapping("/add")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public ResponseEntity<ResponseJson<Boolean>> addProduct(@Validated @RequestBody ProductRequest productRequest)
//                                                            //sử dụng @RBody để nó tự động convert JSON thành đối tượng DTO
//                                                            //sử dụng @Validated để check xem những trường bên entity cấu hình
//                                                            //so với data lúc nhân được có phù hợp hay không
//    {
//        Boolean chek = productService.saveProduct(productRequest);
//        if(!chek){
//            return ResponseEntity.ok().body(new ResponseJson<>(Boolean.FALSE, HttpStatus.BAD_REQUEST, "Error: Can not add the product"));
//        }
//        return ResponseEntity.ok().body(new ResponseJson<>(Boolean.TRUE, HttpStatus.OK, "Add Successed"));
//    }
//    @PutMapping("/update/{id}")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public ResponseEntity<ResponseJson<Boolean>> updateProduct(@PathVariable("id") Long id, @RequestBody ProductRequest productRequest){
//
//        boolean updateProductbyid = productService.updateProductbyid(id, productRequest);
//        if (!updateProductbyid){
//            return ResponseEntity.ok().body(new ResponseJson<>(Boolean.FALSE, HttpStatus.NOT_FOUND, "Not Found The Product"));
//        }
//        return ResponseEntity.ok().body(new ResponseJson<>(Boolean.TRUE, HttpStatus.OK, "Update Success"));
//    }
//
//    @PatchMapping("/update/{id}")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public ResponseEntity<Product> updateproductbypatch(@PathVariable long id, @RequestBody Map<String,Object> fields){
//        Product product= productService.updatebypatch(id, fields);
//        if(product != null){
//            return new ResponseEntity<>(product, HttpStatus.ACCEPTED);
//        }
//        else
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public ResponseEntity<ResponseJson<Boolean>> deleteProductbyid(@PathVariable("id") long id) {
//        Boolean check = productService.deleteProductbyid(id);
//        if (!check){
//            return ResponseEntity.ok().body(new ResponseJson<>(Boolean.TRUE, HttpStatus.NOT_FOUND, "Not Found The Product"));
//        }
//        return ResponseEntity.ok().body(new ResponseJson<>(Boolean.TRUE, HttpStatus.OK, "Delete Success"));
//    }
//    @DeleteMapping("/delete/all")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public ResponseEntity<ResponseJson<Boolean>> deleteallProduct()
//    {
//        productService.deleteallProduct();
//        return ResponseEntity.ok().body(new ResponseJson<>(Boolean.TRUE, HttpStatus.OK, "Delete All Success"));
//
//    }
//
//    @GetMapping("/sortbyname")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN', 'ROLE_USER')")
//    public ResponseEntity<List<Product>> sortproductsbyname(@RequestParam("direction") String direction)
//    {
//        List<Product> products = productService.sortbyproductname(direction);
//        return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
//    }
//    @GetMapping("/sortbyprice")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN', 'ROLE_USER')")
//    public ResponseEntity<List<Product>> sortproductsbyprice(@RequestParam("direction") String direction)
//    {
//        List<Product> products = productService.sortbyproductprice(direction);
//        return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
//    }
//    @GetMapping("/sortbynameandprice")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN', 'ROLE_USER')")
//    public ResponseEntity<List<Product>> sortproductsbynameandprice(@RequestParam("directionname") String directionname,
//                                                                    @RequestParam("directionprice") String directionprice)
//    {
//        List<Product> products = productService.sortbyproductnameandprice(directionname, directionprice);
//        return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
//    }
//
//    @GetMapping("/sortbynameandpriceanddiscount")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN', 'ROLE_USER')")
//    public ResponseEntity<List<Product>> sortproductsbynameandpriceanddiscount( @RequestParam("directionname") String directionname,
//                                                                                @RequestParam("directionprice") String directionprice,
//                                                                                @RequestParam("directiondiscount") String directiondiscount)
//    {
//        List<Product> products = productService.sortbyproductname_price_discount(directionname, directionprice, directiondiscount);
//        return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
//    }
//
//    @GetMapping("/getpagging")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN', 'ROLE_USER')")
//    public ResponseEntity<Map<String, Object>> getPagging(@RequestParam(defaultValue = "0") int page, //page là số trang muốn phân
//                                                          @RequestParam(defaultValue = "8") int size) // size là só sp muốn hiển thị ở 1 trang
//    {
//        Pageable pageable = PageRequest.of(page, size);
//        Page<Product> pageproducts = productService.getPagging(pageable);
//        Map <String,Object> data = new HashMap<>();
//        data.put("product",pageproducts.getContent());
//        data.put("total",pageproducts.getSize());
//        data.put("totalItems",pageproducts.getTotalElements());
//        data.put("totalPages",pageproducts.getTotalPages());
//        return new ResponseEntity<>(data,HttpStatus.OK);
//    }
//
//    @GetMapping("/getpaggingandsortbyname")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN', 'ROLE_USER')")
//    public ResponseEntity<Map<String, Object>> getPaggingandsortbyname(
//            @RequestParam(defaultValue = "0") int page, //page là số trang muốn phân
//            @RequestParam(defaultValue = "8") int size,// size là só sp muốn hiển thị ở 1 trang
//            @RequestParam String directionname)
//    {
//        Sort.Order order;
//        if(directionname.equals("asc")){
//            order = new Sort.Order(Sort.Direction.ASC,"productname");
//        }
//        else {
//            order = new Sort.Order(Sort.Direction.DESC,"productname");
//        }
//        Pageable pageable = PageRequest.of(page, size, Sort.by(order));
//        Page<Product> pageproducts = productService.getPagging(pageable);
//        Map <String, Object> data = new HashMap<>();
//        data.put("product", pageproducts.getContent());
//        data.put("total", pageproducts.getSize());
//        data.put("totalItems", pageproducts.getTotalElements());
//        data.put("totalPages", pageproducts.getTotalPages());
//        return new ResponseEntity<>(data, HttpStatus.OK);
//    }
//}
//
//
