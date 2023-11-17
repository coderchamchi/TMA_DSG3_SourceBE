//package com.bezkoder.springjwt.Service.Impl;
//
//import com.bezkoder.springjwt.Service.CategoryService;
//import com.bezkoder.springjwt.dto.CategoryDTO;
//import com.bezkoder.springjwt.entities.Category;
//import com.bezkoder.springjwt.repository.CategoryRepository;
//import org.apache.commons.lang3.ObjectUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CategoryServiceImpl implements CategoryService {
//    @Autowired
//    CategoryRepository categoryRepository;
//
//    @Override
//    public List<Category> GetAllCategory() {
//        return categoryRepository.findAll();
//    }
//
//    @Override
//    public Optional<CategoryDTO> getCategorybyid(long id) {
//        CategoryDTO categoryDTO = new CategoryDTO();
//        return categoryRepository.findById(id)
//                .map(item -> {
//                    categoryDTO.setCategoryname(item.getCategoryname());
//                    return categoryDTO;
//                });
//    }
//
//
//    @Override
//    public boolean savecategory(CategoryDTO categoryDTO) {
//        if (ObjectUtils.isNotEmpty(categoryDTO)) {
//            Category category = new Category();
//            try {
//                category.setCategoryname(categoryDTO.getCategoryname());
//                categoryRepository.save(category);
//                return true;
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public boolean updateCategorybyid(Long id, CategoryDTO categoryDTO) {
//        if (ObjectUtils.isNotEmpty(id)){
//            Category updatecategory = categoryRepository.getById(id);
//            updatecategory.setCategoryname(categoryDTO.getCategoryname());
//            categoryRepository.save(updatecategory);
//            return true;
//        }
//        else {
//            return false;}
//
//    }
//
//    @Override
//    public boolean deleteCategorybyid(long id) {
//        if (id >= 1) {
//            Category category = categoryRepository.getById(id);
//            if (ObjectUtils.isNotEmpty(category)) {
//                categoryRepository.deleteById(id);
//                return true;
//            }
//            return false;
//        }
//        return false;
//    }
//
//    @Override
//    public boolean deleteallCategory() {
//        categoryRepository.deleteAll();
//        return true;
//    }
//
//
//}
//
//
