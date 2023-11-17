//package com.bezkoder.springjwt.controllers;
//
//import com.bezkoder.springjwt.dto.CategoryDTO;
//import com.bezkoder.springjwt.dto.ResponseJson;
//import com.bezkoder.springjwt.entities.Category;
//import com.bezkoder.springjwt.Service.CategoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//@CrossOrigin(origins = "*", maxAge = 3600)
//@RestController
//@RequestMapping("ProjectSJ/Category")
//public class CategoryController {
//
//    @Autowired
//    private CategoryService categoryService;
//    @GetMapping("/all")
//    public ResponseEntity<List<Category>> findallcategory() {
//        List<Category> listcategory = categoryService.GetAllCategory();
//        return new ResponseEntity<List<Category>>(listcategory, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<CategoryDTO> getcategorybyid(@PathVariable("id") long id){
//        Optional<CategoryDTO> categoryDTObyid= categoryService.getCategorybyid(id);
//        if(categoryDTObyid.isPresent()){
//            CategoryDTO categoryDTO = categoryDTObyid.get();
//            return new ResponseEntity<> (categoryDTO,HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
//
//    @PostMapping("/add")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public ResponseEntity<ResponseJson<Boolean>> addcategory(@RequestBody CategoryDTO categoryDTO) //sử dụng @RBody để nó tự động convert JSON thành đối tượng DTO
//    {
//        categoryService.savecategory(categoryDTO);
//        return ResponseEntity.ok().body(new ResponseJson<>(Boolean.TRUE, HttpStatus.OK, "Add Success"));
//    }
//    @PutMapping("/update/{id}")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public ResponseEntity<ResponseJson<Boolean>> updatecategory(@PathVariable("id") Long id ,@RequestBody CategoryDTO categoryDTO){
//        categoryService.updateCategorybyid(id, categoryDTO);
//        return ResponseEntity.ok().body(new ResponseJson<>(Boolean.TRUE, HttpStatus.OK, "Update Success"));
//    }
//
//    @DeleteMapping("/delete/{id}")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public ResponseEntity<ResponseJson<Boolean>> deletecategorybyid(@PathVariable("id") Long id) {
//        categoryService.deleteCategorybyid(id);
//        return ResponseEntity.ok().body(new ResponseJson<>(Boolean.TRUE, HttpStatus.OK, "Delete Success"));
//
//    }
//    @DeleteMapping("/delete/all")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public ResponseEntity<ResponseJson<Boolean>> deleteallcategory()
//    {
//        categoryService.deleteallCategory();
//        return ResponseEntity.ok().body(new ResponseJson<>(Boolean.TRUE, HttpStatus.OK, "Delete All Success"));
//
//    }
//}
//
