package com.poly.assignment.controller.admin;


import com.poly.assignment.dao.CategoryDAO;
import com.poly.assignment.dao.ProductsDAO;
import com.poly.assignment.domain.Category;
import com.poly.assignment.domain.Product;
import com.poly.assignment.model.CategoryDTO;
import com.poly.assignment.model.ProductDTO;
import com.poly.assignment.services.StorageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("admin/products")
public class ProductController {
    @Autowired
    ProductsDAO productsDAO;

    @Autowired
    CategoryDAO categoryDAO;

    @Autowired
    StorageService storageService;

    @ModelAttribute("categories")
    public List<CategoryDTO> getcategory() {
        return categoryDAO.findAll().stream().map(item -> {
            CategoryDTO dto = new CategoryDTO();
            BeanUtils.copyProperties(item, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    @GetMapping("add")
    public String add(Model model) {
        model.addAttribute("product", new ProductDTO());
        return "admin/products/add-edit";
    }

    @GetMapping("edit/{productID}")
    public ModelAndView edit(ModelMap model, @PathVariable("productID") Long productID) {
        ProductDTO dto = new ProductDTO();

        Optional<Product> opt = productsDAO.findById(productID);

        if (opt.isPresent()) {
            Product entity = opt.get();
            BeanUtils.copyProperties(entity, dto);
            dto.setIsEdit(true);

            model.addAttribute("product", dto);

            return new ModelAndView("admin/products/add-edit");
        }

        model.addAttribute("message", "Category is not existed");

        return new ModelAndView("forward:/admin/products/", model);
    }

    @PostMapping(value = "saveOrUpdate")
    public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("product") ProductDTO dto, BindingResult result) {

//        //check nếu lỗi thì trả lại view trang add hoặc edit
//        if (result.hasErrors()) {
//            return new ModelAndView("admin/products/add-edit");
//        }
        Product entity = new Product();
        BeanUtils.copyProperties(dto, entity);

        Category category = new Category();
        category.setCategoryID(dto.getCategoryID());
        entity.setCategory(category);

        if(!dto.getImageFile().isEmpty()){
            UUID uuid = UUID.randomUUID();
            String uuString = uuid.toString();

            entity.setImage(storageService.getStoredFilename(dto.getImageFile(),uuString));
            storageService.store(dto.getImageFile(),entity.getImage());
        }

        productsDAO.save(entity);

        model.addAttribute("message", "product is saved !");

        return new ModelAndView("forward:/admin/products/", model);
    }

    @GetMapping("delete/{productID}")
    public ModelAndView delete(ModelMap model, @PathVariable("productID") Long productID) {

        categoryDAO.deleteById(productID);
        model.addAttribute("message", "product is delete");

        return new ModelAndView("forward:/admin/products/", model);
    }

    @RequestMapping(value = " ", method = {RequestMethod.GET, RequestMethod.POST})
    public String list(ModelMap model) {

        List<Product> list = productsDAO.findAll();

        model.addAttribute("products", list);

        return "admin/products/list";
    }

    @GetMapping("search")
    //dùng required để xác định có param hoặc không có đều được
    public String search(ModelMap model, @RequestParam(name = "name", required = false) String name) {

        List<Product> list = null;

        //check xem có giá trị name được truyền vào từ param hay không
        if (StringUtils.hasText(name)) {
            list = productsDAO.findByNameContaining(name);
        } else {
            list = productsDAO.findByNameContaining(name);
        }
        //thêm list cate vào attribute để hiển thị lên form
        model.addAttribute("products", list);

        return "admin/products/list";
    }


}
